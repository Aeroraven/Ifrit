package com.aeroraven.ifrit.shape;

import com.aeroraven.ifrit.core.IfritVectord;
import com.aeroraven.ifrit.primitive.IfritPrimitiveBase;
import com.aeroraven.ifrit.primitive.IfritPrimitiveCompound;
import com.aeroraven.ifrit.primitive.IfritPrimitiveLine;

import java.util.ArrayList;

/**
 * 图形工厂类-空心矩形生成工厂<br/>
 * 使用: 工厂模式 Factory Method<br/>
 * @author 1950641 hzw / Aeroraven
 */
public class IfritSFHollowRect
extends IfritShapeFactoryV2{
    /**
     * 创建复合图形
     *
     * @param fg       前景色，四维向量RGBA
     * @param bg       背景色，四维向量RGBA
     * @param fillChar 前景填充字符(若要纯色填充，请设置背景色然后此项设为空格)
     * @param zdepth   纵向深度(与CSS中的z-depth等同)
     * @param vertices 参数0:(minX,minY)顶点
     * @param scalars  参数0: X宽度；参数1:Y宽度
     * @param strings  创建图形所需要的字符串信息
     * @return 创建好的图形
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
        for(int i=0;i<tmp.size();i++) {
            IfritVectord st=tmp.get(i).getDuplicate();
            IfritVectord ed=tmp.get((i+1)%tmp.size()).getDuplicate();
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
