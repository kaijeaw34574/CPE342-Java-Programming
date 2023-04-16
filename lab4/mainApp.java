/* mainApp.java
 *	
 *	The program runs stack and queue through the myUtil package.
 * 
 * Creted by Pornthep Sangthongkhamsuk ID: 63070503431
 */
import java.util.Random;
import myUtil.*;

public class mainApp {

	public static void main(String[] args) {
		Stack st = new Stack(10);
		Queue qe = new Queue(10);
		Random rand = new Random();
		int a, b, i, j = 0;
		
		System.out.println("=== Stack ===");
		for(i = 0; i <= 10; i++) {
			a =  rand.nextInt(10);
			st.push(a);
			System.out.println("Push from the stack: " + a); 
		}
		for(i = 0; i <= 10; i++) {
			System.out.println("Pop from the stack: " + st.pop()); 
		}
		
		System.out.println("=== Queue ===");
		for(j = 0; j <= 10; j++) {
			b = rand.nextInt(10);
			qe.add(b);
			System.out.println("Add from the queue: " + b); 
		}
		for(j = 0; j <= 10; j++) {
			System.out.println("Delete from the queue: " + qe.delete()); 
		}
	}
}