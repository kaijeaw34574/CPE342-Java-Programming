/* MyBuffer.java
 * Created by 63070503431 Pornthep Sangthongkhamsuk
 */

public abstract class MyBuffer {
    final int items[];

    public MyBuffer() {
        this(10);
    }

    public MyBuffer(int x) {
        items = new int[x];
    }

    void showBuffer() {
        System.out.println("{");
        for (int i = 0; i < items.length; i++) {
            System.out.printf("%d,", items[i]);
        }
        System.out.println();
    }

    double average() {
        double x = 0;
        for (int i = 0; i < items.length; i++) {
            x += items[i];
        }
        return (items.length > 0)?(x / items.length):0.0;
    }
}