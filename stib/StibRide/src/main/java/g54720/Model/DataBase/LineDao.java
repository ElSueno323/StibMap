package g54720.Model.DataBase;

import g54720.utils.Dao;
import g54720.utils.RepositoryException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LineDao implements Dao<Integer,LineDto> {

    private Connection connexion;
    public LineDao()throws RepositoryException{
        connexion= DBManager.getInstance().getConnection();
    }

public static LineDao getInstance() throws RepositoryException{
        return LineDaoHolder.getInstance();
}
    @Override
    public void insert(LineDto item) throws RepositoryException {

    }

    @Override
    public void delete(Integer key) throws RepositoryException{

    }

    @Override
    public void update(LineDto item)  throws RepositoryException{

    }

    @Override
    public LineDto get(Integer key) throws RepositoryException {
        if(key==null){
            throw new RepositoryException("Item don't exist");
        }
        String sql="SELECT id FROM LINES WHERE id = ?";
        LineDto dto=null;
        try (PreparedStatement stmt=connexion.prepareStatement(sql)){
            stmt.setInt(1,key);
            ResultSet result=stmt.executeQuery();

            dto=new LineDto(result.getInt(1));
        }catch(SQLException e){
            throw new RepositoryException(e);
        }
        return dto;
    }

    @Override
    public List<LineDto> getAll() throws RepositoryException{
        List<LineDto> ldto=new ArrayList<>();
        String sql="SELECT id FROM LINES";

        try(PreparedStatement stmt=connexion.prepareStatement(sql);
            ResultSet result=stmt.executeQuery()) {
            while(result.next()){
                ldto.add(new LineDto(result.getInt(1)));
            }
        }catch (SQLException e){
            throw new RepositoryException(e);
        }
        return null;
    }
    private static class LineDaoHolder{
        private static LineDao getInstance() throws RepositoryException{
            return new LineDao();
        }
    }
}
