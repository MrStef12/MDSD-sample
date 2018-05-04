/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotdefinitionsample.models;

/**
 *
 * @author ditlev
 */
public class Property {
    private String name;
    private int _default;

    public String getName() {
        return name;
    }

    public int getDefault() {
        return _default;
    }

    public Property(String name, int _default) {
        this.name = name;
        this._default = _default;
    }
}
