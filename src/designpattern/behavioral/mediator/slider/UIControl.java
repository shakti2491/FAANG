package designpattern.behavioral.mediator.slider;

public interface UIControl
{
    void controlChanged(UIControl control);

    String getControlValue();

    String getControlName();
}
