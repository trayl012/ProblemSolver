/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domains.farmer;

import framework.problem.State;
import java.util.Objects;

/**
 * @author Nathan Traylor
 *         Section 001
 */
public class FarmerState implements State {
    
        
            public FarmerState(String farmer, String wolf, String goat, String cabbage) {
            this.farmer = farmer;
            this.wolf = wolf;
            this.goat = goat;
            this.cabbage = cabbage;
        }
    
    @Override
        public boolean equals(Object other) {
            if(other == null) {
                return false;
            }
            
            FarmerState otherFarmer = (FarmerState) other;
            return this.farmer.equals(otherFarmer.farmer) &&
                   this.wolf.equals(otherFarmer.wolf) &&
                   this.goat.equals(otherFarmer.goat) &&
                   this.cabbage.equals(otherFarmer.cabbage);
        }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.farmer);
        hash = 37 * hash + Objects.hashCode(this.wolf);
        hash = 37 * hash + Objects.hashCode(this.goat);
        hash = 37 * hash + Objects.hashCode(this.cabbage);
        return hash;
    }
    
        @Override
        public String toString() {
        StringBuilder string = new StringBuilder();
        
        string.append("   |  |   \n");
        
        if(farmer.equals("West")) {
            string.append(" F |  |   \n");
        }
        else if(farmer.equals("East")) {
            string.append("   |  | F \n");
        }
        
        if(wolf.equals("West")) {
            string.append(" W |  |   \n");
        }
        else if(wolf.equals("East")) {
            string.append("   |  | W \n");
        }
        
        if(goat.equals("West")) {
            string.append(" G |  |   \n");
        }
        else if(goat.equals("East")) {
            string.append("   |  | G \n");
        }
        
        if(cabbage.equals("West")) {
            string.append(" C |  |   \n");
        }
        else if(cabbage.equals("East")) {
            string.append("   |  | C \n");
        }
        string.append("   |  |   "); 
        
        return string.toString();
        }

        public String[] getPositions() {
            String[] positions = {farmer, wolf, goat, cabbage};
            return positions;
        }
        
        
        private String farmer = "Farmer";
        private String wolf = "Wolf";
        private String goat = "Goat";
        private String cabbage = "Cabbage";
         
}
