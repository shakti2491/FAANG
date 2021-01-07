package designpattern.behavioral.chainofresponsibility.leaveapprover;

import java.time.LocalDate;

public class Client
{
    public static void main(String[] args)
    {
        LeaveApplication application = LeaveApplication.getBuilder()
                                                       .withType(LeaveApplication.Type.Sick)
                .from(LocalDate.now()).to(LocalDate.of(2020,9,22)).build();

        System.out.println(application);
        IApproverChain approverChain = new ApproverChain();
        approverChain.approveLeave(application);
        System.out.println(application);

    }
}
