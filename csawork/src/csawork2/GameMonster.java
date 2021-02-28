package csawork2;

/**
 * @author Liuxinjie
 * @version 1.0
 * @date 2021/2/26 021 16:29
 * @software IDEA
 */
public class GameMonster extends GamePerson{
    //怪物
    /**
     * 主角名称
     */
    private String monster;
    /**
     *主角的初始生命值
     */
    private int monsterLife;
    /**
     * 主角的攻击力（可自己配置装备）
     */
    private int monsterAttack;
    /**
     *标签怪物血量是否为0
     */
    private boolean lifeFlag =true;

    /**
     * set()和get()
     * @return
     */
    public String getMonster(){
        return monster;
    }
    @Override
    public boolean getLifeFlag() {
        return lifeFlag;
    }
    @Override
    public void setLifeFlag(boolean lifeFlag) {
        this.lifeFlag = lifeFlag;
    }
    public int getMonsterLife(){
        return monsterLife;
    }
    public void setMonsterLife(int monsterLife){
        this.monsterLife = monsterLife;
    }
    public int getMonsterAttack(){
        return monsterAttack;
    }



    /**构造器
     *
     * @param monster
     * @param monsterLife
     * @param monsterAttack
     */
    public GameMonster(String monster, int monsterLife, int monsterAttack){
        this.monster=monster;
        this.monsterAttack = monsterAttack;
        this.monsterLife = monsterLife;

    }


    /** 攻击
     *
     * @param lead
     * @return
     */
    public int[] attack(GameLead lead){
        // 伤害最低为1且不能为负数, 伤害采用随机的方式, 对敌人的伤害=自己的攻击力-敌人的防御力
        // 攻击力和防御力在设定值的基础上做-20%~20%的减少或者增加, 这里是随机的
        //Math.random()*(n-m)+m 范围m到n的随机数
        int injury=(int)((1+(Math.random()*0.4-0.2))* getMonsterAttack()-lead.getLeadDefensive()*(Math.random()*0.4-0.2));
        while(injury<1) {
            injury = (int) ((1 + (Math.random() * 0.4 - 0.2)) * getMonsterAttack() - lead.getLeadDefensive() * (Math.random() * 0.4 - 0.2));
        }
        //lead的血量=lead的生命值-this.injury
        int leadBlood=lead.getLeadLife()-injury;

        //将lead的血量返回, 同时考虑血量为负数的时候, 将其设置为0
        lead.setLeadLife(leadBlood>0?leadBlood:0);
        int[] temp=new int[2];
        temp[0]=injury;
        temp[1]=lead.getLeadLife();
        return temp;


    }


}
