package Lab1_AI.src;

import java.util.ArrayList;

public class HeuristicCalculate {

    public double weight_cal;
    public int index_num;

    public double G; //cost from the start to the node
    public double H; //cost to the end from the node, estimated with a heuristic

    public double F =  G + H ; //function that A* uses to select a path

    public FindNodes set_parent;
    public ArrayList<FindNodes>  parents;
    public ArrayList<FindNodes>  children ;
    public HeuristicCalculate HeuristicCalculate;



    public void calculateHeuristics(){
        ArrayList<FindNodes> visited=new ArrayList<>();
        DepthFirstSearch(visited, (FindNodes) this);
        H= (double) visited.size();

    }

    public void DepthFirstSearch(ArrayList<FindNodes> visited, FindNodes node) {
        if (visited.contains(node)) {
            return;
        }
        visited.add(node);
        ArrayList<FindNodes> nodeChildren = node.getChildren();
        int i=0;
        int size = nodeChildren.size();
        while( i < size) {
            FindNodes child = nodeChildren.get(i);
            DepthFirstSearch(visited, child);
            i++;
        }

    }
}
