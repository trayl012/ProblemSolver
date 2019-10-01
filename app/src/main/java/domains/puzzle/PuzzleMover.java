/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domains.puzzle;

import java.util.function.UnaryOperator;

import framework.problem.Mover;
import framework.problem.State;
import domains.puzzle.PuzzleState.Location;


/**
 * @author Nathan Traylor
 *         Section 004
 */
public class PuzzleMover extends Mover {


    public PuzzleMover() {
    super.addMove(slide1, new UnaryOperator<State>() {
        @Override
        public State apply(State e) {
            return PuzzleMover.this.SLIDETILE1(e);
        }
    });
    super.addMove(slide2, new UnaryOperator<State>() {
        @Override
        public State apply(State e) {
            return PuzzleMover.this.SLIDETILE2(e);
        }
    });
    super.addMove(slide3, new UnaryOperator<State>() {
        @Override
        public State apply(State e) {
            return PuzzleMover.this.SLIDETILE3(e);
        }
    });
    super.addMove(slide4, new UnaryOperator<State>() {
        @Override
        public State apply(State e) {
            return PuzzleMover.this.SLIDETILE4(e);
        }
    });
    super.addMove(slide5, new UnaryOperator<State>() {
        @Override
        public State apply(State e) {
            return PuzzleMover.this.SLIDETILE5(e);
        }
    });
    super.addMove(slide6, new UnaryOperator<State>() {
        @Override
        public State apply(State e) {
            return PuzzleMover.this.SLIDETILE6(e);
        }
    });
    super.addMove(slide7, new UnaryOperator<State>() {
        @Override
        public State apply(State e) {
            return PuzzleMover.this.SLIDETILE7(e);
        }
    });
    super.addMove(slide8, new UnaryOperator<State>() {
        @Override
        public State apply(State e) {
            return PuzzleMover.this.SLIDETILE8(e);
        }
    });
    }
    
    /**
     * method to slide tile 1
     * @param state the current state of the puzzle
     * @return new PuzzleState if move is legal, null if move is illegal
     */  
    private State SLIDETILE1(State state) {
        PuzzleState pState = (PuzzleState) state;
        Location tile1 = pState.getLocation(1);
        Location blankTile = pState.getLocation(0);
        
        if(!checkBadMove(tile1, blankTile)) {
            return new PuzzleState(pState, tile1, blankTile);
        }
        return null;
    }
    
    /**
     * method to slide tile 2
     * @param state the current state of the puzzle
     * @return new PuzzleState if move is legal, null if move is illegal
     */ 
        private State SLIDETILE2(State state) {
        PuzzleState pState = (PuzzleState) state;
        Location tile2 = pState.getLocation(2);
        Location blankTile = pState.getLocation(0);
        
        if(!checkBadMove(tile2, blankTile)) {
            return new PuzzleState(pState, tile2, blankTile);
        }
        return null;
    }
        
    /**
     * method to slide tile 3
     * @param state the current state of the puzzle
     * @return new PuzzleState if move is legal, null if move is illegal
     */ 
        private State SLIDETILE3(State state) {
        PuzzleState pState = (PuzzleState) state;
        Location tile3 = pState.getLocation(3);
        Location blankTile = pState.getLocation(0);
        
        if(!checkBadMove(tile3, blankTile)) {
            return new PuzzleState(pState, tile3, blankTile);
        }
        return null;
    } 
        
    /**
     * method to slide tile 4
     * @param state the current state of the puzzle
     * @return new PuzzleState if move is legal, null if move is illegal
     */ 
        private State SLIDETILE4(State state) {
        PuzzleState pState = (PuzzleState) state;
        Location tile4 = pState.getLocation(4);
        Location blankTile = pState.getLocation(0);
        
        if(!checkBadMove(tile4, blankTile)) {
            return new PuzzleState(pState, tile4, blankTile);
        }
        return null;
    }  
   
    /**
     * method to slide tile 5
     * @param state the current state of the puzzle
     * @return new PuzzleState if move is legal, null if move is illegal
     */ 
        private State SLIDETILE5(State state) {
        PuzzleState pState = (PuzzleState) state;
        Location tile5 = pState.getLocation(5);
        Location blankTile = pState.getLocation(0);
        
        if(!checkBadMove(tile5, blankTile)) {
            return new PuzzleState(pState, tile5, blankTile);
        }
        return null;
    }  
        
    /**
     * method to slide tile 6
     * @param state the current state of the puzzle
     * @return new PuzzleState if move is legal, null if move is illegal
     */  
        private State SLIDETILE6(State state) {
        PuzzleState pState = (PuzzleState) state;
        Location tile6 = pState.getLocation(6);
        Location blankTile = pState.getLocation(0);
        
        if(!checkBadMove(tile6, blankTile)) {
            return new PuzzleState(pState, tile6, blankTile);
        }
        return null;
    }    
        
     /**
     * method to slide tile 7
     * @param state the current state of the puzzle
     * @return new PuzzleState if move is legal, null if move is illegal
     */   
        private State SLIDETILE7(State state) {
        PuzzleState pState = (PuzzleState) state;
        Location tile7 = pState.getLocation(7);
        Location blankTile = pState.getLocation(0);
        
        if(!checkBadMove(tile7, blankTile)) {
            return new PuzzleState(pState, tile7, blankTile);
        }
        return null;
    }    
    
    /**
     * method to slide tile 8
     * @param state the current state of the puzzle
     * @return new PuzzleState if move is legal, null if move is illegal
     */    
        private State SLIDETILE8(State state) {
        PuzzleState pState = (PuzzleState) state;
        Location tile8 = pState.getLocation(8);
        Location blankTile = pState.getLocation(0);
        
        if(!checkBadMove(tile8, blankTile)) {
            return new PuzzleState(pState, tile8, blankTile);
        }
        return null;
    }    
    
    /**
     * Method to check if an attempted move is valid
     * @param tileSpot the location of the tile being moved
     * @param emptySpot the location containing no tile
     * @return false if move is not bad, true if move is bad
     **/
        private boolean checkBadMove(Location tileSpot, Location emptySpot) {
 
        Location up = new Location(tileSpot.getRow() - 1, tileSpot.getColumn());
        Location down = new Location(tileSpot.getRow() + 1, tileSpot.getColumn());
        Location left = new Location(tileSpot.getRow(), tileSpot.getColumn() - 1);
        Location right = new Location(tileSpot.getRow(), tileSpot.getColumn() + 1);
        
        return !(emptySpot.equals(up) || emptySpot.equals(down) ||
                 emptySpot.equals(left) || emptySpot.equals(right));
        
        }
        
        
        
        
        private final String slide1 = "Slide tile 1";
        private final String slide2 = "Slide tile 2";
        private final String slide3 = "Slide tile 3";
        private final String slide4 = "Slide tile 4";
        private final String slide5 = "Slide tile 5";
        private final String slide6 = "Slide tile 6";
        private final String slide7 = "Slide tile 7";
        private final String slide8 = "Slide tile 8";
}

