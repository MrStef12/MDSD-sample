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
public class Turn extends AbstractTaskItem {
    
    private boolean ccw;
    
    public Turn(boolean ccw) {
        super(1);
        this.ccw = ccw;
    }

    @Override
    public void execute(DesiredProps props) {
        int currentDirection = props.getRotation();
        switch (currentDirection) {
            case Constants.RIGHT:
                props.setRotation(ccw ? Constants.UP : Constants.DOWN);
                break;
            case Constants.LEFT:
                props.setRotation(ccw ? Constants.DOWN : Constants.UP);
                break;
            case Constants.UP:
                props.setRotation(ccw ? Constants.LEFT : Constants.RIGHT);
                break;
            case Constants.DOWN:
                props.setRotation(ccw ? Constants.RIGHT : Constants.LEFT);
                break;
        }
        stepDone();
    }
}
