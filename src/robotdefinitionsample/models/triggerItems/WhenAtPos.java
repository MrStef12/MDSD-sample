/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotdefinitionsample.models.triggerItems;

import robotdefinitionsample.DesiredProps;
import robotdefinitionsample.interfaces.ITaskFetcher;
import robotdefinitionsample.models.Vector2;

/**
 *
 * @author stefh
 */
public class WhenAtPos extends WhenAt {
    
    private Vector2 pos;

    public WhenAtPos(Vector2 pos, ITaskFetcher fetcher) {
        super(fetcher);
        this.pos = pos;
    }

    @Override
    public boolean isAtDestination(DesiredProps props) {
        return props.getPos().equals(pos);
    }
    
}
