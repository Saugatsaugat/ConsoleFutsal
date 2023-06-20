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
public class UserCRUD extends CRUDInterface<User> {

    public UserCRUD(User obj) throws SQLException {
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

    public boolean create(User data) throws SQLException {
        String insertQuery = "Insert into User(usertype,email,firstname,midname,lastname,mobile,userpassword) " + "values(?,?,?,?,?,?,?);";
        PreparedStatement ps = getConnection().prepareStatement(insertQuery);

        ps.setString(1, data.getUsertype());
        ps.setString(2, data.getEmail());
        ps.setString(3, data.getFirstname());
        ps.setString(4, data.getMidname());
        ps.setString(5, data.getLastname());
        ps.setLong(6, data.getMobile());
        ps.setString(7, data.getUserpassword());
        int status = ps.executeUpdate();
        if(status>0) {
            return true;
        }
        else{
            return false;
        }
        
    }

    public User getEmailByData(String email) throws SQLException {
        String getData = "select * from User where email=?";
        PreparedStatement ps = getConnection().prepareStatement(getData);
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();
        if (rs != null && rs.next()) {
            User list = new User();
            list.setId(rs.getLong("id"));
            list.setUsertype(rs.getString("usertype"));
            list.setEmail(rs.getString("email"));
            list.setFirstname(rs.getString("firstname"));
            list.setMidname(rs.getString("midname"));
            list.setLastname(rs.getString("lastname"));
            list.setMobile(rs.getLong("mobile"));
            list.setUserpassword(rs.getString("userpassword"));
            return list;
        } else {
            return null;
        }

    }
    
    public boolean updateUser(User user, Long id) throws SQLException{
       String updateQuery = "update User set email=?,firstname=?,midname=?,lastname=?,mobile=? where id="+id;
       PreparedStatement ps = getConnection().prepareStatement(updateQuery);
       ps.setString(1, user.getEmail());
       ps.setString(2, user.getFirstname());
       ps.setString(3, user.getMidname());
       ps.setString(4,user.getLastname());
       ps.setLong(5,user.getMobile());
       if(ps.execute()){
           return true;
       }
       else{
           return true;
       }
    }

}
