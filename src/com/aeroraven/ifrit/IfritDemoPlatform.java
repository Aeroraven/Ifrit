package com.aeroraven.ifrit;

import com.aeroraven.ifrit.app.IfritApplication;
import com.aeroraven.ifrit.command.IfritCPSwitchRenderScene;
import com.aeroraven.ifrit.component.IfritSprite;
import com.aeroraven.ifrit.core.IfritVectord;
import com.aeroraven.ifrit.scene.IfritScene;
import com.aeroraven.ifrit.shapeBuilder.IfritPrimitiveBuilder;
import com.aeroraven.ifrit.shapeBuilder.IfritShapeDirector;
import com.aeroraven.ifrit.shapeBuilder.IfritShapeTextBuilder;

public class IfritDemoPlatform {

	public static void main(String[] args) throws Exception {
		IfritApplication app = IfritApplication.createApplication();
		
		IfritScene scene = new IfritScene();
		scene.setSceneSize(1000, 400);
		
		IfritSprite sprite = new IfritSprite();
		sprite.setZDepth(0);
		sprite.setTotalFrames(2);
		
		IfritShapeDirector shapeDirector = new IfritShapeDirector();
		IfritShapeTextBuilder textBuilder = new IfritShapeTextBuilder();
		IfritPrimitiveBuilder lineBuilder = new IfritPrimitiveBuilder();
		
		
		shapeDirector.setBackColor(lineBuilder, 255, 0, 0);
		shapeDirector.setForeColor(lineBuilder, 255, 255, 255);
		shapeDirector.createRound(lineBuilder, IfritVectord.val(5.,10.), 3, 0);
		sprite.addPrimitive(lineBuilder.getResult(),0);
		
		shapeDirector.setBackColor(lineBuilder, 0, 255, 0);
		shapeDirector.createSolidRectangle(lineBuilder,10, IfritVectord.val(2.,7.), 6, 6);
		sprite.addPrimitive(lineBuilder.getResult(),1);
		
		scene.addComponent("helloWorld", sprite);
		
		app.getMediator().addCommand(new IfritCPSwitchRenderScene(scene));
		
		while(true) {
			sprite.translate2d(1, 0);
			sprite.frameAdvance();
			Thread.sleep(1000);
		}
	}

}
