import java.util.Scanner;
class Node{
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        next = null;
    }
}
class Queue {
    Node start;
    int size;
    Queue() {
        start = null;
        size = 0;
    }

    public void push(int val) {
        Node temp = start;
        start = new Node(val);
        start.next = temp;
        size++;
    }

    public void enqueue(int val) {
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
        if(start == null) {
            return -1;
        }
        int val = start.data;
        start = start.next;
        if(start == null) {
            size = 0;
        } else {
            size--;
        }
        return val;
    }

    public int size() {
        return size;
    }

    public String toString() {
        String st = "";
        if(start != null) {
            Node temp = start;
            while(temp.next != null) {
                st += temp.data + ", ";
                temp = temp.next;
            }
            st += temp.data;
            return st;
        } else {
            return "Steque is empty.";
        }
    }
}
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            Queue ll = new Queue();
            while(sc.hasNext()) {
                String st = sc.nextLine();
                if(st.equals("")){
                    ll = new Queue();
                    System.out.println();
                }
                String[] input = st.split(" ");
                switch(input[0]){
                    case "push":
                        ll.push(Integer.parseInt(input[1]));
                        System.out.println(ll.toString());
                        break;
                    case "enqueue":
                        ll.enqueue(Integer.parseInt(input[1]));
                        System.out.println(ll.toString());
                        break;
                    case "pop":
                        if(ll.pop() != -1) {
                            System.out.println(ll.toString());
                        } else {
                            System.out.println(ll.toString());
                        }
                        break;
                    case "size":
                        System.out.println(ll.size());
                        break;
                }
            }
            ll = null;
        }
    }
}
