package com.aeroraven.ifrit.renderer;

import java.util.ArrayList;
import com.aeroraven.ifrit.primitive.*;
import com.aeroraven.ifrit.component.IfritComponentBase;
import com.aeroraven.ifrit.constant.*;
import com.aeroraven.ifrit.core.*;
import com.aeroraven.ifrit.misc.IfritMath;

public class IfritRasterizationHandler
extends IfritRenderHandlerBase{
	public void dotRasterizer(IfritFrame output,IfritVectord pt,IfritVectord colvec4) {
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
		if(ptRX>=output.frameH) {
			return;
		}
		if(ptRY>=output.frameW) {
			return;
		}

		output.getter(ptRX, ptRY).setDispCh(" ");
		IfritColor16 bgc=IfritMath.findApporximateColor(IfritMath.convertCol4to3(colvec4));
		output.getter(ptRX, ptRY).setBgColor(bgc);
		output.getter(ptRX, ptRY).setFgColor(IfritColor16.WHITE);
		//System.out.println("PT"+ptRX+","+ptRY+" "+bgc+"/"+pt.get(0)+"#"+pt.get(1));
	}
	public void rasterizationFinal(IfritFrame output, ArrayList<IfritPrimitiveBase> shape, IfritRenderMode renderMode) {
		if(renderMode==IfritRenderMode.DOT) {
			for(IfritPrimitiveBase i:shape) {
				for(IfritVectord j:i.getVertices()) {
					dotRasterizer(output,j,i.getColor4d());
				}
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
