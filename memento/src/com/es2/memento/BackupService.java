package com.es2.memento;


import java.util.ArrayList;

public class BackupService {
    private Server server;
    private int numberOfSnapshots;
    private ArrayList<Memento> snapshots = new ArrayList<Memento>();
    public BackupService(Server server){
        this.server = server;
    }

    public void takeSnapshot(){
        this.snapshots.add(server.backup());
    }

    public void restoreSnapshot(int snapshotNumber) throws NotExistingSnapshotException{
        if (snapshotNumber < 0 || snapshotNumber>this.snapshots.size()-1 ){
            throw new NotExistingSnapshotException();
        }else {
            this.server.restore(this.snapshots.get(snapshotNumber));
        }
    }
}
