jquery 是js的一个框架

网络交换数据时

JSON数据格式    键/值对     名/值对

json对象    {"name: 张三,age:21,address:广东省,bookList:["bookname:xxx, price:88"]"}

json数组    [{"name: 张三, age:21,address:广东省"},{"name: 李四,age:20,address:广东省"}]



Java类型----->json字符串(json对象,json数组)

json字符串(json对象, json数组)----->Java类型的数据



伪代码

假设

​	获取了Java类型的数据

Person person=new Person("Mike",21);

String jsonString ="name:"+person.getName()+","+"age:"+person.getAge();

​	获取了List<Person>集合

StringBuffer sb =new StringBuffer("[");

for(Person person:personList){

​	sb.append("name:"+person.getName()+","+"age:"+person.getAge());

}

sb.append("]");



json解析技术     工具包

1.fastjson   阿里巴巴开源

----JSON  

----JSONArray    json数组

----JSONObje     json对象



在转换过程中要注意





#  Java StringBuffer和StringBuilder类

当对字符串进行修改的死活, 需要使用StringBuffer和StringBuilder类

String类不可修改, 而他们类的对象能够被多次的修改,并且不产生新的未使用对象.

![](java-string-20201208.png)

在使用 StringBuffer 类时，每次都会对 StringBuffer 对象本身进行操作，而不是生成新的对象，所以如果需要对字符串进行修改推荐使用 StringBuffer。

StringBuilder 类在 Java 5 中被提出，它和 StringBuffer 之间的最大不同在于 StringBuilder 的方法不是线程安全的（不能同步访问）。

由于 StringBuilder 相较于 StringBuffer 有速度优势，所以多数情况下建议使用 StringBuilder 类。

```java
public class RunoobTest{
    public static void main(String args[]){
        StringBuilder sb = new StringBuilder(10);
        sb.append("Runoob..");
        System.out.println(sb);  
        sb.append("!");
        System.out.println(sb); 
        sb.insert(8, "Java");
        System.out.println(sb); 
        sb.delete(5,8);
        System.out.println(sb);  
    }
}
```

