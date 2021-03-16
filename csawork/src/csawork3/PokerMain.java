package csawork3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

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

public class PokerMain {
    /**
     * 定义3个玩家和对象,将各个玩家的牌和底牌分别放到ArrayList中
     */


    public static void main(String[] args) {
        //定义扑克对象
        Poker poker=new Poker();

        //0~53,给每张牌一个编号,依次代表大王,小王,2,2,2,2,A,A,A,A...3,3,3,3
        ArrayList<Integer> indexList=new ArrayList();
        indexList=poker.indexToList(indexList);

        //让索引index与牌面值一一对应, 使用hashmap数据结构
        HashMap<Integer,String> map=new HashMap<>();
        map=poker.convertToMap(map);

        //洗牌, 方法返回底牌,玩家1,2,3的索引序号

        poker.shuffleCards(indexList);

        //graphs是Poker的内部类的实例化对象
        Poker.PlayersGraph graphs=poker.new PlayersGraph(4);

        // 定义玩家的昵称
        String[] playersButtomName={"底牌","玩家1","玩家2","玩家3"};

        //发牌
        graphs.playerGetCards(indexList);

        //排序
        graphs.sortPlayerCards();

        //展示玩家手中的牌
        graphs.showPlayersCards(playersButtomName,map);


        //看了牌之后决定谁是地主(抢地主)
        System.out.println("抢地主, 请输入地主玩家序号(1,2,3):");
        Scanner in=new Scanner(System.in);
        int landBoss=in.nextInt();
        while (!(landBoss<=3&&landBoss>0)){
            System.out.println("序号输入错误, 请重新输入: ");
            landBoss=in.nextInt();
        }
        System.out.println("OK, 地主是玩家"+landBoss+"号!");

        //定义地主,农民1,农民2的对象
        //向下转型(必须先向上转型,然后再向下转型)
        Player player=new LandLord("地主");
        LandLord landLord=(LandLord)player;

        Player player1=new Farmer("农民1");
        Farmer farmer1=(Farmer) player1;
        Player player2=new Farmer("农民2");
        Farmer farmer2=(Farmer) player2;

        //打牌阶段
        //将内部类的对象graphs传入, 从而将底牌给地主, 并且重新对地主的牌排序
        landLord.collect(graphs,landBoss);

        //玩家身份确定后,再次展示各个玩家手中的牌
        System.out.println("确定地主后,各玩家的牌如下:");
        showCards(graphs,map,landBoss);
        System.out.println("注意: 输入的序号一定要是自己的序号!");
        //地主先出牌
        System.out.println("请输入地主要出的牌的序号(以逗号分隔开):");

        String play_Index=in.next();
        landLord.play(landBoss,play_Index,graphs,map);
        //展示
        showCards(graphs,map,landBoss);




    }

    /**
     * 展示3个玩家手中的牌
     * @param graphs
     * @param map
     */
    public static void showCards(Poker.PlayersGraph graphs,HashMap<Integer,String> map,int landBoss){
        int playersNum=3;
        //地主序号1
        String[]name={"地主","农民1","农民2"};

        //地主序号2
        if(landBoss==2){
            name[0]="农民1";
            name[1]="地主";
        }

        //地主序号3
        if(landBoss==3){
            name[0]="农民1";
            name[1]="农民2";
            name[2]="地主";
        }
        System.out.println("地主,农民1,农民2的牌分别为:");
        for(int i=1;i<=playersNum;i++){
            System.out.println(name[i-1]+": ");
            for(Integer key:graphs.graphs.get(i)){
                String value=map.get(key);
                System.out.print(value+" ");
            }
            System.out.println();
        }


                ;
    }
}
