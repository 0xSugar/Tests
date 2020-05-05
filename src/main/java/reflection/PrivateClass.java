package reflection;

public class PrivateClass {
    private String name;
    private int age;

    private PrivateClass (String name, int age) {
        this.name = name;
        this.age = age;
    }

    private void testMethod() {
        System.out.println("Private method inside " + toString());
    }

    public PrivateClass() {
    }

    @Override
    public String toString() {
        return "PrivateClass{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
