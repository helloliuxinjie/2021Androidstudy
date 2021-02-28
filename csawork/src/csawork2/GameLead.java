package csawork2;


/**
 * @author Liuxinjie
 * @version 1.0
 * @date 2021/2/26 021 16:17
 * @software IDEA
 */
class GameLead extends GamePerson{
    /**
     * 主角
     */
    private String lead;

    /**
     * 主角的初始生命值
     */
    private int leadLife ;

    /**
     * 主角的攻击力（可自己配置装备）
     */
    private int leadAttack ;

    /**
     *主角的防御力越大，收到的伤害越低（可自己配置装备）
     */
    private int leadDefensive ;


    /**
     * set()和get()
     * @return
     */
    public String getLead(){
        return lead;
    }
    public int getLeadLife(){
        return leadLife;
    }
    public void setLeadLife(int leadLife){
        this.leadLife =leadLife;
    }
    public int getLeadAttack(){
        return leadAttack;
    }
    public int getLeadDefensive(){
        return leadDefensive;
    }


    /**
     * 构造器
     * @param lead
     * @param leadLife
     * @param leadAttack
     * @param leadDefensive
     */
    public GameLead(String lead, int leadLife, int leadAttack, int leadDefensive){
        this.lead=lead;
        this.leadAttack = leadAttack;
        this.leadDefensive = leadDefensive;
        this.leadLife = leadLife;
    }


    /**
     * 攻击Game_Monster monster
     * @param monster
     * @return
     */
    public int[] attack(GameMonster monster){
        // 伤害最低为1且不能为负数, 伤害采用随机的方式, 对敌人的伤害=自己的攻击力-敌人的防御力
        // 攻击力和防御力在设定值的基础上做-20%~20%的减少或者增加, 这里是随机的
        //Math.random()*(n-m)+m 范围m到n的随机数
        int injury=(int)((1+(Math.random()*0.4-0.2))* getLeadAttack());
        while(injury<1) {
            injury = (int) ((1 + (Math.random() * 0.4 - 0.2)) * getLeadAttack());
        }
        //lead的血量=lead的生命值-this.injury
        int monsterBlood=monster.getMonsterLife()-injury;

        //将lead的血量返回, 同时考虑血量为负数的时候, 将其设置为0
        monster.setMonsterLife(monsterBlood>0?monsterBlood:0);
        monster.setLifeFlag(monsterBlood>0?true:false);
        int[] temp=new int[2];
        temp[0]=injury;
        temp[1]=monster.getMonsterLife();
        return temp;

    }

}
