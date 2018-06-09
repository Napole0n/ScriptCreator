/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.classes.principal;

import java.util.List;

/**
 *
 * @author Murilo
 */
public class Field {

    private String fieldName = "";
    private int fieldType = 0;
    private int fieldSize = 0;  //Opcional
    private List<FieldConstraint> constList; //Opcional

    boolean hasConstraint = false;
    boolean isResized = false;

    public String getFieldName() {
        return fieldName;
    }

    public boolean insertConstraint(FieldConstraint c) {
        if (!existsConstraints(c)) {
            constList.add(c);
            if (!hasConstraint) {
                hasConstraint = true;             //seta hasContraint
            }

            return true;
        }
        return false;
    }

    public boolean existsConstraints(FieldConstraint c) {
        boolean flag = false;
        for (FieldConstraint c2 : constList) {
            if (c2.equals(c)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public int getFieldType() {
        return fieldType;
    }

    public void setFieldType(int fieldType) {
        this.fieldType = fieldType;
    }

    public int getFieldSize() {
        return fieldSize;
    }

    public void setFieldSize(int fieldSize) {
        this.fieldSize = fieldSize;
        if (!isResized) {
            isResized = true;                  //seta resized
        }
    }

    public List<FieldConstraint> getConstList() {
        return constList;
    }

    public void setConstList(List<FieldConstraint> constList) {
        this.constList = constList;
    }

   

    

}
