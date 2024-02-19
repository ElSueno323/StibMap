package g54720.Model.DataBase;

import g54720.utils.Dao;
import g54720.utils.RepositoryException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StopsDao implements Dao<Integer[],StopsDto> {

    private Connection connexion;

    public StopsDao()throws RepositoryException{
        connexion=DBManager.getInstance().getConnection();
    }

    public static StopsDao getInstance() throws RepositoryException{
        return  StopsDao.StopsDaoHolder.getInstance();
    }

    @Override
    public void insert(StopsDto item) throws RepositoryException {

    }

    @Override
    public void delete(Integer[] key) throws RepositoryException {

    }

    @Override
    public void update(StopsDto item) throws RepositoryException {

    }

    @Override
    public StopsDto get(Integer[] key) throws RepositoryException {
        if(key.length!=3){
            throw new RepositoryException("key not valide");
        }
        StopsDto dto=null;
        String sql=" SELECT id_line ,id_station ,id_order FROM STOPS where id_line = ? AND id_stops = ? AND id_order = ?";
        try (PreparedStatement stmt=connexion.prepareStatement(sql)){
            stmt.setInt(1,key[0]);
            stmt.setInt(2,key[1]);
            stmt.setInt(3,key[2]);

            ResultSet result=stmt.executeQuery();

            dto=new StopsDto(result.getInt(1),result.getInt(2),result.getInt(3));
        }catch(SQLException e){
            throw new RepositoryException(e);
        }
        return dto;
    }

    @Override
    public List<StopsDto> getAll() throws RepositoryException {
        String sql="SELECT id_line ,id_station ,id_order FROM STOPS ";
        List<StopsDto> ldto=new ArrayList<>();
        try (ResultSet result= connexion.createStatement().executeQuery(sql)){
            while (result.next()){
                ldto.add(new StopsDto(
                        result.getInt(1), result.getInt(2),result.getInt(3) ));
            }
        }catch (SQLException e){
            throw new RepositoryException(e);
        }
        return ldto;
    }

    private static class StopsDaoHolder{
        private static StopsDao getInstance()throws RepositoryException{
            return new StopsDao();
        }
    }
}
