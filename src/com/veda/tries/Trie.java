package com.veda.tries;

public class Trie {
	static final int RADIX = 26;
	
	private Node mRoot;
	
	public Trie() {
		mRoot = new Node(new Character(' '));
	}
	
	public void insert(String string) {
		if(string == null | string.length() == 0) {
			return;
		}
		
		string = string.toLowerCase();
		int stringLength = string.length();
		Node currentNode = mRoot;
		
		for(int index = 0; index < stringLength; index++) {
			char ch = string.charAt(index);
			int trieIndex = ch - 'a';
			
			if(currentNode.getChild(trieIndex) == null) {
				Node newNode = new Node(ch);
				currentNode.setChild(trieIndex, newNode);
			}
			
			currentNode = currentNode.getChild(trieIndex);
		}
		currentNode.setLeaf(true);
	}
	
	public boolean search(String searchString) {
		if(searchString == null || searchString.length() == 0) {
			return false;
		}
		
		int searchLength = searchString.length();
		Node currentNode = mRoot;
		
		for(int index = 0; index < searchLength; index++) {
			char ch = searchString.charAt(index);
			int trieIndex = ch - 'a';
			Node nextChildNode = currentNode.getChild(trieIndex);
			if( nextChildNode == null || currentNode.isLeaf()) {
				return false;
			}
			currentNode = nextChildNode;
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		String str = "adr";
		Trie trie = new Trie();
		trie.insert(str);
		
		System.out.println("searching for adroit: " + trie.search("adroit"));
	}
}
