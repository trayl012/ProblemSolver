package framework.solution;

import framework.graph.Vertex;
import framework.problem.Mover;
import framework.problem.Problem;
import framework.problem.State;
import java.util.LinkedList;
import java.util.List;

/* imports go here */

/**
 * This class represents a state space solver by extending the abstract
 * Solver class.
 * @author Nathan Traylor
 *         Section 004
 */
public class StateSpaceSolver extends Solver {
    
    /**
     * Creates a BFS or DFS state space solver.
     * This constructor should set the queue to a double-ended queue (DEQUE)
     * and set the statistics header.
     * @param problem the problem being solved
     * @param bfs a boolean flag indicating whether BFS is to be performed
     */
    public StateSpaceSolver(Problem problem, boolean bfs) {
        super(problem);
        mover = problem.getMover();
        deque = new LinkedList<>();
        super.setQueue(deque);
        this.bfs = bfs;
        if(bfs) {
        super.statistics.setHeader("Breadth First Search");
        }
        else {
        super.statistics.setHeader("Depth First Search");
        }

    }
    
    /**
     * Adds a vertex to the DEQUE.
     * If BFS is being performed, the vertex should be added to the
     * end of the DEQUE, so the DEQUE acts like an ordinary queue.
     * If DFS is being performed, the vertex should be added to the
     * front of the DEQUE, so the DEQUE acts like a stack.
     * @param v 
     */
    @Override
    public void add(Vertex v) {

        if(bfs) { //is a bfs search
          deque.addLast(v);
        }
        else { //is a dfs search
        deque.addFirst(v);
        }
        
    }
    
    /**
     * This method implements the expand operation required by the 
     * state space search algorithm:

       Expand(u)
          children = {}
          for each name ∈ moveNames do
             child = mover.doMove(name, u)
             if child ≠  null and not OccursOnPath(child, u)
                then d[child] = d[u] + 1
                     pred[child] = u
                     add child to children
          return children

     * @param u the vertex being expanded
     * @return 
     */
    @Override
    public List<Vertex> expand(Vertex u) {
        List<Vertex> children = new LinkedList<>();
        
        for (String name : mover.getMoveNames()) {
            Vertex child = new Vertex(mover.doMove(name, (State) u.getData()));
            if (child.getData() != null && !occursOnPath(child, u)) {
                child.setDistance(u.getDistance() + 1);
                child.setPredecessor(u);
                children.add(child);
            }
        }

        return children;
    }

    /**
     * Checks whether a given vertex appears on the predecessor path
     * of a given ancestor.
     * @param v the vertex to check
     * @param ancestor the ancestor vertex of v
     * @return true if v occurs on the predecessor path of ancestor,
     * false otherwise
     */
    public static boolean occursOnPath(Vertex v, Vertex ancestor) {
        boolean occurs = false;
        Vertex current = (Vertex) ancestor;

        while (current != null && occurs == false) {
            if (current.getData().equals(v.getData())) {
                occurs = true;
            } else {
                current = current.getPredecessor();
            }
        }

        return occurs;
    }
    
    /* private instance fields here */
    private final Mover mover;
    private final LinkedList<Vertex> deque;
    private final boolean bfs;
}
