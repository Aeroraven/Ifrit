package com.aeroraven.mizuki.grammar;

import java.util.ArrayList;

import com.aeroraven.mizuki.dfa.TrieGraph;
import com.aeroraven.mizuki.dfa.TrieGraphNode;

public class GrammarScanner
extends TrieGraph{
	public GrammarScanner() {
		super();
	}
	public ArrayList<GrammarScannerToken> scan(String pattern){
		TrieGraphNode cur = start;
		ArrayList<GrammarScannerToken> ret=new ArrayList<GrammarScannerToken>();
		int lastIdx=0;
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
				for(String j:cur.child.keySet()) {
					System.out.print(j);
				}
				return null;
			}
			if(cur.isFinal) {
				GrammarScannerToken nx = new GrammarScannerToken();
				String nxStr;
				i-=cur.prefetch;
				nxStr = pattern.substring(lastIdx,i+1);
				lastIdx=i+1;
				nx.token=cur.finalSign;
				nx.value=nxStr;
				ret.add(nx);
				cur = start;
			}
		}
		return ret;
	}
}
