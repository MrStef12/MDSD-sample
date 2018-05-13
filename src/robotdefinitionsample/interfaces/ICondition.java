/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotdefinitionsample.interfaces;

import java.util.Map;
import robotdefinitionsample.models.Property;
import robotdefinitionsample.models.Shelf;

/**
 *
 * @author stefh
 */
public interface ICondition {
    public boolean checkCondition(int retries, Shelf shelf, Map<String, Property> properties);
}
