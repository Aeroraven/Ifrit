package com.aeroraven.ifrit.shapefactory;

import com.aeroraven.ifrit.core.IfritVectord;
import com.aeroraven.ifrit.primitive.IfritPrimitiveBase;
import com.aeroraven.ifrit.primitive.IfritPrimitiveCompound;
import com.aeroraven.ifrit.primitive.IfritPrimitiveDot;

import java.util.ArrayList;
/**
 * 图形工厂类-普通文本生成工厂<br/>
 * 使用: 工厂模式 Factory Method<br/>
 * @author 1950641 hzw / Aeroraven
 */
public class IfritSFPlainText
extends IfritShapeFactoryV2{

    /**
     * 创建复合图形
     *
     * @param fg       前景色，四维向量RGBA
     * @param bg       背景色，四维向量RGBA
     * @param fillChar 无作用
     * @param zdepth   纵向深度(与CSS中的z-depth等同)
     * @param vertices 参数0:显示定位
     * @param scalars  不需要标量信息
     * @param strings  参数0:要显示的文字
     * @return 创建好的图形
     */
    @Override
    public IfritPrimitiveBase create(IfritVectord fg, IfritVectord bg, String fillChar, int zdepth, ArrayList<IfritVectord> vertices, ArrayList<Double> scalars, ArrayList<String> strings) {
        int counter=0;
        int ycounter=0;
        IfritPrimitiveCompound product = new IfritPrimitiveCompound();
        product.setZDepth(zdepth);
        String arg = strings.get(0);
        for(int i=0;i<arg.length();i++) {
            String e=arg.substring(i,i+1);
            if(e.getBytes().length==1&& !e.equals("\n")){
                if(i+1<arg.length()) {
                    if(arg.substring(i+1,i+2).getBytes().length==1) {
                        if(arg.charAt(i + 1) == '\n' ==false) {
                            e=arg.substring(i,i+2);
                            i++;
                        }

                    }
                }
            }else if(e.equals("\n")) {
                counter=0;
                ycounter++;
                continue;
            }
            IfritPrimitiveDot tmp=new IfritPrimitiveDot(vertices.get(0).X()+counter,vertices.get(0).Y()+ycounter);
            counter+=1;
            tmp.setZDepth(zdepth);
            tmp.setDisplayChar(e);
            tmp.setForeColor4d(fg.getDuplicate());
            tmp.setBackColor4d(bg.getDuplicate());
            product.add(tmp);
        }
        cache = product;
        return cache;
    }
}
