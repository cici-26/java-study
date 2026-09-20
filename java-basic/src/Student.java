public class Student {
    // 1. 属性（成员变量），用 private 封装
    private Long id;        // 学号
    private String name;    // 姓名
    private Integer age;    // 年龄
    private Double score;   // 成绩

    // 2. 无参构造方法（IDEA 快捷键：Alt + Insert -> Constructor）
    public Student() {
    }

    // 3. 全参构造方法
    public Student(Long id, String name, Integer age, Double score) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.score = score;
    }

    // 4. Getter 和 Setter 方法（IDEA 快捷键：Alt + Insert -> Getter and Setter）
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }
    public Double getScore() { return score; }
    public void setScore(Double score) { this.score = score; }

    // 5. toString 方法（方便打印）
    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', age=" + age + ", score=" + score + "}";
    }
}