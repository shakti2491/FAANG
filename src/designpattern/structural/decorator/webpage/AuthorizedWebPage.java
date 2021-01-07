package designpattern.structural.decorator.webpage;

public class AuthorizedWebPage extends WebPageDecorator
{
    public AuthorizedWebPage(IWebPage webPage)
    {
        super(webPage);
    }
    private void authorizeUser(){
        System.out.println("Authorizing");
    }

    @Override public void display()
    {
        this.authorizeUser();
        super.display();
    }
}
