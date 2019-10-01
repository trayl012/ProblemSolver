/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domains.farmer;

import java.util.function.UnaryOperator;

import framework.problem.Mover;
import framework.problem.State;

/**
 * @author Nathan Traylor
 *         Section 001
 */
public class FarmerMover extends Mover {

    public FarmerMover() {
    super.addMove(move1, new UnaryOperator<State>() {
        @Override
        public State apply(State e) {
            return FarmerMover.this.alone(e);
        }
    });
    super.addMove(move2, new UnaryOperator<State>() {
        @Override
        public State apply(State e) {
            return FarmerMover.this.wolf(e);
        }
    });
    super.addMove(move3, new UnaryOperator<State>() {
        @Override
        public State apply(State e) {
            return FarmerMover.this.goat(e);
        }
    });
    super.addMove(move4, new UnaryOperator<State>() {
        @Override
        public State apply(State e) {
            return FarmerMover.this.cabbage(e);
        }
    });
    }
    
    /**
     * method to move the farmer across the river alone
     * @param state the state of the problem before the farmer moves
     * @return null if move is illegal, else returns the new state
     **/
    private State alone(State state) {
    FarmerState currentState = (FarmerState) state;
    String position[] = currentState.getPositions();
    FarmerState newState = new FarmerState(move(position[0]), position[1],
                                                position[2], position[3]);
    if(checkBadMove(newState))
        return null;

    return newState;
    }

    /**
     * method to move the farmer and wolf across the river
     * @param state the state of the problem before the farmer and wolf move
     * @return null if move is illegal, else returns the new state
     **/
    private State wolf(State state) {
    FarmerState currentState = (FarmerState) state;
    String position[] = currentState.getPositions();
    FarmerState newState = new FarmerState(move(position[0]), move(position[1]),
                                                position[2], position[3]);
    if(checkBadMove(newState))
        return null;

    return newState;
    }

    /**
     * method to move the farmer and goat across the river
     * @param state the state of the problem before the farmer and goat move
     * @return null if move is illegal, else returns the new state
     **/
    private State goat(State state) {
    FarmerState currentState = (FarmerState) state;
    String position[] = currentState.getPositions();
    FarmerState newState = new FarmerState(move(position[0]), position[1],
                                                move(position[2]), position[3]);
    if(checkBadMove(newState))
        return null;

    return newState;
    }
    
    /**
     * method to move the farmer and cabbage across the river
     * @param state the state of the problem before the farmer and cabbage move
     * @return null if move is illegal, else returns the new state
     **/
    private State cabbage(State state) {
    FarmerState currentState = (FarmerState) state;
    String position[] = currentState.getPositions();
    FarmerState newState = new FarmerState(move(position[0]), position[1],
                                                position[2], move(position[3]));
    if(checkBadMove(newState))
        return null;

    return newState;
    }
 
    /**
     * method to check if an attempted move is legal
     * @param state the state of the problem before the move is attempted
     * @return true if move is illegal, false if move is legal
     **/
    private boolean checkBadMove(State state) {
        FarmerState currentState = (FarmerState) state;
        String position[] = currentState.getPositions();
        
        boolean badMove = (position[1].equals(position[2]) && !position[1].equals(position[0])) ||
                          (position[2].equals(position[3]) && !position[2].equals(position[0]));
        
        return badMove;
    }
    
    /**
     * method to move object to other side of the river
     * @param position the position of the object being moved
     * @return move the side of the river the object is moving to
     **/
    private String move(String position) {
        String move = "";
        if(position.equals("West"))
        move = "East";
        else if(position.equals("East"))
        move = "West";
        
        return move;
    }
    
    private final String move1 = "Farmer goes alone";
    private final String move2 = "Farmer takes wolf";
    private final String move3 = "Farmer takes goat";
    private final String move4 = "Farmer takes cabbage";
}
