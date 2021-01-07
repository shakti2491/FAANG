package designpattern.behavioral.chainofresponsibility.leaveapprover;

public class Director extends Employee
{
    public Director( ILeaveApprover successor)
    {
        super("Director", successor);
    }

    @Override protected boolean processRequest(LeaveApplication leaveApplication)
    {
        if(leaveApplication.getType() == LeaveApplication.Type.PTO)
        {
            leaveApplication.approve(getApproverRole());
            return true;
        }
        return false;
    }
}
