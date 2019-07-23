package alone.aa.web.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Proxy {
    public static void main(String[] args) {
        //1.创建真实对象
        Lenvo lenvo = new Lenvo();

        //2.动态代理增强lenvo对象
        /*
        三个参数：1.类加载器，真实对象.getClass().getClassLoader()
                2.接口数组，真实对象.getClass().getInterfaces()
                3.处理器new InvocationHandler()
         */
        SaleComputer proxy_lenvo = (SaleComputer) java.lang.reflect.Proxy.newProxyInstance(lenvo.getClass().getClassLoader(),
                lenvo.getClass().getInterfaces(), new InvocationHandler() {
                    /*代理逻辑编写的方法，代理对象调用的所有方法都会触发该方法执行
                    * 参数：1.proxy:代理对象
                    * 2.method:代理对象调用的方法，被封装为的对象
                    * 3.代理对象调用方法的时候传递的参数*/
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //1.增强参数，判断是否是sale方法
                        if(method.getName().equals("sale")){
                            //增强参数
                            double money=(double)args[0];
                            money=money*0.85;

                            //3.增强逻辑
                            System.out.println("专车接送");
                            //使用真实对象调用该方法
                            String obj = (String) method.invoke(lenvo, money);

                            //2.增强返回值
                            return obj+"鼠标垫";
                        }else {
                            //使用真实对象，调用该方法
                            Object obj = method.invoke(lenvo, args);
                            return obj;
                        }

                    }
                });
        //2.调用方法
        String computer = proxy_lenvo.sale(8000);

    }
}
