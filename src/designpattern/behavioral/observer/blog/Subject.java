package designpattern.behavioral.observer.blog;

import java.util.ArrayList;

public class Subject
{
    private ArrayList<IObserver> observers = new ArrayList<>();
    public void registerObserver(IObserver observer){
        observers.add(observer);
    }

    public void unregister(IObserver observer){
        observers.remove(observer);
    }

    public void notifying(){
        for(IObserver observer : observers){
            observer.update(this);
        }
    }
}
