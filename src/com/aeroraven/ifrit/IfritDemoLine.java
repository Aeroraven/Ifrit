package com.aeroraven.ifrit;

import com.aeroraven.ifrit.component.IfritSprite;
import com.aeroraven.ifrit.natives.IfritGraphicsNativeWin32;
import com.aeroraven.ifrit.scene.IfritScene;
import com.aeroraven.ifrit.shapeBuilder.IfritShapeDirector;
import com.aeroraven.ifrit.shapeBuilder.IfritPrimitiveBuilder;
import com.aeroraven.ifrit.win32.IfritConsoleInterface;
import com.aeroraven.ifrit.core.*;

public class IfritDemoLine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//OS Adaption
			IfritGraphicsNativeWin32 nat= new IfritGraphicsNativeWin32();
			nat.cls();
			
			//Create Scene
			IfritScene scene = new IfritScene();
			scene.setSceneSize(1000, 400);
			
			//Create Component
			IfritSprite sprite = new IfritSprite();
			sprite.setZDepth(0);
			
			//Create Primitive Generator
			IfritShapeDirector shapeDirector = new IfritShapeDirector();
			IfritPrimitiveBuilder lineBuilder = new IfritPrimitiveBuilder();
			
			shapeDirector.setBackColor(lineBuilder, 255, 0, 0);
			shapeDirector.setForeColor(lineBuilder, 255, 255, 255);
			shapeDirector.setFillChar(lineBuilder, "  ");
			//shapeDirector.createLine(lineBuilder, new IfritVectord(0.,0.), new IfritVectord(60.,5.), 0);
			//shapeDirector.createRound(lineBuilder, new IfritVectord(50.,50.), 20., 0);
			shapeDirector.createTriangle(lineBuilder,
					IfritVectord.val(0.,0.) ,
					IfritVectord.val(50.,40.) ,
					IfritVectord.val(75.,20.) , 0);
			
			sprite.addPrimitive(lineBuilder.getResult());
			
			//Component Attachment
			scene.addComponent("helloWorld", sprite);
			
			//Render
			scene.render();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
