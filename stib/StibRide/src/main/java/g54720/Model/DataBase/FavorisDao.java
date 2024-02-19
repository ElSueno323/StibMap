package g54720.Model.DataBase;

import g54720.utils.Dao;
import g54720.utils.RepositoryException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FavorisDao implements Dao<Integer[],FavorisDto> {
    private Connection connection;

    public FavorisDao()throws RepositoryException{
        connection=DBManager.getInstance().getConnection();
    }

    public static FavorisDao getInstance() throws  RepositoryException{
        return  FavorisDao.FavorisDaoHolder.getInstance();
    }

    @Override
    public void insert(FavorisDto item) throws RepositoryException {
        String sql=" INSERT INTO FAVORIS ( id_origin , id_destination ) VALUES (?,?) ";
        try(PreparedStatement preparedStatement=connection.prepareStatement(sql)){
            preparedStatement.setInt(1,item.getId_origin());
            preparedStatement.setInt(2,item.getId_destination());
            preparedStatement.executeUpdate();

        }catch (SQLException exception){
            throw new RepositoryException(exception);
        }
    }

    @Override
    public void delete(Integer[] key) throws RepositoryException {
        String sql=" DELETE FROM FAVORIS WHERE  id_favoris = ? AND id_origin = ? AND id_destination = ? ";
        try(PreparedStatement preparedStatement=connection.prepareStatement(sql)){
            preparedStatement.setInt(1,key[0]);
            preparedStatement.setInt(2,key[1]);
            preparedStatement.setInt(3,key[2]);
            preparedStatement.executeUpdate();

        }catch (SQLException exception){
            throw new RepositoryException(exception);
        }

    }

    @Override
    public void update(FavorisDto item) throws RepositoryException {
        String sql=" INSERT INTO FAVORIS ( id_origin , id_destination ) VALUES (?,?,?) ";
        try(PreparedStatement preparedStatement=connection.prepareStatement(sql)){
            preparedStatement.setInt(1,item.getId_origin());
            preparedStatement.setInt(2,item.getId_destination());
            preparedStatement.executeUpdate();

        }catch (SQLException exception){
            throw new RepositoryException(exception);
        }

    }

    @Override
    public FavorisDto get(Integer[] key) throws RepositoryException {
        if(key.length!=3){
            throw new RepositoryException("key not valide");
        }
        FavorisDto favorisDto=null;
        String sql="SELECT id_favoris ,id_origin ,id_destination,A.name,Z.name FROM FAVORIS " +
                "JOIN STATIONS A on id_origin=A.id " +
                "JOIN STATIONS Z on id_destination=Z.id where id_favoris = ? " +
                "AND id_origin= ? AND id_destination=?";
        try (PreparedStatement preparedStatement=connection.prepareStatement(sql)){
            preparedStatement.setInt(1,key[0]);
            preparedStatement.setInt(2,key[1]);
            preparedStatement.setInt(3,key[2]);

            ResultSet resultSet= preparedStatement.executeQuery();

            favorisDto=new FavorisDto(resultSet.getInt(1),resultSet.getInt(2),resultSet.getInt(3),
                    resultSet.getString(4),resultSet.getString(5));
        }catch (SQLException exception){
            throw new RepositoryException(exception);
        }
        return favorisDto;
    }

    @Override
    public List<FavorisDto> getAll() throws  RepositoryException{
        String sql ="SELECT id_favoris ,id_origin ,id_destination,A.name,Z.name FROM FAVORIS " +
                "JOIN STATIONS A on id_origin=A.id "+
                "JOIN STATIONS Z on id_destination=Z.id ";
        List<FavorisDto> listFavoris=new ArrayList<>();
        try(ResultSet resultSet=connection.createStatement().executeQuery(sql)){
            while(resultSet.next()){
                listFavoris.add(new FavorisDto(
                        resultSet.getInt(1),resultSet.getInt(2),resultSet.getInt(3),
                        resultSet.getString(4),resultSet.getString(5)));

            }
        }catch (SQLException exception){
            throw new RepositoryException(exception);
        }
        return listFavoris;
    }


    private static class FavorisDaoHolder{
        private static FavorisDao getInstance()throws RepositoryException{
            return new FavorisDao();
        }
    }
}
