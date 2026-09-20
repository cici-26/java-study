public class Hero {
    // ============ 1. 属性 ============

    // 【没有 static】实例变量：每个英雄独有的名字和血量
    public String name;
    public int hp;

    // 【有 static】静态变量：所有英雄共享的游戏版本号
    public static String gameVersion = "S14赛季";

    // ============ 2. 方法 ============

    // 【没有 static】实例方法：英雄攻击，必须依赖具体英雄的名字和血量
    public void attack() {
        System.out.println(this.name + " 正在攻击，当前血量：" + this.hp);
    }

    // 【没有 static】实例方法：英雄回血，改变的是具体某个英雄的血量
    public void heal(int amount) {
        this.hp = this.hp + amount;
        System.out.println(this.name + " 喝了药水，恢复了 " + amount + " 点血，当前血量：" + this.hp);
    }

    // 【有 static】静态方法：显示游戏版本，不需要知道是哪个英雄
    public static void showGameVersion() {
        System.out.println("当前游戏版本是：" + gameVersion);
    }

    // 【有 static】静态方法：纯数学工具，计算伤害，不需要依赖任何具体的英雄对象
    public static int calculateDamage(int attack, int defense) {
        return Math.max(attack - defense, 1); // 保底伤害1点
    }
}