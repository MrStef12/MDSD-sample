/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotdefinitionsample;

import robotdefinitionsample.models.Vector2;

/**
 *
 * @author stefh
 */
public class DesiredProps {
    
    private Vector2 pos;
    private int rotation;

    public DesiredProps(Vector2 pos, int rotation) {
        this.pos = pos;
        this.rotation = rotation;
    }

    public Vector2 getPos() {
        return pos;
    }

    public int getRotation() {
        return rotation;
    }

    public void setPos(int x, int y) {
        this.pos = new Vector2(x, x);
    }
    
    public void setPos(Vector2 pos) {
        this.pos = pos;
    }

    public void setRotation(int rotation) {
        this.rotation = rotation;
    }
    
}
