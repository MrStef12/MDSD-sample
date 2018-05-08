/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotdefinitionsample;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import robotdefinitionsample.models.Obstacle;
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
    
    private static Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
    for (Node node : gridPane.getChildren()) {
        if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
            return node;
        }
    }
    return null;
}
}
