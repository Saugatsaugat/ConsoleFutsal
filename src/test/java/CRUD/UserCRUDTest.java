package CRUD;

import controller.PasswordHashController;
import entites.User;
import entites.UserCRUD;
import java.sql.ResultSet;
import java.sql.SQLException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.Suite;

/**
 *
 * @author saugat
 */
@RunWith(JUnit4.class)
public class UserCRUDTest {

    @Test
    public void testCreate() throws SQLException {
        System.out.println("Testing Create Method");
        User user = new User();
        user.setUsertype("futsalowner");
        user.setFirstname("Anita");
        user.setLastname("Singh");
        user.setEmail("anita7@gmail.com");
        user.setMobile(98450881L);
        user.setUserpassword(new PasswordHashController().getPasswordHash("Nepal@123"));

        boolean expected = true;
        boolean actual = new UserCRUD(new User()).create(user);
        assertEquals(expected, actual);

    }

    @Test
    public void testDeleteById() throws SQLException {
        System.out.println("Testing Deleting by Id in User Column");
        Long id = 9L;
        boolean expected = true;
        boolean result = new UserCRUD(new User()).deleteById(id);
        assertEquals(expected, result);
    }

    @Test
    public void testReadAllData() throws SQLException {
        System.out.println("Testing Read all data from User");
        ResultSet rs = new UserCRUD(new User()).getAllData();
        assertNotNull("Cannot be null", rs);
    }

    @Test
    public void testUpdateUser() throws SQLException {
        System.out.println("Testing update by Id in User column");
        User user = new User();
        user.setUsertype("futsalowner");
        user.setFirstname("Anita");
        user.setLastname("Singh");
        user.setEmail("anitaa@gmail.com");
        user.setMobile(98450881L);
        user.setUserpassword(new PasswordHashController().getPasswordHash("Nepal@123"));
        Long id = 7L;
        boolean actual = new UserCRUD(new User()).updateUser(user, id);
        assertTrue(actual);

    }



}
