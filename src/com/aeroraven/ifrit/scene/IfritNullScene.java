package com.aeroraven.ifrit.scene;

import com.aeroraven.ifrit.component.IfritSprite;
import com.aeroraven.ifrit.core.IfritVectord;
import com.aeroraven.ifrit.shape.IfritSFPlainText;
import com.aeroraven.ifrit.shape.IfritShapeFactoryV2;

import java.util.ArrayList;
import java.util.List;

/**
 * 空场景<br/>
 * 使用: 空对象 Null Object<br/>
 * @author 1950641 hzw / Aeroraven
 */
public final class IfritNullScene
extends IfritScene{
    public IfritNullScene() {
        setSceneSize(100,100);
        IfritSprite nullTip = new IfritSprite();
        IfritShapeFactoryV2 txtFactory = new IfritSFPlainText();
        txtFactory.create(
                IfritVectord.val(0.,0.,0.,0.),
                IfritVectord.val(255.,255.,255.,0.),
                "",
                1,
                new ArrayList<IfritVectord>(List.of(IfritVectord.val(0.,0.))),
                null,
                new ArrayList<String>(List.of("This is the default scene of Ifrit Application!\n Begin with creating your customzied scene")));
        nullTip.addPrimitive(txtFactory.getStoreRef());
        addComponent("default",nullTip);
        System.out.println("RENDERED");
    }
}
