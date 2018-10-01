import java.util.Scanner;
class Node{
    int data;
    Node next;
    Node(int data) {
        this.data = data;
    }
}
class Queue {
    Node start;
    int size;
    public void push(int val) {
        if(start == null) {
            start = new Node(val);
        } else {
            Node temp = start;
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(val);
        }
        size++;
    }

    public int pop() {
        int val = start.data;
        start = start.next;
        if(start == null) {
            size = 0;
        } else {
            size--;
        }
        return val;
    }
}
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        while(input > 0) {
            Queue qu = new Queue();
            String st = "";
            int n = sc.nextInt();
            int m = sc.nextInt();
            for (int i = 0; i < n; i++) {
                qu.push(i);
            }
            while(qu.size > 1) {
                int temp = m - 1;
                for (int j = 0; j < temp; j++) {
                    qu.push(qu.pop());
                }
                st += qu.pop() + " ";
            }
            st += qu.pop();
            System.out.println(st);
            input--;
        }
    }
}
