package com.veda.graph;

public class UndirectedGraph {
	private static int MAX_NUM_VERTICES = 30;
	private int mNumberOfVertices = 0;
	private int mNumberOfEdges = 0;
	
	private Vertex[] mVertices = new Vertex[MAX_NUM_VERTICES];
	private boolean[][] mAdjacencyMatrix = 
			new boolean[MAX_NUM_VERTICES][MAX_NUM_VERTICES];
	
	public int getNumberOfVertices() {
		return mNumberOfVertices;
	}
	
	public int getNumberOfEdges() {
		return mNumberOfEdges;
	}
	
	public void display() {
		for(int rowCount = 0; rowCount < mNumberOfVertices; rowCount++) {
			for(int colCount = 0; colCount < mNumberOfVertices; colCount++) {
				if(mAdjacencyMatrix[rowCount][colCount]) {
					System.out.print("1 ");
				} else {
					System.out.print("0 ");
				}
			}
			System.out.println();
		}
	}
	
	public void insertVertex(String name) {
		Vertex vertex = new Vertex(name);
		mVertices[mNumberOfVertices++] = vertex;
	}
	
	public int getIndex(String name) {
		for(int count = 0; count < mNumberOfVertices; count++) {
			Vertex vertex = mVertices[count];
			if(name.equals(vertex.getValue())) {
				return count;
			}
		}
		return -1;
	}
	
	public boolean edgeExists(String startVertex, String endVertex) {
		int startIndex = getIndex(startVertex);
		int endIndex = getIndex(endVertex);
		
		if(startIndex == -1 || endIndex == -1) {
			return false;
		}
		
		return mAdjacencyMatrix[startIndex][endIndex];
	}
	
	public void insertEdge(String startVertex, String endVertex) {
		int startIndex = getIndex(startVertex);
		int endIndex = getIndex(endVertex);
		
		if(startIndex == -1 || endIndex == -1) {
			System.out.println("One of the vertices does not exists. Add the vertex using the insertVertex() and " + 
						"then call insertEdge()");
			return;
		}
		
		mAdjacencyMatrix[startIndex][endIndex] = true;
		mAdjacencyMatrix[endIndex][startIndex] = true;
		mNumberOfEdges++;
	}
	
	public void deleteEdge(String startVertex, String endVertex) {
		int startIndex = getIndex(startVertex);
		int endIndex = getIndex(endVertex);
		
		if(startIndex == -1 || endIndex == -1) {
			System.out.println("One of the vertices does not exists.");
			return;
		}
		
		mAdjacencyMatrix[startIndex][endIndex] = false;
		mAdjacencyMatrix[endIndex][startIndex] = false;
		mNumberOfEdges--;
	}
	
	public int degree(String vertexName) {
		int index = getIndex(vertexName);
		
		int degree = 0;
		for(int count = 0; count < mNumberOfVertices; count++) {
			if(mAdjacencyMatrix[index][count]) {
				degree++;
			}
		}
		return degree;
	}
	
}
