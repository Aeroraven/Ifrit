package com.aeroraven.ifrit.shape;

import com.aeroraven.ifrit.core.IfritVectord;
import com.aeroraven.ifrit.primitive.IfritPrimitiveBase;

import java.util.ArrayList;

/**
 *  ����ͼԪ�Ĺ������� <br/>
 *  ʹ�ø����ϸ�Ĺ���ģʽ������дԭ�е�IfritShapeFactory���ع�ǰ�����Ѿ�������<br/>
 *  ʹ��: ����ģʽ Factory Method<br/>
 * @author 1950641 hzw / Aeroraven
 */
public abstract class IfritShapeFactory {
    protected IfritPrimitiveBase cache;

    /**
     * �������ù��������������
     */
    public void reset() {
        cache = null;
    }

    /**
     * �����ݴ����еĶ�������
     *
     * @return ����
     */
    public IfritPrimitiveBase getStoreRef() {
        return cache;
    }

    /**
     * �����ݴ����еĶ������
     *
     * @return ԭ�Ͷ���Ŀ�¡
     */
    public IfritPrimitiveBase getStoreClone() {
        return cache.clone();
    }
    /** ��������ͼ��
     * @param fg ǰ��ɫ����ά����RGBA
     * @param bg ����ɫ����ά����RGBA
     * @param fillChar ǰ������ַ�(��Ҫ��ɫ��䣬�����ñ���ɫȻ�������Ϊ�ո�)
     * @param zdepth �������(��CSS�е�z-depth��ͬ)
     * @param vertices ����ͼ������Ҫ��ʸ����������
     * @param scalars ����ͼ������Ҫ�ı�����������
     * @param strings  ����ͼ������Ҫ���ַ�����Ϣ
     * @return �����õ�ͼ��
     */
    public abstract IfritPrimitiveBase create(
            IfritVectord fg,
            IfritVectord bg,
            String fillChar,
            int zdepth,
            ArrayList<IfritVectord> vertices,
            ArrayList<Double> scalars,
            ArrayList<String> strings);
}
