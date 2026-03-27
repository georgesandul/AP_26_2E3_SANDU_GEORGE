package org.example.command;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.repository.Catalog;
import java.io.File;

public class SaveCommand implements Command{
    private Catalog catalog;
    private String filePath;

    public SaveCommand(Catalog catalog, String filePath){
        this.catalog = catalog;
        this.filePath = filePath;
    }

    @Override
    public void execute() throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), catalog);
        System.out.println("catalog saved to " + filePath);
    }
}
