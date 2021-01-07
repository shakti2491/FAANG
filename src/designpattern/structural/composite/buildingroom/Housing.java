package designpattern.structural.composite.buildingroom;

import java.util.ArrayList;

public class Housing implements IStructure
{
    private ArrayList<IStructure> structures;
    private String address;

    public Housing(String address)
    {
        this.structures = new ArrayList<>();
        this.address = address;
    }

    public int addStructure(IStructure structure){
        structures.add(structure);
        return this.structures.size()-1;
    }

    public IStructure getStructure(int compNumber){
        return structures.get(compNumber);
    }
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
        return this.address;
    }
}
