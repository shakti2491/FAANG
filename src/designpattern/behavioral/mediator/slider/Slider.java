package designpattern.behavioral.mediator.slider;

public class Slider extends javafx.scene.control.Slider implements UIControl
{
    private UIMediator mediator;
    private boolean mediateUpdate;

    public Slider(UIMediator mediator){
        this.mediator = mediator;
        setMin(0);
        setMax(50);
        setBlockIncrement(5);
        mediator.register(this);
        this.valueProperty().addListener((v,o,n)-> {
            if(!mediateUpdate)
                this.mediator.valueChanged(this);
        });
    }

    @Override public void controlChanged(UIControl control)
    {
        mediateUpdate = true;
        setValue(Double.valueOf(control.getControlValue()));
        mediateUpdate =false;
    }

    @Override public String getControlValue()
    {
        return Double.toString(getValue());
    }

    @Override public String getControlName()
    {
        return "Slider";
    }
}
