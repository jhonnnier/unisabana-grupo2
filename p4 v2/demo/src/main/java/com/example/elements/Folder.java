package com.example.elements;


import java.awt.print.Printable;
import java.util.ArrayList; 


public class Folder implements Operator{
    private String name;
    private ArrayList<Operator> files= new ArrayList<Operator>();
    
    public Folder(String name){
        this.name=name;
    }

    @Override
    public int getSize(){
        int cont = 0;
        for (Operator files : files){
            cont += files.getSize();
        }
        return cont;
    }
  
    @Override
    public void rename(String newname){
        this.name = newname;
    }

    public void remove(Operator erase){     
        if (this.files.contains(erase)){  
            files.remove(erase);
        }else{
            System.out.print("Esta carpeta no contiene el archivo ");erase.view("");System.out.println();
                
        }
    }

    public void addFile(Operator add){
        files.add(add);
    }


    @Override
    public void view(String level){
        System.out.println(level+"+Name: " + name+ " - Size: "+getSize());
        for (Operator file : files){
            file.view(level+"-");
        }
       
    }


    public void move(Operator target, Folder to){
        if (this.files.contains(target)){  
            to.addFile(target);
            remove(target);
        }else{
            System.out.println("Esta carpeta no contiene el archivo ");target.view("");
                
        }
    }

}
