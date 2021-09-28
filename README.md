## Ifrit
#### 介绍 

一个Java实现的命令行绘图的工具。<s>Deals AOE Arts Damage in a long line</s>



#### 开始

<b>对于Java 9+用户</b>（如果使用模块）

```java
requires com.aeroraven.ifrit;
```

<b>对于未升级到Windows10的Windows用户</b>

- 升级到Windows10，或使用支持CSI序列的终端或控制台

<b>对于非Windows的用户</b>

- 重新编译适用于当前操作系统的 IfritNative （使用C++编写）

- 对于非Linux用户和非Windows用户，需要根据操作系统自行添加 IfritNative 内容。

  

<b>初始化应用程序</b>

该步骤用于完成线程初始化(GC线程、绘制线程、IO线程和音频线程)以及操作系统相关的环境初始化。

```java
IfritApplication app = IfritApplication.createApplication();
```

<b>创建场景</b>

场景(Scene)是绘制的单位，一次绘制过程中只会有一个场景会被绘制。场景是控件(Component)的容器。

```java
IfritScene  scene = new IfritScene();
```

<b>创建组件</b>

组件(Component)是由一个或多个图形(Primitive)构成的具有统一功能的对象。图形的创建可以通过`IfritShapeFactory`类实例化的对象来产生。通过`IfritShapeFactory`生成的图形可以通过组件的`addPrimitive`方法添加到组件中。

```java
IfritSprite sprite = new IfritSprite();
IfritShapeFactory shapeFactory = new IfritShapeFactory();

shapeFactory.textBuilder()
    .setBackColor(255, 0, 0)
    .setForeColor(255,255, 255)
    .createTextWithRectBorder("Button A", 0, 0, 12, 5, 0)
    .store();
sprite.addPrimitive(shapeFactory.getFinalShape(),0);	
```

<b>设置绘制场景</b>

该步骤实现设置绘制线程所需要绘制的场景。绘制流程为：将场景中的图形按照Z轴顺序排好（垂直于屏幕），将各个图形按照控制台进行光栅化(IfritRasterizationHandler)，最后根据改变的像素点绘制图形(IfritDisplayHandler)

```java
app.setRenderScene(scene);
```



#### 已经使用的设计模式

- Singleton 单例模式
- Bridge 桥接模式
- Command 命令模式
- Mediator 中介者模式
- Factory Method 工厂方法
- Template Method 模板方法
- Composite 组合模式
- Observer 观察者模式



#### 计划使用的设计模式

- Null Object 空对象模式



#### 可以使用的控件

##### IfritComponentBase (所有控件共用的部分)

- `translate2d(x,y)`方法
  - 该方法会通知其下属的所有子组件(对于IfritWindow对象)和子图形按照给定的X偏移和Y偏移进行移动（虽然这样从算法角度效率极其低下，但为了套Observer设计模式。。。）
- `addPrimitive(shape,frame)`方法
  - 该方法将图形`shape`添加到控件的指定帧`frame`中。对于`IfritWindow`对象，该方法会抛出异常。



##### IfritSprite

支持最基础的图形显示和动画效果。IfritSprite可以拥有多个帧，并且播放逐帧动画。

- `setTotalFrames(x)`
  - 设定对象拥有`x`个帧
- `frameAdvance()`
  - 播放下一帧
  - 使用IfritCPAddRenderEventHandler和该方法可以实现动画效果。

##### IfritButton

按钮组件，支持键盘点击事件。用户可以通过左右键选中按钮。

- `setClickHandler(x)`
  - 在按钮处于选中状态时，用户若按下ENTER，则控制器x会被触发。一个按钮仅支持一个点击控制器
- `addPrimitive(shape,0)`方法
  - 在按钮非选中时，展示图形`shape`
- `addPrimitive(shape,1)`方法
  - 在按钮选中时，展示图形`shape`

##### IfritWindow

组件容器，能够存放组件。在一个场景中，如果存在多个可见窗口(IfritWindow，且isHidden为false)，则会将可选中的组件范围限定在该IfritWindow的子组件中，并且递归地查找该IfritWindow是否包含可见的子窗口，若存在则递归限定组件范围。

- `addComponent`方法用于添加子组件



#### 可以使用的图形

##### 文字图形

- Text Builder / createTextWithRectBorder 带矩形背景的文本框，文字左上对齐
- Text Builder / createTextContainer 普通文字

##### 位图图形 

- Image Builder / createImageContainer 绘制位图
  - 不建议使用的选项（在Windows上为了获得最佳效果，请将字号设置为1，缓冲区设置尽量大）

##### 基本图形（按控制台像素光栅化后）

- Primitive Builder / createLine 绘制直线

- Primitive Builder / createCircleArc 绘制圆弧

- Primitive Builder / createRound 绘制圆形（填充）

- Primitive Builder / createTriangle 绘制三角形

- Primitive Builder / createHollowPolygon 绘制空心多边形

- Primitive Builder / createSolidPolygon 绘制实心多边形

- Primitive Builder / createHollowRectangle 绘制空心矩形

- Primitive Builder / createSolidRectangle 绘制实心矩形

  

#### 支持的命令行

所有和GC、绘制、音频等线程的交互通过Mediator进行（虽然这样效率低下，但是能套设计模式）

- Threading Mediator / IfritCPSwitchRenderScene(IfritScene scene)
  - 设置渲染线程需要绘制的场景
- Threading Mediator / IfritCPAddIOEventHandler(String hash, IfritEventHandler handler)
  - 设置IO输入的事件控制器(Handler)

- Threading Mediator / IfritCPRemoveIOEventHandler(String hash)
  - 移除IO事件控制器
- Threading Mediator / IfritCPAddRenderEventHandler(String hash, IfritEventHandler handler)
  - 设置帧更新事件控制器(Handler)
- Threading Mediator / IfritCPRemoveRenderEventHandler(String hash, IfritEventHandler handler)
  - 移除帧更新事件控制器

