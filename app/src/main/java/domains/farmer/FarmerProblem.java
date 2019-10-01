/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domains.farmer;

import framework.problem.Problem;

/**
 * @author Nathan Traylor
 *         Section 001
 */
public class FarmerProblem extends Problem {
    
        
            public FarmerProblem() {
            super();
            super.setName("Farmer, Wolf, Goat, and Cabbage");
            super.setIntroduction(INTRO);
            super.setMover(new FarmerMover());
            super.setInitialState(initialState);
            super.setCurrentState(super.getInitialState());
            super.setFinalState(finalState);
        }
            
        FarmerState initialState = new FarmerState("West", "West", "West", "West");
        FarmerState finalState = new FarmerState("East", "East", "East", "East");
        
        private static final String INTRO = 
             "A farmer and his wolf, goat, and cabbage come to the edge of a " +
             "river they wish to cross. There is a boat at the river's edge " +
             "that only the farmer can row. The farmer can take at most one " +
             "other object besides himself on a crossing, but if the wolf is " +
             "ever left with the goat, the wolf will eat the goat; similarly, " +
             "if the goat is left with the cabbage, the goat will eat the " +
             "cabbage. Devise a sequence of crossings of the river so that all " +
             "four characters arrive safely on the other side.";
    
}
