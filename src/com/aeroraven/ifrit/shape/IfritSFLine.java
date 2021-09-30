package com.aeroraven.ifrit.shape;

import com.aeroraven.ifrit.core.IfritVectord;
import com.aeroraven.ifrit.primitive.IfritPrimitiveBase;
import com.aeroraven.ifrit.primitive.IfritPrimitiveCompound;
import com.aeroraven.ifrit.primitive.IfritPrimitiveLine;

import java.util.ArrayList;

/**
 * 图形工厂类-线生成工厂<br/>
 * 使用: 工厂模式 Factory Method<br/>
 * @author 1950641 hzw / Aeroraven
 */
public class IfritSFLine
extends  IfritShapeFactoryV2{
    /**
     * 创建复合图形
     *
     * @param fg       前景色，四维向量RGBA
     * @param bg       背景色，四维向量RGBA
     * @param fillChar 前景填充字符(若要纯色填充，请设置背景色然后此项设为空格)
     * @param zdepth   纵向深度(与CSS中的z-depth等同)
     * @param vertices 位置0和1表示直线的起点和终点
     * @param scalars  该工厂不需要标量信息
     * @param strings  该工厂不需要字符串信息
     * @return 创建好的图形
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
