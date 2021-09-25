package com.aeroraven.mizuki.trie;

import java.util.HashMap;

public class TrieNode {
	char ch; //Trie节点的符号
	boolean isFinal; //是否为终态
	Object finalSign; //终态标识
	HashMap<Character,TrieNode> child;//子节点(节省空间耗费时间)
	public TrieNode() {
		ch=' ';
		isFinal=false;
		finalSign=null;
		child=new HashMap<Character,TrieNode>();
	}
}
