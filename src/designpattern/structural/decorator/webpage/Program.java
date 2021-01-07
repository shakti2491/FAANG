package designpattern.structural.decorator.webpage;

public class Program
{
    public static void main(String[] args)
    {
        IWebPage webPage = new BasicWebPage();
        webPage = new AuthorizedWebPage(webPage);
        webPage = new AuthenticateWebPage(webPage);
        webPage.display();
    }
}
