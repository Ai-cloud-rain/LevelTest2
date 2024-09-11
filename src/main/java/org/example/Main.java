package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main{
  public static void main(String[] args) {
    StudentManagement studentManagement = new StudentManagement();  // 学生管理システム
    Scanner scanner = new Scanner(System.in);  // ユーザーからの入力

    while (true) {
      try {
        System.out.println("1. 学生を追加");
        System.out.println("2. 学生を削除");
        System.out.println("3. 点数を更新");
        System.out.println("4. 平均点を計算");
        System.out.println("5. 全学生の情報を表示");
        System.out.println("6. 終了");
        System.out.print("選択してください: ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // 改行文字を消費

        switch (choice) {
          case 1:
            System.out.println();
            System.out.print("学生の名前を入力してください: ");
            String nameToAdd = scanner.nextLine();
            System.out.print(nameToAdd + "の点数を入力してください: ");
            int scoreToAdd = scanner.nextInt();
            scanner.nextLine();
            studentManagement.addStudent(nameToAdd, scoreToAdd);  // 学生を追加
            break;

          case 2:
            System.out.println();
            System.out.print("削除する学生の名前を入力してください: ");
            String nameToRemove = scanner.nextLine();
            studentManagement.removeStudent(nameToRemove);  // 学生を削除
            break;

          case 3:
            System.out.println();
            System.out.print("更新する学生の名前を入力してください: ");
            String nameToUpdate = scanner.nextLine();
            System.out.print(nameToUpdate + "の新しい点数を入力してください: ");
            int newScore = scanner.nextInt();
            scanner.nextLine();
            studentManagement.updateStudentScore(nameToUpdate, newScore);  // 点数を更新
            break;

          case 4:
            System.out.println();
            double average = studentManagement.calculateAverageScore();  // 平均点を計算
            System.out.printf("平均点: %.1f点%n", average);
            break;

          case 5:
            System.out.println();
            studentManagement.displayAllStudents();  // 全学生情報を表示
            break;

          case 6:
            System.out.println("プログラムを終了します。");
            scanner.close();
            return;

          default:
            System.out.println("無効な選択です。もう一度試してください。");
            break;
        }

        System.out.println();  // 1行余白を追加

      } catch (InputMismatchException e) {
        System.out.println("入力エラー: 数値を入力してください。");
        scanner.nextLine();  // 入力エラー時にScannerをリセット
        System.out.println();
      } catch (Exception e) {
        System.out.println("エラーが発生しました: " + e.getMessage());
        System.out.println();
      }
    }
  }
}
