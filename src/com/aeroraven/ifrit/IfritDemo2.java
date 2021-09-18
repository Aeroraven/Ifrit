package com.aeroraven.ifrit;

import com.aeroraven.ifrit.component.*;
import com.aeroraven.ifrit.scene.*;
import com.aeroraven.ifrit.shapeBuilder.*;
import com.aeroraven.ifrit.win32.IfritConsoleInterface;
import com.aeroraven.ifrit.natives.*;

public class IfritDemo2 {
	public static void main(String[] args) {
		try {
			//适配操作系统
			IfritGraphicsNativeWin32 nat= new IfritGraphicsNativeWin32();
			IfritConsoleInterface.ICI_SetConsoleFontInfoEx(0, (short)0, (short)1, 0, 0, "Arial");
			nat.cls();
			
			//创建场景
			IfritScene scene = new IfritScene();
			scene.setSceneSize(1000, 400);
			
			//创建组件
			IfritSprite sprite = new IfritSprite();
			sprite.setZDepth(0);
			
			//创建图形生成器
			IfritShapeDirector shapeDirector = new IfritShapeDirector();
			
			//创建图片生成器
			IfritShapeImageBuilder imageBuilder = new IfritShapeImageBuilder();
			
			//加载图像（点集）
			shapeDirector.createImageContainer(imageBuilder, "C:\\Users\\huang\\Pictures\\exc.png",0,0,0);
			//将生成器结果添加到组件
			sprite.addPrimitive(imageBuilder.getResult());
			
			//将组件添加到场景中
			scene.addComponent("helloWorld", sprite);

			//渲染场景
			scene.render();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
