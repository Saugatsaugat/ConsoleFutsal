
package repository;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author saugat
 */
public interface CRUDInterface<T1> {
    public boolean create(T1 data);
    public List<T1> getAllData();
    public T1 getDataById(BigDecimal id);
    public boolean deleteById(BigDecimal id);
}