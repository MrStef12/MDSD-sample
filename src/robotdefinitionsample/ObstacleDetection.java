/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotdefinitionsample;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import robotdefinitionsample.models.Obstacle;
import robotdefinitionsample.models.Shelf;
import robotdefinitionsample.models.Vector2;

/**
 *
 * @author stefh
 */
public class ObstacleDetection<T> {
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
    
    public static Shelf getShelfAtPos(GridPane grid, DesiredProps props) {
        int x = props.getPos().getX();
        int y = props.getPos().getY();
        for(Node node : grid.getChildren()) {
            if (node instanceof Shelf) {
                Vector2 pos = ((Shelf) node).getPos();
                if (pos.getX() == x && pos.getY() == y) {
                    return (Shelf) node;
                }
            }
        }
        return null;
    }
}
