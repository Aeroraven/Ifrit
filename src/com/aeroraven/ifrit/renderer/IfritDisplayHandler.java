package com.aeroraven.ifrit.renderer;

import java.util.ArrayList;

import com.aeroraven.ifrit.component.IfritComponentBase;
import com.aeroraven.ifrit.core.IfritGlobal;
import com.aeroraven.ifrit.natives.*;
import com.aeroraven.ifrit.constant.*;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.OutputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.IOException;

public final class IfritDisplayHandler
extends IfritRenderHandlerBase{
	private static IfritDisplayHandler instance;
	private IfritFrame frameBuffer;
	
	public static IfritDisplayHandler getInst() {
		if(instance == null) {
			instance = new IfritDisplayHandler();
			IfritGlobal globalArguments = IfritGlobal.getInst();
			instance.frameBuffer = new IfritFrame();
			instance.frameBuffer.initalize(globalArguments.getScreenWidth(), globalArguments.getScreenHeight());
		}
		return instance;
	}
	
	public IfritFrame handleComponents(ArrayList<IfritComponentBase> arg,int sW,int sH) {
		return null;
	}
	public void handleFrame(IfritFrameBase fr) {
		//Create Native Display Adapter
		IfritGraphicsNativeBase cgapi = new IfritGraphicsNativeWin32();
		int flushWidth = Math.min(fr.frameW, frameBuffer.frameW);
		int flushHeight = Math.min(fr.frameH, frameBuffer.frameH);
		System.out.println("FLUSHW:"+flushWidth);
		System.out.println("FLUSHH:"+flushHeight);
		for(int i=0;i<flushHeight;i++) {
			for(int j=0;j<flushWidth;j++) {
				IfritPixel newPx = fr.getter(i, j);
				IfritPixel oldPx = frameBuffer.getter(i, j);
				if(newPx.getFgColor()!=oldPx.getFgColor()||newPx.getBgColor()!=oldPx.getBgColor()||
					newPx.getDispCh()!=oldPx.getDispCh()) {
				//if(true) {
					cgapi.setTextPos((short)(j*2), (short)i);
					cgapi.setTextColor(newPx.getBgColor(),newPx.getFgColor());
					OutputStream out = new BufferedOutputStream ( System.out );
					try {
						out.write(newPx.getDispCh().getBytes());
						out.write(newPx.getDispCh().getBytes());
						out.flush();
					} catch (IOException e) {
						e.printStackTrace();
					}
					//Update frame buffer
					oldPx.setDispCh(new String(newPx.getDispCh()));
					oldPx.setBgColor(newPx.getBgColor());
					oldPx.setFgColor(newPx.getFgColor());
				}
			}
		}
		
	}
}
