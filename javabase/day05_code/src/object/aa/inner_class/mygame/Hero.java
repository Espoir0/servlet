package object.aa.inner_class.mygame;

public class Hero {
    private String name;
    private Skill skill;
    private Weapon weapon;




    public Hero() {
    }

    public Hero(String name, Skill skill,Weapon weapon) {
        this.name = name;
        this.skill = skill;
        this.weapon=weapon;
    }

    public void attack(){
        System.out.println("剑客"+name+"，遭遇敌军，使用 "+weapon);
        skill.attack();
        System.out.println("释放技能完毕，击杀敌军.");
        System.out.println("victory");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

}
