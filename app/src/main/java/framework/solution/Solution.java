/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.solution;

import java.util.Stack;
import framework.graph.Vertex;


/**
 *
 * @author Nathan Traylor
 *         Section 001
 */
public class Solution {

    /**
     * Creates an object that represents a path from a start
     * vertex to an end vertex in a problem solving domain.
     * This constructor will be called after a search has been
     * initiated on the start vertex.
     * If a path from start to end exists, it can be constructed
     * from the predecessor information stored in the end vertex.
     * @param start the start vertex
     * @param end the end vertex
     */
    public Solution(Vertex start, Vertex end) {
        /* you must provide */
        this.startVertex = start;
        this.endVertex = end;
        vertices = new Stack();
        vertices.push(end);
        
        while(!vertices.peek().equals(start)) {
        Vertex front = (Vertex) vertices.peek();
        vertices.push(front.getPredecessor());
        }
        
    }

    /**
     * Gets the length of the solution, that is, the number of moves
     * to get to the end state from the start.
     * @return the solution length
     */
    public int getLength() {
    int length = vertices.size() - 1;
    
    return length;
    }
    
    /**
     * Checks whether there are more vertices in this solution.
     * @return true if there are more vertices in this solution, false
     * otherwise
     */
    public boolean hasNext() {
        
    return (vertices.size() >= 1);
    }
    
    /**
     * Removes and returns the next vertex in this solution.
     * @return the next vertex in this solution
     * @throws RuntimeException if there are no more vertices
     */
    public Vertex next() { 
    try {    
    return (Vertex) vertices.pop();
    }
    catch(RuntimeException e) {
        
    }
    
    return null;
    }
    
    /* private instance fields and methods here */
    private final Vertex startVertex;
    private final Vertex endVertex;
    private final Stack vertices;
}