package designpattern.behavioral.command.emailexchange;

public class Client
{
    public static void main(String[] args) throws InterruptedException
    {
        EWSService service = new EWSService();
        ICommand c1 = new AddMemberCommand("a@a.com","spam",service);
        MailTaskRunner.getInstance().addCommand(c1);

        ICommand c2 = new AddMemberCommand("b@b.com","spam",service);
        MailTaskRunner.getInstance().addCommand(c2);

        Thread.sleep(3000);
        MailTaskRunner.getInstance().shutdown();
    }
}
