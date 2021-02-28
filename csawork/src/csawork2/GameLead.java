package csawork2;


/**
 * @author Liuxinjie
 * @version 1.0
 * @date 2021/2/26 021 16:17
 * @software IDEA
 */
class GameLead extends GamePerson{

    /**
     * 构造器
     * @param lead
     * @param leadLife
     * @param leadAttack
     * @param leadDefensive
     */

    public GameLead(String lead, int leadLife, int leadAttack, int leadDefensive,boolean lifeFlag){
        super(lead,leadLife,leadAttack,leadDefensive,lifeFlag);
    }


    /**
     * 攻击GameMonster monster
     * @param monster
     * @return
     */
    @Override
    public int[] attackMonster(GameMonster monster){
        // 伤害最低为1且不能为负数, 伤害采用随机的方式, 对敌人的伤害=自己的攻击力-敌人的防御力
        // 攻击力和防御力在设定值的基础上做-20%~20%的减少或者增加, 这里是随机的
        //Math.random()*(n-m)+m 范围m到n的随机数
        int injury=(int)((1+(Math.random()*0.4-0.2))* this.getPersonAttack());
        while(injury<1) {
            injury = (int) ((1 + (Math.random() * 0.4 - 0.2)) * getPersonAttack());
        }
        //lead的血量=lead的生命值-this.injury
        int monsterBlood=monster.getPersonLife()-injury;

        //将lead的血量返回, 同时考虑血量为负数的时候, 将其设置为0
        monster.setPersonLife(monsterBlood>0?monsterBlood:0);
        monster.setLifeFlag(monsterBlood>0);
        int[] temp=new int[2];
        temp[0]=injury;
        temp[1]=monster.getPersonLife();
        return temp;

    }

}
