package designpattern.structural.decorator.webpage;

public class BasicWebPage implements IWebPage
{
    private String html;
    private String css;
    private  String scripts;
    @Override public void display()
    {
        System.out.println("Displaying webPage");
    }
}
