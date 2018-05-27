/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotdefinitionsample;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import robotdefinitionsample.models.Obstacle;
import robotdefinitionsample.models.Pickupable;
import robotdefinitionsample.models.Vector2;

/**
 *
 * @author stefh
 */
public class ObstacleDetection {
    public static boolean detect(GridPane grid, DesiredProps props) {
        int x = props.getPos().getX();
        int y = props.getPos().getY();
        
        for(Node node : grid.getChildren()) {
            if (node instanceof Obstacle) {
                Vector2 pos = ((Obstacle) node).getPos();
                if (pos.getX() == x && pos.getY() == y) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static Pickupable getShelfAtPos(GridPane grid, DesiredProps props) {
        int x = props.getPos().getX();
        int y = props.getPos().getY();
        for(Node node : grid.getChildren()) {
            if (node instanceof Pickupable) {
                Vector2 pos = ((Pickupable) node).getPos();
                if (pos.getX() == x && pos.getY() == y) {
                    return (Pickupable) node;
                }
            }
        }
        return null;
    }
}
