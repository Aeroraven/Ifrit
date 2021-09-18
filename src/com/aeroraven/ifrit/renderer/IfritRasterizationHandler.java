package com.aeroraven.ifrit.renderer;

import java.util.ArrayList;
import com.aeroraven.ifrit.primitive.*;
import com.aeroraven.ifrit.component.IfritComponentBase;
import com.aeroraven.ifrit.constant.*;
import com.aeroraven.ifrit.core.*;
import com.aeroraven.ifrit.misc.IfritMath;

public class IfritRasterizationHandler
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
		if(ptRX>=output.frameW) {
			return;
		}
		if(ptRY>=output.frameH) {
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
			int dx=(int)Math.round(rSt.get(0)),dy=(int)Math.round(rSt.get(0));
			double slope = (rEd.get(1)-rSt.get(1))/(rEd.get(0)-rSt.get(0));
			double e=-0.5;
			if(descending) {
				e=0.5;
			}
			for(int i=dx;i<(int)Math.round(rEd.get(0));i++) {
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
			int dx=(int)Math.round(rSt.get(1)),dy=(int)Math.round(rSt.get(1));
			double slope = (rEd.get(0)-rSt.get(0))/(rEd.get(1)-rSt.get(1));
			double e=-0.5;
			if(descending) {
				e=0.5;
			}
			for(int i=dx;i<(int)Math.round(rEd.get(1));i++) {
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
	}
	public void rasterizationWrapper(IfritFrame output,IfritPrimitiveBase shape) {
		if(!shape.isFinal()) {
			ArrayList<IfritPrimitiveBase> cr = shape.getDirectChild();
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
