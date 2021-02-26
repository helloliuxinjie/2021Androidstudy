package CSA_work2;

/**
 * @author Liuxinjie
 * @version 1.0
 * @date 2021/2/20 020 11:24
 * @software IDEA
 */

class A{
    private int life;
    private int aggress;
    private int recovery;
    public A(int life, int aggress, int recovery) {
        super();
        this.life = life;
        this.aggress = aggress;
        this.recovery = recovery;
    }
    public int getLife() {
        return life;
    }
    public void setLife(int life) {
        this.life = life;
    }
    public int getAggress() {
        return aggress;
    }
    public void setAggress(int aggress) {
        this.aggress = aggress;
    }
    public int getRecovery() {
        return recovery;
    }
    public void setRecovery(int recovery) {
        this.recovery = recovery;
    }
}
class B{
    private int life;//生命
    private int aggress;//攻击
    private int recovery;//防御
    public B(int life, int aggress, int recovery) {
        super();
        this.life = life;
        this.aggress = aggress;
        this.recovery = recovery;
    }
    public int getLife() {
        return life;
    }
    public void setLife(int life) {
        this.life = life;
    }
    public int getAggress() {
        return aggress;
    }
    public void setAggress(int aggress) {
        this.aggress = aggress;
    }
    public int getRecovery() {
        return recovery;
    }
    public void setRecovery(int recovery) {
        this.recovery = recovery;
    }
}
public class test {
    public static void main(String[] args) {
        A a=new A(100,20,10);
        B b=new B(100,30,5);
//都有生命开始攻击
        while(a.getLife()>0&&b.getLife()>0){
            System.out.println("a攻击");
//如果a的攻击小于b的防御生命不变，否则修改
            if(a.getAggress()<=b.getRecovery()){
                b.setLife(b.getLife());
            }else{
                b.setLife(b.getLife()-(a.getAggress()-b.getRecovery()));
            }
            if(b.getLife()<=0){
//b死亡终止，输出a的生命
                System.out.println("b死亡");
                System.out.println("a的生命"+a.getLife());
                break;
            }
//ab剩下的生命
            System.out.println("a的生命"+a.getLife());
            System.out.println("b的生命"+b.getLife());
            System.out.println("-------------");
            System.out.println("b攻击");
//b破不了防
            if(b.getAggress()<=a.getRecovery()){
                a.setLife(a.getLife());
            }else{
                a.setLife(a.getLife()-(b.getAggress()-a.getRecovery()));
            }
            if(a.getLife()<=0){
                System.out.println("a死亡");
                System.out.println("b的生命"+b.getLife());
                break;
            }
            System.out.println("a的生命"+a.getLife());
            System.out.println("b的生命"+b.getLife());
        }
    }
}