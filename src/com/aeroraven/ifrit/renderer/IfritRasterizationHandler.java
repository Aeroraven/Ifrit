package com.aeroraven.ifrit.renderer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import com.aeroraven.ifrit.primitive.*;
import com.aeroraven.ifrit.component.IfritComponentBase;
import com.aeroraven.ifrit.constant.*;
import com.aeroraven.ifrit.core.*;
import com.aeroraven.ifrit.misc.IfritMath;

class IfritRasterizationHandler
extends IfritRenderHandlerBase{
	public void dotRasterizer(IfritFrame output,IfritVectord pt,IfritVectord colvec4,IfritVectord colvec4bg,String dispCh) {
		int ptX = (int)(double)(pt.get(0));
		int ptY = (int)(double)(pt.get(1));
		ArrayList<IfritVectord> distpt = new ArrayList<IfritVectord>();
		distpt.add(new IfritVectord(ptX+1.0,ptY+1.0));
		distpt.add(new IfritVectord(ptX+0.0,ptY+1.0));
		distpt.add(new IfritVectord(ptX+1.0,ptY+0.0));
		distpt.add(new IfritVectord(ptX+0.0,ptY+0.0));
		int closetIdx=3;
		double closetDist= 9E+100;
		for(int i=0;i<4;i++) {
			if(IfritMath.getEculideanDist(pt, distpt.get(i))<closetDist && distpt.get(i).get(0)>-1.0 && distpt.get(i).get(1)>1.0) {
				closetIdx=i;
				closetDist=IfritMath.getEculideanDist(pt, distpt.get(i));
			}
		}
		closetIdx=3;
		int ptRX = (int)(double)distpt.get(closetIdx).get(0);
		int ptRY = (int)(double)distpt.get(closetIdx).get(1);
		if(ptRX>=output.frameW||ptRX<0) {
			return;
		}
		if(ptRY>=output.frameH||ptRY<0) {
			return;
		}
		output.getter(ptRX, ptRY).setDispCh(dispCh);
		IfritColor16 bgc=IfritMath.findApporximateColor(IfritMath.convertCol4to3(colvec4bg));
		IfritColor16 fgc=IfritMath.findApporximateColor(IfritMath.convertCol4to3(colvec4));
		output.getter(ptRX, ptRY).setBgColor(bgc);
		output.getter(ptRX, ptRY).setFgColor(fgc);
	}
	public void lineRasterizer(IfritFrame output, IfritVectord st,IfritVectord ed, IfritVectord colvec4, IfritVectord colvec4bg,String dispCh) {
		//Compare slope
		double deltaX = Math.abs (st.get(0)-ed.get(0));
		double deltaY = Math.abs(st.get(1)-ed.get(1));
		boolean scanYAxis = (deltaY>deltaX);
		boolean descending = false;
		IfritColor16 fgc=IfritMath.findApporximateColor(IfritMath.convertCol4to3(colvec4));
		IfritColor16 bgc=IfritMath.findApporximateColor(IfritMath.convertCol4to3(colvec4bg));
		//Switch order
		IfritVectord rSt,rEd;
		if(scanYAxis) {
			if(ed.get(1)>st.get(1)) {
				rSt=st;
				rEd=ed;
			}else {
				rSt=ed;
				rEd=st;
			}
			if(rEd.get(0)-rSt.get(0)<0) {
				descending=true;
			}
		}else {
			if(ed.get(0)>st.get(0)) {
				rSt=st;
				rEd=ed;
			}else {
				rSt=ed;
				rEd=st;
			}
			if(rEd.get(1)-rSt.get(1)<0) {
				descending=true;
			}
		}
		//Bresenham Line Rasterizer
		if(!scanYAxis) {
			//Starting
			int dx=(int)Math.round(rSt.get(0)),dy=(int)Math.round(rSt.get(1));
			double slope = (rEd.get(1)-rSt.get(1))/(rEd.get(0)-rSt.get(0));
			double e=-0.5;
			if(descending) {
				e=0.5;
			}
			for(int i=dx;i<=(int)Math.round(rEd.get(0));i++) {
				if((dx<output.getFrameW())&&(dx>=0)&&(dy<output.getFrameH())&&(dy>=0)) {
					IfritPixel px=output.getter(dx, dy);
					px.setBgColor(bgc);
					px.setFgColor(fgc);
					px.setDispCh(dispCh);
				}
				dx++;
				e+=slope;
				if(!descending) {
					if(e>=0) {
						dy++;
						e=e-1;
					}
				}else {
					if(e<=00) {
						dy--;
						e=e+1;
					}
				}
			}
		}else {
			int dx=(int)Math.round(rSt.get(1)),dy=(int)Math.round(rSt.get(0));
			double slope = (rEd.get(0)-rSt.get(0))/(rEd.get(1)-rSt.get(1));
			double e=-0.5;
			if(descending) {
				e=0.5;
			}
			for(int i=dx;i<=(int)Math.round(rEd.get(1));i++) {
				if((dx<output.getFrameH())&&(dx>=0)&&(dy<output.getFrameW())&&(dy>=0)) {
					IfritPixel px=output.getter(dy, dx);
					px.setBgColor(bgc);
					px.setFgColor(fgc);
					px.setDispCh(dispCh);
				}
				dx++;
				e+=slope;
				if(!descending) {
					if(e>=0) {
						dy++;
						e=e-1;
					}
				}else {
					if(e<=00) {
						dy--;
						e=e+1;
					}
				}
			}
		}
	}
	
	public void arcRasterizer(IfritFrame output,IfritVectord ct,IfritVectord ed,IfritVectord color4vecfg, IfritVectord color4vecbg, String dispCh,boolean doFilling) {
		//Get Top Pixel
		double radius=IfritMath.getEculideanDist(ct, ed);
		IfritVectord tp=new IfritVectord(ct.get(0),ct.get(1)+radius);
		int cx=(int)Math.round(ct.get(0));
		int cy=(int)Math.round(ct.get(1));
		int dx=(int)Math.round(tp.get(0));
		int dy=(int)Math.round(tp.get(1));
		//Color Approximation
		IfritColor16 fgc=IfritMath.findApporximateColor(IfritMath.convertCol4to3(color4vecfg));
		IfritColor16 bgc=IfritMath.findApporximateColor(IfritMath.convertCol4to3(color4vecbg));
		
		//Draw 1/8 arc, Using Bresenham Rasterizer
		ArrayList<Integer> arcPixelsX = new ArrayList<Integer>();
		ArrayList<Integer> arcPixelsY = new ArrayList<Integer>();
		arcPixelsX.add(Integer.valueOf(dx));
		arcPixelsY.add(Integer.valueOf(dy));
		int delta=(int)(3.-2.*radius);
		if(doFilling) {
			for(int j=cy+(dx-cx);j<=dy;j++) {
				arcPixelsX.add(Integer.valueOf(dx));
				arcPixelsY.add(Integer.valueOf(j));
			}
		}
		while(dx-cx<=dy-cy) {
			if(delta<=0) {
				dx++;
				delta+=4*(dx-1-cx)+7;
			}else {
				dx++;
				dy--;
				delta+=4*((dx-1-cx)-(dy+1-cy))+11;
			}
			if(!doFilling) {
				arcPixelsX.add(Integer.valueOf(dx));
				arcPixelsY.add(Integer.valueOf(dy));
			}else {
				for(int j=cy+(dx-cx);j<=dy;j++) {
					arcPixelsX.add(Integer.valueOf(dx));
					arcPixelsY.add(Integer.valueOf(j));
				}
			}
			
		}
		//Symmetry
		int pxSize = arcPixelsX.size();
		for(int i=0;i<pxSize;i++) {
			int rX=arcPixelsX.get(i)-cx;
			int rY=arcPixelsY.get(i)-cy;
			//Px1-RT_top_half
			if(rX+cx>=0&&rX+cx<output.getFrameW()&&rY+cy>=0&&rY+cy<output.getFrameH()) {
				IfritPixel px = output.getter(rX+cx, rY+cy);
				px.setBgColor(bgc);
				px.setFgColor(fgc);
				px.setDispCh(dispCh);
			}
			//Px2-RT_bottom_half
			if(rY+cx>=0&&rY+cx<output.getFrameW()&&rX+cy>=0&&rX+cy<output.getFrameH()) {
				IfritPixel px = output.getter(rY+cx, rX+cy);
				px.setBgColor(bgc);
				px.setFgColor(fgc);
				px.setDispCh(dispCh);
			}
			//Px3-RB_top_half
			if(rY+cx>=0&&rY+cx<output.getFrameW()&&-rX+cy>=0&&-rX+cy<output.getFrameH()) {
				IfritPixel px = output.getter(rY+cx, -rX+cy);
				px.setBgColor(bgc);
				px.setFgColor(fgc);
				px.setDispCh(dispCh);
			}
			//Px4-RB_bottom_half
			if(rX+cx>=0&&rX+cx<output.getFrameW()&&-rY+cy>=0&&-rY+cy<output.getFrameH()) {
				IfritPixel px = output.getter(rX+cx, -rY+cy);
				px.setBgColor(bgc);
				px.setFgColor(fgc);
				px.setDispCh(dispCh);
			}
			//Px5-LT_top_half
			if(-rX+cx>=0&&-rX+cx<output.getFrameW()&&rY+cy>=0&&rY+cy<output.getFrameH()) {
				IfritPixel px = output.getter(-rX+cx, rY+cy);
				px.setBgColor(bgc);
				px.setFgColor(fgc);
				px.setDispCh(dispCh);
			}
			//Px6-LT_bottom_half
			if(-rY+cx>=0&&-rY+cx<output.getFrameW()&&rX+cy>=0&&rX+cy<output.getFrameH()) {
				IfritPixel px = output.getter(-rY+cx, rX+cy);
				px.setBgColor(bgc);
				px.setFgColor(fgc);
				px.setDispCh(dispCh);
			}
			//Px7-LB_top_half
			if(-rY+cx>=0&&-rY+cx<output.getFrameW()&&-rX+cy>=0&&-rX+cy<output.getFrameH()) {
				IfritPixel px = output.getter(-rY+cx, -rX+cy);
				px.setBgColor(bgc);
				px.setFgColor(fgc);
				px.setDispCh(dispCh);
			}
			//Px8-LB_bottom_half
			if(-rX+cx>=0&&-rX+cx<output.getFrameW()&&-rY+cy>=0&&-rY+cy<output.getFrameH()) {
				IfritPixel px = output.getter(-rX+cx, -rY+cy);
				px.setBgColor(bgc);
				px.setFgColor(fgc);
				px.setDispCh(dispCh);
			}
		}
	}
	public void polygonRasterizer(IfritFrame output,ArrayList<IfritVectord> vx,IfritVectord color4vecfg, IfritVectord color4vecbg, String dispCh) {
		//Counting Vertices
		int minY=90000;
		int maxY=-1;
		int n=vx.size();
		ArrayList<Integer> vertexCounter = new ArrayList<Integer>();
		for(int i=0;i<vx.size();i++) {
			int xc=0;
			if(vx.get(i).get(1)<vx.get((i+1)%n).get(1)) {
				xc++;
			}
			if(vx.get(i).get(1)<vx.get((i-1+n)%n).get(1)) {
				xc++;
			}
			vertexCounter.add(xc);
			if((int)(double)vx.get(i).get(1)<minY) {
				minY=(int)(double)vx.get(i).get(1);
			}
			if((int)Math.ceil(vx.get(i).get(1))>maxY) {
				maxY=(int)(double)vx.get(i).get(1);
			}
			
		}
		
		minY=Math.max(0,minY);
		maxY=Math.min(output.getFrameH(),maxY);
		//Constructing AEL
		HashMap<Integer,ArrayList<Double>> ael =new HashMap<Integer,ArrayList<Double>>();
		for(int i=minY;i<=maxY;i++) {
			
			ael.put(i, new ArrayList<Double>());
			for(int j=0;j<n;j++) {
				int stIdx=j;
				int edIdx=(j+1)%n;
				IfritVectord st=vx.get(stIdx),ed=vx.get(edIdx);
				if((int)(double)st.get(1)==i) {
					for(int k=0;k<vertexCounter.get(j);k++) {
						ael.get(i).add(st.get(0));
						
					}
				}
				if((int)(double)st.get(1)==i||(int)(double)ed.get(1)==i||st.get(1)==ed.get(1)) {
					continue;
				}
				if(Math.min(st.get(1),ed.get(1))>i||Math.max(ed.get(1),st.get(1))<i) {
					continue;
				}
				
				//Get intersections
				double sA,sB,sC;
				double tA,tB,tC;
				double iX;
				sA=st.get(1)-ed.get(1);
				sB=-st.get(0)+ed.get(0);
				sC=st.get(0)*ed.get(1)-ed.get(0)*st.get(1);
				tA=0;
				tB=1;
				tC=-i;
				iX=(sB*tC-tB*sC)/(sA*tB-tA*sB);
				ael.get(i).add(iX);
			}
			Collections.sort(ael.get(i));
		}
		//Color Approximation
		IfritColor16 fgc=IfritMath.findApporximateColor(IfritMath.convertCol4to3(color4vecfg));
		IfritColor16 bgc=IfritMath.findApporximateColor(IfritMath.convertCol4to3(color4vecbg));
		
		//Filling
		for(int i=minY;i<=maxY;i++) {
			
			for(int j=0;j<ael.get(i).size();j+=2) {
				for(int k=(int)Math.floor(ael.get(i).get(j));k<(int)Math.round(ael.get(i).get(j+1));k++) {
					IfritPixel px = output.getter(k, i);
					px.setBgColor(bgc);
					px.setFgColor(fgc);
					px.setDispCh(dispCh);
				}
			}
		}
	}
	public void lineloopRasterizer(IfritFrame output,ArrayList<IfritVectord> vx,IfritVectord color4vecfg, IfritVectord color4vecbg, String dispCh) {
		for(int i=0;i<vx.size();i++) {
			lineRasterizer(output,vx.get(i),vx.get((i+1)%vx.size()),color4vecfg,color4vecbg,dispCh);
		}
	}
	public void linestripRasterizer(IfritFrame output,ArrayList<IfritVectord> vx,IfritVectord color4vecfg, IfritVectord color4vecbg, String dispCh) {
		for(int i=0;i<vx.size()-1;i++) {
			lineRasterizer(output,vx.get(i),vx.get((i+1)%vx.size()),color4vecfg,color4vecbg,dispCh);
		}
	}
	public void rasterizationFinal(IfritFrame output, ArrayList<IfritPrimitiveBase> shape, IfritRenderMode renderMode) {
		if(renderMode==IfritRenderMode.DOT) {
			for(IfritPrimitiveBase i:shape) {
				for(IfritVectord j:i.getVertices()) {
					dotRasterizer(output,j,i.getForeColor4d(),i.getBackColor4d(),i.getDisplayChar());
				}
			}
		}
		if(renderMode==IfritRenderMode.LINE) {
			for(IfritPrimitiveBase i:shape) {
				lineRasterizer(output,i.getVertices().get(0),i.getVertices().get(1),i.getForeColor4d(),i.getBackColor4d(),i.getDisplayChar());
			}
		}
		if(renderMode==IfritRenderMode.FULL_ARC) {
			for(IfritPrimitiveBase i:shape) {
				arcRasterizer(output,i.getVertices().get(0),i.getVertices().get(1),i.getForeColor4d(),i.getBackColor4d(),i.getDisplayChar(),false);
			}
		}
		if(renderMode==IfritRenderMode.ROUND) {
			for(IfritPrimitiveBase i:shape) {
				arcRasterizer(output,i.getVertices().get(0),i.getVertices().get(1),i.getForeColor4d(),i.getBackColor4d(),i.getDisplayChar(),true);
			}
		}
		if(renderMode==IfritRenderMode.TRIANGLE) {
			for(IfritPrimitiveBase i:shape) {
				ArrayList<IfritVectord> vx = new ArrayList<IfritVectord>();
				vx.add(i.getVertices().get(0));
				vx.add(i.getVertices().get(1));
				vx.add(i.getVertices().get(2));
				polygonRasterizer(output,vx,i.getForeColor4d(),i.getBackColor4d(),i.getDisplayChar());
				lineloopRasterizer(output,vx,i.getForeColor4d(),i.getBackColor4d(),i.getDisplayChar());
			}
		}
		if(renderMode==IfritRenderMode.POLYGON) {
			//System.out.println("POLYTON!!");
			for(IfritPrimitiveBase i:shape) {
				ArrayList<IfritVectord> vx = i.getVertices();
				polygonRasterizer(output,vx,i.getForeColor4d(),i.getBackColor4d(),i.getDisplayChar());
				lineloopRasterizer(output,vx,i.getForeColor4d(),i.getBackColor4d(),i.getDisplayChar());
			}
		}
	}
	public void rasterizationWrapper(IfritFrame output,IfritPrimitiveBase shape) {
		if(!shape.isFinal()) {
			ArrayList<IfritPrimitiveBase> cr = shape.getDirectChild();
			Collections.sort(cr);
			for(IfritPrimitiveBase i:cr) {
				rasterizationWrapper(output, i);
			}
		}else {
			rasterizationFinal(output,shape.getDirectChild(),shape.getRenderMode());
		}
	}
	public IfritFrame handleComponents(ArrayList<IfritComponentBase> arg,int sW,int sH) {
		IfritFrame newFrame = new IfritFrame();
		newFrame.initalize(sW, sH);
		for(IfritComponentBase i:arg) {
			ArrayList<IfritPrimitiveBase> primList = i.getPrimitives();
			for(IfritPrimitiveBase j:primList) {
				rasterizationWrapper(newFrame,j);
				
			}
		}
		return newFrame;
	}
	public void handleFrame(IfritFrameBase fr) {
		
	}
}
