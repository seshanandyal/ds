package com.veda.tries;

public class Node {
	private Character mCharacter;
	private Node[] mChildren;
	private boolean mIsLeaf;
	
	public Node(Character character) {
		mCharacter = character;
		mChildren = new Node[Trie.RADIX];
	}
	
	public void setChild(int index, Node node) {
		mChildren[index] = node;
	}
	
	public Node getChild(int index) {
		return mChildren[index];
	}
	
	public boolean isLeaf() {
		return mIsLeaf;
	}
	
	public void setLeaf(boolean isLeaf) {
		mIsLeaf = isLeaf;
	}
	
	public Character getCharacter() {
		return mCharacter;
	}
	
	public String toString() {
		return String.valueOf(mCharacter);
	}
}
