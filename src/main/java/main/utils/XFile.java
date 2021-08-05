package main.utils;

import main.obj.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class XFile {
    public static void writeFile(Student student) throws IOException {
        FileWriter w_file = new FileWriter("C:/Users/HP/IdeaProjects/OceanTech/ChuaBT/Pj1/lib/students.txt", true);
        PrintWriter print_writer = new PrintWriter(w_file);
        print_writer.print("\n" + student.getName() + " % " + student.getAge() + " % " + student.getCode() + " % " + student.getClassName() + " % " + student.getAddress() + " % " + student.getMark());
        print_writer.close();
    }

    public static void readFile(){
        ArrayList<Student> student = new ArrayList<Student>();

        try{
            File r_file = new File("C:/Users/HP/IdeaProjects/OceanTech/ChuaBT/Pj1/lib/students.txt");
            Scanner sc = new Scanner(r_file);

            while (sc.hasNextLine()) {
                String s = sc.nextLine();
                if(s == null){
                    continue;
                }
                String[] arr = s.split(" % ");
                student.add(readStudent(arr));
            }
            for (int i = 0; i < student.size(); i++) {
                System.out.println((i+1) + ". " + student.get(i));
            }
        } catch (Exception e){
            System.out.println("Exception: " + e.getMessage());
        }
    }

    public static int getTheNumberOfStudent() throws FileNotFoundException {
        int lines = 0;
        File file = new File("C:/Users/HP/IdeaProjects/OceanTech/ChuaBT/Pj1/lib/students.txt");
        Scanner sc = new Scanner(file);
        while(sc.hasNextLine())
        {
            sc.nextLine();
            lines++;
        }
        return lines;
    }

    public static Student readStudent(String[] arr){
        String name, code, className, address;
        int age;
        float mark;

        name = arr[0];
        age = Integer.parseInt(arr[1]);
        code = arr[2];
        className = arr[3];
        address = arr[4];
        mark = Float.valueOf(arr[5]);

        Student student = new Student(name, age, code, className, address, mark);
        return student;
    }

    public static Student studentFromKeyboard(){
        Scanner sc = new Scanner(System.in);
        String name, code, className, address;
        int age;
        float mark;

        System.out.print("Nhap name : ");
        name = sc.nextLine();
        System.out.print("Nhap age : ");
        String age_fake = sc.nextLine();
        age = Integer.parseInt(age_fake);
        System.out.print("Nhap code : ");
        code = sc.nextLine();
        System.out.print("Nhap class name : ");
        className = sc.nextLine();
        System.out.print("Nhap address : ");
        address = sc.nextLine();
        System.out.print("Nhap mark : ");
        String mark_fake = sc.nextLine();
        mark = Float.parseFloat(mark_fake);
        Student student = new Student(name, age, code, className, address, mark);
        return student;
    }
}
