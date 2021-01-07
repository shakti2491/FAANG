package designpattern.behavioral.state.vendingmachine.state;

import designpattern.behavioral.state.vendingmachine.VendingMachine;

public interface State
{
    void insertDollar(VendingMachine vendingMachine);
    void ejectMoney(VendingMachine vendingMachine);
    void dispense(VendingMachine vendingMachine);
}
