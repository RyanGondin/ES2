package com.es2.composite;

import java.util.ArrayList;


public class SubMenu extends Menu{
    private ArrayList<Menu> children;

    public SubMenu(){
        children = new ArrayList<Menu>();
    }

    public void showOptions() {
        System.out.println(this.label);
        for (Menu child: children)
            child.showOptions();
    }

    public void addChild(Menu child){
        this.children.add(child);
    }

    public void removeChild(Menu child){
        this.children.remove(child);
    }
}
