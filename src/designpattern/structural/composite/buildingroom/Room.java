package designpattern.structural.composite.buildingroom;

public  abstract class Room implements IStructure
{
    private  String name;
    @Override public void enter()
    {

    }

    @Override public void exit()
    {

    }

    @Override public void location()
    {

    }

    @Override public String getName()
    {
        return this.name;
    }
}
