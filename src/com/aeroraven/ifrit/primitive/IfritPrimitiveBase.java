package com.aeroraven.ifrit.primitive;

import java.util.*;
import com.aeroraven.ifrit.core.*;
import com.aeroraven.ifrit.constant.*;


/**
 * 图元基类
 * 存储图元的顶点、深度等相关信息 <br/>
 * 使用: 组合模式 Composite <br/>
 * 支持: 原型模式 Prototype <br/>
 * @author 1950641 hzw / Aeroraven
 */
public abstract class IfritPrimitiveBase
implements IfritPrimitiveEventInterface, IfritPrimitiveGeometryInterface,Comparable<IfritPrimitiveBase>,Cloneable {
	protected ArrayList<IfritVectord> pointlist=null;
	protected String alias ="";
	protected Boolean isFinal =false;
	protected int zdepth = 0;
	protected IfritRenderMode renderMode;
	protected String dispChar = "  ";
	
	public abstract IfritVectord getForeColor3d();
	public abstract void setForeColor3d(IfritVectord color3d);
	public abstract IfritVectord getForeColor4d();
	public abstract void setForeColor4d(IfritVectord color4d);
	
	public abstract IfritVectord getBackColor3d();
	public abstract void setBackColor3d(IfritVectord color3d);
	public abstract IfritVectord getBackColor4d();
	public abstract void setBackColor4d(IfritVectord color4d);
	
	
	public abstract void translate2d(IfritVectord offset2d);

	
	public void setAlias(String arg) {alias=arg;}
	public String getAlias(String arg) {return alias;}
	public boolean isFinal() {return isFinal;}
	
	public abstract IfritRenderMode getRenderMode();
	public abstract void setRenderMode(IfritRenderMode e);
	
	public int compareTo(IfritPrimitiveBase e) {
		return Integer.compare(zdepth, e.zdepth);
	}

	@Override
	public IfritPrimitiveBase clone() {
		try {
			IfritPrimitiveBase clone = (IfritPrimitiveBase) super.clone();
			clone.pointlist = new ArrayList<IfritVectord>();
			if(pointlist!=null) {
				for(IfritVectord i:pointlist) {
					clone.pointlist.add(i.getDuplicate());
				}
			}
			clone.alias = new String(alias);
			clone.isFinal = (boolean) isFinal;
			clone.zdepth = zdepth;
			clone.renderMode = renderMode;
			clone.dispChar = new String(dispChar);
			return clone;
		} catch (CloneNotSupportedException e) {
			throw new AssertionError();
		}
	}
}
