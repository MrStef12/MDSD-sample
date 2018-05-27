/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotdefinitionsample.models.taskitems;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import robotdefinitionsample.DesiredProps;
import robotdefinitionsample.models.Pickupable;
import robotdefinitionsample.models.Robot;
import robotdefinitionsample.models.Vector2;

/**
 *
 * @author stefh
 */
public class WaitUntilPickupable extends WaitUntil {
    
    private String pickupableName;

    public WaitUntilPickupable(String pickupableName, Vector2 pos) {
        super(pos);
        this.pickupableName = pickupableName;
    }
    
    public WaitUntilPickupable(String pickupableName, Vector2 pos, int seconds, Constants.OR or) {
        super(pos, seconds, or);
        this.pickupableName = pickupableName;
    }

    @Override
    public Vector2 getPos(DesiredProps props) {
        GridPane grid = props.getGrid();
        for(Node node : grid.getChildren()) {
            if (node instanceof Pickupable) {
                Pickupable p = (Pickupable) node;
                if (p.getName().equals(pickupableName)) {
                    return p.getPos();
                }
            }
        }
        return null;
    }
    
}
