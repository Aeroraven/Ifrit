package com.aeroraven.ifrit.testdemo;

import com.aeroraven.ifrit.app.IfritApplication;
import com.aeroraven.ifrit.command.IfritCPSwitchRenderScene;
import com.aeroraven.ifrit.component.IfritButton;
import com.aeroraven.ifrit.component.IfritSprite;
import com.aeroraven.ifrit.component.IfritWindow;
import com.aeroraven.ifrit.core.IfritVectord;
import com.aeroraven.ifrit.scene.IfritScene;
import com.aeroraven.ifrit.shape.IfritShapeFactory;

public class NullSceneDemo {
    static IfritShapeFactory shapeFactory = new IfritShapeFactory();
    static IfritApplication app;

    public static void main(String[] args) throws Exception {
        NullSceneDemo x = new NullSceneDemo();
        x.runApp();
    }

    public void runApp() throws Exception {
        app = IfritApplication.createApplication();

    }

}
