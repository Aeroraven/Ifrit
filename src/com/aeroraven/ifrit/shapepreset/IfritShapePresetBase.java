package com.aeroraven.ifrit.shapepreset;

import com.aeroraven.ifrit.core.IfritVectord;
import com.aeroraven.ifrit.primitive.IfritPrimitiveCompound;

import java.util.ArrayList;

public abstract class IfritShapePresetBase {
    /**
     * @param fg 前景色，RGBA
     * @param bg 背景色，RGBA
     * @param zdepth 纵轴深度
     * @param vertices 实现预设的必要矢量
     * @param scalars 实现预设的必要参数
     * @return 预设图形
     */
    public abstract IfritPrimitiveCompound createPresetShape(IfritVectord fg,
                                             IfritVectord bg,
                                             int zdepth,
                                             ArrayList<IfritVectord> vertices,
                                             ArrayList<Double> scalars);
}
