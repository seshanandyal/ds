package com.veda.graph;

public class Vertex {
	private String mValue;
	private VertexState mState;
	private Vertex mPredecessor;
	private int mDistance = Integer.MAX_VALUE;
	
	public Vertex(String value) {
		mValue = value;
	}
	
	public String toString() {
		return mValue;
	}
	
	public String getValue() {
		return mValue;
	}
	
	public void setState(VertexState state) {
		mState = state;
	}
	
	public VertexState getVertexState() {
		return mState;
	}
	
	public void setPredecessor(Vertex predecessor) {
		mPredecessor = predecessor;
	}
	
	public Vertex getPredecessor() {
		return mPredecessor;
	}
	
	public void setDistance(int distance) {
		mDistance = distance;
	}
	
	public int getDistance() {
		return mDistance;
	}
}
