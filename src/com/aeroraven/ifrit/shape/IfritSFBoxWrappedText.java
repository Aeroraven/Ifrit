package com.aeroraven.ifrit.shape;

import com.aeroraven.ifrit.core.IfritVectord;
import com.aeroraven.ifrit.primitive.IfritPrimitiveBase;
import com.aeroraven.ifrit.primitive.IfritPrimitiveCompound;
import com.aeroraven.ifrit.primitive.IfritPrimitiveDot;

import java.util.ArrayList;
import java.util.List;

/**
 * ͼ�ι�����-���о����ı������ɹ���<br/>
 * ʹ��: ����ģʽ Factory Method<br/>
 * @author 1950641 hzw / Aeroraven
 */
public class IfritSFBoxWrappedText
extends IfritShapeFactoryV2{

    /**
     * ��������ͼ��
     *
     * @param fg       ǰ��ɫ����ά����RGBA
     * @param bg       ����ɫ����ά����RGBA
     * @param fillChar ������
     * @param zdepth   �������(��CSS�е�z-depth��ͬ)
     * @param vertices ����0:��ʾ��λ
     * @param scalars  ����0:�ı���X�᳤��;����1:�ı���Y�᳤��
     * @param strings  ����0:Ҫ��ʾ������
     * @return �����õ�ͼ��
     */
    @Override
    public IfritPrimitiveBase create(IfritVectord fg, IfritVectord bg, String fillChar, int zdepth, ArrayList<IfritVectord> vertices, ArrayList<Double> scalars, ArrayList<String> strings) {
        IfritPrimitiveCompound product = new IfritPrimitiveCompound();
        product.setZDepth(zdepth);
        int pixelsLen=0;
        String text = strings.get(0);
        int w=scalars.get(0).intValue();
        int h=scalars.get(1).intValue();
        for(int i=0;i<text.length();i++) {
            pixelsLen++;
            if(text.substring(i,i+1).getBytes().length==1) {
                if(i+1<text.length()) {
                    if(text.substring(i+1,i+2).getBytes().length==1) {
                        i++;
                    }
                }
            }
        }
        //Background
        for(int i=0;i<w;i++) {
            for(int j=0;j<h;j++) {
                IfritPrimitiveDot dot = new IfritPrimitiveDot(vertices.get(0).X()+i,vertices.get(0).Y()+j);
                dot.setForeColor4d(fg.getDuplicate());
                dot.setBackColor4d(bg.getDuplicate());
                dot.setDisplayChar("  ");
                dot.setZDepth(zdepth);
                product.add(dot);
            }
        }
        //Central Text
        int offsetX= (int)vertices.get(0).X();
        int offsetY= (int)vertices.get(0).Y();
        int wordX=(w/2-pixelsLen/2)+offsetX;
        int wordY=h/2+offsetY;
        IfritShapeFactoryV2 textFactory = new IfritSFPlainText();
        textFactory.create(fg,bg,fillChar,zdepth,
                new ArrayList<IfritVectord>(List.of(IfritVectord.val((double) wordX, (double) wordY))),
                null,
                new ArrayList<String>(List.of(strings.get(0))));
        product.add(textFactory.getStoreClone());

        //Top Border
        StringBuilder lt= new StringBuilder();
        StringBuilder lb= new StringBuilder();
        for(int i=offsetX;i<offsetX+w;i++) {
            if(i==offsetX||i==offsetX+w-1) {
                lt.append("**");
                lb.append("**");
            }else {
                lt.append("--");
                lb.append("--");
            }
        }
        textFactory.reset();
        textFactory.create(fg,bg,fillChar,zdepth,
                new ArrayList<IfritVectord>(List.of(IfritVectord.val((double) offsetX, (double) offsetY))),
                null,
                new ArrayList<String>(List.of(lt.toString())));
        product.add(textFactory.getStoreClone());
        textFactory.reset();
        textFactory.create(fg,bg,fillChar,zdepth,
                new ArrayList<IfritVectord>(List.of(IfritVectord.val((double) offsetX, (double) offsetY+h-1))),
                null,
                new ArrayList<String>(List.of(lb.toString())));
        product.add(textFactory.getStoreClone());

        //LR Border
        IfritShapeFactoryV2 dotFactory = new IfritSFDot();
        for(int i=offsetY+1;i<offsetY+h-1;i++) {
            dotFactory.reset();
            dotFactory.create(fg,bg,"| ",zdepth,
                    new ArrayList<IfritVectord>(List.of(IfritVectord.val((double) offsetX, (double) i))),
                    null,
                    null);
            product.add(dotFactory.getStoreClone());

            dotFactory.reset();
            dotFactory.create(fg,bg,"| ",zdepth,
                    new ArrayList<IfritVectord>(List.of(IfritVectord.val((double) offsetX+w-1, (double) i))),
                    null,
                    null);
            product.add(dotFactory.getStoreClone());
        }
        cache = product;
        return product;
    }
}
