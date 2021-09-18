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
			IfritSprite sprite2 = new IfritSprite();
			sprite.setZDepth(0);
			sprite2.setZDepth(1);
			
			//创建图形生成器
			IfritShapeDirector shapeDirector = new IfritShapeDirector();
			
			//创建图片生成器
			IfritShapeImageBuilder imageBuilder = new IfritShapeImageBuilder();
			
			//加载图像（点集）
			shapeDirector.createImageContainer(imageBuilder, "C:\\Users\\huang\\Desktop\\test.png",0,0,0);
			//将生成器结果添加到组件
			sprite.addPrimitive(imageBuilder.getResult());
			
			//加载图像（点集）
			shapeDirector.createImageContainer(imageBuilder, "C:\\Users\\huang\\Desktop\\test.png",4,4,0);
			//将生成器结果添加到组件
			sprite2.addPrimitive(imageBuilder.getResult());			
			
			//将组件添加到场景中
			scene.addComponent("helloWorld", sprite);
			scene.addComponent("test", sprite2);
			
			//动画效果
			while(true) {
				//移动组件
				IfritSprite animateSprite= (IfritSprite)scene.getComponent("test");
				animateSprite.translate2d(2, 2);
				
				//渲染场景
				scene.render();
				
				//延迟
				Thread.sleep(50);
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
