package com.aeroraven.mizuki.dfa;

import java.util.HashMap;

public class TrieGraphNode {
	public boolean isFinal; //�Ƿ���̬
	public int prefetch; //Ԥ��ȡ����
	public Object finalSign; //��̬��ʶ
	public HashMap<String,TrieGraphNode> child;//�����ڵ�
	public TrieGraphNode() {
		isFinal=false;
		prefetch=0;
		finalSign=0;
		child = new HashMap<String,TrieGraphNode>();
	}
}
