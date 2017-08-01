package com.veda.graph;

public class UndirectedWeightedGraph {
	private static int MAX_NUM_VERTICES = 30;
	private int mNumberOfVertices = 0;
	private int mNumberOfEdges = 0;
	
	private Vertex[] mVertices = new Vertex[MAX_NUM_VERTICES];
	private int[][] mAdjacencyMatrix = 
			new int[MAX_NUM_VERTICES][MAX_NUM_VERTICES];
	
	public int getNumberOfVertices() {
		return mNumberOfVertices;
	}
	
	public int getNumberOfEdges() {
		return mNumberOfEdges;
	}
	
	public void display() {
		for(int rowCount = 0; rowCount < mNumberOfVertices; rowCount++) {
			for(int colCount = 0; colCount < mNumberOfVertices; colCount++) {
				System.out.print(mAdjacencyMatrix[rowCount][colCount] + " ");
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
		
		return mAdjacencyMatrix[startIndex][endIndex] != 0;
	}
	
	public void insertEdge(String startVertex, String endVertex, int weight) {
		int startIndex = getIndex(startVertex);
		int endIndex = getIndex(endVertex);
		
		if(startIndex == -1 || endIndex == -1) {
			System.out.println("One of the vertices does not exists. Add the vertex using the insertVertex() and " + 
						"then call insertEdge()");
			return;
		}
		
		mAdjacencyMatrix[startIndex][endIndex] = weight;
		mAdjacencyMatrix[endIndex][startIndex] = weight;
		mNumberOfEdges++;
	}
	
	public void deleteEdge(String startVertex, String endVertex) {
		int startIndex = getIndex(startVertex);
		int endIndex = getIndex(endVertex);
		
		if(startIndex == -1 || endIndex == -1) {
			System.out.println("One of the vertices does not exists.");
			return;
		}
		
		mAdjacencyMatrix[startIndex][endIndex] = 0;
		mAdjacencyMatrix[endIndex][startIndex] = 0;
		mNumberOfEdges--;
	}
	
	public int degree(String vertexName) {
		int index = getIndex(vertexName);
		
		int degree = 0;
		for(int count = 0; count < mNumberOfVertices; count++) {
			if(mAdjacencyMatrix[index][count] != 0) {
				degree++;
			}
		}
		return degree;
	}
	
}
