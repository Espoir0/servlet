package demo;

/**
 * 函数式接口，有且只有一个抽象方法
 *      静态，默认，私有的方法可以有
 *
 *      @FunctionalInterface注解
 *      安全检查：
 *          接口中不是一个抽象方法的时候，编译失败
 */

@FunctionalInterface
public interface FunctionInterface{

    public abstract void method();

}
