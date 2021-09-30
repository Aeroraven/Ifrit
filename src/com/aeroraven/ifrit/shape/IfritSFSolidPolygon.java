package com.aeroraven.ifrit.shape;

import com.aeroraven.ifrit.core.IfritVectord;
import com.aeroraven.ifrit.primitive.IfritPrimitiveBase;
import com.aeroraven.ifrit.primitive.IfritPrimitiveCompound;
import com.aeroraven.ifrit.primitive.IfritPrimitivePolygon;

import java.util.ArrayList;
/**
 * 图形工厂类-实心多边形生成工厂<br/>
 * 使用: 工厂模式 Factory Method<br/>
 * @author 1950641 hzw / Aeroraven
 */
public class IfritSFSolidPolygon
extends IfritShapeFactoryV2{
    /**
     * 创建复合图形
     *
     * @param fg       前景色，四维向量RGBA
     * @param bg       背景色，四维向量RGBA
     * @param fillChar 前景填充字符(若要纯色填充，请设置背景色然后此项设为空格)
     * @param zdepth   纵向深度(与CSS中的z-depth等同)
     * @param vertices 参数i:多边形的第i顶点
     * @param scalars  无需标量
     * @param strings  无需字符串
     * @return 创建好的图形
     */
    @Override
    public IfritPrimitiveBase create(IfritVectord fg, IfritVectord bg, String fillChar, int zdepth, ArrayList<IfritVectord> vertices, ArrayList<Double> scalars, ArrayList<String> strings) {
        IfritPrimitiveCompound product = new IfritPrimitiveCompound();
        IfritPrimitivePolygon tmp = new IfritPrimitivePolygon();
        tmp.setZDepth(zdepth);
        tmp.setDisplayChar(fillChar);
        tmp.setForeColor4d(fg.getDuplicate());
        tmp.setBackColor4d(bg.getDuplicate());
        for(int i=0;i<vertices.size();i++) {
            IfritVectord st=vertices.get(i).getDuplicate();
            tmp.addVertex(st);
        }
        product.add(tmp);
        product.setZDepth(zdepth);
        cache = product;
        return product;
    }
}
