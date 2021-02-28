package csawork2;

/**
 * @author Liuxinjie
 * @version 1.0
 * @date 2021/2/27 027 23:57
 * @software IDEA
 */
public class GamePerson {
    /**
     * 角色
     */
    private String person;

    /**
     * 角色的初始生命值
     */
    private int personLife;

    /**
     * 角色的攻击力（可自己配置装备）
     */
    private int personAttack;

    /**
     *角色的防御力越大，收到的伤害越低（可自己配置装备）
     */
    private int personDefensive;

    /**
     *标签怪物血量是否为0
     */
    private boolean lifeFlag ;


    /**
     * set()和get()
     * @return
     */
    public String getPerson(){
        return person;
    }
    public int getPersonLife(){
        return personLife;
    }
    public void setPersonLife(int personLife){
        this.personLife = personLife;
    }
    public int getPersonAttack(){
        return personAttack;
    }
    public int getPersonDefensive(){
        return personDefensive;
    }
    public boolean getLifeFlag() {
        return lifeFlag;
    }
    public void setLifeFlag(boolean lifeFlag) {
        this.lifeFlag = lifeFlag;
    }


    /**
     * 构造器
     * @param person
     * @param personLife
     * @param personAttack
     * @param personDefensive
     */
    public GamePerson(String person, int personLife, int personAttack, int personDefensive){
        this.person = person;
        this.personAttack = personAttack;
        this.personDefensive = personDefensive;
        this.personLife = personLife;
    }


    /**
     * 攻击Game_Monster enemy
     * @param enemy
     * @return
     */
    public int[] attack(GamePerson enemy){
        // 伤害最低为1且不能为负数, 伤害采用随机的方式, 对敌人的伤害=自己的攻击力-敌人的防御力
        // 攻击力和防御力在设定值的基础上做-20%~20%的减少或者增加, 这里是随机的
        //Math.random()*(n-m)+m 范围m到n的随机数
        int injury=(int)((1+(Math.random()*0.4-0.2))* getPersonAttack());
        while(injury<1) {
            injury = (int) ((1 + (Math.random() * 0.4 - 0.2)) * getPersonAttack());
        }
        //lead的血量=lead的生命值-this.injury
        int monsterBlood=enemy.getPersonLife()-injury;

        //将lead的血量返回, 同时考虑血量为负数的时候, 将其设置为0
        enemy.setPersonLife(monsterBlood>0?monsterBlood:0);
        enemy.setLifeFlag(monsterBlood>0?true:false);
        int[] temp=new int[2];
        temp[0]=injury;
        temp[1]=enemy.getPersonLife();
        return temp;

    }
}
