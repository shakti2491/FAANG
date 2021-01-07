package designpattern.structural.decorator.webpage;

public class AuthenticateWebPage extends WebPageDecorator
{
    public AuthenticateWebPage(IWebPage webPage)
    {
        super(webPage);
    }

    private void authentication(){
        System.out.println("Authenticating");
    }
    @Override public void display()
    {
        this.authentication();
        super.display();
    }
}
