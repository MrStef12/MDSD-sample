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
public class WaitUntilRobot extends WaitUntil {
    
    private String robotName;

    public WaitUntilRobot(String robotName, Vector2 pos) {
        super(pos);
        this.robotName = robotName;
    }
    
    public WaitUntilRobot(String robotName, Vector2 pos, int seconds, Constants.OR or) {
        super(pos, seconds, or);
        this.robotName = robotName;
    }

    @Override
    public Vector2 getPos(DesiredProps props) {
        GridPane grid = props.getGrid();
        for(Node node : grid.getChildren()) {
            if (node instanceof Robot) {
                Robot r = (Robot) node;
                if (r.getName().equals(robotName)) {
                    return r.getPos();
                }
            }
        }
        return null;
    }
}
