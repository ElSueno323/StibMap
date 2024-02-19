package g54720.Model.DataBase;

import g54720.utils.Repository;
import g54720.utils.RepositoryException;

import java.util.List;

public class StopsRepository implements Repository<Integer[],StopsDto> {
    private final StopsDao dao;

    public StopsRepository() throws RepositoryException{
        dao=StopsDao.getInstance();
    }

    @Override
    public void add(StopsDto item) throws RepositoryException {

    }

    @Override
    public void remove(Integer[] key) throws RepositoryException {

    }

    @Override
    public StopsDto get(Integer[] key) throws RepositoryException {
        return dao.get(key);
    }

    @Override
    public List<StopsDto> getAll() throws RepositoryException {
        return dao.getAll();
    }

    @Override
    public boolean contains(Integer[] key) throws RepositoryException {
        return dao.get(key)!=null;
    }
}
