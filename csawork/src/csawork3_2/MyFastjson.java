package csawork3_2;

/**
 * @author Liuxinjie
 * @version 1.0
 * @date 2021/3/15 015 19:27
 * @software IDEA
 */

import java.lang.reflect.Field;

/**
 * 作业要求:
 * 利用反射机制完成一种数据解析工具
 * 自己设计一种数据格式，然后通过反射机制，要求有两种功能：
 * 1.将一个类转换成字符串（你们所设计的数据格式）
 * 2.将字符串转换成一个类
 */
public class MyFastjson {
    /**
     * json:    {"id":1,"name":"tom"}
     * id和name是类里面的属性, 后面就是对应属性的值
     */
    /**
     * 生成json的字符串
     * 思路:
     * 1.得到object的class对象,
     * 2.在得到class里面所有属性,
     * 3.循环遍历所有属性并打破属性的访问权限
     * 4.得到属性名作为json的key
     * 5.得到属性值作为json的value
     * 6.把key和value进行拼装成json的格式模样
     * 7.再次循环重复直到所有属性遍历完 3~6步骤
     * 8.返回最后拼装好的字符串
     */
    public static String toJSONString(Object object) throws Exception {
        StringBuffer json=new StringBuffer("{");


        //1.得到object的class对象,
        Class<?> clazz=object.getClass();
        //2.在得到class里面所有属性,
        Field[]fields=clazz.getDeclaredFields();
        //3.循环遍历所有属性并打破属性的访问权限
        //计数器,用于判断是否循环到数组末尾, 便于不添加最后一个逗号
        int count=0;
        int length = fields.length;

        for (Field field:fields) {
            field.setAccessible(true);
            //4.得到属性名作为json的key
            String name = field.getName();
            //5.得到属性值作为json的value
            Object objectValue = field.get(object);
            //6.把key和value进行拼装成json的格式模样
            json.append("\""+name+"\"");
            //如果值为字符串,加上引号
            if(objectValue instanceof String){
                json.append(":\""+objectValue.toString()+"\"");
            }else{//为数字类型
                json.append(":"+objectValue.toString());
            }
            count++;
            if(count!=length) {
                json.append(",");
            }
            //7.再次循环重复直到所有属性遍历完 3~6步骤

        }
        //添加最后一个大括号
        json.append("}");

        //8.返回最后拼装好的字符串
        return json.toString();
    }

    /**
     * 把json的字符串转换成对象
     * 传递进去一个json字符串和class对象, 返回一个泛型
     */
    public static <T> T parseObject(String json , Class<T> tClass)throws Exception{
        //给的json字符串{"name":"刘鑫杰","gender":true,"age":100,"score":59.0}
        //根据类的对象tClass创建一个要返回的对象
        T t = tClass.getConstructor().newInstance();
        //整体思路：先把外面的大括号去掉, 然后再用split用逗号进行拆分, 然后冒号进行拆分

        //去掉前后的大括号
        String newStr = json.replace("{", "").replace("}", "");
        //此时没有大括号了
        System.out.println(newStr);
        //按逗号进行拆分
        String[] split = newStr.split(",");
//        "name":"刘鑫杰" "gender":true  "age":100 "score":59.0
        for (String s:split) {
            //对冒号进行拆分
            //将里面的所有引号替换为空""-->去引号
            String replaceS = s.replace("\"", "");
            String[] keyValue = replaceS.split(":");
            //key
            String key=keyValue[0];
            //value
            String value = keyValue[1];
            System.out.println(key+" "+ value);

            //根据key在tClass里面找到属性和对象
            Field declaredField = tClass.getDeclaredField(key);
            //打破访问权限
            declaredField.setAccessible(true);

            //因为里面有个布尔变量,而这里的value是字符串类型,所以还要做一个判断
            //得到属性值的名字(属性对应的类型),比如true对应boolean
            String simpleName = declaredField.getType().getSimpleName();
            //设置对象值
            if(simpleName.equals("boolean")){
                declaredField.set(t,Boolean.valueOf(value));
            }else if(simpleName.equals("int")){
                declaredField.set(t,Integer.valueOf(value));
            }else if(simpleName.equals("double")){
                declaredField.set(t,Double.valueOf(value));
            }
            else{//字符类型值设置
                declaredField.set(t,value);
            }


        }
        return t;
    }

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


