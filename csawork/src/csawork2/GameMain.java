package csawork2;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Liuxinjie
 * @version 1.0
 * @date 2021/2/26 021 16:15
 * @software IDEA
 *
 *  Notice: 第二次修改
 *  1.怪物和主角都继承一个类,降低耦合度
 *  2.变量命名规范,Java独有的驼峰命名法(项目名全部小写,包名全部小写,类名单词首字母大写,变量名方法名首字母小写,常量名全部大写)
 *  3.代码重复度(随机选择一个怪物攻击部分if else
 *
 */
public class GameMain extends JFrame {


    /**
     * 用来存放角色战斗结束时血量,依次为主角和4个怪物
     * 静态数组
     */
    public static int[] blood=new int[5];

    /**
     * 用来存放角色初始血量,依次为主角和4个怪物
     * 静态数组
     */
    public static int[] originBlood=new int[5];

    /**
     * 用来存放角色的名称,依次为主角和4个怪物
     * 静态数组
     */
    public static String[]name=new String[5];

    /**
     * 初始化血条界面展示窗口
     */
    public void init(){
        this.setTitle("The rest of blood");
        this.setSize(300,200);
        this.setLocation(300,300);

        //点叉后结束进程
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //显示窗口
        this.setVisible(true);
    }

    /**
     * 血条图形表示
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.RED);
        //角色数量
        int roleNum=5;
        //满血为100
        double fullBlood=100.0;
        //y轴增量
        int yPlus=0;
        for(int i=0;i<roleNum;i++){
            g.drawString(name[i],70,100+yPlus);
            g.drawRect(140,88+yPlus,100,10);
            g.fillRect(140,88+yPlus, (int)(fullBlood*blood[i]/originBlood[i]),9);
            yPlus+=15;
        }
    }

    public static void main(String[] args) {
        // ###主角###
        Scanner in =new Scanner(System.in);
        System.out.println("请输入主角名称(Tips:迪迦)：");
        //主角名称
        String lead=in.nextLine();

        System.out.println("请输入主角生命值：");
        //主角的初始生命值
        int leadLife=in.nextInt();

        System.out.println("请输入主角攻击力：");
        //主角的攻击力（可自己配置装备）
        int leadAttack=in.nextInt();

        System.out.println("请输入主角防御力：");
        //主角的防御力越大，收到的伤害越低（可自己配置装备）
        int leadDefensive=in.nextInt();




        // ###怪物###
        System.out.println("请输入怪物Boss的名称(Tips:加坦杰厄)：");
        //怪物Boss名称
        String monster1=in.next();

        System.out.println("请输入怪物Boss生命值：");
        //怪物的初始生命值
        int monsterLife=in.nextInt();

        System.out.println("请输入怪物Boss攻击力：");
        //怪物的攻击力（可自己配置装备）
        int monsterAttack=in.nextInt();



        // 对象:一个主角
        GameLead gameLead = new GameLead(lead, leadLife, leadAttack, leadDefensive,true);

        //对象: 一个怪物Boss,三个工具人  创建arraylist集合
        ArrayList<GameMonster> list=new ArrayList<>();
        //Boss
        GameMonster gameMonster1 = new GameMonster(monster1, monsterLife, monsterAttack,0,true);
        GameMonster gameMonster2 = new GameMonster("哥尔赞", 200, 50,0,true);
        GameMonster gameMonster3 = new GameMonster("宿那鬼", 235, 60,0,true);
        GameMonster gameMonster4 = new GameMonster("基里艾洛德人", 250, 55,0,true);

        list.add(gameMonster1);
        list.add(gameMonster2);
        list.add(gameMonster3);
        list.add(gameMonster4);



        // 展示主角和怪物的初始属性
        show(list,lead,leadLife,leadAttack,leadDefensive);
        //战斗阶段
        /**
         * 战斗为回合制，回合数自己定义。
         * 主角先攻击，然后怪物攻击，然后主角攻击，然后怪物攻击。（攻击是交替进行的，先主角，在怪
         * 物）
         * 如果你有更好的攻击模式，可以自行设计，到时候在代码里面进行注释说明
         */
        System.out.println("请输入battle总回合数:");
        int battle=in.nextInt();
        //设置初始回合为1
        int round=1;
        boolean flag=true;
        // 当某一方的血量为0(Boss为0或者主角为0)时或者达到总回合数退出
        while (flag&&(round<=battle)){
            System.out.println("=============第"+round+"回合=============");
            /**
             * 主角攻击怪物的策略:随机random攻击一个怪物（给每个怪物编一个序号）
             * 设置一个attack_order, 攻击次数对Boss有所偏重, 比例为4:2:2:2
             */
            flag= leadAttackOrder(gameLead,list);
            round++;
        }

        // 战斗结束
        System.out.println("The battle is over!!!");
        //主角血量
        System.out.println(gameLead.getPerson()+"血量为:"+gameLead.getPersonLife());
        //怪物个数
        int monsterNum=4;

        blood[0]=gameLead.getPersonLife();
        for(int i=0;i<monsterNum;i++) {
            //怪物血量
            System.out.println(list.get(i).getPerson() + "血量为:" + list.get(i).getPersonLife());
            //将血量存放在blood数组中
            blood[i+1]=list.get(i).getPersonLife();
        }

        //图形化界面
        //创建窗口对象
        GameMain gameMain=new GameMain();
        //调用窗口对象的init(), 将其显示出来
        gameMain.init();



    }

    /**
     * 根据随机数在那个范围来决定主角攻击哪一个怪物
     * @param attackOrder
     * @return
     */
    private static int judgeMonster(int attackOrder){
        int monsterNum;
        if(attackOrder>=0&&attackOrder<=3){monsterNum=0;}
        else if(attackOrder==4||attackOrder==5){monsterNum=1;}
        else if(attackOrder==6||attackOrder==7){monsterNum=2;}
        else {monsterNum=3;}
        return monsterNum;
    }


    /**  考虑将主角攻击怪物的过程方法以及怪物反击进行封装
     *
     * @param gameLead
     * @param list
     * @return
     */
    private static boolean leadAttackOrder(GameLead gameLead, ArrayList<GameMonster> list){
        // 取值为0~9的十个整数
        int attackOrder=(int)(Math.random()*10);
        //获得怪物编号
        int monsterNum= judgeMonster(attackOrder);
        // 如果怪物的生命值为0, 主角就在随机选择一个怪物进行攻击,  防止对无生命值的怪物一直进行攻击
        while (monsterNum<4&&!list.get(monsterNum).getLifeFlag()){
            attackOrder=(int)(Math.random()*10);
            monsterNum=judgeMonster(attackOrder);

        }
        return attackMonsterLead(attackOrder,gameLead,list);
    }


    /** 展示主角和怪物的初始属性
     *
     * @param list
     * @param lead
     * @param leadLife
     * @param leadAttack
     * @param leadDefensive
     */
    private static void show(ArrayList<GameMonster> list, String lead, int leadLife, int leadAttack, int leadDefensive){
        System.out.println("主角和怪物的初始属性如下:");
        System.out.println("名称    生命值    攻击力    防御力");
        System.out.println(lead+"       "+leadLife+"       "+leadAttack+"       "+leadDefensive);
        System.out.println(list.get(0).getPerson()+"       "+list.get(0).getPersonLife()+"       "+list.get(0).getPersonAttack()+"       "+0);
        System.out.println(list.get(1).getPerson()+"       "+list.get(1).getPersonLife()+"       "+list.get(1).getPersonAttack()+"       "+0);
        System.out.println(list.get(2).getPerson()+"       "+list.get(2).getPersonLife()+"       "+list.get(2).getPersonAttack()+"       "+0);
        System.out.println(list.get(3).getPerson()+"       "+list.get(3).getPersonLife()+"       "+list.get(3).getPersonAttack()+"       "+0);
        //将角色原始血量存入数组中
        originBlood[0]=leadLife;
        name[0]=lead;
        int roleNum=5;
        for(int i=0;i<roleNum;i++){
            if(i+1<5) {
                originBlood[i + 1] = list.get(i).getPersonLife();
                name[i+1]=list.get(i).getPerson();
            }
        }
    }


    /**
     *
     * @param attackOrder
     * @param gameLead
     * @param list
     * @return
     */
    private static boolean attackMonsterLead(int attackOrder,GameLead gameLead, ArrayList<GameMonster> list){
        int monsterNum=judgeMonster(attackOrder);

        // 第一个元素伤害,第二个元素生命值
        int []injuryLife;
        int bossLife;// 怪物老大的血量
        int []injuryLife2;
        int leadLife;

        injuryLife = gameLead.attackMonster(list.get(monsterNum));
        System.out.println(gameLead.getPerson()+"对"+list.get(monsterNum).getPerson()+"造成"+injuryLife[0]+"点伤害, "+list.get(monsterNum).getPerson()+"生命值为:"+injuryLife[1]);
        // 主角攻击老大时(monster=0), 返回怪物老大的血量否则怪物boss血量为1
        bossLife=monsterNum==0?injuryLife[1]:1;

        //怪物反击
        if(list.get(monsterNum).getPersonLife()!=0) {
            injuryLife2 = list.get(monsterNum).attackLead(gameLead);
            System.out.println(list.get(monsterNum).getPerson() + "对" + gameLead.getPerson() + "造成" + injuryLife2[0] + "点伤害, " + gameLead.getPerson() + "生命值为:" + injuryLife2[1]);
            leadLife=injuryLife2[1];
        }else {
            System.out.println(list.get(monsterNum).getPerson() + "生命值为:0, 无法做出反击!  " + gameLead.getPerson() + "生命值为:" + gameLead.getPersonLife());
            leadLife = gameLead.getPersonLife();
        }
        boolean flag=(bossLife!=0&&leadLife!=0);
        return flag;

    }

}
