/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.classes.script;

import mg.classes.principal.Field;
import mg.classes.principal.ISQLCreator;
import mg.classes.principal.Table;
import mg.classes.principal.TypeCreator;

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

        String part_1;

        int fieldCount = t.getFieldList().size() - 1;

        String sql = "CREATE TABLE " + t.getTableName() + "( ";

        for (Field f : t.getFieldList()) {

            sql = sql + f.getFieldName() + " " + f.getFieldType();

        }
        return sql;
    }

    public boolean validateField(Field f) {
        boolean flag = true;
        if (f.getFieldType() == 0) {
            System.err.println("Tipo do Campo não foi definido!");
        } else if (f.getFieldName().equals("")) {
            System.err.println("Nome do Campo não definido!");
        } else if (f.getFieldType() == TypeCreator.VARCHAR.getTypeValue()
                || f.getFieldType() == TypeCreator.CHAR.getTypeValue()
                || f.getFieldType() == TypeCreator.TINYINT.getTypeValue()
                || f.getFieldType() == TypeCreator.SMALLINT.getTypeValue()
                || f.getFieldType() == TypeCreator.MEDIUMINT.getTypeValue()
                || f.getFieldType() == TypeCreator.INT.getTypeValue()
                || f.getFieldType() == TypeCreator.BIGINT.getTypeValue()
                || f.getFieldType() == TypeCreator.FLOAT.getTypeValue()
                || f.getFieldType() == TypeCreator.DOUBLE.getTypeValue()
                || f.getFieldType() == TypeCreator.DECIMAL.getTypeValue()) {

            if (f.getFieldSize() == 0) {
                System.err.println("Tamanho do campo não definido");
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
