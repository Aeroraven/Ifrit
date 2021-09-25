package com.aeroraven.mizuki.trie;

import java.util.HashMap;

public class TrieNode {
	char ch; //Trie�ڵ�ķ���
	boolean isFinal; //�Ƿ�Ϊ��̬
	Object finalSign; //��̬��ʶ
	HashMap<Character,TrieNode> child;//�ӽڵ�(��ʡ�ռ�ķ�ʱ��)
	public TrieNode() {
		ch=' ';
		isFinal=false;
		finalSign=null;
		child=new HashMap<Character,TrieNode>();
	}
}
