package com.aeroraven.ifrit.shape;

import com.aeroraven.ifrit.core.IfritVectord;
import com.aeroraven.ifrit.primitive.IfritPrimitiveBase;
import com.aeroraven.ifrit.primitive.IfritPrimitiveCircleArc;
import com.aeroraven.ifrit.primitive.IfritPrimitiveCompound;

import java.util.ArrayList;

/**
 * ͼ�ι�����-����Բ���ɹ���<br/>
 * ʹ��: ����ģʽ Factory Method<br/>
 * @author 1950641 hzw / Aeroraven
 */
public class IfritSFHollowCircle
extends IfritShapeFactory {

    /**
     * ��������ͼ��
     *
     * @param fg       ǰ��ɫ����ά����RGBA
     * @param bg       ����ɫ����ά����RGBA
     * @param fillChar ǰ������ַ�(��Ҫ��ɫ��䣬�����ñ���ɫȻ�������Ϊ�ո�)
     * @param zdepth   �������(��CSS�е�z-depth��ͬ)
     * @param vertices ����0:��ʾԲ��
     * @param scalars  ����0:��ʾ��ʾ�뾶
     * @param strings  �ù�������Ҫ�ַ�����Ϣ
     * @return �����õ�ͼ��
     */
    @Override
    public IfritPrimitiveBase create(IfritVectord fg, IfritVectord bg, String fillChar, int zdepth, ArrayList<IfritVectord> vertices, ArrayList<Double> scalars, ArrayList<String> strings) {
        IfritPrimitiveCompound product = new IfritPrimitiveCompound();
        IfritPrimitiveCircleArc arc = new IfritPrimitiveCircleArc(vertices.get(0).X(),vertices.get(0).Y(),scalars.get(0));
        arc.setForeColor4d(fg.getDuplicate());
        arc.setBackColor4d(bg.getDuplicate());
        arc.setDisplayChar(fillChar);
        arc.setZDepth(zdepth);
        product.add(arc);
        product.setZDepth(zdepth);
        cache = product;
        return product;
    }
}