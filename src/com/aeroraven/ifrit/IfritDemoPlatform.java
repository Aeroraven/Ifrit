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
		//初始化应用程序(初始化多线程 & 适配操作系统)
		IfritApplication app = IfritApplication.createApplication();
		
		//创建场景
		IfritScene scene = new IfritScene();
		scene.setSceneSize(1000, 400);
		
		//创建组件(Sprite)
		IfritSprite sprite = new IfritSprite();
		sprite.setZDepth(0);
		
		//设定组件的帧数(不设定默认为1)
		sprite.setTotalFrames(2);
		
		//创建图形生成器
		IfritShapeDirector shapeDirector = new IfritShapeDirector();
		IfritShapeTextBuilder textBuilder = new IfritShapeTextBuilder();
		IfritPrimitiveBuilder lineBuilder = new IfritPrimitiveBuilder();
			
		//生成图形并添加到组件对应帧中(创建一个红色圆形)
		shapeDirector.setBackColor(lineBuilder, 255, 0, 0);
		shapeDirector.setForeColor(lineBuilder, 255, 255, 255);
		shapeDirector.createRound(lineBuilder, IfritVectord.val(5.,10.), 3, 0);
		sprite.addPrimitive(lineBuilder.getResult(),0);
		
		//在第二帧插入绿色矩形
		shapeDirector.setBackColor(lineBuilder, 0, 255, 0);
		shapeDirector.createSolidRectangle(lineBuilder,10, IfritVectord.val(2.,7.), 6, 6);
		sprite.addPrimitive(lineBuilder.getResult(),1);
		
		//将组件添加到场景中
		scene.addComponent("helloWorld", sprite);
		
		//指定渲染线程需要渲染的场景
		app.getMediator().addCommand(new IfritCPSwitchRenderScene(scene));
		
		//自定义动画(线程会定时重绘,不需要调用scene.render())
		while(true) {
			sprite.translate2d(1, 0);
			sprite.frameAdvance();
			//变换每1秒执行一次
			Thread.sleep(1000);
		}
	}

}
