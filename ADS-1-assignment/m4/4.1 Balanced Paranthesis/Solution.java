import java.util.Scanner;
class Node {
    char data;
    Node next;

    Node(char data) {
        this.data = data;
    }
}
public class Solution {
    Node start;
    int size;

    public Solution() {
        start = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public void push(char data) {
        Node temp = start;
        start = new Node(data);
        start.next = temp;
        size++;
    }

    public char pop() {
        if(start != null) {
            char res = start.data;
            start = start.next;
            size--;
            return res;
        }
        return ' ';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        while(sc.hasNext()) {
            String st = sc.nextLine();
            // System.out.println(st);
            Solution s = new Solution();
            int count = 0;
            for (int i = 0; i < st.length(); i++) {
                if(st.charAt(i) == '{' || st.charAt(i) == '[' || st.charAt(i) == '(') {
                    s.push(st.charAt(i));
                    System.out.println(count++);
                } else {
                    char res = s.pop();
                    System.out.println(res);
                    if(st.charAt(i) == '}' && res != '{') {
                        break;
                    } else if (st.charAt(i) == ']' && res != '[') {
                        break;
                    } else if (st.charAt(i) == ')' && res != '(') {
                        break;
                    }
                }
            }
            System.out.println(s.size() + " HI");
            if(s.size() != 0) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}
