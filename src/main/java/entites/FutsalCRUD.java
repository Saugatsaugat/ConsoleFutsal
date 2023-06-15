/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entites;

import java.math.BigDecimal;
import java.util.List;
import repository.CRUDRepo;

/**
 *
 * @author saugat
 */
public class FutsalCRUD extends CRUDRepo<Futsal> {
    static FutsalCRUD obj = new FutsalCRUD();

    public boolean addFutsal(Futsal futsalInformation) {
        if ((obj.create(futsalInformation)) == null) {
            return false;
        }
        return true;
    }

    ////////////////////////////////////
    public List<Futsal> getFutsalList() {
        return obj.getAllData();
    }

//    //////////////////////////////////////
    public Futsal getFutsalDataById(BigDecimal id) {
        Futsal futsal = obj.getDataById(id);
        if(futsal!=null){
            return futsal;
        }
        return null;
    }
    
    public boolean deleteFutsalDataById(BigDecimal id)
    {
        if(obj.deleteById(id)){
            return true;
        }
        return false;

    }
    
}
