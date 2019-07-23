package object.aa.API.generic;

import java.util.ArrayList;
import java.util.Collection;

public class Demo3 {
    public static void main(String[] args) {
        Collection<Integer> coll=new ArrayList<>();
        Collection<String> coll2=new ArrayList<>();
        Collection<Number> coll3=new ArrayList<>();
        Collection<Object> coll4=new ArrayList<>();


        getElement1(coll);
        getElement1(coll3);
       // getElement1(coll2);报错coll2里面的元素不是Number的子类
      //  getElement1(coll4);报错


      //  getElement2(coll);报错
      //  getElement2(coll2);报错

        getElement2(coll3);
        getElement2(coll4);

    }

    //泛型上限，此时的泛型必须是Number或者Num的子类
    private static void getElement1(Collection<? extends Number> coll) {

    }

    //泛型上限，此时的泛型必须是Number或者Number的父类
    private static void getElement2(Collection<? super Number >coll) {
    }


    }
