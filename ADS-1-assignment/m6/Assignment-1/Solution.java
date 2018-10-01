import java.util.Scanner;
// Rajesh
class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        next = null;
    }
}

class LinkedList {
    public Node start;
    public int size;
    LinkedList() {
        start = null;
        size = 0;
    }
    public void add(int val) {
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

    public LinkedList reverse() {
        LinkedList nl = new LinkedList();
        Node temp = start;
        Node reverse = null;
        while(temp != null) {
            Node temp2 = reverse;
            reverse = new Node(temp.data);
            reverse.next = temp2;
            temp = temp.next;
        }
        nl.start = reverse;
        nl.size = size;
        return nl;
    }

    public String toString() {
        if(start == null) {
            return "";
        } else {
            Node temp = start;
            String st = "";
            while(temp != null) {
                st += temp.data;
                temp = temp.next;
            }
            return st;
        }
    }
}
class AddLargeNumbers {

    public static LinkedList numberToDigits(String number) {
        LinkedList ll = new LinkedList();
        for (int i = 0; i < number.length(); i++) {
            ll.add(Integer.parseInt(number.charAt(i) + ""));
        }
        return ll;
    }

    public static LinkedList numberToDigitsTwo(String number) {
        LinkedList ll = new LinkedList();
        for (int i = 0; i < number.length(); i++) {
            ll.add(Integer.parseInt(number.charAt(i) + ""));
        }
        return ll;
    }

    public static String digitsToNumber(LinkedList list) {
        return list.toString();
    }

    public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {
        list1 = list1.reverse();
        list2 = list2.reverse();
        if(list1 == null || list2 == null) {
            return null;
        } else {
            LinkedList finallist = new LinkedList();
            int extra = 0;
            Node max = null;
            Node min = null;
            if(list1.size > list2.size) {
                max = list1.start;
                min = list2.start;
            } else {
                max = list2.start;
                min = list1.start;
            }
            int sum = 0;
            while(max != null) {
                if(min != null) {
                    sum = sum + max.data + min.data;
                } else {
                    sum = sum + max.data;
                }
                finallist.add(sum % 10);
                sum = sum / 10;
                if(min != null) {
                    min = min.next;
                }
                max = max.next;
            }
            if(sum > 0) {
                finallist.add(sum);
            }
            finallist = finallist.reverse();
            return finallist;
        }
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch(input){
            case "numberToDigits":
                LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
                LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
                System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
                System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
                break;

            case "addLargeNumbers":
                pDigits = AddLargeNumbers.numberToDigits(p);
                qDigits = AddLargeNumbers.numberToDigits(q);
                LinkedList result = AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
                System.out.println(AddLargeNumbers.digitsToNumber(result));
                break;
        }
    }
}
