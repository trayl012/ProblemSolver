package framework.graph;

import framework.problem.Problem;
import framework.problem.State;
import java.util.Stack;
import java.util.List;

///**
// * @author Nathan Traylor Section 001
// */
//public class GraphCreator {
//
//    public Graph createGraphFor(Problem problem) {
//        G = new Graph();
//        Stack S = new Stack();
//        Vertex start = new Vertex(problem.getInitialState());
//        S.push(start);
//        moves = problem.getMover().getMoveNames();
//        while (!S.isEmpty()) {
//            Vertex u = (Vertex) S.pop();
//                for(int i = 0; i < moves.size(); ++i) {
//                String m = moves.get(i);
//                State next = (State) problem.getMover().doMove(m, (State) u.getData());
//                if (next != null) {
//                    Vertex v = new Vertex(next);
//                    if (G.getVertices().containsKey(v)) {
//                        G.getVertices().get(v);
//                    } else {
//                        S.push(v);
//                    }
//                    G.addEdge((Vertex) u, v);
//                }
//
//            }
//
//        }
//
//        return G;
//    }
//
//    private Graph G = null;
//    private List<String> moves;
//}
