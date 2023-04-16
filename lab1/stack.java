/* stack.java
 *  The program shows a simple stack structure.
 *  Created by 63070503431 Pornthep Sangthongkhamsuk
 */

public class stack {
    
    static int st[] = new int[10];
    
    static int top = 0;
    
    static void push(int x) {
        if (top >= st.length)
            System.out.println("Stack is full");
        else
            st[top++] = x;
    }

    static int pop() {
        if (top > 0)
            return st[--top];
        System.out.println("Stack underflow");
        return 0;
    }

    public static void main(String args[]) {
        int j;
        for (j=0;j<=10;j++) {
            push(j+1);
        }
        for (j=0;j<=10;j++) {
            System.out.println(pop());
        }
    }
} 