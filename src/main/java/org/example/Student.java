package org.example;

public class Student {
  private String name;  // 学生の名前
  private int score;    // 学生の点数

  public Student(String name, int score) {
    this.name = name;
    this.score = score;
  }

  public String getName() {
    return name;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }
}
