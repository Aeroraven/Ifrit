package com.aeroraven.ifrit;

import com.aeroraven.ifrit.app.IfritApplication;
import com.aeroraven.ifrit.command.IfritCPAddIOEventHandler;
import com.aeroraven.ifrit.command.IfritCPSwitchRenderScene;
import com.aeroraven.ifrit.component.IfritButton;
import com.aeroraven.ifrit.component.IfritSprite;
import com.aeroraven.ifrit.component.IfritWindow;
import com.aeroraven.ifrit.constant.*;
import com.aeroraven.ifrit.event.IfritEventHandler;
import com.aeroraven.ifrit.scene.IfritScene;
import com.aeroraven.ifrit.shape.IfritShapeFactory;

public class IfritDemoPlatform {
	static IfritScene  scene = new IfritScene();
	static IfritButton btn1 = new IfritButton();
	static IfritButton btn2 = new IfritButton();
	static IfritWindow window = new IfritWindow();
	
	static IfritShapeFactory shapeFactory = new IfritShapeFactory();
	static IfritApplication app;
	
	public static void main(String[] args) throws Exception {
		IfritDemoPlatform x = new IfritDemoPlatform();
		x.runApp();
	}
	
	public void runApp() throws Exception {
		app = IfritApplication.createApplication();
		app.getGlobal().setFrameUpdateInterval(10);
		
		scene.setSceneSize(1000, 400);
		
		//Add Button1
		btn1.setZDepth(0);
		shapeFactory.textBuilder()
					.setBackColor(255, 0, 0)
					.setForeColor(255,255, 255)
					.createTextWithRectBorder("HelloWorld", 0, 0, 12, 5, 0)
					.store();
		btn1.addPrimitive(shapeFactory.getFinalShape(),0);	
		shapeFactory.textBuilder()
					.setBackColor(0, 255, 0)
					.setForeColor(255,255, 255)
					.createTextWithRectBorder("HelloWorld", 0, 0, 12, 5, 0)
					.store();
		btn1.addPrimitive(shapeFactory.getFinalShape(),1);	
		scene.addComponent("1", btn1);
		
		//Add Button 2
		btn2.setZDepth(0);
		shapeFactory.textBuilder()
					.setBackColor(255, 0, 0)
					.setForeColor(255,255, 255)
					.createTextWithRectBorder("HelloWorld", 20, 0, 12, 5, 0)
					.store();
		btn2.addPrimitive(shapeFactory.getFinalShape(),0);	
		shapeFactory.textBuilder()
					.setBackColor(0, 255, 0)
					.setForeColor(255,255, 255)
					.createTextWithRectBorder("HelloWorld", 20, 0, 12, 5, 0)
					.store();
		btn2.addPrimitive(shapeFactory.getFinalShape(),1);	
		scene.addComponent("2", btn2);
		
		app.getMediator().addCommand(new IfritCPSwitchRenderScene(scene));
	}

}
