/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.classes.principal;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Murilo
 */
public class Table {

    private String tableName;
    private List<Field> fieldList = new ArrayList<Field>();

    public Table(String tableName) {
        this.tableName = tableName;
    }

    public Table(String tableName, List<Field> fields) {
        this.tableName = tableName;
        this.fieldList = fields;
    }

    /**
     *
     * @param f field para ser inserido na tabela
     * @return true se for inserido com sucesso, false se houver algum erro
     */
    public boolean insertField(Field f) {
        if (!existsField(f)) {
            fieldList.add(f);
            return true;
        }
        return false;
    }

   
    private boolean existsField(Field field) {
        boolean flag = false;
        if (!(this.fieldList.isEmpty())) {
            for (Field f : fieldList) {
                if (f.equals(field)) {
                    flag = true;
                }
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
