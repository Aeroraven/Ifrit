package com.aeroraven.ifrit.shape;

import com.aeroraven.ifrit.core.IfritVectord;
import com.aeroraven.ifrit.primitive.IfritPrimitiveBase;

import java.util.ArrayList;

/**
 *  基本图元的工厂基类 <br/>
 *  使用更加严格的工厂模式定义重写原有的IfritShapeFactory（重构前的类已经废弃）<br/>
 *  使用: 工厂模式 Factory Method<br/>
 * @author 1950641 hzw / Aeroraven
 */
public abstract class IfritShapeFactory {
    protected IfritPrimitiveBase cache;

    /**
     * 用于重置工厂生产结果缓存
     */
    public void reset() {
        cache = null;
    }

    /**
     * 返回暂存区中的对象引用
     *
     * @return 对象
     */
    public IfritPrimitiveBase getStoreRef() {
        return cache;
    }

    /**
     * 返回暂存区中的对象深拷贝
     *
     * @return 原型对象的克隆
     */
    public IfritPrimitiveBase getStoreClone() {
        return cache.clone();
    }
    /** 创建复合图形
     * @param fg 前景色，四维向量RGBA
     * @param bg 背景色，四维向量RGBA
     * @param fillChar 前景填充字符(若要纯色填充，请设置背景色然后此项设为空格)
     * @param zdepth 纵向深度(与CSS中的z-depth等同)
     * @param vertices 创建图形所需要的矢量参数集合
     * @param scalars 创建图形所需要的标量参数集合
     * @param strings  创建图形所需要的字符串信息
     * @return 创建好的图形
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
