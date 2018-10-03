import java.util.*;

class Team {
    String name;
    int wins;
    int lose;
    int draw;
    Team(String name, int wins, int lose, int draw) {
        this.name = name;
        this.wins = wins;
        this.lose = lose;
        this.draw = draw;
    }

    public int compareTo(Team other) {
        if(this.wins < other.wins) {
            return -1;
        } else if (this.wins > other.wins) {
            return 1;
        } else if (this.wins == other.wins) {
            if(this.lose < other.lose) {
                return 1;
            } else if (this.lose > other.lose) {
                return -1;
            } else if (this.lose == other.lose) {
                if(this.draw < other.draw) {
                    return -1;
                } else if (this.draw > other.draw) {
                    return 1;
                }
                return 0;
            }
        }
        return 0;
    }
}

public class Solution{
    public static void sort(Team[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if(a[j].compareTo(a[min]) >= 0) {
                    min = j;
                }
            }
            exchange(a, i, min);
        }
    }

    public static void exchange(Team[] a, int index1, int index2) {
        Team temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Team[] teams = new Team[10];
        int index = 0;
        while(sc.hasNext()) {
            String st = sc.nextLine();
            // {5, 7, -1, -3, 0, 2, 1}
            String[] starr = st.split(",");
            teams[index++] = new Team(starr[0], Integer.parseInt(starr[1]), Integer.parseInt(starr[2]), Integer.parseInt(starr[2]));
        }
        // for (int i = 0; i < index; i++) {
        //     System.out.print(teams[i].name+",");
        //     System.out.print(teams[i].wins+",");
        //     System.out.print(teams[i].lose+",");
        //     System.out.print(teams[i].draw+",");
        //     System.out.println();
        // }
        Team[] copy = new Team[index];
        System.arraycopy(teams, 0, copy, 0, index);
        teams = copy;
        sort(teams);
        for (int i = 0; i < teams.length; i++) {
            System.out.print(teams[i].name);
            if(i < teams.length - 1) {
                System.out.print(",");
            }
        }
    }
}
