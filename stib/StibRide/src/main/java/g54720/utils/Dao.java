package g54720.utils;

import java.util.List;

public interface Dao <K, T extends Dto<K>>{
    public void insert(T item) throws  RepositoryException;
    public void delete(K key) throws  RepositoryException;
    public void update(T item) throws RepositoryException;
    public T get(K key) throws RepositoryException;
    public List<T> getAll() throws RepositoryException;
}
