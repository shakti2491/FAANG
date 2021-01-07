package designpattern.behavioral.chainofresponsibility.leaveapprover;

public class ApproverChain implements IApproverChain
{

    private ILeaveApprover[] approvers = new ILeaveApprover[0];
    private int pos;
    private int n;
    @Override public void approveLeave(LeaveApplication leaveApplication)
    {
        if(n<pos){
            ILeaveApprover leaveApprover = approvers[pos++];
            leaveApprover.processLeaveApplication(leaveApplication,this);
        }

    }

}
