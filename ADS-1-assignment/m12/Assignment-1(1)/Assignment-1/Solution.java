import java.util.Scanner;
class Student {
    String name;
    int[] date;
    int sub1;
    int sub2;
    int sub3;
    int total;
    String reservation_category;
    Student (String name, int[] date, int sub1, int sub2, int sub3, int total, String reservation_category) {
        this.name = name;
        this.date = date;
        this.sub1 = sub1;
        this.sub2 = sub2;
        this.sub3 = sub3;
        this.total = total;
        this.reservation_category = reservation_category;
    }

    public int compareTo(Student other) {
        if(this.total > other.total) {
            return 1;
        } else if(this.total < other.total) {
            return -1;
        } else if(this.sub3 > other.sub3) {
            return 1;
        } else if(this.sub3 < other.sub3) {
            return -1;
        } else if(this.sub2 > other.sub2) {
            return 1;
        } else if(this.sub2 < other.sub2) {
            return -1;
        } else if(this.date[2] > other.date[2]) {
            return 1;
        } else if(this.date[2] < other.date[2]) {
            return -1;
        } else if(this.date[1] > other.date[1]) {
            return 1;
        } else if(this.date[1] < other.date[1]) {
            return -1;
        } else if(this.date[0] > other.date[0]) {
            return 1;
        } else {
            return -1;
        }
    }
}

class Interview {
    Student[] students;
    int size = 0;
    Interview(int count) {
        students = new Student[count];
    }

    public void addStudent(Student student) {
        students[size++] = student;
    }

    public void sort() {
        for (int i = 0; i < size; i++) {
            int min = i;
            for (int j = i + 1; j < size; j++) {
                if(less(students[j], students[min])) {
                    min = j;
                }
            }
            exchange(students, i, min);
        }
    }

    public boolean less(Student first, Student second) {
        return first.compareTo(second) > 0;
    }

    public void exchange(Student[] studentsarr, int i, int j) {
        Student temp = studentsarr[i];
        studentsarr[i] = studentsarr[j];
        studentsarr[j] = temp;
    }

    public int catogeryrecruit(Student[] studentsSorted, String catogery, int vacancies) {
        // System.out.println(studentsSorted.length + " HI");
        // System.out.println(students.length + " HI HELLO");
        int count = 0;
        if(vacancies > 0) {
            while(count < studentsSorted.length) {
                if(vacancies > 0 && studentsSorted[count] != null && catogery.equals("ALL")) {
                    // System.out.println(size + "LO");
                    this.students[size++] = studentsSorted[count];
                    studentsSorted[count] = null;
                    vacancies--;
                } else if(vacancies > 0 && studentsSorted[count] != null){
                    if(studentsSorted[count].reservation_category.equals(catogery)) {
                        this.students[size++] = studentsSorted[count];
                        studentsSorted[count] = null;
                        vacancies--;
                    }
                }
                if(size == this.students.length) {
                    break;
                }
                count++;
            }
        }
        if(vacancies > 0) {
            return vacancies;
        }
        return 0;
    }

    public void recruit(Student[] studentsSorted, int unreserved, int bc_category_vacancies, int st_category_vacancies, int sc_category_vacancies) {
        // int count = 0;
        int vacancies = catogeryrecruit(studentsSorted, "ALL", unreserved);
        vacancies = catogeryrecruit(studentsSorted, "ST", st_category_vacancies);
        if(vacancies > 0) {
            vacancies = catogeryrecruit(studentsSorted, "ALL", vacancies);
        }
        vacancies = catogeryrecruit(studentsSorted, "SC", sc_category_vacancies);
        if(vacancies > 0) {
            vacancies = catogeryrecruit(studentsSorted, "ALL", vacancies);
        }
        vacancies = catogeryrecruit(studentsSorted, "BC", bc_category_vacancies);
        if(vacancies > 0) {
            vacancies = catogeryrecruit(studentsSorted, "ALL", vacancies);
        }
    }

    public String toString() {
        String st = "";
        for (int i = 0; i < size; i++) {
            st += students[i].name + "," + students[i].total + "," + students[i].reservation_category + "\n";
        }
        return st;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int vacancies = sc.nextInt();
        int unreserved = sc.nextInt();
        int bc_category_vacancies = sc.nextInt();
        int sc_category_vacancies = sc.nextInt();
        int st_category_vacancies = sc.nextInt();
        sc.nextLine();
        Interview interview = new Interview(N);
        while(sc.hasNext()) {
            String[] input = sc.nextLine().split(",");
            String[] datestring = input[1].split("-");
            int[] date = new int[datestring.length];
            for (int i = 0; i < datestring.length; i++) {
                date[i] = Integer.parseInt(datestring[i]);
            }
            interview.addStudent(new Student(input[0], date, Integer.parseInt(input[2]), Integer.parseInt(input[3]), Integer.parseInt(input[4]), Integer.parseInt(input[5]), input[6]));
        }
        interview.sort();
        System.out.println(interview);
        Interview recruting = new Interview(vacancies);
        recruting.recruit(interview.students, unreserved, bc_category_vacancies, st_category_vacancies, sc_category_vacancies);
        recruting.sort();
        System.out.println(recruting);
    }
}
