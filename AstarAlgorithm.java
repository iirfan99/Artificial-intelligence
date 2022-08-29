package Lab1_AI.src;
import java.util.ArrayList;


public class AstarAlgorithm {


    public static double A_star(FindNodes nodeCurrent){

        ArrayList<FindNodes> open = new ArrayList<>();
        open.add(nodeCurrent);
        ArrayList<FindNodes> nodeVisited = new ArrayList<>();
        ArrayList<FindNodes> parents = new ArrayList<>();


        while (true){
            if (open.isEmpty()) break;
            FindNodes node_current=open.get(0);

            int i=0;
            int size= open.size();
            while(i<size){
                FindNodes node = open.get(i);
                if (node.F > node_current.F) {
                    node_current = node;
                }
                i++;
            }
            open.remove(node_current);
            nodeVisited.add(node_current);

            if(node_current.getChildren().isEmpty()){
                if (node_current != null) {
                    do {
                        parents.add(node_current);
                        node_current = node_current.set_parent;
                    } while (node_current != null);
                }


            }else{
                ArrayList<FindNodes> children = node_current.getChildren();
                int j=0;
                int size_children = children.size();
                while(j<size_children){
                    FindNodes node = children.get(j);
                    if (nodeVisited.contains(node)) {
                    } else {
                        double checker = node_current.G + node_current.weight_cal;
                        if (node.G <= checker) {
                            node.funG(node_current.G + node_current.weight_cal);
                            double f = node.F;
                            node.set_parent(node_current);
                            if (open.contains(node)) {
                            } else {
                                open.add(node);
                            }
                        }
                    }
                    j++;
                }
            }
        }
        double total=0;
        int i=0;
        int size_parent = parents.size();
        while (i<size_parent){
            FindNodes node = parents.get(i++);
            total = total + node.weight_cal;
        }
        return total;
    }
}
