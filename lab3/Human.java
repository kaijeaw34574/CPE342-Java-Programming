/* Human.java
 * Created by 63070503431 Pornthep Sangthongkhamsuk
 */

public class Human extends Animal {
    String name;
    void talk() {
        hello();
    }
    void hello() {
        System.out.println("Hello");
    }
    public Human() {
        super(); 
    }
    public Human(int life) {
        super(life);
    }
    public Human(String Name) {
        super();
        this.name = new String(Name);
    }
    public Human(String Name, int life) {
        super(life);
        this.name = new String(Name);
    }
}
