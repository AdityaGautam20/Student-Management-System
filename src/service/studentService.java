package service;

import model.Student;
import util.fileHandler;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class studentService {
   private Map<Integer, Student> studentMap = new HashMap<>();

   public void load() {
      this.studentMap = fileHandler.loadStudents();
   }

   public void addStudent(Student s) {
      if (studentMap.containsKey(s.getId())) {
         System.out.println("❌ Student with ID " + s.getId() + " already exists!");
         return;
      }

      studentMap.put(s.getId(), s);
      fileHandler.saveStudents(studentMap);
   }

   public boolean deleteStudent(int id) {
      if (studentMap.containsKey(id)) {
         studentMap.remove(id);

         fileHandler.saveStudents(studentMap);
         return true;
      }
      return false;
   }

   public boolean updateStudent(int id, Student updatedStudent) {
      if (studentMap.containsKey(id)) {
         studentMap.put(id, updatedStudent);

         fileHandler.saveStudents(studentMap);
         return true;
      }
      return false;
   }

   public Student searchStudent(int id) {
      return studentMap.get(id);
   }

   public Collection<Student> getAllStudents() {
      return studentMap.values(); // returns all students as a collection
   }
}
