
import controller.ValidationController;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author saugat
 */
public class ValidationContollerTest {
    
    @Test
    public void validateEmail() {
        String email = "saugat@gmail.com";
        ValidationController obj = new ValidationController();
        String output = obj.checkEmail(email);
        assertEquals(null,output);

    }
    
   
    
    

}
