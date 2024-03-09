package com.es2.bridge;

import java.util.LinkedHashMap;
import java.util.UUID;
public class APIMoodle implements APIServiceInterface {

    protected LinkedHashMap<String,String> content = new LinkedHashMap<String,String>();
    private String contentId;

    public APIMoodle() {
    }
    public String getContent(String contentId){

        if (contentId.equals("0")){
            String agg="";
            for (String key : content.keySet()) agg += content.get(key);
            return agg;

        }else return this.content.get(contentId);

    }
    public String setContent(String content) {
        String id= UUID.randomUUID().toString();
        this.content.put(id, content);
        return id;
    }
}
