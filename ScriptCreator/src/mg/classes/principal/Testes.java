/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.classes.principal;

import mg.classes.database.DataBase;
import mg.classes.script.ScriptCreator;

/**
 *
 * @author Murilo
 */
public class Testes {
    
    public static void main(String[] args) {
      
     Field f1 = new Field("ID",Type.INT);   
     f1.insertConstraint(FieldConstraint.AUTO_INCREMENT);
     f1.insertConstraint(FieldConstraint.NOT_NULL);
     f1.insertConstraint(FieldConstraint.PRIMARY_KEY);
    
     
     Field f2 = new Field("Nome",Type.VARCHAR,45);
     Field f3 = new Field("Idade",Type.INT);
     
     Table tabela = new Table("Pessoa");
     tabela.insertField(f1);
     tabela.insertField(f2);
     tabela.insertField(f3);
     
     
     ScriptCreator s = new ScriptCreator();
     DataBase db = new DataBase("novo","root","");
     System.out.println(s.generateCreate(tabela));

        db.executeScript(s.generateCreate(tabela));
        
        
    }
    
}
