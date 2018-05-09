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
public class PropertyNotSet extends Exception {

    /**
     * Creates a new instance of <code>PropertyNotSet</code> without detail
     * message.
     */
    public PropertyNotSet() {
    }

    /**
     * Constructs an instance of <code>PropertyNotSet</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public PropertyNotSet(String msg) {
        super(msg);
    }
}
