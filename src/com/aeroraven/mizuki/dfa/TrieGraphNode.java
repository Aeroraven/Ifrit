package com.aeroraven.mizuki.dfa;

import java.util.HashMap;

public class TrieGraphNode {
	public boolean isFinal; //�Ƿ���̬
	public int prefectch; //Ԥ��ȡ����
	public Object finalSign; //��̬��ʶ
	public HashMap<String,TrieGraphNode> child;//�����ڵ�
}
