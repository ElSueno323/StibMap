package g54720.utils;

import java.util.ArrayList;
import java.util.List;

public class Observable {
    private final List<Observer> observers;

    public Observable(){
        observers=new ArrayList<>();
    }
    public void registerObserver(Observer observer){
        if(observer==null){
            throw new NullPointerException();
        }
        if(!observers.contains(observer)){
            observers.add(observer);
        }
    }

    public synchronized void removeObserver(Observer observer){
        observers.remove(observer);
    }

    public void notifyObserver(Object object){
        for(Observer observer: observers){
            observer.update(this,object);
        }
    }

}
