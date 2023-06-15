
package entites;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author saugat
 */
public class Futsal {
    private BigDecimal id;
    private String name;
    private BigInteger pan;
    private String address;
    private BigInteger mobile;
    private BigDecimal rate;
    private BigDecimal userId;

    public BigDecimal getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigInteger getPan() {
        return pan;
    }

    public String getAddress() {
        return address;
    }

    public BigInteger getMobile() {
        return mobile;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPan(BigInteger pan) {
        this.pan = pan;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMobile(BigInteger mobile) {
        this.mobile = mobile;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal getUserId() {
        return userId;
    }

    public void setUserId(BigDecimal userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Futsal{" + "id=" + id + ", name=" + name + ", pan=" + pan + ", address=" + address + ", mobile=" + mobile + ", rate=" + rate + ", userId=" + userId + '}';
    }

    
    
}
