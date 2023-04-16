/* Animal.java
 * Created by 63070503431 Pornthep Sangthongkhamsuk
 */

public abstract class Animal {
    int life;
    public Animal() {
        this(100);
    }
    public Animal(int life) {
        this.life = life;
    }
    abstract void talk();
}
