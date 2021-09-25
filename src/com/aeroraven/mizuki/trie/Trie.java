package com.aeroraven.mizuki.trie;

public class Trie {
	private TrieNode root;
	public Trie() {
		root = new TrieNode();
	}
	public void addRule(String rule,Object match) {
		TrieNode cur = root;
		for(int i=0;i<rule.length();i++) {
			if(cur.child.get(rule.charAt(i))==null) {
				cur.child.put(rule.charAt(i), new TrieNode());
			}
			cur = cur.child.get(rule.charAt(i));
		}
		cur.finalSign = match;
		cur.isFinal=true;
	}
	public Object matchRule(String pattern) {
		TrieNode cur =root;
		for(int i=0;i<pattern.length();i++) {
			if(cur.child.get(pattern.charAt(i))!=null) {
				cur = cur.child.get(pattern.charAt(i));
			}else {
				return null;
			}
		}
		if(cur.isFinal==false) {
			return null;
		}
		return cur.finalSign;
	}
}
