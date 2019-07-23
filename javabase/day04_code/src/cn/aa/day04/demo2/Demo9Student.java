package cn.aa.day04.demo2;

public class Demo9Student{
    private int id;
    private String name;
    private int age;
    static String room;
    private static int idCounter=0;// 计数器，每当new一个对象时，计数器++

    public Demo9Student() {
        idCounter++;
    }

    public Demo9Student(String name, int age) {
        this.name = name;
        this.age = age;
        this.id = ++idCounter; //new 一个对象，idcounter++；
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static String getRoom() {
        return room;
    }

    public static void setRoom(String room) {
        Demo9Student.room = room;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(int idCounter) {
        Demo9Student.idCounter = idCounter;
    }
}
