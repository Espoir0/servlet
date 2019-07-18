package alone.aa.test;

import alone.aa.modle.PO.User;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

/**
 * 该类是用来测试属性和成员变量的区别
 * 一般情况下都把方法和对应的成员变量名字设置一样
 */
public class BeanUtilsTest {
    @Test
    public void test(){
        User user = new User();
        try {
            BeanUtils.setProperty(user,"hehe","木兰");
            System.out.println(user);
           //输出    User{id=0, username='木兰', password='null'}

            String name=BeanUtils.getProperty(user,"hehe");
            //输出：  木兰
            System.out.println(name);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
