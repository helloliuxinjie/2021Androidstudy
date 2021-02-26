package CSA_work2;

/**
 * @author Liuxinjie
 * @version 1.0
 * @date 2021/2/26 021 16:29
 * @software IDEA
 */
public class Game_Monster {
    //怪物
    private String monster; //主角名称
    private int monster_life;//主角的初始生命值
    private int monster_attack;//主角的攻击力（可自己配置装备）
    private boolean life_flag=true;// 标签怪物血量是否为0

    //set()和get()
    public String getMonster(){
        return monster;
    }
//    public void setMonster(String monster){
//        this.monster=monster;
//    }

    public boolean getLife_flag() {
        return life_flag;
    }

    public void setLife_flag(boolean life_flag) {
        this.life_flag = life_flag;
    }

    public int getMonster_life(){
        return monster_life;
    }
    public void setMonster_life(int monster_life){
        this.monster_life=monster_life;
    }
    public int getMonster_attack(){
        return monster_attack;
    }
//    public void setMonster_attack(int monster_attack){
//        this.monster_attack=monster_attack;
//    }


    //构造器
    public Game_Monster(String monster,int monster_life,int monster_attack){
        this.monster=monster;
        this.monster_attack=monster_attack;
        this.monster_life=monster_life;

    }


    // 攻击
    public int[] Attack(Game_Lead lead){
        // 伤害最低为1且不能为负数, 伤害采用随机的方式, 对敌人的伤害=自己的攻击力-敌人的防御力
        // 攻击力和防御力在设定值的基础上做-20%~20%的减少或者增加, 这里是随机的
        //Math.random()*(n-m)+m 范围m到n的随机数
        int injury=(int)((1+(Math.random()*0.4-0.2))*getMonster_attack()-lead.getLead_defensive()*(Math.random()*0.4-0.2));
        while(injury<1)
            injury=(int)((1+(Math.random()*0.4-0.2))*getMonster_attack()-lead.getLead_defensive()*(Math.random()*0.4-0.2));

        //lead的血量=lead的生命值-this.injury
        int lead_blood=lead.getLead_life()-injury;

        //将lead的血量返回, 同时考虑血量为负数的时候, 将其设置为0
        lead.setLead_life(lead_blood>0?lead_blood:0);
        int[] temp=new int[2];
        temp[0]=injury;
        temp[1]=lead.getLead_life();
        return temp;


    }


}
