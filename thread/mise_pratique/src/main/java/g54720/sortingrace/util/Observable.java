package g54720.sortingrace.util;

import java.util.List;

public interface Observable {
    public void registerObserver(Observer observer);

    public void removeObserver(Observer observer);

    public void notifyObserver(Object object); // Object et pas list ?
}
