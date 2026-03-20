package org.example;

import org.example.model.Resource;
import org.example.repository.Catalog;
import org.example.exception.ResourceException;

import java.io.File;
import java.io.IOException;

import java.awt.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Catalog catalog1 = new Catalog();
        Resource test = new Resource("doc1","dummy", "/Users/georgesandu/Desktop/dummy.rtf",2026, "George Sandu");
        catalog1.add(test);
        System.out.println(catalog1);

        try{
            openResource(test);
        } catch(ResourceException except){
            System.err.println(except.getMessage());
        }

    }

    public static void openResource(Resource resource) throws ResourceException{
        File myFile = new File(resource.getLocation());

        if(!myFile.exists()){
            throw new ResourceException("file doesn't exist");
        }

        if(Desktop.isDesktopSupported()){
            try{
                Desktop.getDesktop().open(myFile);
            } catch(IOException except){
                throw new ResourceException("cannot read file");
            }
        } else{
            throw new ResourceException("Desktop not supported");
        }
    }
}
