import java.util.*;

class Student {

    private String name;
    private int id;
    private double marks;


    public Student(String name, int id, double marks) {
        this.name = name;
        this.id = id;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }
    
    public int getId() {
        return id;
    }

    public double getMarks() {
        return marks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public String toString() {
        return "Name: " + name + ", Id: " + id + ", Marks: " + marks;
    }
    
}




class Mainclass {
    public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    ArrayList<Student> students = new ArrayList<>();
    selection(students, sc);


    }


    public static void selection(ArrayList<Student> students, Scanner sc) {

    while(true) {
        System.out.println("Menu : ");
        System.out.println("1.Add a student");
        System.out.println("2.Delete a student");
        System.out.println("3.View the list of students");
        System.out.println("4.Search for a student");
        System.out.println("5.Exit");

        System.out.println("Please enter your choice: ");
        int choice = sc.nextInt();

        switch(choice) {
            case 1: 
            System.out.println("Adding student to the list : ");
            addStudent(students,sc);
            System.out.println("Students after adding: ");
            displayStudent(students);
            break;

            case 2: 
            System.out.println("Deleting the student from the list: ");
            deleteStudent(students, sc);
            System.out.println("Students after deleting: ");
            displayStudent(students);
            break;

            case 3: 
            System.out.println("Viewing the list of students: ");
            displayStudent(students);
            break;

            case 4:
            System.out.println("Searching for a student : ");
            searchStudent(students, sc);
            break;

            case 5: 
            System.out.println("Exiting....");
            System.exit(0);
            break;

            default:
            System.out.println("You entered a wrong choice.");
            break;



            
        }
    }

}

//ADDING STUDENT IN THE LIST

    
public static void addStudent(ArrayList<Student> students, Scanner sc) {

    System.out.print("Enter the name of the student : ");
    sc.nextLine();
    String name = sc.nextLine();
    System.out.print("Enter the id of the student: ");
    int id = sc.nextInt();
    System.out.print("Enter the marks of the student: ");
    double marks = sc.nextDouble(); 

    Student st = new Student(name, id, marks);
    students.add(st);

       
}

//DELETING STUDENT FROM THE LIST

public static void deleteStudent(ArrayList<Student> students, Scanner sc) {

    if(students.isEmpty()) {
        System.out.println("No students found.");

    }

    else {

    System.out.println("Enter the id of the student to be deleted: ");

    int todelete_id = sc.nextInt();
    
    boolean removed = students.removeIf(ele -> ele.getId() == todelete_id);

    if(removed) {
        System.out.println("Student is deleted.");
    }

    else {
        System.out.println("Student is not found.");
    }

        }

    
}

//SEARCHING FOR A STUDENT IN THE LIST

public static void searchStudent(ArrayList<Student> students, Scanner sc) {

    System.out.print("Enter the id of the student to search: ");

    int searchId = sc.nextInt();

    Student target = null;
    for(Student s: students) {

        if(s.getId() == searchId) {
            target = s;
            break;
        }
        
    }

    if(target != null) {
    System.out.println(target);
    }
    else {
        System.out.println("Student is not found.");
    }
    
}

//DISPLAY OF STUDENTS IN THE LIST

public static void displayStudent(ArrayList<Student> students) {

    if(students.isEmpty()) {
        System.out.println("No students available.");
    }
    for(Student s : students) {
        System.out.println(s);
    }
}
}
