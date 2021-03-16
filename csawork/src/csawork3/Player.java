package csawork3;

/**
 * @author Liuxinjie
 * @version 1.0
 * @date 2021/3/3 003 23:00
 * @software IDEA
 */

import java.util.Collections;
import java.util.HashMap;

/**
 * 定义一个玩家类作为父类
 * 包含玩家的名字,出牌,要不起
 */

class Player {

    /**
     * 玩家名字
     */
    String name=null;

    /**
     * 出牌
     * 传入的是自己手中牌的序号数组
     */
    void play(int playerNum,String play_Index,Poker.PlayersGraph graphs,HashMap<Integer,String> map){
        //出牌,将其从自己的list中移除
        String[] strToArray=play_Index.split(",");
        Integer[]index=new Integer[strToArray.length];

        for(int i=0;i<strToArray.length;i++){
            if(!("".equals(strToArray[i]))) {
                index[i] = Integer.parseInt(strToArray[i]);
            }
        }

        //展示出的牌,其中index为要出的牌的序号
        for(Integer key:index){
            String value=map.get(key);
            System.out.print(value+" ");
            //然后将已经出了的牌,从手牌中移除
            graphs.graphs.get(playerNum).remove(key);

        }
        System.out.println();



    }

    /**
     * 要不起,过
     */
    void pass(){

    }

    /**
     * 构造器
     * @param name
     */
    public Player(String name){
        this.name=name;
    }
}

interface Speaking{
    /**
     * 对局中的说话
     */
    void speak(String str);

}

interface CollectButtomCards{
    /**
     * 地主将三张底牌收入
     */
    void collect(Poker.PlayersGraph graphs, int lodrLandNum);
}

/**
 * 地主玩家
 */
class LandLord extends Player implements CollectButtomCards,Speaking{
    String name;

    /**
     * 构造器
     * @param name
     */
    public LandLord(String name){
        super(name);

    }

    /**
     * 地主说话,由主方法传String
     * @param str
     */
    @Override
    public void speak(String str){

        System.out.println("地主"+name+":"+str);
    }


    @Override
    public void collect(Poker.PlayersGraph graphs,int lordLandNum){
        //将三张底牌给地主
        graphs.graphs.get(lordLandNum).add(graphs.graphs.get(0).get(0));
        graphs.graphs.get(lordLandNum).add(graphs.graphs.get(0).get(1));
        graphs.graphs.get(lordLandNum).add(graphs.graphs.get(0).get(2));

        //对地主的牌重新排序
        Collections.sort(graphs.graphs.get(lordLandNum));

    }

}

/**
 * 农民玩家
 */
class Farmer extends Player implements Speaking{
    String name;

    /**
     * 构造器
     * @param name
     */
    public Farmer(String name){
        super(name);

    }

    /**
     * 农民玩家说话, 由主方法传String
     * @param str
     */
    @Override
    public void speak(String str) {

        System.out.println("农民"+name+":"+str);
    }


}


