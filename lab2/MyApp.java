/* MyApp.java
 * Created by 63070503431 Pornthep Sangthongkhamsuk
 */

public class MyApp {
    public static void main(String args[]) {
        int i;
        Stack st;
        Queue q;
        st = new Stack(10);
        q = new Queue(10);
        System.out.println("=== Stack ===");
        for (i = 0; i <= 10; i++) {
            st.push(i);
        }
        for( i = 0; i <= 10; i++) {
            System.out.printf("%d\n", st.pop()); 
        }
        System.out.println("=== Queue ===");
        for (i = 0; i <= 10; i++) {
            q.add(i);
        }
        for (i = 0; i <= 10; i++) {
            System.out.printf("%d\n", q.delete()); 
        }
    }
}
