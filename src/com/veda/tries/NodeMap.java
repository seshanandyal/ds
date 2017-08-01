package com.veda.tries;

public class NodeMap {
	private Character mCharacter;
	private NodeMap[] mChildren;
	private boolean mIsLeaf;
	
	public NodeMap(Character character) {
		mCharacter = character;
		mChildren = new NodeMap[Trie.RADIX];
	}
	
	public void setChild(int index, NodeMap NodeMap) {
		mChildren[index] = NodeMap;
	}
	
	public NodeMap getChild(int index) {
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
