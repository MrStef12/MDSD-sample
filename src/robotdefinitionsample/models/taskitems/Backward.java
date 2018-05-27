/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotdefinitionsample.models.taskitems;

import robotdefinitionsample.DesiredProps;

/**
 *
 * @author stefh
 */
public class Backward extends AbstractTaskItem {
    
    public Backward(int steps) {
        super(steps);
    }
    
    @Override
    public void execute(DesiredProps props) {
        int currentDirection = props.getRotation();
        switch (currentDirection) {
            case Constants.RIGHT:
                props.setPos(props.getPos().add(-1,0));
                break;
            case Constants.LEFT:
                props.setPos(props.getPos().add(1,0));
                break;
            case Constants.UP:
                props.setPos(props.getPos().add(0,1));
                break;
            case Constants.DOWN:
                props.setPos(props.getPos().add(0,-1));
                break;
        }
        stepDone();
    }
}
