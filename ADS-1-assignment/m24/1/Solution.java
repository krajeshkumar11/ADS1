import java.util.*;

class Student {
    int roll_no;
    String name;
    double percentage;

    Student(int roll_no, String name, double percentage) {
        this.roll_no = roll_no;
        this.name = name;
        this.percentage = percentage;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        LinearProbingHashST<Integer, Student> lpht = new LinearProbingHashST<Integer,Student>(n);
        while(n > 0) {
            String uinput = sc.nextLine();
            String[] uinputlist = uinput.split(",");
            Student new_st = new Student(Integer.parseInt(uinputlist[0]), uinputlist[1], Double.parseDouble(uinputlist[2]));
            lpht.put(Integer.parseInt(uinputlist[0]), new_st);
            // System.out.println(uinput);
            n--;
        }
        int operations_n = sc.nextInt();
        sc.nextLine();
        while(operations_n > 0) {
            String[] uinputlist = sc.nextLine().split(" ");
            // System.out.println(uinput);
            if(uinputlist[0].equals("get")) {
                if(uinputlist[2].equals("1")) {
                    Student st = lpht.get(Integer.parseInt(uinputlist[1]));
                    System.out.println(st.name);
                } else if(uinputlist[2].equals("2")) {
                    Student st = lpht.get(Integer.parseInt(uinputlist[1]));
                    System.out.println(st.percentage);
                }
            }
            operations_n--;
        }
    }
}
