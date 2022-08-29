package Lab1_AI.src;

import java.util.ArrayList;

public class FindNodes extends HeuristicCalculate {



    @Override
    public String toString() {


        return "Node{" +
                "index=" + index_num +
                ",weight=" + weight_cal +
                ", G=" + G +
                ", h=" + H +
                ", F=" + F+

                "}\n";
    }


    public FindNodes(int number) {

        this.index_num = number;
        this.weight_cal = weight_cal;
        this.parents = new ArrayList<FindNodes>();
        this.children = new ArrayList<FindNodes>();
    }



    public ArrayList<FindNodes> getChildren() {

        return   this.children;
    }

    public void setChildren(ArrayList<FindNodes> children) {

        this.children = children;
    }

    public void addParent(FindNodes parent) {

        this.parents.add(parent);
    }
    public void addChild(FindNodes child) {

        this.children.add(child);
    }






    public void setWeight_cal(double weight_cal) {

        this.weight_cal = weight_cal;
    }



    public void funG(double g) {

        this.G = g;
    }



    public void set_parent(FindNodes set_parent) {
        this.set_parent = set_parent;
    }








}
