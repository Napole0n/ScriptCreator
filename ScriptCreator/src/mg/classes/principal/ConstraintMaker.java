/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.classes.principal;

/**
 *
 * @author Murilo
 */
public enum ConstraintMaker {
    NOT_NULL(1),
    AUTO_INCREMENT(2),
    PRYMARY_KEY(3),
    FOREIGN_KEY(4),
    ;
    
    public int constSelected;

    private ConstraintMaker(int number) {
        constSelected = number;
    }
    
    public int getConstraintValue(){
        return constSelected;
    }
    
    
}
