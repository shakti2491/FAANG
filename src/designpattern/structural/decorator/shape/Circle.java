package designpattern.structural.decorator.shape;

public class Circle implements Shape
{
    private float radius;
    public Circle(float radius){
        this.radius = radius;
    }

    public Circle(){

    }

    void resize(float factor){
        radius *= factor;
    }


    @Override
    public  String info(){
        return "A circle of radius"+radius;
    }
}
