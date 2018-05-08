/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotdefinitionsample.exceptions;

/**
 *
 * @author stefh
 */
public class WeightTooHigh extends Exception {

    /**
     * Creates a new instance of <code>WeightTooHigh</code> without detail
     * message.
     */
    public WeightTooHigh() {
    }

    /**
     * Constructs an instance of <code>WeightTooHigh</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public WeightTooHigh(String msg) {
        super(msg);
    }
}