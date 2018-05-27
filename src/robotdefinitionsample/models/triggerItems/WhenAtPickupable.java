/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotdefinitionsample.models.triggerItems;

import robotdefinitionsample.DesiredProps;
import robotdefinitionsample.ObstacleDetection;
import robotdefinitionsample.interfaces.ITaskFetcher;
import robotdefinitionsample.models.Pickupable;

/**
 *
 * @author stefh
 */
public class WhenAtPickupable extends WhenAt {
    
    private String pickupableName;

    public WhenAtPickupable(String pickupableName, ITaskFetcher fetcher) {
        super(fetcher);
        this.pickupableName = pickupableName;
    }

    @Override
    public boolean isAtDestination(DesiredProps props) {
        Pickupable p = ObstacleDetection.getShelfAtPos(props.getGrid(), props);
        return p != null && p.getName().equals(pickupableName);
    }
    
}
