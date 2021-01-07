package designpattern.behavioral.chainofresponsibility.leaveapprover;

public interface ILeaveApprover
{
    void processLeaveApplication(LeaveApplication leaveApplication, IApproverChain chain);
    String getApproverRole();
}
