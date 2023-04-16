/* MyApp.java
 * Created by 63070503431 Pornthep Sangthongkhamsuk
 */

public class MyApp {
    public static void main(String[] args) {
        Animal[] a = new Animal[9];
        a[0] = new Human("Human1" , 100);
        a[1] = new Human("Human2" , 100);
        a[2] = new Human("Human3" , 100);
        a[3] = new Dog("Dog1", 100);
        a[4] = new Dog("Dog2", 100);
        a[5] = new Dog("Dog3 ", 100);
        a[6] = new Cat("Cat1", 100);
        a[7] = new Cat("Cat2", 100);
        a[8] = new Cat("Cat3", 100);
        for (int i = 0; i < a.length; i++) {
            a[i].talk();
        }
    }
}
