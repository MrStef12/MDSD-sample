/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotdefinitionsample.models.taskitems;

import robotdefinitionsample.DesiredProps;
import robotdefinitionsample.models.Robot;
import robotdefinitionsample.interfaces.TaskItem;
import robotdefinitionsample.models.Vector2;

/**
 *
 * @author stefh
 */
public abstract class WaitUntil implements TaskItem {
    
    private Vector2 pos;
    private int seconds;
    private Constants.OR or;
    private boolean done;

    public WaitUntil(Vector2 pos) {
        this.pos = pos;
        this.seconds = -1;
    }
    
    public WaitUntil(Vector2 pos, int seconds, Constants.OR or) {
        this.pos = pos;
        this.seconds = seconds;
        this.or = or;
    }

    @Override
    public void execute(DesiredProps props) {
        Vector2 pos = getPos(props);
        if (pos == null) {
            System.out.println("WaitUntil - OBJECT FOR POSITION IS NOT FOUND");
            return;
        }
        if (pos.equals(this.pos)) {
            done = true;
        } else if(seconds >= 0) {
            seconds--;
            if (seconds < 1) {
                props.setWaitOr(or);
                done = true;
            }
        }
    }

    @Override
    public boolean isDone() {
        return done;
    }
    
    public abstract Vector2 getPos(DesiredProps props);
}
