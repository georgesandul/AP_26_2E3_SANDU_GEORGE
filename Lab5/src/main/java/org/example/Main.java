package org.example;

import org.example.command.*;
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

        String filePath = "catalog.json";

        try{
            Command list = new ListCommand(catalog1);
            list.execute();

            Command view = new ViewCommand(test);
            view.execute();
        } catch (Exception e){
            System.err.println(e.getMessage());
        }

        try{
            Command save = new SaveCommand(catalog1, filePath);
            save.execute();

            Command load = new LoadCommand(filePath);
            load.execute();

            Command report = new ReportCommand(catalog1);
            report.execute();
        } catch (Exception e){
            System.err.println(e.getMessage());
        }

    }
}
