package Dao.bean;

public class Student{
    private int id;
    private String name;

    public void setID(int id){
        this.id = id; }

    public int getID(){
        return id;}

    public void setName(String name){
        this.name = name; }

    public String getName(){
        return name; }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

