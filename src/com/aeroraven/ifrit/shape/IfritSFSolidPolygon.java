package com.aeroraven.ifrit.shape;

import com.aeroraven.ifrit.core.IfritVectord;
import com.aeroraven.ifrit.primitive.IfritPrimitiveBase;
import com.aeroraven.ifrit.primitive.IfritPrimitiveCompound;
import com.aeroraven.ifrit.primitive.IfritPrimitivePolygon;

import java.util.ArrayList;
/**
 * ͼ�ι�����-ʵ�Ķ�������ɹ���<br/>
 * ʹ��: ����ģʽ Factory Method<br/>
 * @author 1950641 hzw / Aeroraven
 */
public class IfritSFSolidPolygon
extends IfritShapeFactoryV2{
    /**
     * ��������ͼ��
     *
     * @param fg       ǰ��ɫ����ά����RGBA
     * @param bg       ����ɫ����ά����RGBA
     * @param fillChar ǰ������ַ�(��Ҫ��ɫ��䣬�����ñ���ɫȻ�������Ϊ�ո�)
     * @param zdepth   �������(��CSS�е�z-depth��ͬ)
     * @param vertices ����i:����εĵ�i����
     * @param scalars  �������
     * @param strings  �����ַ���
     * @return �����õ�ͼ��
     */
    @Override
    public IfritPrimitiveBase create(IfritVectord fg, IfritVectord bg, String fillChar, int zdepth, ArrayList<IfritVectord> vertices, ArrayList<Double> scalars, ArrayList<String> strings) {
        IfritPrimitiveCompound product = new IfritPrimitiveCompound();
        IfritPrimitivePolygon tmp = new IfritPrimitivePolygon();
        tmp.setZDepth(zdepth);
        tmp.setDisplayChar(fillChar);
        tmp.setForeColor4d(fg.getDuplicate());
        tmp.setBackColor4d(bg.getDuplicate());
        for(int i=0;i<vertices.size();i++) {
            IfritVectord st=vertices.get(i).getDuplicate();
            tmp.addVertex(st);
        }
        product.add(tmp);
        product.setZDepth(zdepth);
        cache = product;
        return product;
    }
}
