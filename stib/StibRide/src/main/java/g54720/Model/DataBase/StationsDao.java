package g54720.Model.DataBase;

import g54720.utils.Dao;
import g54720.utils.RepositoryException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StationsDao implements Dao<Integer,StationsDto> {
    private Connection connexion;
    public StationsDao()throws RepositoryException{
        connexion= DBManager.getInstance().getConnection();
    }

    public static StationsDao getInstance() throws RepositoryException{
        return StationsDao.StationsDaoHolder.getInstance();
    }
    @Override
    public void insert(StationsDto item) throws RepositoryException {

    }

    @Override
    public void delete(Integer key) throws RepositoryException {

    }

    @Override
    public void update(StationsDto item) throws RepositoryException {

    }

    @Override
    public StationsDto get(Integer key) throws RepositoryException {
        if(key==null){
            throw new RepositoryException("Station not founded");
        }
        String sql="SELECT id , name FROM STATIONS WHERE id = ?";
        StationsDto dto=null;
        try (PreparedStatement stmt=connexion.prepareStatement(sql)){
            stmt.setInt(1,key);
            ResultSet result=stmt.executeQuery();

            dto=new StationsDto(result.getInt(1),result.getString(2));

        }catch(SQLException e){
            throw new RepositoryException(e);
        }
        return dto;
    }

    @Override
    public List<StationsDto> getAll() throws RepositoryException {
        String sql="SELECT id , name FROM STATIONS";
        List<StationsDto> ldto=new ArrayList<>();
        try (ResultSet result=connexion.createStatement().executeQuery(sql)){

            while(result.next()){
                ldto.add(new StationsDto(result.getInt(1),result.getString(2)));
            }
        }catch(SQLException e){
            throw new RepositoryException(e);
        }
        return ldto;
    }

    private static class StationsDaoHolder{
        private static StationsDao getInstance() throws RepositoryException{
            return new StationsDao();
        }
    }
}
