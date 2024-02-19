package g54720.Model.DataBase;

import g54720.utils.Repository;
import g54720.utils.RepositoryException;

import java.util.List;

public class FavorisRepository implements Repository<Integer[],FavorisDto> {
    private final FavorisDao favorisDao;

    public  FavorisRepository()throws RepositoryException{
        favorisDao=FavorisDao.getInstance();
    }

    @Override
    public void add(FavorisDto item) throws RepositoryException {
        favorisDao.insert(item);
    }

    @Override
    public void remove(Integer[] key) throws RepositoryException {
        favorisDao.delete(key);
    }

    @Override
    public FavorisDto get(Integer[] key) throws RepositoryException {
        return favorisDao.get(key);
    }

    @Override
    public List<FavorisDto> getAll() throws RepositoryException {
        return favorisDao.getAll();
    }


    @Override
    public boolean contains(Integer[] key) throws RepositoryException {
        return false;
    }
}
