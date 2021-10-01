package com.aeroraven.ifrit.shape;

import com.aeroraven.ifrit.core.IfritVectord;
import com.aeroraven.ifrit.primitive.IfritPrimitiveBase;
import com.aeroraven.ifrit.primitive.IfritPrimitiveCompound;
import com.aeroraven.ifrit.primitive.IfritPrimitiveDot;

import java.util.ArrayList;

/**
 * 图形工厂类-点生成工厂<br/>
 * 使用: 工厂模式 Factory Method<br/>
 * @author 1950641 hzw / Aeroraven
 */
public class IfritSFDot
extends IfritShapeFactory {
    /**
     * 创建复合图形
     *
     * @param fg       前景色，四维向量RGBA
     * @param bg       背景色，四维向量RGBA
     * @param fillChar 前景填充字符(若要纯色填充，请设置背景色然后此项设为空格)
     * @param zdepth   纵向深度(与CSS中的z-depth等同)
     * @param vertices 接收至少1个顶点(至多1个有效)，表示点坐标
     * @param scalars  该工厂不需要额外标量参量
     * @return 创建好的图形
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
