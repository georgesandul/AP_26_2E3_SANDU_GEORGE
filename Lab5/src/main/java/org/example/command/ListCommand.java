package org.example.command;
import org.example.repository.Catalog;

public class ListCommand implements Command{
    private Catalog catalog;

    public ListCommand(Catalog catalog){
        this.catalog = catalog;
    }

    @Override
    public void execute(){
        System.out.println(catalog.toString());
    }
}
