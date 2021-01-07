package designpattern.behavioral.chainofresponsibility.leaveapprover;

import java.time.Duration;
import java.time.LocalDate;


public class LeaveApplication
{
    public enum Type {Sick, PTO,LOP};

    public enum Status {Pending, Approved, Rejected};

    private Type type;

    private LocalDate from;

    private LocalDate to;

    private String processedBy;

    private Status status;

    public LeaveApplication(Type type, LocalDate from, LocalDate to)
    {
        this.type = type;
        this.from = from;
        this.to = to;
    }

    public Type getType()
    {
        return type;
    }

    public void setType(Type type)
    {
        this.type = type;
    }

    public LocalDate getFrom()
    {
        return from;
    }

    public void setFrom(LocalDate from)
    {
        this.from = from;
    }

    public LocalDate getTo()
    {
        return to;
    }

    public void setTo(LocalDate to)
    {
        this.to = to;
    }

    public String getProcessedBy()
    {
        return processedBy;
    }

    public void setProcessedBy(String processedBy)
    {
        this.processedBy = processedBy;
    }

    public Status getStatus()
    {
        return status;
    }

    public void setStatus(Status status)
    {
        this.status = status;
    }

    public long getNoOfDays(){
        return Duration.between( to.atStartOfDay(),from.atStartOfDay()).toDays();
    }

    public void approve(String approverName) {
        this.status = Status.Approved;
        this.processedBy = approverName;
    }

    public void reject(String approverName) {
        this.status = Status.Rejected;
        this.processedBy = approverName;
    }
    public static Builder getBuilder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return type + " leave for "+getNoOfDays()+" day(s) "+status
                + " by "+processedBy;
    }
    public static class Builder {
        private Type type;
        private LocalDate from;
        private LocalDate to;
        private LeaveApplication application;

        private Builder() {

        }

        public Builder withType(Type type) {
            this.type = type;
            return this;
        }

        public Builder from(LocalDate from) {
            this.from = from;
            return this;
        }

        public Builder to(LocalDate to) {
            this.to = to;
            return this;
        }

        public LeaveApplication build() {
            this.application = new LeaveApplication(type, from, to);
            return this.application;
        }

        public LeaveApplication getApplication() {
            return application;
        }
    }
}
