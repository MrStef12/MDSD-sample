/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotdefinitionsample.models;

import javafx.scene.control.Label;

/**
 *
 * @author ditlev
 */
public class Obstacle extends Label {
    private Vector2 pos;
    private Vector2 size;

    public Obstacle(String name, Vector2 pos, Vector2 size) {
        super(name);
        this.pos = pos;
        this.size = size;
    }

    public String getName() {
        return this.getText();
    }

    public Vector2 getPos() {
        return pos;
    }

    public Vector2 getSize() {
        return size;
    }
    
}
