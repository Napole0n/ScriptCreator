/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.classes.connection;
/**
 *
 * @author Murilo
 */
public class Connector {

    private static Connector instance;

    private Connector() {
    }

    public Connector getInstance() {
        if (instance == null) {
            instance = new Connector();
        }
        return instance;
    }

}
