package alone.aa.web.proxy;

/**
 *
 *真实类
 */
public class Lenvo implements SaleComputer{
    @Override
    public String sale(double money) {
        System.out.println("花了"+money+"买了一台联想电脑");
        return "lenvo";
    }

    @Override
    public void show() {
        System.out.println("show...");
    }
}
