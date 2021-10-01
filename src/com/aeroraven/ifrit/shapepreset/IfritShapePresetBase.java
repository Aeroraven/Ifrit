package com.aeroraven.ifrit.shapepreset;

import com.aeroraven.ifrit.core.IfritVectord;
import com.aeroraven.ifrit.primitive.IfritPrimitiveCompound;

import java.util.ArrayList;

public abstract class IfritShapePresetBase {
    /**
     * @param fg ǰ��ɫ��RGBA
     * @param bg ����ɫ��RGBA
     * @param zdepth �������
     * @param vertices ʵ��Ԥ��ı�Ҫʸ��
     * @param scalars ʵ��Ԥ��ı�Ҫ����
     * @return Ԥ��ͼ��
     */
    public abstract IfritPrimitiveCompound createPresetShape(IfritVectord fg,
                                             IfritVectord bg,
                                             int zdepth,
                                             ArrayList<IfritVectord> vertices,
                                             ArrayList<Double> scalars);
}
