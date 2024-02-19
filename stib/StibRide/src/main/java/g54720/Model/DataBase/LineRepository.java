package g54720.Model.DataBase;

import g54720.utils.Repository;
import g54720.utils.RepositoryException;

import java.util.List;

public class LineRepository implements Repository<Integer,LineDto> {
    private final LineDao dao;
    public LineRepository() throws RepositoryException{
        dao=LineDao.getInstance();
    }

    @Override
    public void add(LineDto item) throws RepositoryException {
        Integer key= item.getKey();
        if(contains(item.getKey())){
            dao.update(item);
        }else{
            dao.insert(item);
        }
    }

    @Override
    public void remove(Integer key) throws RepositoryException {
        if(contains(key)){
            dao.delete(key);
        }else{
            throw new RepositoryException("This Line no exist");
        }
    }

    @Override
    public LineDto get(Integer key) throws RepositoryException {
        return dao.get(key);
    }

    @Override
    public List<LineDto> getAll() throws RepositoryException {
        return dao.getAll();
    }

    @Override
    public boolean contains(Integer key) throws RepositoryException {
        return dao.get(key)!=null ;
    }
}
