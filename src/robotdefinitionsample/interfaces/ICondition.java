/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotdefinitionsample.interfaces;

import java.util.Map;
import robotdefinitionsample.models.Pickupable;

/**
 *
 * @author stefh
 */
public interface ICondition {
    public boolean checkCondition(int retries, Pickupable shelf, Map<String, Integer> properties);
}
