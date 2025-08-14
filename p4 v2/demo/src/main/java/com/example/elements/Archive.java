package com.example.elements;

public class Archive implements Operator{
    private String name;
    private int size;

    
    public Archive(String name, int size){
        this.name = name;
        this.size = size;
    }



    @Override
    public int getSize(){
        return size;
    }

    @Override
    public void view(String level){
        System.out.println(level+"-Name: " + name+ " - Size: "+ getSize());
    }

    @Override
    public void rename(String newname){
        this.name = newname;
    }

}
