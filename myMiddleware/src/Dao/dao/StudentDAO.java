package Dao.dao;

import Dao.bean.*;
import java.util.*;
public interface StudentDAO{
    public void insert(Student s);
    public void update(Student s);
    public void delete(int id);
    public Student findByID(int id);
    public ArrayList<Student> findAll();
}

