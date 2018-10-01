import java.util.Scanner;
class Node{
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        next = null;
    }
}
class LinkedList {
    Node start;
    int size;
    LinkedList() {
        start = null;
        size = 0;
    }

    public void pushLeft(int val) {
        Node temp = start;
        start = new Node(val);
        start.next = temp;
        size++;
    }

    public void pushRight(int val) {
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

    public int popLeft() {
        if(start == null) {
            System.out.println("Deck is empty");
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

    public int popRight() {
        int val = 0;
        if(start != null) {
            Node temp = start;
            if(temp.next == null) {
                val = temp.data;
                temp = null;
            } else if (temp.next.next == null) {
                val = temp.next.data;
                temp.next = null;
            } else {
                while(temp.next.next != null) {
                    temp = temp.next;
                }
                val = temp.next.data;
                temp.next = null;
            }
            size--;
            return val;
        } else {
            System.out.println("Deck is empty");
            return -1;
        }
    }

    public int size() {
        return size;
    }

    public String toString() {
        String st = "[";
        if(start != null) {
            Node temp = start;
            while(temp.next != null) {
                st += temp.data + ", ";
                temp = temp.next;
            }
            st += temp.data;
        }
        st += "]";
        return st;
    }
}
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        LinkedList ll = new LinkedList();
        // String p = sc.nextLine();
        // String q = sc.nextLine();
        while(sc.hasNext()) {
            String[] input = sc.nextLine().split(" ");
            switch(input[0]){
                case "pushLeft":
                    ll.pushLeft(Integer.parseInt(input[1]));
                    System.out.println(ll.toString());
                    break;
                case "pushRight":
                    ll.pushRight(Integer.parseInt(input[1]));
                    System.out.println(ll.toString());
                    break;
                case "popLeft":
                    if(ll.popLeft() != -1) {
                        System.out.println(ll.toString());
                    }
                    break;
                case "popRight":
                    if(ll.popRight() != -1) {
                        System.out.println(ll.toString());
                    }
                    break;
                case "size":
                    System.out.println(ll.size());
                    break;
            }
        }
    }
}
