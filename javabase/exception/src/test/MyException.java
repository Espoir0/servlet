package test;

public class MyException extends Exception /*RunTimeException*如果继承的是该异常则不用自己声明，交给虚拟机处理*/{
    public MyException() {
    }

    public MyException(String message) {
        super(message);
    }
}
