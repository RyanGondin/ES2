package com.es2.objectpool;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ReusablePool extends java.lang.Object {
    private static ReusablePool instance;
    private List<HttpURLConnection> available;
    private List<HttpURLConnection> used;
    private int maxPoolSize;

    private ReusablePool(){
        available = new ArrayList<>();
        used = new ArrayList<>();
        maxPoolSize = 10;
    }

    public static ReusablePool getInstance(){
        if (instance == null){
            instance = new ReusablePool();
        }
        return instance;
    }

    public synchronized HttpURLConnection acquire() throws IOException, PoolExhaustedException{
        HttpURLConnection estgv = null;
        if (this.available.isEmpty())
            if (this.used.size() < this.maxPoolSize) {
                URL ipvlink = new URL("https://www.ipv.pt");
                estgv = (HttpURLConnection) ipvlink.openConnection();
                estgv.setRequestMethod("GET");
                this.used.add(estgv);
            }else throw  new PoolExhaustedException();
        else{
                this.used.add(this.available.get(0));
            }
        return estgv;
    }

    public synchronized void release(HttpURLConnection conn) throws ObjectNotFoundException{
        int i = this.used.indexOf(conn);
        if (i != -1){
            this.available.add(this.used.get(i));
            this.used.remove(i);
        }
        else throw new ObjectNotFoundException();
    }

    public synchronized void resetPool(){
        instance = null;
    }

    public void setMaxPoolSize(int size){
        this.maxPoolSize = size;
    }

}
