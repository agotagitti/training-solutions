package references.parameters;

public class ReferencesMain {

    public static void main(String[] args) {

        Person person1;
        Person person2;

        person1 = new Person("Jane Doe", 20);
        person2 = person1;

        person2.setName("Jill Doe");

        System.out.println(person1);
        System.out.println(person2);

    }
}
