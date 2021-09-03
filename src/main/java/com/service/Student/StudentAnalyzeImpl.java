package com.service.Student;

import com.pojo.grade;
import com.pojo.student;

import java.util.List;

class Node {
     private String courseName;
     private int grade;
     private Node next;

     public Node(String courseName, int grade) {
         this.courseName = courseName;
         this.grade = grade;
     }

     public void setNext(Node next) {
         this.next = next;
     }

     public Node getNext() {
         return this.next;
     }

     public String getCourseName() {
         return this.courseName;
     }

     public int getGrade() {
         return this.grade;
     }
 }

public class StudentAnalyzeImpl{

    public static void main(String[] args){
        StudentService studentService=new StudentServiceImpl();
        List<grade> gradeList = studentService.search("3002");
        Node head = new Node("KONG",0);
        head.setNext(null);
        Node p=null;
        Node r=head;
        for(grade grade1 : gradeList){
            p=new Node(grade1.getCourseName(),grade1.getGrade1());
            p.setNext(null);
            p.setNext(r.getNext());
            r.setNext(p);
            r=p;
        }

       // 第二步取出所有数据
        Node currentNode = head.getNext();//
        while (currentNode != null){
            System.out.println(currentNode.getCourseName()+" "+currentNode.getGrade());
            currentNode = currentNode.getNext();
        }



    }

}
