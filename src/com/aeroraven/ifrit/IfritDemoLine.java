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
			//�������ϵͳ
			IfritGraphicsNativeWin32 nat= new IfritGraphicsNativeWin32();
			nat.cls();
			
			//��������
			IfritScene scene = new IfritScene();
			scene.setSceneSize(1000, 400);
			
			//�������
			IfritSprite sprite = new IfritSprite();
			sprite.setZDepth(0);
			
			//����ͼ��������
			IfritShapeDirector shapeDirector = new IfritShapeDirector();
			IfritPrimitiveBuilder lineBuilder = new IfritPrimitiveBuilder();
			
			shapeDirector.setBackColor(lineBuilder, 255, 0, 0);
			shapeDirector.setForeColor(lineBuilder, 255, 255, 255);
			shapeDirector.setFillChar(lineBuilder, "  ");
			shapeDirector.createLine(lineBuilder, new IfritVectord(43.,4.), new IfritVectord(12.,25.), 0);
			
			
			sprite.addPrimitive(lineBuilder.getResult());
			
			//�������ӵ�������
			scene.addComponent("helloWorld", sprite);
			
			//��Ⱦ����
			scene.render();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
