package main.obj;

public class Student {
    private String name;
    private int age;
    private String code;
    private String className;
    private String address;
    private float mark;

    public Student(){

    }
    public Student(String name, int age, String code, String className, String address, float mark) {
        this.name = name;
        this.age = age;
        this.code = code;
        this.className = className;
        this.address = address;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return  "name='" + name + '\'' +
                ", age=" + age +
                ", code='" + code + '\'' +
                ", className='" + className + '\'' +
                ", address='" + address + '\'' +
                ", mark=" + mark;
    }
}
