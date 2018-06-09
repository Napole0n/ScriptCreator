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
public interface ISQLCreator {
    
    public String executeSelect();
    public String executeCreate(Table t);
    public String executeAlter();
    public String executeDelete();
    public String executeDropTable();
    
    
}
