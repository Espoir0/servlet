package method;

/**
 * 使用对象名引用方法
 */
public class Demo2 {
    public static void printString(Printable p){
        p.print("hello world");
    }

    public static void main(String[] args) {
        //lambda表达式
        printString(s->new MethodObject().printUpperCase(s));

        //对象引用，
        printString(new MethodObject()::printUpperCase);
    }
}

class MethodObject{
    public void   printUpperCase(String s){
        System.out.println(s.toUpperCase());
    }

}

@FunctionalInterface
interface Printable<E>{
    public abstract void print(String s);
}