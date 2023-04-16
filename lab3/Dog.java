/* Dog.java
 * Created by 63070503431 Pornthep Sangthongkhamsuk
 */

public class Dog extends Animal {
    String name;
    void talk() {
        bark();
    }
    void bark() {
        System.out.println("Bowwow");
    }
    public Dog() {
        super(); 
    }
    public Dog(int life) {
        super(life);
    }
    public Dog(String Name) {
        super();
        this.name = new String(Name);
    }
    public Dog(String Name, int life) {
        super(life);
        this.name = new String(Name);
    }
}