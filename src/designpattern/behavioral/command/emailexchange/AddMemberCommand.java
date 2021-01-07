package designpattern.behavioral.command.emailexchange;

public class AddMemberCommand implements ICommand
{
    private String emailAddress;
    private String listName;

    private EWSService receiver;

    public AddMemberCommand(String emailAddress, String listName, EWSService receiver)
    {
        this.emailAddress = emailAddress;
        this.listName = listName;
        this.receiver = receiver;
    }

    @Override public void execute()
    {
        this.receiver.addMember(emailAddress,listName);
    }
}
