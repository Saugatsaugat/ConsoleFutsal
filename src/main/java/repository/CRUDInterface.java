
package repository;

import java.util.List;

/**
 *
 * @author saugat
 */
public interface CRUDInterface<T1> {
    public T1 create(T1 data);
    public List<T1> getAllData();
    public T1 getDataById(String email);
    public boolean deleteById(String email);
}