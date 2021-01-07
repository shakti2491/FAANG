package designpattern.behavioral.command.paste;

import designpattern.behavioral.command.emailexchange.ICommand;

public interface IInvoker
{
    void invokeCommand(ICommand command);
}
