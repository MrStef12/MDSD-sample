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
public class Setdown extends AbstractTaskItem {

    public Setdown() {
        super(1);
    }

    @Override
    public void execute(DesiredProps props) {
        props.setShouldSetDown(props.getRobot().getPickedUp() != null);
        stepDone();
    }
    
}
