public class Main {
    public static void main(String[] args) {

        // 1. 调用【有 static】的方法：直接用 类名.方法名()，不需要 new 对象
        Hero.showGameVersion();

        // 2. 调用【有 static】的工具方法：算伤害
        int damage = Hero.calculateDamage(100, 30);
        System.out.println("计算出的伤害为：" + damage);


        // 3. 调用【没有 static】的方法：必须先 new 对象
        Hero garen = new Hero(); // 造出一个叫 garen 的英雄
        garen.name = "盖伦";
        garen.hp = 500;

        Hero teemo = new Hero(); // 再造一个提莫
        teemo.name = "提莫";
        teemo.hp = 300;

        // 对象各自调用各自的方法，互不影响
        garen.attack(); // 输出：盖伦 正在攻击...
        teemo.attack(); // 输出：提莫 正在攻击...

        garen.heal(100); // 盖伦回血，提莫的血量不受影响
    }
}