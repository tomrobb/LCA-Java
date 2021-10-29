import java.util.*;

public class DAGraph {
    private final int Nodes;
    private final ArrayList<Integer>[] children;
    private final ArrayList<Integer>[] parents;

    public DAGraph(int Nodes){
        this.Nodes = Nodes;
        children = (ArrayList<Integer>[]) new ArrayList[Nodes];
        parents = (ArrayList<Integer>[]) new ArrayList[Nodes];

        // Making an ArrayList for each Vertex

    }


    void addNode(int key){

    }



    ArrayList<Node> getParents(Node child){

        ArrayList<Node> parents = new ArrayList<Node>();

        if(!child.parents.isEmpty()){
            for(int i=0;i<child.parents.size();i++){
                // if we haven't added it to our parents list yet
                if(!parents.contains(child.parents.get(i))){
                    parents.add(child.parents.get(i));
                    getParents(child.parents.get(i));
                }
            }
        }

        return parents;

    }


    public static void main(String args[]){


    }
}
