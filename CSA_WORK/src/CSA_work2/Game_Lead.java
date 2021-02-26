package CSA_work2;


/**
 * @author Liuxinjie
 * @version 1.0
 * @date 2021/2/26 021 16:17
 * @software IDEA
 */
class Game_Lead {
    // 主角
    private String lead=null; //主角名称
    private int lead_life=0;//主角的初始生命值
    private int lead_attack=0;//主角的攻击力（可自己配置装备）
    private int lead_defensive=0;//主角的防御力越大，收到的伤害越低（可自己配置装备）



    //set()和get()
    public String getLead(){
        return lead;
    }
    public void setLead(String lead){
        this.lead=lead;
    }
    public int getLead_life(){
        return lead_life;
    }
    public void setLead_life(int lead_life){
        this.lead_life=lead_life;
    }
    public int getLead_attack(){
        return lead_attack;
    }
    public void setLead_attack(int lead_attack){
        this.lead_attack=lead_attack;
    }
    public int getLead_defensive(){
        return lead_defensive;
    }
    public void setLead_defensive(int lead_defensive){
        this.lead_defensive=lead_defensive;
    }



    //构造器
    public Game_Lead(String lead,int lead_life,int lead_attack,int lead_defensive){
        this.lead=lead;
        this.lead_attack=lead_attack;
        this.lead_defensive=lead_defensive;
        this.lead_life=lead_life;
    }




    //攻击Game_Monster monster
    public int[] Attack(Game_Monster monster){
        // 伤害最低为1且不能为负数, 伤害采用随机的方式, 对敌人的伤害=自己的攻击力-敌人的防御力
        // 攻击力和防御力在设定值的基础上做-20%~20%的减少或者增加, 这里是随机的
        //Math.random()*(n-m)+m 范围m到n的随机数
        int injury=(int)((1+(Math.random()*0.4-0.2))*getLead_attack());
        while(injury<1)
            injury=(int)((1+(Math.random()*0.4-0.2))*getLead_attack());

        //lead的血量=lead的生命值-this.injury
        int monster_blood=monster.getMonster_life()-injury;

        //将lead的血量返回, 同时考虑血量为负数的时候, 将其设置为0
        monster.setMonster_life(monster_blood>0?monster_blood:0);
        monster.setLife_flag(monster_blood>0?true:false);
        int[] temp=new int[2];
        temp[0]=injury;
        temp[1]=monster.getMonster_life();
        return temp;

    }

}
