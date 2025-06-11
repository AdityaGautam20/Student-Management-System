package util;

import model.Student;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class fileHandler {

    // Load students from file into a HashMap
    public static Map<Integer, Student> loadStudents() {
        Map<Integer, Student> map = new HashMap<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("D:\\Student Management System/data/students.txt"));
            String line = br.readLine();

            while(line != null) {
                String[] substrings = line.split(", " , -1);

                if(substrings.length == 5) {
                    int id = Integer.parseInt(substrings[0]);
                    String name = substrings[1];
                    int age = Integer.parseInt(substrings[2]);
                    String email = substrings[3];
                    String course = substrings[4];

                    Student student = new Student(id, name, age, email, course);
                    map.put(id, student);
                }

                line = br.readLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return map;
    }

    // Save all students from HashMap to file
    public static void saveStudents(Map<Integer, Student> studentMap) {

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\Student Management System/data/students.txt"));
            for(Student stu : studentMap.values()) {
                bw.write(stu.toString());
                bw.newLine();
            }
            bw.close();
        }
        catch (IOException e) {
            System.out.println("⚠️ File not found, starting fresh.");
        }
    }
}
