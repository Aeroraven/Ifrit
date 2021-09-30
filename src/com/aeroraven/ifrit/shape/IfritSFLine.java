package com.aeroraven.ifrit.shape;

import com.aeroraven.ifrit.core.IfritVectord;
import com.aeroraven.ifrit.primitive.IfritPrimitiveBase;
import com.aeroraven.ifrit.primitive.IfritPrimitiveCompound;
import com.aeroraven.ifrit.primitive.IfritPrimitiveLine;

import java.util.ArrayList;

/**
 * ͼ�ι�����-�����ɹ���<br/>
 * ʹ��: ����ģʽ Factory Method<br/>
 * @author 1950641 hzw / Aeroraven
 */
public class IfritSFLine
extends  IfritShapeFactoryV2{
    /**
     * ��������ͼ��
     *
     * @param fg       ǰ��ɫ����ά����RGBA
     * @param bg       ����ɫ����ά����RGBA
     * @param fillChar ǰ������ַ�(��Ҫ��ɫ��䣬�����ñ���ɫȻ�������Ϊ�ո�)
     * @param zdepth   �������(��CSS�е�z-depth��ͬ)
     * @param vertices λ��0��1��ʾֱ�ߵ������յ�
     * @param scalars  �ù�������Ҫ������Ϣ
     * @param strings  �ù�������Ҫ�ַ�����Ϣ
     * @return �����õ�ͼ��
     */
    @Override
    public IfritPrimitiveBase create(IfritVectord fg, IfritVectord bg, String fillChar, int zdepth, ArrayList<IfritVectord> vertices, ArrayList<Double> scalars, ArrayList<String> strings) {
        IfritPrimitiveCompound product = new IfritPrimitiveCompound();
        IfritPrimitiveLine line = new IfritPrimitiveLine(vertices.get(0).X(),vertices.get(0).Y(),
                vertices.get(1).X(),vertices.get(1).Y());
        line.setForeColor4d(fg.getDuplicate());
        line.setBackColor4d(bg.getDuplicate());
        line.setDisplayChar(fillChar);
        line.setZDepth(zdepth);
        product.add(line);
        product.setZDepth(zdepth);
        cache = product;
        return product;
    }
}
