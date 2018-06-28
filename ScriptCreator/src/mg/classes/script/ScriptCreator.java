/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.classes.script;

import mg.classes.principal.Field;
import mg.classes.principal.FieldConstraint;
import mg.classes.principal.ISQLCreator;
import mg.classes.principal.Table;
import mg.classes.principal.Type;

/**
 *
 * @author Murilo
 */
public class ScriptCreator implements ISQLCreator {

    @Override
    public String executeSelect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String executeCreate(Table t) {

        String sql = "CREATE TABLE " + t.getTableName() + "(";

        for (int i = 0; i < t.getFieldList().size(); i++) {

            Field f = t.getFieldList().get(i);

            if (validateField(f)) {
                if (f.isResized) {
                    sql = sql + f.getFieldName() + " " + f.getFieldType().toString() + "(" + f.getFieldSize() + ")";

                    if (f.hasConstraint) {
                        sql = sql + " ";
                        for (FieldConstraint fc : f.getConstList()) {
                            if(fc == FieldConstraint.AUTO_INCREMENT){
                                String constString = "AUTO_INCREMENT ";
                                sql = sql + constString;
                            }else{
                            String constString = fc.toString();
                            sql = sql + constString.replace("_", " ") + " ";
                            }
                        }
                    }

                    if (!(i == t.getFieldList().size() - 1)) {
                        sql = sql + ",";
                    }

                } else {
                    sql = sql + f.getFieldName() + " " + f.getFieldType();

                    if (f.hasConstraint) {
                        sql = sql + " ";
                        for (FieldConstraint fc : f.getConstList()) {
                            String constString = fc.toString();
                            sql = sql + constString.replace("_", " ") + " ";
                        }
                    }

                    if (!(i == t.getFieldList().size() - 1)) {
                        sql = sql + ",";
                    }
                }

            }
        }
        sql = sql + ");";

        return sql;
    }

    public boolean validateField(Field f) {
        boolean flag = true;
        if (f.getFieldName().equals("")) {
            System.err.println("Nome do Campo não definido!");
        } else if (f.getFieldType() == Type.VARCHAR
                || f.getFieldType() == Type.CHAR
                || f.getFieldType() == Type.TINYINT
                || f.getFieldType() == Type.SMALLINT
                || f.getFieldType() == Type.MEDIUMINT
                || f.getFieldType() == Type.INT
                || f.getFieldType() == Type.BIGINT
                || f.getFieldType() == Type.FLOAT
                || f.getFieldType() == Type.DOUBLE
                || f.getFieldType() == Type.DECIMAL) {

            if (f.getFieldSize() == 0) {
                f.isResized = true;
                f.setFieldSize(10);
            } else {
                flag = true;
            }

        } else {
            flag = true;
        }
        return flag;

    }

    @Override
    public String executeAlter() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String executeDelete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String executeDropTable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
