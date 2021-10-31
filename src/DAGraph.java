import java.util.ArrayList;
import java.util.List;

public class DAGraph {

    public static ArrayList<Edge>[] adjList;
    public int numberOfNodes;


    // Constructor for DAGraph
    public DAGraph(int numberOfNodes){
        adjList = (ArrayList<Edge>[]) new ArrayList[numberOfNodes + 1];
        for (int i=1; i<=numberOfNodes; i++){
            adjList[i] = new ArrayList<Edge>();
        }
        this.numberOfNodes = numberOfNodes;
    }


    // function to test whether the graph is empty
    public boolean isEmpty(){
        if(numberOfNodes == 0){
            return true;
        }
        return false;
    }


    // function that adds an edge between two Nodes
    public void addEdge(int src, int dst){
        if (dst <= numberOfNodes && src <= numberOfNodes){
            if (adjList[dst] == null){
                adjList[dst] = new ArrayList<Edge>();
            }
            Edge edge =  new Edge(dst, src);
            if (!containsEdge(dst,src)){
                adjList[dst].add(edge);
            }
        }
    }

    public boolean containsEdge(int src, int dst){
        if(dst <= numberOfNodes && src <= numberOfNodes){
            ArrayList<Edge> edgeList;
            edgeList = adjList[dst];
            for (Edge edge : edgeList){
                if (edge.nodeB == src){
                    return true;
                }
            }
        }
        return false;
    }

    public void removeEdge(int src, int dst){
        if(dst <= numberOfNodes && src <= numberOfNodes){
            ArrayList<Edge> edges = adjList[dst];
            for (int i=0; i < edges.size(); i++){
                Edge e = edges.get(i);
                if (e.nodeA == dst && e.nodeB == src){
                    edges.remove(i);
                    break;
                }
            }
        }
    }

    boolean hasCycle(){
        List<Integer> visitedNodes = new ArrayList<>();
        for (int i=1; i < adjList.length; i++){
            if (hasCycle(i, visitedNodes)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasCycle(int n, List<Integer> visitedNodes){
        if(visitedNodes.contains(n)){
            return true;
        }
        visitedNodes.add(n);
        for (Edge edge : adjList[n]){
            if (hasCycle(edge.nodeB, visitedNodes)){
                return true;
            }
        }
        visitedNodes.remove(visitedNodes.size() - 1);
        System.out.println(visitedNodes);
        return false;
    }


    public int LCA(int a, int b){
        ArrayList<Integer> ancestorsA = new ArrayList<Integer>();
        ArrayList<Integer> ancestorsB = new ArrayList<Integer>();
        ancestorsA.add(a);
        ancestorsB.add(b);

        findPath(ancestorsA, a);
        findPath(ancestorsB, b);
        System.out.println("Path from Node A: " + ancestorsA);
        System.out.println("Path from Node B: " + ancestorsB);

        for (int i : ancestorsA)
            if (ancestorsB.contains(i)){
                System.out.println("LCA= " + i);
                return i;
            }
        return 0;
    }


    public void findPath(ArrayList<Integer> ancestors, int node){
        ArrayList<Edge> edgeList;
        edgeList = adjList[node];
        for (Edge edge : edgeList){
            ancestors.add(edge.nodeB);
            findPath(ancestors, edge.nodeB);
        }
    }

    public int getNumberOfNodes(){
        return numberOfNodes;
    }

    public ArrayList<Edge>[] getAdjList(){
        return adjList;
    }


    // This method was only for testing, not actually needed
    public void printGraph(){
        ArrayList<Edge> edgeList;
        System.out.println("\nEdges of Graph:\nsrc -> dst");
        for (int i=1; i<= numberOfNodes; i++){
            edgeList = adjList[i];
            for (Edge edge : edgeList){
                System.out.println(edge.nodeB + " -> " + edge.nodeA);
            }
        }
    }

}
