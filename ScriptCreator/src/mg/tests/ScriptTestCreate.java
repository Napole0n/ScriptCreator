/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package mg.tests;



import static junit.framework.TestCase.assertEquals;
import mg.classes.principal.Field;
import mg.classes.principal.FieldConstraint;
import mg.classes.principal.Table;
import mg.classes.principal.Type;
import mg.classes.script.ScriptCreator;
import org.junit.Test;



/**
 *
 * @author murilo.goedert
 */
public class ScriptTestCreate {

    
    @Test
    public void test(){
        
     Field f1 = new Field("ID",Type.INT);   
     f1.insertConstraint(FieldConstraint.AUTO_INCREMENT);
     f1.insertConstraint(FieldConstraint.NOT_NULL);
     
     Field f2 = new Field("Nome",Type.VARCHAR,45);
     Field f3 = new Field("Idade",Type.INT);
     
     Table tabela = new Table("Pessoa");
     tabela.insertField(f1);
     tabela.insertField(f2);
     tabela.insertField(f3);
     
     
     ScriptCreator s = new ScriptCreator();
        
        
        String strExpected = "CREATE TABLE Pessoa(ID INT(10) AUTO INCREMENT NOT NULL ,Nome VARCHAR(45),Idade INT(10));";
        String strObtained = s.executeCreate(tabela);
        
        strExpected.trim();
        strObtained.trim();
        
        System.out.println(strObtained);
       assertEquals(strExpected,strObtained);
        
    }
    
    
   
   
}
