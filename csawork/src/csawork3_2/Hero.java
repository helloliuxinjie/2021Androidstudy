package csawork3_2;

/**
 * @author Liuxinjie
 * @version 1.0
 * @date 2021/3/10 010 16:03
 * @software IDEA
 */
public class Hero {

    public String name="Mike";
    public boolean gender =false;
    private int age=Integer.MAX_VALUE;
    private double score=Double.MIN_VALUE;


    /**
     * 构造器
     */

    public Hero() {//无参构造
    }

    public Hero(String name, boolean gender) {
        this.name = name;
        this.gender = gender;
    }

    public Hero(int age, double score) {
        this.age = age;
        this.score = score;
    }

    public Hero(String name, boolean gender, int age, double score) {//包含所有参数的构造
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.score = score;
    }

    /**
     * set和get函数
     */
    public int getAge() {
        return age;
    }

    public double getScore() {
        return score;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Hero{name="+this.name+", gender="+this.gender+", age="+this.age+", score="+this.score+"}";
    }
}
