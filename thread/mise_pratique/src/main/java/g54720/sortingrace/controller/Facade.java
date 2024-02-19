package g54720.sortingrace.controller;

import g54720.sortingrace.model.*;
import g54720.sortingrace.util.Observable;
import g54720.sortingrace.util.Observer;

import java.util.ArrayList;


public class Facade implements Observable ,Observer {
    private final ArrayList<Observer> observer;
    private DataGenerator dataGenerator;


    public Facade() {
        observer=new ArrayList<>();
    }

    public void start(SizeSort size, Type type, int nbThreads){
        dataGenerator=new DataGenerator(size,type); // nbThread pas nécessaire ?
        for(int i=0;i<nbThreads;i++){
            Sort sort=createSort(type,size);
            SortingThread thr=new SortingThread(sort); // passer le sort ou le type de sort.
            thr.registerObserver(this);
            thr.start();
        }
    }

    private Sort createSort(Type type , SizeSort size){
        switch (type){
            case BUBBLE:
                return new BubbleSort(size.nbr());
            case MERGE:
                return new MergeSort(size.nbr());
            default:
                return null;
        }
    }
    @Override
    public void registerObserver(Observer observer) {
        this.observer.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {

    }

    @Override
     public void notifyObserver(Object object) {
        for(Observer o:this.observer){
            o.update(object);
        }
    }

    @Override
    public void update(Object object) {
        notifyObserver(object);
    }
}
