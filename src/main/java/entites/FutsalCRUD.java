
package entites;

import java.math.BigDecimal;
import java.util.List;
import repository.CRUDRepo;

/**
 *
 * @author saugat
 */
public class FutsalCRUD extends CRUDRepo<Futsal> {
    public static FutsalCRUD obj1 = new FutsalCRUD();

    public boolean addFutsal(Futsal futsalInformation) {
        if ((obj1.create(futsalInformation)) != null) {
            return true;
        }
        return false;
    }

    ////////////////////////////////////
    public List<Futsal> getFutsalList() {
        return obj1.getAllData();
    }

//    //////////////////////////////////////
    public Futsal getFutsalDataById(BigDecimal id) {
        Futsal futsal = obj1.getDataById(id);
        if(futsal!=null){
            return futsal;
        }
        return null;
    }
    
    public boolean deleteFutsalDataById(BigDecimal id)
    {
        if(obj1.deleteById(id)){
            return true;
        }
        return false;

    }
    
}
