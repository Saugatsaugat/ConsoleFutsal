
package com.mycompany.consolefutsal;

import entites.FutsalCRUD;
import entites.UserCRUD;


/**
 *
 * @author saugat
 */
public class ObjectCreation{
    MainInitialization obj;
    public ObjectCreation(){
        obj = new MainInitialization();
        obj.userCRUD = new UserCRUD();
        obj.futsalCRUD = new FutsalCRUD();
    }
    
}
