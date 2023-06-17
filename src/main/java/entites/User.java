
package entites;

/**
 *
 * @author saugat
 */
public class User extends AbstractEntity implements IAbstractEntity{

    private String usertype;
    private String email;
    private String firstname;
    private String midname;
    private String lastname;
    private Long mobile;
    private String userpassword;

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
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

    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }

    public Long getMobile() {
        return mobile;
    }

 
    
    @Override 
    public String getTableName(){
        return "User";
    }

  
}
