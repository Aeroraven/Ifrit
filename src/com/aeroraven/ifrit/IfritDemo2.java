package com.aeroraven.ifrit;

import com.aeroraven.ifrit.component.*;
import com.aeroraven.ifrit.scene.*;
import com.aeroraven.ifrit.shapeBuilder.*;
import com.aeroraven.ifrit.win32.IfritConsoleInterface;
import com.aeroraven.ifrit.natives.*;

public class IfritDemo2 {
	public static void main(String[] args) {
		try {
			//�������ϵͳ
			IfritGraphicsNativeWin32 nat= new IfritGraphicsNativeWin32();
			IfritConsoleInterface.ICI_SetConsoleFontInfoEx(0, (short)0, (short)1, 0, 0, "Arial");
			nat.cls();
			
			//��������
			IfritScene scene = new IfritScene();
			scene.setSceneSize(1000, 400);
			
			//�������
			IfritSprite sprite = new IfritSprite();
			IfritSprite sprite2 = new IfritSprite();
			sprite.setZDepth(0);
			sprite2.setZDepth(1);
			
			//����ͼ��������
			IfritShapeDirector shapeDirector = new IfritShapeDirector();
			
			//����ͼƬ������
			IfritShapeImageBuilder imageBuilder = new IfritShapeImageBuilder();
			
			//����ͼ�񣨵㼯��
			shapeDirector.createImageContainer(imageBuilder, "C:\\Users\\huang\\Desktop\\test.png",0,0,0);
			//�������������ӵ����
			sprite.addPrimitive(imageBuilder.getResult());
			
			//����ͼ�񣨵㼯��
			shapeDirector.createImageContainer(imageBuilder, "C:\\Users\\huang\\Desktop\\test.png",4,4,0);
			//�������������ӵ����
			sprite2.addPrimitive(imageBuilder.getResult());			
			
			//�������ӵ�������
			scene.addComponent("helloWorld", sprite);
			scene.addComponent("test", sprite2);
			
			//����Ч��
			while(true) {
				//�ƶ����
				IfritSprite animateSprite= (IfritSprite)scene.getComponent("test");
				animateSprite.translate2d(2, 2);
				
				//��Ⱦ����
				scene.render();
				
				//�ӳ�
				Thread.sleep(50);
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
