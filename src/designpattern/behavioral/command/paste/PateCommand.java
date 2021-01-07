package designpattern.behavioral.command.paste;

import designpattern.behavioral.command.emailexchange.ICommand;

public class PateCommand implements ICommand
{
    // receiver
    private Document document;
    private int position;
    private String text;
    @Override public void execute()
    {

    }
}
