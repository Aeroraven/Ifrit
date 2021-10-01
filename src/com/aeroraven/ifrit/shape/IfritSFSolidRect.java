package com.aeroraven.ifrit.shape;

import com.aeroraven.ifrit.core.IfritVectord;
import com.aeroraven.ifrit.primitive.IfritPrimitiveBase;
import com.aeroraven.ifrit.primitive.IfritPrimitiveCompound;
import com.aeroraven.ifrit.primitive.IfritPrimitivePolygon;

import java.util.ArrayList;

/**
 * ͼ�ι�����-ʵ�ľ������ɹ���<br/>
 * ʹ��: ����ģʽ Factory Method<br/>
 * @author 1950641 hzw / Aeroraven
 */
public class IfritSFSolidRect
extends IfritShapeFactory {
    /**
     * ��������ͼ��
     *
     * @param fg       ǰ��ɫ����ά����RGBA
     * @param bg       ����ɫ����ά����RGBA
     * @param fillChar ǰ������ַ�(��Ҫ��ɫ��䣬�����ñ���ɫȻ�������Ϊ�ո�)
     * @param zdepth   �������(��CSS�е�z-depth��ͬ)
     * @param vertices ����0:(minX,minY)����
     * @param scalars  ����0: X��ȣ�����1:Y���
     * @param strings  ����ͼ������Ҫ���ַ�����Ϣ
     * @return �����õ�ͼ��
     */
    @Override
    public IfritPrimitiveBase create(IfritVectord fg, IfritVectord bg, String fillChar, int zdepth, ArrayList<IfritVectord> vertices, ArrayList<Double> scalars, ArrayList<String> strings) {
        IfritPrimitiveCompound product = new IfritPrimitiveCompound();
        ArrayList<IfritVectord> tmp = new ArrayList<>();
        IfritVectord rt=IfritVectord.val(vertices.get(0).X()+scalars.get(0),vertices.get(0).Y());
        IfritVectord rb=IfritVectord.val(vertices.get(0).X()+scalars.get(0),vertices.get(0).Y()+scalars.get(1));
        IfritVectord lb=IfritVectord.val(vertices.get(0).X(),vertices.get(0).Y()+scalars.get(1));
        IfritVectord lt=IfritVectord.val(vertices.get(0).X(),vertices.get(0).Y());
        tmp.add(rt);
        tmp.add(rb);
        tmp.add(lb);
        tmp.add(lt);
        IfritPrimitivePolygon tmp2 = new IfritPrimitivePolygon();
        tmp2.setZDepth(zdepth);
        tmp2.setDisplayChar(fillChar);
        tmp2.setForeColor4d(fg.getDuplicate());
        tmp2.setBackColor4d(bg.getDuplicate());
        for (IfritVectord ifritVectord : tmp) {
            IfritVectord st = ifritVectord.getDuplicate();
            tmp2.addVertex(st);
        }
        product.add(tmp2);
        product.setZDepth(zdepth);
        cache = product;
        return product;
    }
}
