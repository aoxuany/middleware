package model;
public class Student{
    private long iD;
    private String name;

    public Student(int id, String name) {
    }

    public void setID(long iD){
        this.iD = iD; }

    public long getID(){
        return iD;}

    public void setName(String name){
        this.name = name; }

    public String getName(){
        return name; }
}
