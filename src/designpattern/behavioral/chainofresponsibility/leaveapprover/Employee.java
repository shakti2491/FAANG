package designpattern.behavioral.chainofresponsibility.leaveapprover;

public abstract class Employee implements ILeaveApprover
{
    private String role;
    private ILeaveApprover successor;
    public Employee(String role, ILeaveApprover successor){
        this.role = role;
        this.successor = successor;
    }

    @Override public void processLeaveApplication(LeaveApplication leaveApplication, IApproverChain approverChain)
    {
        if(!processRequest(leaveApplication))
            approverChain.approveLeave(leaveApplication);

    }

    protected abstract boolean processRequest(LeaveApplication leaveApplication);

    @Override public String getApproverRole()
    {
        return role;
    }
}
