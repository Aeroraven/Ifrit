package com.aeroraven.ifrit.shape;

import com.aeroraven.ifrit.core.IfritVectord;
import com.aeroraven.ifrit.primitive.IfritPrimitiveBase;
import com.aeroraven.ifrit.primitive.IfritPrimitiveCompound;
import com.aeroraven.ifrit.primitive.IfritPrimitiveDot;

import java.util.ArrayList;

/**
 * ͼ�ι�����-�����ɹ���<br/>
 * ʹ��: ����ģʽ Factory Method<br/>
 * @author 1950641 hzw / Aeroraven
 */
public class IfritSFDot
extends IfritShapeFactory {
    /**
     * ��������ͼ��
     *
     * @param fg       ǰ��ɫ����ά����RGBA
     * @param bg       ����ɫ����ά����RGBA
     * @param fillChar ǰ������ַ�(��Ҫ��ɫ��䣬�����ñ���ɫȻ�������Ϊ�ո�)
     * @param zdepth   �������(��CSS�е�z-depth��ͬ)
     * @param vertices ��������1������(����1����Ч)����ʾ������
     * @param scalars  �ù�������Ҫ�����������
     * @return �����õ�ͼ��
     */
    @Override
    public IfritPrimitiveBase create(IfritVectord fg, IfritVectord bg, String fillChar, int zdepth, ArrayList<IfritVectord> vertices, ArrayList<Double> scalars, ArrayList<String> strings) {
        IfritPrimitiveCompound product = new IfritPrimitiveCompound();
        IfritPrimitiveDot dot = new IfritPrimitiveDot(vertices.get(0).X(),vertices.get(0).Y());
        dot.setForeColor4d(fg.getDuplicate());
        dot.setBackColor4d(bg.getDuplicate());
        dot.setDisplayChar(fillChar);
        dot.setZDepth(zdepth);
        product.add(dot);
        product.setZDepth(zdepth);
        cache = product;
        return product;
    }
}
