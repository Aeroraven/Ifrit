package com.aeroraven.ifrit.shape;

import com.aeroraven.ifrit.core.IfritVectord;
import com.aeroraven.ifrit.primitive.IfritPrimitiveBase;
import com.aeroraven.ifrit.primitive.IfritPrimitiveCompound;
import com.aeroraven.ifrit.primitive.IfritPrimitivePolygon;

import java.util.ArrayList;

/**
 * 图形工厂类-实心矩形生成工厂<br/>
 * 使用: 工厂模式 Factory Method<br/>
 * @author 1950641 hzw / Aeroraven
 */
public class IfritSFSolidRect
extends IfritShapeFactory {
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
