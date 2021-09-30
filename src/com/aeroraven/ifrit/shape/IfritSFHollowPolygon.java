package com.aeroraven.ifrit.shape;

import com.aeroraven.ifrit.core.IfritVectord;
import com.aeroraven.ifrit.primitive.IfritPrimitiveBase;
import com.aeroraven.ifrit.primitive.IfritPrimitiveCompound;
import com.aeroraven.ifrit.primitive.IfritPrimitiveLine;

import java.util.ArrayList;

/**
 * ͼ�ι�����-���Ķ�������ɹ���<br/>
 * ʹ��: ����ģʽ Factory Method<br/>
 * @author 1950641 hzw / Aeroraven
 */
public class IfritSFHollowPolygon
extends  IfritShapeFactoryV2{
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
        for(int i=0;i<vertices.size();i++) {
            IfritVectord st=vertices.get(i).getDuplicate();
            IfritVectord ed=vertices.get((i+1)%vertices.size()).getDuplicate();
            IfritPrimitiveLine subtmp = new IfritPrimitiveLine(st.get(0),st.get(1),ed.get(0),ed.get(1));
            subtmp.setZDepth(zdepth);
            subtmp.setDisplayChar(fillChar);
            subtmp.setForeColor4d(fg.getDuplicate());
            subtmp.setBackColor4d(bg.getDuplicate());
            product.add(subtmp);
        }
        product.setZDepth(zdepth);
        cache = product;
        return product;
    }
}
