/* queue.java
 *  The program shows a simple queue structure.
 *  Created by 63070503431 Pornthep Sangthongkhamsuk
 */

public class queue {  
  
    static int size = 10; 

    static int array[] = new int[size];  
  
    static int front = 0;  
  
    static int rear = -1;  
  
    static int currentSize = 0;   
    
    static boolean isQueueFull() {  
        return (size == currentSize);  
    }      
   
    static boolean isQueueEmpty()  {  
        return (currentSize == 0);  
    }  

    static void insert(int x) {  
        if (isQueueFull()) {
            System.out.println("Queue is full");  
            return;
        }
        if (rear == size - 1)
            rear = -1;  
        array[++rear] = x;  
        currentSize++;  
        System.out.println("Added to the queue: " + x);  
    }  
  
    static int delete() {  
        if (isQueueEmpty()) {
            System.out.println("Queue is empty");
            System.exit(0);
        }
        int temp = array[front++];  
        if (front == size)   
            front = 0;    
        currentSize--;  
        return temp;  
    }    

    public static void main(String[] args) {  
        int j=0;
        for (j=0;j<=10;j++) {
            insert(j); 
        } 
        for (j=0;j<=10;j++) {
            System.out.println("Deleted from the queue: " + delete()); 
        }  
    }  
}