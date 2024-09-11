package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StudentManagement {
  private List<Student> students;  // 学生のリスト

  public StudentManagement() {
    this.students = new ArrayList<>();
  }

  public void addStudent(String name, int score) {
    students.add(new Student(name, score));
  }

  public void removeStudent(String name) {
    students = students.stream()
        .filter(student -> !student.getName().equals(name))
        .collect(Collectors.toList());
  }

  public void updateStudentScore(String name, int newScore) {
    Optional<Student> studentToUpdate = students.stream()
        .filter(student -> student.getName().equals(name))
        .findFirst();

    studentToUpdate.ifPresent(student -> student.setScore(newScore));
  }

  public double calculateAverageScore() {
    double average = students.stream()
        .mapToInt(Student::getScore)
        .average()
        .orElse(0.0);
    return Math.round(average * 10) / 10.0;  // 小数点以下1桁までに丸める
  }

  public void displayAllStudents() {
    System.out.println("学生一覧:");
    students.forEach(student ->
        System.out.println(student.getName() + ": " + student.getScore() + "点")
    );
  }
}

