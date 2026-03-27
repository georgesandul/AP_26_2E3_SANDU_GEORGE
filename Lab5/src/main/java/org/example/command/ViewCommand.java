package org.example.command;

import org.example.exception.ResourceException;
import org.example.model.Resource;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ViewCommand implements Command{
    private Resource resource;

    public ViewCommand(Resource resource){
        this.resource = resource;
    }

    @Override
    public void execute() throws Exception {
        File myFile = new File(resource.getLocation());

        if(!myFile.exists()){
            throw new ResourceException("does not exsist");
        }

        if(Desktop.isDesktopSupported()){
            try{
                Desktop.getDesktop().open(myFile);
            } catch (IOException e){
                throw new ResourceException("cannot read file");
            }
        }else{
            throw new ResourceException("desktop not supported");
        }
    }
}
