/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.util.List;

/**
 *
 * @author <@Gabriel.espinosa>
 */
public interface Observable {

    /**
     * Register an observer.
     *
     * @param observer the observer.
     */
    public void registerObserver(Observer observer);

    /**
     * Notify the observers.
     *
     * @param object the list of object that will be given to the observer.
     */
    public void notifyObserver(List<Object> object);

}

