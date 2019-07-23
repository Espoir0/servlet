package cn.aa.day04.demo2;

public class Demo8Static {
    public static void main(String[] args) {
        Demo9Student s=new Demo9Student("aa",19);
        s.room="1001";
        System.out.println(s.getAge()+" "+s.getId()+"  "+s.getName()+"  "+s.room);

        Demo9Student s2 = new Demo9Student("bb",20);
        System.out.println(s2.getAge()+" "+s2.getId()+"  "+s2.getName()+"  "+s2.room);

    }
}
