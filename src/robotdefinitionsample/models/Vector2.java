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
public class Vector2 {
    private int x;
    private int y;
    
    public Vector2 (int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public Vector2 add(int x, int y) {
        return new Vector2(this.x + x, this.y + y);
    }
    
    public Vector2 add(Vector2 pos) {
        return new Vector2(this.x + pos.getX(), this.y + pos.getY());
    }
}
