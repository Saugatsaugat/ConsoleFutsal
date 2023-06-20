
import controller.JDBCController;
import java.sql.Connection;
import java.sql.SQLException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author saugat
 */
public class ConnectionTest {
    
    @Test
    public void testDatabase() throws ClassNotFoundException, SQLException{
        System.out.println("Database Connection Testing: successResult method");
        String expected = "Established";
        String actual = new JDBCController().successResult();
        assertEquals(expected,actual);
    }
    
    @Test
    public void testGetCon() throws ClassNotFoundException, SQLException{
        System.out.println("Database Connection Testing: getCon method");
        Connection con = new JDBCController().getCon();
        assertNotNull("Con must have Connection",con);
    }
    
}
