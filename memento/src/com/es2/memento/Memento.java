package com.es2.memento;

import java.util.ArrayList;

public class Memento {

    private ArrayList<String> studentNames = new ArrayList<String>();
    public Memento(ArrayList<String> studentNames){
        this.studentNames = new ArrayList<String>(studentNames);
    }

    public ArrayList<String> getState(){
        return this.studentNames;
    }
}
