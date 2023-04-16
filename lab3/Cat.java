/* Cat.java
 * Created by 63070503431 Pornthep Sangthongkhamsuk
 */

public class Cat extends Animal {
    String name;
    void talk() {
        meow();
    }
    void meow() {
        System.out.println("Meow");
    }
    public Cat() {
        super(); 
    }
    public Cat(int life) {
        super(life);
    }
    public Cat(String Name) {
        super();
        this.name = new String(Name);
    }
    public Cat(String Name, int life) {
        super(life);
        this.name = new String(Name);
    }
}
