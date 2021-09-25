package com.aeroraven.mizuki.dfa;


public class TrieGraph { //DFA
	protected TrieGraphNode start;
	public TrieGraph() {
		start = new TrieGraphNode();
	}
	public TrieGraphNode locateNode(String pattern) {
		TrieGraphNode cur = start;
		for(int i=0;i<pattern.length();i++) {
			if(cur.child.get("any")!=null&&i+1<pattern.length()) {
				cur = cur.child.get("any");
			}else if(cur.child.get("num")!=null&&Character.isDigit(pattern.substring(i,i+1).charAt(0))) {
				cur = cur.child.get("num");
			}else if(cur.child.get("nonnum")!=null&&!Character.isDigit(pattern.substring(i,i+1).charAt(0))) {
					cur = cur.child.get("nonnum");
			}else if(cur.child.get("alphabet")!=null&&Character.isAlphabetic(pattern.substring(i,i+1).charAt(0))) {
				cur = cur.child.get("alphabet");
			}else if(cur.child.get("nonalphabet")!=null&&!Character.isAlphabetic(pattern.substring(i,i+1).charAt(0))) {
				cur = cur.child.get("nonalphabet");
			}else if(cur.child.get(pattern.substring(i,i+1))!=null) {
				cur = cur.child.get(pattern.substring(i,i+1));
			}else {
				return null;
			}
		}
		return cur;
	}
	public TrieGraphNode appendLoop(TrieGraphNode node,String seqCh) {
		node.child.put(seqCh, node);
		return node;
	}
	public TrieGraphNode appendNonTerminalNode(TrieGraphNode node,String seqCh) {
		TrieGraphNode x =  new TrieGraphNode();
		node.child.put(seqCh, x);
		return x;
	}
	public TrieGraphNode appendTerminalNode(TrieGraphNode node, String seqCh,Object finalSign, int prefetchRetrace) {
		TrieGraphNode x = new TrieGraphNode();
		x.prefectch=prefetchRetrace;
		x.isFinal=true;
		x.finalSign=finalSign;
		node.child.put(seqCh, x);
		return x;
	}
}
