package designpattern.behavioral.command.emailexchange;

import java.util.LinkedList;
import java.util.List;

public class MailTaskRunner implements  Runnable
{

    private Thread runner;

    private List<ICommand> pendingCommands;

    private volatile boolean stop;

    private static final MailTaskRunner RUNNER = new MailTaskRunner();

    public static final MailTaskRunner getInstance() {
        return RUNNER;
    }

    private MailTaskRunner() {
        pendingCommands = new LinkedList<>();
        runner = new Thread(this);
        runner.start();
    }

    //Run method takes pending commands and executes them.
    @Override
    public void run() {

        while (true) {
            ICommand cmd = null;
            synchronized (pendingCommands) {
                if (pendingCommands.isEmpty()) {
                    try {
                        pendingCommands.wait();
                    } catch (InterruptedException e) {
                        System.out.println("Runner interrupted");
                        if (stop) {
                            System.out.println("Runner stopping");
                            return;
                        }
                    }
                } else {
                    cmd = pendingCommands.remove(0);
                }
            }
            if (cmd == null)
                return;
            cmd.execute();
        }

    }

    //Giving it a command will schedule it for later execution
    public void addCommand(ICommand cmd) {
        synchronized (pendingCommands) {
            pendingCommands.add(cmd);
            pendingCommands.notifyAll();
        }
    }

    public void shutdown() {
        this.stop = true;
        this.runner.interrupt();
    }
}
