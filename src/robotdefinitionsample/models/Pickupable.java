/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotdefinitionsample.models;

import java.util.HashMap;
import java.util.Map;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import robotdefinitionsample.interfaces.IMoveable;

/**
 *
 * @author ditlev
 */
public class Pickupable extends Label implements IMoveable {
    private Vector2 pos;
    private Map<String, Integer> properties;

    public Pickupable(String name, Vector2 pos) {
        super(name);
        this.pos = pos;
        this.properties = new HashMap<>();
    }

    
    public String getName() {
        return this.getText();
    }

    public Vector2 getPos() {
        return pos;
    }

    public Map<String, Integer> getPickupableProperties() {
        return properties;
    }
    
    public Integer getProperty(String key){
        return properties.get(key);
    }

    public void setPos(Vector2 pos) {
        this.pos = pos;
    }
    
    public void addProperty(String name, Integer num) {
        properties.put(name, num);
    }

    @Override
    public void execute(GridPane grid) {

    }

    @Override
    public void move(GridPane grid) {
        grid.getChildren().remove(this);
        grid.add(this, this.getPos().getX(), this.getPos().getY());
    }
}
