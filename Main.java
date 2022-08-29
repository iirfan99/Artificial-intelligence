package Lab1_AI.src;

import java.io.File;
import java.util.*;


public class Main  {


    public static void main (String[] args) {
        readDag();
    }

    public static String[] paths_dag_testing = {
            "default_test.txt", "test_small_sparse.dag",
            "test_small.dag", "test_medium_sparse.dag",
            "test_medium.dag", "test_large_sparse.dag",
            "test_large.dag", "test_xlarge_sparse.dag", "test_xlarge.dag",


    };

    public  static  void readDag() throws ArrayIndexOutOfBoundsException {
        File file = new File(Arrays.toString(paths_dag_testing));
        try {
        System.out.println(" Testing Dag files names" +file);


        for (int i = 0, paths_dag_testingLength = paths_dag_testing.length; i < paths_dag_testingLength; i++) {
            String test_String = paths_dag_testing[i];
            ArrayList<FindNodes> nodes = FileRead.fileRederHandle(test_String);

            FindNodes node_to_starting = nodes.get(nodes.size() - 1);


            System.out.println(test_String);


            System.out.println("Path weighted by  h=0 for file name: " + test_String + " is total value: " + AstarAlgorithm.A_star(node_to_starting));


            int j = 0;
            int size = nodes.size();
            while (j < size){
                FindNodes node1 = nodes.get(j++);
                node1.calculateHeuristics();
            }

            System.out.println("Path weighted by DFS heuristics for file name: " + test_String + " is total value: " + AstarAlgorithm.A_star(node_to_starting));
            System.out.println("-------------------------------- TEST---------------------------------------");

        }

        }catch(ArrayIndexOutOfBoundsException  e)

        {
            System.out.println(e);
        }


    }
}












