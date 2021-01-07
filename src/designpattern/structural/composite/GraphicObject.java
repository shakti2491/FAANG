package designpattern.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class GraphicObject
{
    protected String name = "Group";
    public String color;
    public List<GraphicObject> children = new ArrayList<>();

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
