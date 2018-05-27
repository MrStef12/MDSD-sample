/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotdefinitionsample.interfaces;

import robotdefinitionsample.DesiredProps;

/**
 *
 * @author stefh
 */
public interface TriggerItem extends TaskItem {
    public boolean isTriggered(DesiredProps props);
}
