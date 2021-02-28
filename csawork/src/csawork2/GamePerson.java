package csawork2;

/**
 * @author Liuxinjie
 * @version 1.0
 * @date 2021/2/28 027 13:57
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
     *标签角色血量是否为0
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
    public GamePerson(String person, int personLife, int personAttack, int personDefensive,boolean lifeFlag){
        this.person = person;
        this.personAttack = personAttack;
        this.personDefensive = personDefensive;
        this.personLife = personLife;
        this.lifeFlag=lifeFlag;

    }


    /**攻击GamePerson enemy
     */
    public int[] attackLead(GameLead gameLead){
        return new int[2];
    }
    public int[] attackMonster(GameMonster gameMonster){
        return new int[2];
    }

}
