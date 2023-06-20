package repository;

import entites.IAbstractEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author saugat
 * @param <T>
 */
public abstract class CRUDInterface<T extends IAbstractEntity> {

    private T obj;

    public abstract Connection getConnection();
    Statement st;

    public CRUDInterface(T obj) throws SQLException {
        this.st = getConnection().createStatement();
        this.obj = obj;
    }
    

    public ResultSet getAllData() throws SQLException {
        String allDataQuery = "Select * from " + obj.getTableName()+";";
        ResultSet rs = st.executeQuery(allDataQuery);
        if(rs!=null){
            return rs;
        }
        return null;
    }

    public ResultSet getDataById(Long id) throws SQLException {
        String getDataByIdQuery = "select * from " + obj.getTableName() + " where id=?";
        PreparedStatement ps = getConnection().prepareStatement(getDataByIdQuery);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs != null) {
            return rs;
        }
        return null;
    }

    public boolean deleteById(Long id) throws SQLException {
        String deleteQuery = "delete from " + obj.getTableName() + " where id=?";
        PreparedStatement ps = getConnection().prepareStatement(deleteQuery);
        ps.setLong(1,id);
        int status = ps.executeUpdate();
        if(status>0){
            return true;
        }
        else{
        return false;
        }
    }

}
