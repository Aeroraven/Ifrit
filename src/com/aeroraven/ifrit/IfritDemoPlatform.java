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
		//��ʼ��Ӧ�ó���(��ʼ�����߳� & �������ϵͳ)
		IfritApplication app = IfritApplication.createApplication();
		
		//��������
		IfritScene scene = new IfritScene();
		scene.setSceneSize(1000, 400);
		
		//�������(Sprite)
		IfritSprite sprite = new IfritSprite();
		sprite.setZDepth(0);
		
		//�趨�����֡��(���趨Ĭ��Ϊ1)
		sprite.setTotalFrames(2);
		
		//����ͼ��������
		IfritShapeDirector shapeDirector = new IfritShapeDirector();
		IfritShapeTextBuilder textBuilder = new IfritShapeTextBuilder();
		IfritPrimitiveBuilder lineBuilder = new IfritPrimitiveBuilder();
			
		//����ͼ�β���ӵ������Ӧ֡��(����һ����ɫԲ��)
		shapeDirector.setBackColor(lineBuilder, 255, 0, 0);
		shapeDirector.setForeColor(lineBuilder, 255, 255, 255);
		shapeDirector.createRound(lineBuilder, IfritVectord.val(5.,10.), 3, 0);
		sprite.addPrimitive(lineBuilder.getResult(),0);
		
		//�ڵڶ�֡������ɫ����
		shapeDirector.setBackColor(lineBuilder, 0, 255, 0);
		shapeDirector.createSolidRectangle(lineBuilder,10, IfritVectord.val(2.,7.), 6, 6);
		sprite.addPrimitive(lineBuilder.getResult(),1);
		
		//�������ӵ�������
		scene.addComponent("helloWorld", sprite);
		
		//ָ����Ⱦ�߳���Ҫ��Ⱦ�ĳ���
		app.getMediator().addCommand(new IfritCPSwitchRenderScene(scene));
		
		//�Զ��嶯��(�̻߳ᶨʱ�ػ�,����Ҫ����scene.render())
		while(true) {
			sprite.translate2d(1, 0);
			sprite.frameAdvance();
			//�任ÿ1��ִ��һ��
			Thread.sleep(1000);
		}
	}

}
