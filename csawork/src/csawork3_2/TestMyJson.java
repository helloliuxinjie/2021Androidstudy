package csawork3_2;

/**
 * @author Liuxinjie
 * @version 1.0
 * @date 2021/3/15 015 21:31
 * @software IDEA
 */
public class TestMyJson {
    public static void main(String[] args) throws Exception {

        //把类转换成json
        System.out.println("========把类转换成json========");
        Hero hero=new Hero("刘鑫杰",false,100,59);
        String jsonString = MyFastjson.toJSONString(hero);
        System.out.println(jsonString);

        //换行
        System.out.println();
        System.out.println();
        System.out.println();

        //把json转换成类
        System.out.println("========把json转换成类========");
        Hero hero1=MyFastjson.parseObject(jsonString,Hero.class);
        System.out.println(hero1);
    }
}
