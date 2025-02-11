import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student{
    private String name;
    private int rollnumber;
    private String grade;
    
    public Student(String name,int rollnumber,String grade){
        this.name=name;
        this.rollnumber=rollnumber;
        this.grade=grade;
    }
    public int getRollNumber(){
        return rollnumber;
    }
    public String toString(){
        return "Name:"+name+ ",Roll number:" +rollnumber+ ",Grade:"+grade;
        
    }
}
class StudentManagementSystem{
    private List<Student> students;
    
    public StudentManagementSystem(){
        students=new ArrayList<>();
    }
    public void addStudent(Student student){
        students.add(student);
    }
    public boolean removeStudent(int rollnumber){
        for (Student student:students){
            if(student.getRollNumber()==rollnumber){
                students.remove(student);
                return true;
            }
        }
        return false;
    }
    public Student searchStudent(int rollNumber){
        for (Student student:students){
            if (student.getRollNumber()==rollNumber){
                return student;
            }
        }
        return null;
    }
    public List<Student> getAllStudents(){
        return students;
    }
}
public class Student_management_system{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        StudentManagementSystem sms=new StudentManagementSystem();
        
        while (true){
            System.out.println("1. Add student");
            System.out.println("2. Remove student");
            System.out.println("3. Search student");
            System.out.println("4. Display all students");
            System.out.println("5. exit");
            System.out.print("Enter your choice:");
            int choice=sc.nextInt();
            switch(choice){
                case 1:
                    sc.nextLine();
                    System.out.print("Enter student name:");
                    String name=sc.nextLine();
                    System.out.print("Enter roll number:");
                    int rollNumber=sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter grade:");
                    String grade=sc.nextLine();
                    
                    Student newStudent=new Student(name,rollNumber,grade);
                    sms.addStudent(newStudent);
                    System.out.println("Student added");
                    break;
                case 2:
                    System.out.print("Enter roll number of student to remove");
                    int rollToRemove=sc.nextInt();
                    boolean removed=sms.removeStudent(rollToRemove);
                    if(removed){
                        System.out.println("Student removed");
                        
                    }else{
                        System.out.println("Student not found");
                    }
                    break;
                case 3:
                    System.out.print("Enter roll number of student to search");
                    int rollToSearch=sc.nextInt();
                    Student searchedStudent=sms.searchStudent(rollToSearch);
                    if(searchedStudent!=null){
                        System.out.println("Student found:");
                        System.out.println(searchedStudent);
                    }else{
                        System.out.println("Student not found");
                    }
                    break;
                case 4:
                    List<Student> allStudents=sms.getAllStudents();
                    if(allStudents.isEmpty()){
                        System.out.println("no of students to display");
                    }else{
                        System.out.println("All students:");
                        for(Student student:allStudents){
                            System.out.println(student);
                        }
                    }
                    break;
                case 5:
                    System.out.println("Exiting..");
                    sc.close();
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again");
                    break;
            }
        }
    }
}