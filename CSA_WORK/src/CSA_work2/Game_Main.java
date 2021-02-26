package CSA_work2;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Liuxinjie
 * @version 1.0
 * @date 2021/2/26 021 16:15
 * @software IDEA
 */
public class Game_Main extends JFrame {
    public static void main(String[] args) {
        // ###主角###
        Scanner in =new Scanner(System.in);
        System.out.println("请输入主角名称(Tips:迪迦)：");
        String lead=in.nextLine();//主角名称
        System.out.println("请输入主角生命值：");
        int lead_life=in.nextInt();//主角的初始生命值
        System.out.println("请输入主角攻击力：");
        int lead_attack=in.nextInt();//主角的攻击力（可自己配置装备）
        System.out.println("请输入主角防御力：");
        int lead_defensive=in.nextInt();//主角的防御力越大，收到的伤害越低（可自己配置装备）


        // ###怪物###
        System.out.println("请输入怪物Boss的名称(Tips:加坦杰厄)：");
        String monster1=in.next();//怪物Boss名称
        System.out.println("请输入怪物Boss生命值：");
        int monster_life=in.nextInt();//怪物的初始生命值
        System.out.println("请输入怪物Boss攻击力：");
        int monster_attack=in.nextInt();//怪物的攻击力（可自己配置装备）


        // 对象:一个主角
        Game_Lead game_lead = new Game_Lead(lead, lead_life, lead_attack, lead_defensive);

        //对象: 一个怪物Boss,三个工具人  创建arraylist集合
        ArrayList<Game_Monster> list=new ArrayList<>();
        Game_Monster game_monster1 = new Game_Monster(monster1, monster_life, monster_attack);//Boss
        Game_Monster game_monster2 = new Game_Monster("哥尔赞", 100, 23);
        Game_Monster game_monster3 = new Game_Monster("宿那鬼", 135, 18);
        Game_Monster game_monster4 = new Game_Monster("基里艾洛德人", 150, 20);

        list.add(game_monster1);
        list.add(game_monster2);
        list.add(game_monster3);
        list.add(game_monster4);

//        Game_Monster game_monster = new Game_Monster(monster, monster_life, monster_attack);

        // 展示主角和怪物的初始属性
        show(list,lead,lead_life,lead_attack,lead_defensive);
        //战斗阶段
        /**
         * 战斗为回合制，回合数自己定义。
         * 主角先攻击，然后怪物攻击，然后主角攻击，然后怪物攻击。（攻击是交替进行的，先主角，在怪
         * 物）
         * 如果你有更好的攻击模式，可以自行设计，到时候在代码里面进行注释说明
         */
        System.out.println("请输入battle总回合数:");
        int battle=in.nextInt();
        int round=1;//设置初始回合为1
        boolean flag=true;
        while (flag&&(round<=battle)){// 当某一方的血量为0(Boss为0或者主角为0)时或者达到总回合数退出
            System.out.println("=============第"+round+"回合=============");

            //主角先攻击
            /**
             * 主角攻击怪物的策略:随机random攻击一个怪物（给每个怪物编一个序号）
             * 设置一个attack_order, 攻击次数对Boss有所偏重, 比例为4:2:2:2
             */
//            int injury_Life[]={0,0};
//            int boss_life=LeadAttackOrder(game_lead,list);
//            System.out.println(game_lead.getLead()+"对"+list.get(0).getMonster()+"造成"+injury_Life[0]+"点伤害, "+list.get(0).getMonster()+"生命值为:"+injury_Life[1]);

            //怪物后攻击, 怪物中随机random一个怪物对奥特曼攻击
//            int injury_Life2[]=list.get(0).Attack(game_lead);
//            System.out.println(list.get(0).getMonster()+"对"+game_lead.getLead()+"造成"+injury_Life2[0]+"点伤害, "+game_lead.getLead()+"生命值为:"+injury_Life2[1]);
            //当主角的血量不为0并且怪物的老大血量不为0, flag=ture
            flag=LeadAttackOrder(game_lead,list);
            round++;

        }

        // 战斗结束
        System.out.println("The battle is over!!!");
        System.out.println(game_lead.getLead()+"血量为:"+game_lead.getLead_life());//主角血量

        for(int i=0;i<4;i++) {
            System.out.println(list.get(i).getMonster() + "血量为:" + list.get(i).getMonster_life());//怪物血量
        }

        //图形化界面暂无
//        public static int lead_blood= game_lead.getLead_life();



    }

    private static int judge_monster(int attack_order){
        int monster_num;
        if(attack_order>=0&&attack_order<=3)monster_num=0;
        else if(attack_order==4||attack_order==5)monster_num=1;
        else if(attack_order==6||attack_order==7)monster_num=2;
        else monster_num=3;
        return monster_num;
    }
    //  考虑将主角攻击怪物的过程方法以及怪物反击进行封装
    private static boolean LeadAttackOrder(Game_Lead game_lead,ArrayList<Game_Monster> list){
        int attack_order=(int)(Math.random()*10);// 取值为0~9的十个整数
        int monster_num=judge_monster(attack_order);
        while (!list.get(monster_num).getLife_flag()){// 如果怪物的生命值为0, 主角就在随机选择一个怪物进行攻击,  防止对无生命值的怪物一直进行攻击
            attack_order=(int)(Math.random()*10);
            monster_num=(attack_order);

        }
        int injury_Life[];// 第一个元素伤害,第二个元素生命值
        int boss_life=1;// 怪物老大的血量
        int injury_Life2[];//
        int lead_life=1;

        if (attack_order>=0&&attack_order<=3){//主角攻击怪物老大,当attack取0,1,2,3
            injury_Life = game_lead.Attack(list.get(0));
            System.out.println(game_lead.getLead()+"对"+list.get(0).getMonster()+"造成"+injury_Life[0]+"点伤害, "+list.get(0).getMonster()+"生命值为:"+injury_Life[1]);
            boss_life=injury_Life[1];

            //怪物反击
            if(list.get(0).getMonster_life()!=0) {
                injury_Life2 = list.get(0).Attack(game_lead);
                System.out.println(list.get(0).getMonster() + "对" + game_lead.getLead() + "造成" + injury_Life2[0] + "点伤害, " + game_lead.getLead() + "生命值为:" + injury_Life2[1]);
                lead_life=injury_Life2[1];
            }else {
                System.out.println(list.get(0).getMonster() + "生命值为:0, 无法做出反击!  " + game_lead.getLead() + "生命值为:" + game_lead.getLead_life());
                lead_life=game_lead.getLead_life();
            }
        }else if(attack_order==4||attack_order==5){//主角攻击怪物工具人1号,当attack取4,5
            injury_Life = game_lead.Attack(list.get(1));
            System.out.println(game_lead.getLead()+"对"+list.get(1).getMonster()+"造成"+injury_Life[0]+"点伤害, "+list.get(1).getMonster()+"生命值为:"+injury_Life[1]);

            //怪物反击
            if(list.get(1).getMonster_life()!=0) {
                injury_Life2 = list.get(1).Attack(game_lead);
                System.out.println(list.get(1).getMonster() + "对" + game_lead.getLead() + "造成" + injury_Life2[0] + "点伤害, " + game_lead.getLead() + "生命值为:" + injury_Life2[1]);
                lead_life=injury_Life2[1];
            }else{
                System.out.println(list.get(1).getMonster()+"生命值为:0, 无法做出反击!  "+ game_lead.getLead() + "生命值为:" + game_lead.getLead_life());
                lead_life=game_lead.getLead_life();
            }

        }else if(attack_order==6||attack_order==7) {//主角攻击怪物工具人2号,当attack取6,7
            injury_Life = game_lead.Attack(list.get(2));
            System.out.println(game_lead.getLead()+"对"+list.get(2).getMonster()+"造成"+injury_Life[0]+"点伤害, "+list.get(2).getMonster()+"生命值为:"+injury_Life[1]);

            //怪物反击
            if(list.get(2).getMonster_life()!=0) {
                injury_Life2 = list.get(2).Attack(game_lead);
                System.out.println(list.get(2).getMonster() + "对" + game_lead.getLead() + "造成" + injury_Life2[0] + "点伤害, " + game_lead.getLead() + "生命值为:" + injury_Life2[1]);
                lead_life=injury_Life2[1];
            }else {
                System.out.println(list.get(2).getMonster() + "生命值为:0, 无法做出反击!  " + game_lead.getLead() + "生命值为:" + game_lead.getLead_life());
                lead_life=game_lead.getLead_life();
            }
        }else {//主角攻击怪物工具人3号,当attack取8,9
            injury_Life = game_lead.Attack(list.get(3));
            System.out.println(game_lead.getLead()+"对"+list.get(3).getMonster()+"造成"+injury_Life[0]+"点伤害, "+list.get(3).getMonster()+"生命值为:"+injury_Life[1]);

            //怪物反击
            if(list.get(3).getMonster_life()!=0) {
                injury_Life2 = list.get(3).Attack(game_lead);
                System.out.println(list.get(3).getMonster() + "对" + game_lead.getLead() + "造成" + injury_Life2[0] + "点伤害, " + game_lead.getLead() + "生命值为:" + injury_Life2[1]);
                lead_life=injury_Life2[1];
            }else {
                System.out.println(list.get(3).getMonster() + "生命值为:0, 无法做出反击!  " + game_lead.getLead() + "生命值为:" + game_lead.getLead_life());
                lead_life = game_lead.getLead_life();
            }
        }
        boolean flag=(boss_life!=0&&lead_life!=0);
        return flag;
    }
    // 展示主角和怪物的初始属性
    private static void show(ArrayList<Game_Monster> list,String lead, int lead_life,int lead_attack,int lead_defensive){
        System.out.println("主角和怪物的初始属性如下:");
        System.out.println("名称    生命值    攻击力    防御力");
        System.out.println(lead+"       "+lead_life+"       "+lead_attack+"       "+lead_defensive);
        System.out.println(list.get(0).getMonster()+"       "+list.get(0).getMonster_life()+"       "+list.get(0).getMonster_attack()+"       "+0);
        System.out.println(list.get(1).getMonster()+"       "+list.get(1).getMonster_life()+"       "+list.get(1).getMonster_attack()+"       "+0);
        System.out.println(list.get(2).getMonster()+"       "+list.get(2).getMonster_life()+"       "+list.get(2).getMonster_attack()+"       "+0);
        System.out.println(list.get(3).getMonster()+"       "+list.get(3).getMonster_life()+"       "+list.get(3).getMonster_attack()+"       "+0);

    }

}
