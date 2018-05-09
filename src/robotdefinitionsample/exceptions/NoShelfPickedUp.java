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
public class NoShelfPickedUp extends Exception {

    /**
     * Creates a new instance of <code>NoShelfPickedUp</code> without detail
     * message.
     */
    public NoShelfPickedUp() {
    }

    /**
     * Constructs an instance of <code>NoShelfPickedUp</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public NoShelfPickedUp(String msg) {
        super(msg);
    }
}
