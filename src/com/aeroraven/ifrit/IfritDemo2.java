package com.aeroraven.ifrit;

import com.aeroraven.ifrit.component.*;
import com.aeroraven.ifrit.scene.*;
import com.aeroraven.ifrit.shapeBuilder.*;
import com.aeroraven.ifrit.natives.*;

public class IfritDemo2 {
	public static void main(String[] args) {
		try {
			//Clear
			IfritGraphicsNativeWin32 nat= new IfritGraphicsNativeWin32();
			nat.cls();
			
			//Creating a new scene
			IfritScene scene = new IfritScene();
			scene.setSceneSize(80, 50);
			
			//Creating a new component
			IfritSprite sprite = new IfritSprite();
			sprite.setZDepth(0);
	
			//Create a shape director
			IfritShapeDirector shapeDirector = new IfritShapeDirector();
			
			//Create a image builder
			IfritShapeImageBuilder imageBuilder = new IfritShapeImageBuilder();
			
			//Load a image
			shapeDirector.createImageContainer(imageBuilder, "C:\\Users\\huang\\Desktop\\Test.png",0,0,0);
			
			//Add the shape to the component
			sprite.addPrimitive(imageBuilder.getResult());
			
			//Attach the component with the scene
			scene.addComponent("helloWorld", sprite);
				
			//Do render
			scene.render();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
