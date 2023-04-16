/* Queue.java
 * Created by 63070503431 Pornthep Sangthongkhamsuk
 */

public class Queue extends MyBuffer {
    int head = 0;
    int tail = -1;
    int count = 0;
    
    Queue() {
        this(10);
    }

    Queue(int x) {
        super(x);
        count = 0;
    }

    public void add(int x) {
        if (count == items.length) {
            System.out.println("Queue is full");  
            return;
        }
        if (tail == items.length - 1) 
            tail = -1;  
        items[++tail] = x;  
        count++;  
     }

    public int delete() {
        if (count == 0) 
            System.out.println("Queue is empty");
        int temp = items[head++];  
        if (head == items.length)   
            head = 0;    
        count--;  
        return temp;  
    }
}
