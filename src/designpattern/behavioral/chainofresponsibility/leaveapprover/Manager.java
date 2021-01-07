package designpattern.behavioral.chainofresponsibility.leaveapprover;

public class Manager extends Employee
{
    public Manager(ILeaveApprover successor)
    {
        super("Manager", successor);
    }

    @Override protected boolean processRequest(LeaveApplication leaveApplication)
    {
        switch (leaveApplication.getType()) {
            case Sick:
                leaveApplication.approve(this.getApproverRole());
                return true;
            case PTO:
                if(leaveApplication.getNoOfDays() <=5){
                    leaveApplication.approve(getApproverRole());
                    return true;
                }
        }

        return false;
    }
}
