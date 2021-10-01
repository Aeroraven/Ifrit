package com.aeroraven.ifrit.testdemo;

import com.aeroraven.ifrit.app.IfritApplication;

public class NullSceneDemo {
    static IfritApplication app;

    public static void main(String[] args) throws Exception {
        NullSceneDemo x = new NullSceneDemo();
        x.runApp();
    }

    public void runApp() throws Exception {
        app = IfritApplication.createApplication();
    }

}
