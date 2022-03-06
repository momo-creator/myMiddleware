package Dao.test;
import Dao.bean.Student;
import Dao.dao.StudentDAO;
import Dao.daoIMP.StudentDAOIMP;

import java.util.*;

public class main {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAOIMP();

        //1.查找所有
        System.out.println("查找所有:");
        ArrayList<Student> student1 = dao.findAll();
        for(Student s : student1){
            System.out.println(s);
        }

        //2.插入信息
        System.out.println("插入信息");
        Student stu1 = new Student();
        stu1.setID(10004);
        stu1.setName("小茗");
        dao.insert(stu1);
        ArrayList<Student> student3 = dao.findAll();
        for(Student s : student3){
            System.out.println(s);
        }

        //3.按照id查找
        System.out.println("按照id查找:");
        System.out.println(dao.findByID(10002));

        //4.删除信息
        System.out.println("按照学号删除:");
        dao.delete(10001);
        ArrayList<Student> student2 = dao.findAll();
        for(Student s : student2){
            System.out.println(s);
        }

        //5.修改信息
        System.out.println("修改信息");
        Student stu2 = new Student();
        stu2.setID(10002);
        stu2.setName("小亮");
        dao.update(stu2);
        ArrayList<Student> student4 = dao.findAll();
        for(Student s : student4){
            System.out.println(s);
        }





    }
}
