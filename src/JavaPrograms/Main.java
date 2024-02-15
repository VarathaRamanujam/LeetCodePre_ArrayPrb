package JavaPrograms;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Student stu = new Student("hi");
        stu.name="ggg";
        System.out.println(stu.name);
      }
  public static class Student{
        String name ;
        Student( String name){
            this.name=name;
        }

    }
}
