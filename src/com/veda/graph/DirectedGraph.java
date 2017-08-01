package com.veda.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.DelayQueue;

public class DirectedGraph {
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
		mNumberOfEdges--;
	}
	
	public int outDegree(String name) { 
		int index = getIndex(name);
		
		if(index == -1) {
			System.out.println("There is no vertex with that name.");
			return -1;
		}
		
		int rowCount = 0;
		for(int count = 0; count < mNumberOfVertices; count++) {
			if(mAdjacencyMatrix[index][count]) {
				rowCount++;
			}
		}
		return rowCount;
	}
	
	public int inDegree(String name) {
		int index = getIndex(name);
		
		if(index == -1) {
			System.out.println("There is no vertex with that name.");
			return -1;
		}
		
		int colCount = 0;
		for(int count = 0; count < mNumberOfVertices; count++) {
			if(mAdjacencyMatrix[count][index]) {
				colCount++;
			}
		}
		return colCount;
	}
	
	private void initializeStateOfAllVertices() {
		for(int count = 0; count < mNumberOfVertices; count++) {
			mVertices[count].setState(VertexState.INITIAL);
		}
	}
	
	private void breadthFirstSearch(int startIndex) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(startIndex);
		mVertices[startIndex].setState(VertexState.WAITING);
		while(!queue.isEmpty()) {
			int vertexIndex = queue.remove();
			System.out.print(mVertices[vertexIndex] + " ->");
			mVertices[vertexIndex].setState(VertexState.VISTED);
			
			//Find all the adjacent vertices of vertexIndex that are 
			// in initial state. Add these vertices to the queue
			for(int count = 0; count < mNumberOfVertices; count++) {
				if(mAdjacencyMatrix[vertexIndex][count] &&
						mVertices[count].getVertexState() == VertexState.INITIAL) {
					queue.add(count);
					mVertices[count].setState(VertexState.WAITING);
					mVertices[count].setPredecessor(mVertices[vertexIndex]);
					if(mVertices[count].getPredecessor() != null) {
						int vertexDistance = 
								mVertices[count].getPredecessor().getDistance() + 1;
						mVertices[count].setDistance(vertexDistance);
					}
				}
			}
		}
		System.out.println();
	}
	
	public void breadFirstTraverseAll() {
		for(int count = 0; count < mNumberOfVertices; count++) {
			if(mVertices[count].getVertexState() == VertexState.INITIAL) {
				breadthFirstSearch(count);
			}
		}
	}
	
	public void performBreadthFirstSearch(String startVertex) {
		int startIndex = getIndex(startVertex);
		
		if(startIndex == -1) {
			System.out.println("The start vertex cannot be found.");
			return;
		}
		initializeStateOfAllVertices();
		breadthFirstSearch(startIndex);
	}
	
	private void findShortestPath(String startVertex, String targetVertex) {
		int startIndex = getIndex(startVertex);
		int targetIndex = getIndex(targetVertex);
		
		if(startIndex == -1 || targetIndex == -1) {
			System.out.println("One or both of the vertices "
					+ "provided do not exist.");
			return;
		}
		
		if(mVertices[targetIndex].getDistance() == Integer.MAX_VALUE) {
			System.out.printf("There is no path from %s to %s \n", 
					startVertex, targetVertex);
		}
		
		System.out.printf("Shortest path from %s to %s is: \n", 
				startVertex, targetVertex);
		Deque<Vertex> stack = new ArrayDeque<>();
		stack.push(mVertices[targetIndex]);
		Vertex predecessor = mVertices[targetIndex].getPredecessor();
		while(predecessor != null) {
			stack.push(predecessor);
			predecessor = predecessor.getPredecessor();
		}
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + " ->");
		}
	}
	
	public static void main(String[] args) {
		DirectedGraph graph = new DirectedGraph();
		graph.insertVertex("Zero");
		graph.insertVertex("One");
		graph.insertVertex("Two");
		graph.insertVertex("Three");
		graph.insertVertex("Four");
		graph.insertVertex("Five");
		graph.insertVertex("Six");
		graph.insertVertex("Seven");
		graph.insertVertex("Eight");
		graph.insertVertex("Nine");
		
		graph.insertEdge("Zero", "One");
		graph.insertEdge("Zero", "Three");
		graph.insertEdge("One", "Two");
		graph.insertEdge("One", "Four");
		graph.insertEdge("One", "Five");
		graph.insertEdge("Two", "Three");
		graph.insertEdge("Two", "Five");
		graph.insertEdge("Thee", "Six");
		graph.insertEdge("Four", "Five");
		graph.insertEdge("Four", "Seven");
		graph.insertEdge("Five", "Six");
		graph.insertEdge("Five", "Eight");
		graph.insertEdge("Six", "Eight");
		graph.insertEdge("Six", "Nine");
		graph.insertEdge("Seven", "Eight");
		graph.insertEdge("Eight", "Nine");
		
		graph.display();
		graph.performBreadthFirstSearch("Zero");
		graph.breadFirstTraverseAll();
		graph.findShortestPath("Zero", "Eight");
		/*
		System.out.printf("Number of Vertices: %d and Number of Edges: %d \n", 
				graph.getNumberOfVertices(), graph.getNumberOfEdges());
		
		System.out.printf("Indegree of Zero is: %d and Outdegree of One is %d \n", 
				graph.inDegree("Zero"), graph.outDegree("One"));
		*/
	}
}
