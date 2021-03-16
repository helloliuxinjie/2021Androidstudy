package csawork3;

/**
 * @author Liuxinjie
 * @version 1.0
 * @date 2021/3/3 003 19:04
 * @software IDEA
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * 扑克牌类,总共54张牌
 *
 */
class Poker {


    /**
     * 让每张扑克牌索引与牌面值一一对应的存入hashmap数据结构中
     * @param map
     * @return
     */
    public HashMap<Integer,String> convertToMap(HashMap<Integer,String> map){
        // 将大小王放入map
        map.put(0,"[0.大王]");
        map.put(1,"[1.小王]");
        int key=2;
        //每张牌的颜色:梅花,方块,红桃,黑桃
        String[]color={"黑桃","梅花","红桃","方块"};
        //每张牌的点数(大小王特殊处理)
        String[] value={"2","A","K","Q","J","10","9","8","7","6","5","4","3"};
        for(int i=0;i<value.length;i++){
            for(int j=0;j<color.length;j++){

                map.put(key,"["+key+"."+color[j]+"_"+value[i]+"]");
                key++;
            }
        }
        return map;

    }

    /**
     * 将每张扑克牌的索引放如Arraylist中
     * @param indexList
     * @return
     */
    public ArrayList<Integer> indexToList(ArrayList<Integer> indexList){
        int num=54;
        for(int i=0;i<num;i++){
            indexList.add(i);
        }
        return indexList;
    }

    /**
     * 洗牌,即将索引全部打乱index
     * @param indexList
     */
    public void shuffleCards(ArrayList<Integer> indexList){

         Collections.shuffle(indexList);
    }



    /**
     * 定义一个内部类用来存放玩家链表图
     */
    class PlayersGraph{
        //玩家链表图的实现
        /**
         * 0(底牌)---->接牌(索引) list
         * 1(player1)---->接牌(索引) list
         * 2(player2)---->接牌(索引) list
         * 3(player3)---->接牌(索引) list
         *
         */
        ArrayList<ArrayList<Integer>> graphs;

        /**
         * 顶点:0~v
         * 构造器
         */
        public PlayersGraph(int v){
            graphs=new ArrayList<>(v);
            for(int i=0;i<v;i++){
                //每个顶点后面都加一个ArrayList
                graphs.add(new ArrayList<>());
            }
        }

        /**
         * 内部类方法一: 发牌
         * 返回存储底牌,玩家1,2,3的牌的索引的数据结构graph
         * @param indexList
         */
        public void playerGetCards(ArrayList<Integer> indexList){

            //前三张牌作为底牌
            graphs.get(0).add(indexList.get(0));
            graphs.get(0).add(indexList.get(1));
            graphs.get(0).add(indexList.get(2));

            for(int i=3;i<indexList.size();i++){
                //玩家1,2,3所得到的牌的索引
                if(i%3==0){
                    graphs.get(1).add(indexList.get(i));
                }else if(i%3==1){
                    graphs.get(2).add(indexList.get(i));
                }else if(i%3==2){
                    graphs.get(3).add(indexList.get(i));
                }
            }
        }

        /**
         * 内部类方法二: 对玩家手中的牌进行排序
         *
         */
        public void sortPlayerCards(){

            Collections.sort(graphs.get(1));
            Collections.sort(graphs.get(2));
            Collections.sort(graphs.get(3));

        }

        /**
         * 内部类方法三: 展示各个玩家手中的牌
         * @param name
         * @param map
         */
        public void showPlayersCards(String[]name,HashMap<Integer,String> map){
            System.out.println("所有玩家的牌为:");
            int Num=3;
            for(int i=0;i<=Num;i++){
                System.out.println(name[i]+": ");
                for(Integer key:graphs.get(i)){
                    String value=map.get(key);
                    System.out.print(value+" ");
                }
                System.out.println();
            }
        }



    }






}