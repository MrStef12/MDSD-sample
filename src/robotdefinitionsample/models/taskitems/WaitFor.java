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
public class WaitFor extends AbstractTaskItem {

    public WaitFor(int seconds) {
        super(seconds);
    }

    @Override
    public void execute(DesiredProps props) {
        stepDone();
    }
    
}
