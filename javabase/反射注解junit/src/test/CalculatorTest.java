package test;

import junit.Calculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

    //初始化方法，用于资源申请，在所有测试方法执行之前，会执行该方法
    @Before
    public void init(){
        System.out.println("init....");
    }

    //释放资源方法，在所有方法执行之后都要执行该方法
    @After
    public void close(){
        System.out.println("close...");
    }

    /**
     * 测试add()方法
     * 使用junit的时候一般不用输出，判定结果绿色代表成功
     *   断言的结果和实际结果去对比
     */
    @Test
    public void testAdd(){
        int result=new Calculator().add(1,3,4);

        //断言结果是否与运行结果相等
        Assert.assertEquals(8,result);
    }

    @Test
    public void testSub(){
        int result =new Calculator().sub(10,5,2);
        Assert.assertEquals(3,result);
    }
}
