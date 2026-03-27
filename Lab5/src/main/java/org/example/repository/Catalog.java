package org.example.repository;

import org.example.model.Resource;

import java.util.ArrayList;
import java.util.List;

public class Catalog {

    List<Resource> resourceList = new ArrayList<>();
    public void add(Resource resource){
        resourceList.add(resource);
    }

    public List<Resource> getResourceList() {
        return resourceList;
    }

    public void setResourceList(List<Resource> resourceList) {
        this.resourceList = resourceList;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "resourceList=" + resourceList +
                '}';
    }
}
