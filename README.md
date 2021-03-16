# README

# ***2021年1月29日***

这是用于2021学习Android的一个仓库，里面会存放一些资料笔记和作业！

# ***2021年2月26日***

CSA_work2里面game前缀文件为第二次作业, 其他为一些练习

# ***2021年2月28日***

```
第二次作业的一些修改
Notice: 第二次修改
*  1.怪物和主角都继承一个类,降低耦合度
*  2.变量命名规范,Java独有的驼峰命名法(项目名全部小写,包名全部小写,类名单词首字母大写,变量名方法名首字母小写,常量名全部大写)
*  3.代码重复度(随机选择一个怪物攻击部分if else)
```



# **2021年3月8日**

## 第三次作业

### 3.1  斗地主游戏

```java
/**
 * @author Liuxinjie
 * @version 1.0
 * @date 2021/3/3 003 19:01
 * @software IDEA
 *
 * 知识点: 泛型, hashmap,内部类(定义扑克牌, 发牌, 洗牌, 看牌阶段)
 * 知识点: 接口, 继承, 多态(向下转型),(定义玩家打牌阶段)
 * 玩家类player(父类), 地主类(子类),农民类(子类).然后子类实现了一些接口
 */

/**
 * 本程序只完成了牌的定义,洗牌,发牌,牌的排序,抢地主,地主出第一次牌(同时显示出的牌,然后将玩家的牌从该玩家手牌中去掉)的过程
 * 其他功能如玩家说话,玩家要不起pass()函数,等功能还没有实现(就不打算去实现了)
 */
```

斗地主过程: 组合牌-->洗牌-->发牌-->看牌

原理图:

![](F:/Android2Learning/2021Androidstudy/csawork/out/production/csawork/csawork3/斗地主原理图.jpg)

参考链接https://blog.csdn.net/weixin_40521823/article/details/84144861

### 3.3 json 反射机制

**3. 利用反射机制完成一种数据解析工具**

**自己设计一种数据格式，然后通过反射机制，要求有两种功能：**

**1.将一个类转换成字符串（你们所设计的数据格式）**

**2.将字符串转换成一个类**

**举个例子**

```java
//这是一个类
public class Student {
    public String name="test";
    public boolean gender=false;
    private int age=Integer.MAX_VALUE;
    private double score=Double.MIN_VALUE;
    //省略set和get函数
}
/*通过反射机制，你可以把它转换成字符串
  比如格式：
  "{
     name:"test"
     gender:false
     age:xxxxxx
     score:xxxxx    
  }"
*/
//简单的示例函数（类转换成字符串）
//函数并没有很好区分字符串类型，且无法解析数组，成员变量为实体类的情况
//仅仅提供一个思路，具体的需要你们自己去完善
public static <T> StringBuffer ObjectToJson(T t){
        Class<?> c=t.getClass();
        Field[] fields=c.getDeclaredFields();
        StringBuffer sb=new StringBuffer("{");
        for(Field field:fields){
            field.setAccessible(true);
            if(sb.equals("{")){
                sb.append(",");
            }
            sb.append("\n"+"\""+field.getName()+"\":");
            try {
                sb.append(field.get(t));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        sb.append("\n}");
        return sb;
}
```

**3.实现了json字符串和对象的互转**

如下面这种格式, 包括字符型, 布尔型,int ,double

```java
//json
{"name":"刘鑫杰","gender":true,"age":100,"score":59.0}
//类对象(重写toString()得到)
Hero{name=刘鑫杰, gender=false, age=100, score=59.0}
```

