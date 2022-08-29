package Lab1_AI.src;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class FileRead {
    public static ArrayList<FindNodes> fileRederHandle(String path){

        ArrayList<FindNodes> nodes= new ArrayList<>();
        int numcount=0;
        int numOfNodes=0;
        int parameter_index=0;
        try {
            BufferedReader sc = new BufferedReader(new FileReader(path));
            String line = sc.readLine();
            if (line != null) {
                do {
                    if (numcount == 0) {
                        numOfNodes = Integer.parseInt(line);
                        for (int i = 0; i < numOfNodes; i++) {
                            nodes.add(new FindNodes(i));
                        }
                        FindNodes finalNode = new FindNodes(-1);
                        nodes.add(finalNode);
                    }
                    if (numcount <= numOfNodes && numcount > 0) {
                        nodes.get(numcount - 1).setWeight_cal(Double.parseDouble(line));
                    }
                    if (numcount > numOfNodes) {
                        ArrayList<FindNodes> children = new ArrayList<>();
                        String[] lineArr = line.split(" ");
                        for (String s : lineArr) {
                            if (Integer.parseInt(s) != -1) {
                                children.add(nodes.get(Integer.parseInt(s)));
                                nodes.get(Integer.parseInt(s)).addParent(nodes.get(parameter_index));
                            } else {
                                children.add(nodes.get(nodes.size() - 1));
                                nodes.get(nodes.size() - 1).addParent(nodes.get(parameter_index));
                            }
                        }
                        nodes.get(parameter_index).setChildren(children);
                        parameter_index += 1;
                    }
                    numcount += 1;
                    line = sc.readLine();
                } while (line != null);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        FindNodes startNode= new FindNodes(numOfNodes);
        nodes.add(startNode);
        int i = 0;
        int size = nodes.size();
        while(i < size){
            FindNodes child = nodes.get(i++);
            if (child.parents.isEmpty() && child != startNode) {
                child.addParent(startNode);
                startNode.addChild(child);
            }
        }

        return nodes;
    }
}
