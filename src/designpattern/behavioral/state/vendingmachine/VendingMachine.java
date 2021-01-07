package designpattern.behavioral.state.vendingmachine;

import designpattern.behavioral.state.vendingmachine.state.State;

public class VendingMachine
{
    private State idleState;
    private State outOfStockState;
    private State hasOneDollarState;

    private State currentState;
    int count;

    public VendingMachine(int count)
    {
        this.count = count;
    }
}
