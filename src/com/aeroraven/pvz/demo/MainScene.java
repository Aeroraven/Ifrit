package com.aeroraven.pvz.demo;

import com.aeroraven.ifrit.app.IfritApplication;
import com.aeroraven.ifrit.command.IfritCPSwitchRenderScene;
import com.aeroraven.ifrit.component.IfritButton;
import com.aeroraven.ifrit.component.IfritSprite;
import com.aeroraven.ifrit.constant.IfritEventName;
import com.aeroraven.ifrit.event.IfritEventHandler;
import com.aeroraven.ifrit.scene.IfritScene;
import com.aeroraven.ifrit.shape.IfritShapeFactory;

public class MainScene {
	static IfritScene  scene = new IfritScene();
	static IfritApplication app;
	static final String MainString="  ____  _             _                       _____               _     _          \r\n"
			+ " |  _ \\| | __ _ _ __ | |_ ___  __   _____    |__  /___  _ __ ___ | |__ (_) ___ ___ \r\n"
			+ " | |_) | |/ _` | '_ \\| __/ __| \\ \\ / / __|     / // _ \\| '_ ` _ \\| '_ \\| |/ _ / __|\r\n"
			+ " |  __/| | (_| | | | | |_\\__ \\  \\ V /\\__ \\_   / /| (_) | | | | | | |_) | |  __\\__ \\\r\n"
			+ " |_|   |_|\\__,_|_| |_|\\__|___/   \\_/ |___(_) /____\\___/|_| |_| |_|_.__/|_|\\___|___/\r\n"
			+ "                                                                                   ";
	static IfritShapeFactory shapeFactory = new IfritShapeFactory();
	static IfritSprite mainTitle = new IfritSprite();
	static IfritButton mainButton = new IfritButton();
	static IfritButton exitButton = new IfritButton();
	
	public static void main(String[] args) throws Exception {
		MainScene x = new MainScene();
		x.runApp();
	}
	
	public void startGame(IfritEventName eventName, Object ...params) {
		System.out.println("点击了开始游戏");
	}
	public void quitGame(IfritEventName eventName, Object ...params) {
		System.out.println("点击了结束游戏");
		System.exit(0);
	}
	public void runApp() throws Exception {
		app = IfritApplication.createApplication();
		
		app.getGlobal().setFrameUpdateInterval(10);
		app.setTitle("Plants vs. Zombies");
		
		//=====这里换成自己想要的音乐文件=====
		//(按顺序播放)
		app.addAudioFile("red.wav");
		//app.addAudioFile("weedy.wav");
		//=================================
		
		scene.setSceneSize(1000, 400);
		
		shapeFactory.textBuilder().setBackColor(0, 0, 0).setForeColor(255, 255, 0).createTextContainer(MainString, 20, 10, 0).store();
		mainTitle.addPrimitive(shapeFactory.getFinalShape());
		scene.addComponent("mainTitle", mainTitle);
		
		shapeFactory.textBuilder().setBackColor(0, 0, 0).setForeColor(255, 255, 0).createTextWithRectBorder("开始游戏 GAME START!", 22, 30, 15,5,1).store();
		mainButton.addPrimitive(shapeFactory.getFinalShape(),0);
		shapeFactory.textBuilder().setBackColor(255, 0, 0).setForeColor(255, 255, 0).createTextWithRectBorder("开始游戏 GAME START!", 22, 30, 15,5,1).store();
		mainButton.addPrimitive(shapeFactory.getFinalShape(),1);
		scene.addComponent("mainButton", mainButton);
		
		shapeFactory.textBuilder().setBackColor(0, 0, 0).setForeColor(255, 0, 0).createTextWithRectBorder("退出游戏 QUIT", 46, 30, 15,5,1).store();
		exitButton.addPrimitive(shapeFactory.getFinalShape(),0);
		shapeFactory.textBuilder().setBackColor(255, 0, 0).setForeColor(255, 255, 0).createTextWithRectBorder("退出游戏 QUIT", 46, 30, 15,5,1).store();
		exitButton.addPrimitive(shapeFactory.getFinalShape(),1);
		
		scene.addComponent("exitButton", exitButton);
		
		mainButton.setClickHandler((IfritEventHandler)this::startGame);
		exitButton.setClickHandler((IfritEventHandler)this::quitGame);
		
		app.setRenderScene(scene);
	}

}
