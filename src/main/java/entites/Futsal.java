
package entites;

import java.math.BigDecimal;

/**
 *
 * @author saugat
 */
public class Futsal extends AbstractEntity implements IAbstractEntity{
    private String name;
    private Long pan;
    private String address;
    private Long mobile;
    private BigDecimal rate;
    private Long userId;

    
    public String getName() {
        return name;
    }

    public Long getPan() {
        return pan;
    }

    public String getAddress() {
        return address;
    }

    public Long getMobile() {
        return mobile;
    }

    public BigDecimal getRate() {
        return rate;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setPan(Long pan) {
        this.pan = pan;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String getTableName() {
        return "Futsal";
    }


    
    
}
