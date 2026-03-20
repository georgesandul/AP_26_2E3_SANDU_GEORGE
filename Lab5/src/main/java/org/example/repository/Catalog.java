package org.example.repository;

import org.example.model.Resource;

import java.util.ArrayList;
import java.util.List;

public class Catalog {

    List<Resource> resourceList = new ArrayList<>();
    public void add(Resource resource){
        resourceList.add(resource);
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "resourceList=" + resourceList +
                '}';
    }
}
