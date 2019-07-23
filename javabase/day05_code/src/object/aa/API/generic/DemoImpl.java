package object.aa.API.generic;

public class DemoImpl implements Demo<String> {

    @Override
    public void test(String s) {
        System.out.println(s);
    }
}
