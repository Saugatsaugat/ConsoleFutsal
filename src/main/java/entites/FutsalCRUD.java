package entites;

import controller.JDBCController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import repository.CRUDInterface;

/**
 *
 * @author saugat
 */
public class FutsalCRUD extends CRUDInterface<Futsal> {

    public FutsalCRUD(Futsal obj) throws SQLException {
        super(obj);
    }

    @Override
    public Connection getConnection() {
        try {
            return new JDBCController().getCon();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FutsalCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean create(Futsal data) throws SQLException {
        String insertQuery = "Insert into Futsal(pan,name,mobile,rate,address,ownerId) "
                + "values(?,?,?,?,?,?,?);";

        PreparedStatement ps = getConnection().prepareStatement(insertQuery);
        ps.setLong(1, data.getPan());
        ps.setString(2, data.getName());

        ps.setLong(4, data.getMobile());
        ps.setBigDecimal(5, data.getRate());
        ps.setString(3, data.getAddress());
        ps.setLong(6, data.getUserId());
        if (ps.execute()) {
            return true;
        }
        return false;
    }

    public boolean updateFutsal(Futsal user, Long id) throws SQLException {
        String updateQuery = "update Futsal set pan=?,name=?,address=?,mobile=?,rate=? where id=" + id;
        PreparedStatement ps = getConnection().prepareStatement(updateQuery);
        ps.setLong(1, user.getPan());
        ps.setString(2, user.getName());
        ps.setString(3, user.getAddress());
        ps.setLong(4, user.getMobile());
        ps.setBigDecimal(5, user.getRate());
        if (ps.execute()) {
            return true;
        } else {
            return true;
        }
    }

    public boolean checkIfFutsalRegistered(Long id) throws SQLException {
        String checkFutsalOwnerId = "select * from Futsal where ownerid=?";
        PreparedStatement ps = getConnection().prepareStatement(checkFutsalOwnerId);
        ps.setLong(1, id);
        if (ps.execute()) {
            return true;
        } else {
            return false;
        }
    }

    public Futsal getFutsalDataByOwnerId(Long id) throws SQLException {
        String getData = "select * from Futsal where ownerid=?";
        PreparedStatement ps = getConnection().prepareStatement(getData);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        if(rs!=null && rs.next()){
            Futsal list = new Futsal();
            list.setId(rs.getLong("id"));
            list.setPan(rs.getLong("pan"));
            list.setName(rs.getString("name"));
            list.setMobile(rs.getLong("mobile"));
            list.setRate(rs.getBigDecimal("rate"));
            list.setAddress(rs.getString("address"));
            return list;
        }
        else{
            return null;
        }
    }

}
