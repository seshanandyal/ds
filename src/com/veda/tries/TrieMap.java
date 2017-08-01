package com.veda.tries;

public class TrieMap {
static final int RADIX = 26;
	
	private NodeMap mRoot;
	
	public TrieMap() {
		mRoot = new NodeMap(new Character(' '));
	}
	
	public void insert(String string) {
		if(string == null | string.length() == 0) {
			return;
		}
		
		string = string.toLowerCase();
		int stringLength = string.length();
		NodeMap currentNodeMap = mRoot;
		
		for(int index = 0; index < stringLength; index++) {
			char ch = string.charAt(index);
			int trieIndex = ch - 'a';
			
			if(currentNodeMap.getChild(trieIndex) == null) {
				NodeMap newNodeMap = new NodeMap(ch);
				currentNodeMap.setChild(trieIndex, newNodeMap);
			}
			
			currentNodeMap = currentNodeMap.getChild(trieIndex);
		}
		currentNodeMap.setLeaf(true);
	}
	
	public boolean search(String searchString) {
		if(searchString == null || searchString.length() == 0) {
			return false;
		}
		
		int searchLength = searchString.length();
		NodeMap currentNodeMap = mRoot;
		
		for(int index = 0; index < searchLength; index++) {
			char ch = searchString.charAt(index);
			int trieIndex = ch - 'a';
			NodeMap nextChildNodeMap = currentNodeMap.getChild(trieIndex);
			if( nextChildNodeMap == null || currentNodeMap.isLeaf()) {
				return false;
			}
			currentNodeMap = nextChildNodeMap;
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
