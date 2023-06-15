
package entites;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author saugat
 */
public class User {
    private BigDecimal id;
    private String type;
    private String email;
    private String firstname;
    private String midname;
    private String lastname;
    private BigInteger mobile;
    private String password;

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setMidname(String midname) {
        this.midname = midname;
    }

    public String getMidname() {
        return midname;
    }

    public void setMobile(BigInteger mobile) {
        this.mobile = mobile;
    }

    public BigInteger getMobile() {
        return mobile;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{ " + "id=" + id + ", type=" + type + ", email=" + email + ", firstname=" + firstname + ", lastname=" + lastname + ", mobile=" + mobile + ", password=" + password + '}';
    }
}
