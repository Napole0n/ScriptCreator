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
public class Table {

    private String tableName;
    private List<Field> fieldList;

    public Table(String tableName) {
        this.tableName = tableName;
    }


    public Table(String tableName, List<Field> fields) {
        this.tableName = tableName;
        this.fieldList = fields;
    }

    public boolean insertField(Field f) {
        if (!existsField(f)) {
            fieldList.add(f);
            return true;
        }
        return false;
    }


    public boolean existsField(Field field) {
        boolean flag = false;
        for (Field f : fieldList) {
            if (f.equals(field)) {
                flag = true;
            }
        }
        return flag;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<Field> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<Field> fieldList) {
        this.fieldList = fieldList;
    }



}
