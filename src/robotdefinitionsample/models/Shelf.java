/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotdefinitionsample.models;

import java.util.HashMap;
import java.util.Map;
import javafx.scene.control.Label;

/**
 *
 * @author ditlev
 */
public class Shelf extends Label {
    private Vector2 pos;
    private Map<String, Property> properties;

    public Shelf(String name, Vector2 pos) {
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

    public Map<String, Property> getShelfProperties() {
        return properties;
    }
    
    public Property getProperty(String key){
        return properties.get(key);
    }
    
    public void addProperty(String name, Property p) {
        properties.put(name, p);
    }
    
}
