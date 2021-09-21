package com.aeroraven.ifrit.shape;

public class IfritShapeFactoryText
extends IfritShapeFactoryBase{
	IfritShapeFactory parent;
	public IfritShapeFactoryText(IfritShapeFactory x) {
		builder = new IfritShapeTextBuilder();
		parent=x;
	}
	public IfritShapeFactoryText setFillChar(String fillCh) {
		builder.setConfigStr("setFillCh", new String(fillCh));
		return this;
	}
	public IfritShapeFactoryText setForeColor(int R,int G,int B) {
		builder.setConfig("setForeColor3", R,G,B);
		return this;
	}
	public IfritShapeFactoryText setBackColor(int R,int G,int B) {
		builder.setConfig("setBackColor3", R,G,B);
		return this;
	}
	public IfritShapeFactoryText createTextContainer(String text,int offsetX,int offsetY,int zdepth) throws Exception {
		builder.builderBegin();
		builder.setConfig("setx", offsetX);
		builder.setConfig("sety", offsetY);
		builder.addFromString(text, zdepth);
		return this;
	}
	public IfritShapeFactoryText createTextWithRectBorder(String text,int offsetX,int offsetY,int w,int h,int zdepth) throws Exception {
		builder.builderBegin();
		int pixelsLen=0;
		for(int i=0;i<text.length();i++) {
			pixelsLen++;
			if(text.substring(i,i+1).getBytes().length==1) {
				if(i+1<text.length()) {
					if(text.substring(i+1,i+2).getBytes().length==1) {
						i++;
					}
				}
			}
		}
		//Background
		for(int i=0;i<w;i++) {
			for(int j=0;j<h;j++) {
				builder.setConfig("setx", i+offsetX);
				builder.setConfig("sety", j+offsetY);
				builder.addFromString("  ", zdepth);
			}
		}
		//Central Text
		int wordX=(w/2-pixelsLen/2)+offsetX;
		int wordY=h/2+offsetY;
		builder.setConfig("setx", wordX);
		builder.setConfig("sety", wordY);
		builder.addFromString(text, zdepth);
		//Top Border
		String lt="",lb="";
		for(int i=offsetX;i<offsetX+w;i++) {
			if(i==offsetX||i==offsetX+w-1) {
				lt+="**";
				lb+="**";
			}else {
				lt+="--";
				lb+="--";
			}
		}
		builder.setConfig("setx", offsetX);
		builder.setConfig("sety", offsetY);
		builder.addFromString(lt, zdepth);
		
		builder.setConfig("setx", offsetX);
		builder.setConfig("sety", offsetY+h-1);
		builder.addFromString(lb, zdepth);
		//LR Border
		for(int i=offsetY+1;i<offsetY+h-1;i++) {
			builder.setConfig("setx", offsetX);
			builder.setConfig("sety", i);
			builder.addFromString("| ", zdepth);
			
			builder.setConfig("setx", offsetX+w-1);
			builder.setConfig("sety", i);
			builder.addFromString(" |", zdepth);
		}
		return this;
	}
	public void store() {
		parent.setCache(builder.getResult());
	}
}
