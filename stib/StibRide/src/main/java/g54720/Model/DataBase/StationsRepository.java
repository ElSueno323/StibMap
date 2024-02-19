package g54720.Model.DataBase;

import g54720.utils.Repository;
import g54720.utils.RepositoryException;

import java.util.List;

public class StationsRepository implements Repository<Integer ,StationsDto> {
    private final StationsDao dao;
    public StationsRepository() throws RepositoryException{
        dao=StationsDao.getInstance();
    }
    @Override
    public void add(StationsDto item) throws RepositoryException {

    }

    @Override
    public void remove(Integer key) throws RepositoryException {

    }

    @Override
    public StationsDto get(Integer key) throws RepositoryException {
        StationsDto copy= dao.get(key);
       return copy;
    }

    @Override
    public List<StationsDto> getAll() throws RepositoryException {
        return dao.getAll();
    }

    @Override
    public boolean contains(Integer key) throws RepositoryException {
        StationsDto copy=dao.get(key);
        return copy!=null;
    }
}
