package com.es2.composite;

public class Link extends Menu {
    private String URL;
    public Link(){

    }

    public String getURL(){
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public void showOptions(){
        System.out.println(getLabel() + "\n" + getURL());
    }
}
