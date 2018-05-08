/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotdefinitionsample.exceptions;

/**
 *
 * @author ditlev
 */
public class InvalidMove extends Exception{
    public InvalidMove() {
        super();
    }
    
    public InvalidMove(String name) {
        super(name);
    }
}
