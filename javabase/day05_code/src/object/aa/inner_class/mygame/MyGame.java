package object.aa.inner_class.mygame;

public class MyGame {
    public static void main(String[] args) {
        Hero hero = new Hero();
        hero.setName("李白");
        hero.setWeapon(new Weapon("青莲剑"));

        //技能和对象只使用一次用匿名内部类，
        hero.setSkill(new Skill() {
            @Override
            public void attack() {
                System.out.println("释放：青莲剑歌，十步杀一人千里不留行");
            }
        });

        hero.attack();
    }

}
