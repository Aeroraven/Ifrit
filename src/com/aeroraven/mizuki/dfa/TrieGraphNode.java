package com.aeroraven.mizuki.dfa;

import java.util.HashMap;

public class TrieGraphNode {
	public boolean isFinal; //是否终态
	public int prefectch; //预读取个数
	public Object finalSign; //终态标识
	public HashMap<String,TrieGraphNode> child;//后续节点
}
