package designpattern.structural.decorator.datasource;

public class DataSourceDecorator implements DataSource
{
    private DataSource wrapee;

    DataSourceDecorator(DataSource source){
        this.wrapee = source;
    }
    @Override public void writeData(String data)
    {
        this.wrapee.writeData(data);
    }

    @Override public String readData()
    {
        return this.wrapee.readData();
    }
}
