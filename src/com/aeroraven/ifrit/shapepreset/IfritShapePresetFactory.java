package com.aeroraven.ifrit.shapepreset;

import com.aeroraven.ifrit.core.IfritVecAssist;
import com.aeroraven.ifrit.core.IfritVectord;
import com.aeroraven.ifrit.primitive.IfritPrimitiveBase;
import com.aeroraven.ifrit.primitive.IfritPrimitiveCompound;
import com.aeroraven.ifrit.shape.IfritSFPlainText;
import com.aeroraven.ifrit.shape.IfritSFSolidRect;
import com.aeroraven.ifrit.shape.IfritShapeFactory;

import java.util.ArrayList;

/**
 * Ԥ�踴��ͼ�εļ򵥹���<br/>
 * ��Ҫ����ͼԪ��ʹ��IfritShapeFactory��<br/>
 * ʹ��: �򵥹��� Simple Factory / ���� Singleton
 * @author 1950641 hzw / aeroraven
 */
public final class IfritShapePresetFactory {
    private static IfritShapePresetFactory instance;
    private IfritShapePresetFactory(){}
    public static IfritShapePresetFactory getInstance() {
        if(instance==null) {
            instance = new IfritShapePresetFactory();
        }
        return instance;
    }
    public IfritPrimitiveBase produce(IfritShapePresetType type,
                                      IfritVectord fg,
                                      IfritVectord bg,
                                      int zdepth,
                                      ArrayList<IfritVectord> vertices) {
        return null;
    }
}

class IfritSPGrid
extends  IfritShapePresetBase{

    /**
     * @param fg       ǰ��ɫ��RGBA
     * @param bg       ����ɫ��RGBA
     * @param zdepth   �������
     * @param vertices ����0:��ʼ����
     * @param scalars  ����0:X����;����1:Y����
     * @return Ԥ��ͼ��
     */
    @Override
    public IfritPrimitiveCompound createPresetShape(IfritVectord fg, IfritVectord bg, int zdepth, ArrayList<IfritVectord> vertices, ArrayList<Double> scalars) {
        //Primitive
        IfritPrimitiveCompound product = new IfritPrimitiveCompound();
        product.setZDepth(zdepth);
        //Top & Bottom
        StringBuilder top;
        StringBuilder bottom;
        int w = (int) (double) scalars.get(0);
        int h = (int) (double) scalars.get(1);
        double dx = vertices.get(0).X();
        double dy = vertices.get(0).Y();
        top = new StringBuilder("�X");
        bottom = new StringBuilder("�a");
        String repeat = "�T".repeat(Math.max(0, w - 2));
        top.append(repeat);
        bottom.append(repeat);

        IfritShapeFactory textfactory = new IfritSFPlainText();
        textfactory.create(fg,bg,"",zdepth, IfritVecAssist.conv2List(vertices.get(0)),null,IfritVecAssist.conv2ListStr(top.toString()));

        //Background
        IfritShapeFactory background = new IfritSFSolidRect();
        background.create(fg,bg,"  ",zdepth, IfritVecAssist.conv2List(vertices.get(0)),IfritVecAssist.conv2ListDbl((double)w,(double)h),null);
        product.add(background.getStoreRef());

        //Top&Bottom
        product.add(textfactory.getStoreRef());

        //Left & Right
        for(int i=1;i<h-1;i++) {
            textfactory.reset();
            textfactory.create(fg,bg,"",zdepth,
                    IfritVecAssist.conv2List(IfritVectord.val(dx,dy+i)),
                    null,
                    IfritVecAssist.conv2ListStr("�U"));
            product.add(textfactory.getStoreRef());
            textfactory.reset();
            textfactory.create(fg,bg,"",zdepth,
                    IfritVecAssist.conv2List(IfritVectord.val(dx+w-1,dy+i)),
                    null,
                    IfritVecAssist.conv2ListStr("�U"));
            product.add(textfactory.getStoreRef());

        }
        return product;
    }
}