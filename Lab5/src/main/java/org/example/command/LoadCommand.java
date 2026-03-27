package org.example.command;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.repository.Catalog;

import java.io.File;

public class LoadCommand implements Command{
    private String filePath;

    public LoadCommand(String filePath){
        this.filePath = filePath;
    }

    @Override
    public void execute() throws Exception{
        ObjectMapper mapper = new ObjectMapper();

        File file = new File(filePath);

        if(!file.exists()){
            throw new Exception("cannot load file from " + filePath);
        }

        Catalog ldedCatalog = mapper.readValue(file, Catalog.class);
        System.out.println("catalog loaded");
        System.out.println(ldedCatalog.toString());
    }
}
