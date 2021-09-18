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
			//适配操作系统
			IfritGraphicsNativeWin32 nat= new IfritGraphicsNativeWin32();
			nat.cls();
			
			//创建场景
			IfritScene scene = new IfritScene();
			scene.setSceneSize(1000, 400);
			
			//创建组件
			IfritSprite sprite = new IfritSprite();
			sprite.setZDepth(0);
			
			//创建图形生成器
			IfritShapeDirector shapeDirector = new IfritShapeDirector();
			IfritPrimitiveBuilder lineBuilder = new IfritPrimitiveBuilder();
			
			shapeDirector.setBackColor(lineBuilder, 255, 0, 0);
			shapeDirector.setForeColor(lineBuilder, 255, 255, 255);
			shapeDirector.setFillChar(lineBuilder, "  ");
			shapeDirector.createLine(lineBuilder, new IfritVectord(43.,4.), new IfritVectord(12.,25.), 0);
			
			
			sprite.addPrimitive(lineBuilder.getResult());
			
			//将组件添加到场景中
			scene.addComponent("helloWorld", sprite);
			
			//渲染场景
			scene.render();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
