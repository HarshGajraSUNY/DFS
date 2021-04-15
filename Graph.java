package dfs;

import java.util.HashMap;
import java.util.Stack;

public class Graph {

	 private Vertex[] vertices;
	 int maxVertices=20 ;
	 int verticesAdded ;
	 int[][] adjEdgeMatrix ;
	 Stack<Vertex> stck;
	 HashMap<String,Integer> hm ;
	
	public Graph() {
		vertices = new Vertex[maxVertices];
		verticesAdded=0;
		adjEdgeMatrix = new int[maxVertices][maxVertices];
		stck= new Stack<Vertex>();
		hm= new HashMap<String, Integer>();
	}
	
	public int getAdjUnvisitedVertex(int v) {
		
		for(int i=0;i<verticesAdded;i++) {
			
			if(adjEdgeMatrix[v][i]==1  && vertices[i].visited==false)
			return i;
		}
		
		return -1;
	}
	
	public  void addVertex(String label) {
		Vertex add = new Vertex(label);
		vertices[verticesAdded]=add;
		hm.put(label, verticesAdded);
		verticesAdded++;
		
	}
	
	public  void addEdges(int vertex1, int vertex2) {
		
		
		adjEdgeMatrix[vertex1][vertex2]=1;
		adjEdgeMatrix[vertex2][vertex1]=1;
		
	}
	
	public void displayVertex(int v) {
	    System.out.print(vertices[v].label + " ");
	  }
	
	public void dfs(Graph g) {
		
		Vertex root = vertices[1];
		root.visited=true;
		stck.push(root);
		displayVertex(hm.get(root.label));
		
		while(!stck.isEmpty()) {
			
			Vertex v = stck.peek();
			int index = hm.get(v.label);
			int adj = getAdjUnvisitedVertex(index);
			
			{
				if(adj==-1) {
					
					stck.pop();
				}else {
					
					stck.push(vertices[adj]);
					vertices[adj].visited=true;
					displayVertex(adj);
				}
				
				
			}
			
			
		}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Graph g = new Graph();
		g.addVertex("A");
		g.addVertex("B");
		g.addVertex("C");
		g.addVertex("D");
		g.addVertex("E");
		g.addVertex("F");
		
		g.addEdges(0, 1);
		g.addEdges(1, 2);
		g.addEdges(0, 3);
		g.addEdges(1, 3);
		g.addEdges(3, 4);
		g.addEdges(4, 5);
		
		
		System.out.println("Visits: ");
	    g.dfs(g);
	    System.out.println();
		
	}

}
