package service;

import model.Student;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class studentService {
   private Map<Integer, Student> studentMap = new HashMap<>();

   public void addStudent(Student s) {
      studentMap.put(s.getId(), s);
   }

   public boolean deleteStudent(int id) {
      if (studentMap.containsKey(id)) {
         studentMap.remove(id);
         return true;
      }
      return false;
   }

   public boolean updateStudent(int id, Student updatedStudent) {
      if (studentMap.containsKey(id)) {
         studentMap.put(id, updatedStudent);
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
