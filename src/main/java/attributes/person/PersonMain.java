package attributes.person;

public class PersonMain {

    public static void main(String[] args) {

        Person person = new Person("Jane Doe", "12345");
        person.moveTo(new Address("Scotland", "Craigland", "Osprey Heights 42", "GB3246"));

        System.out.println(person.personToString());
        System.out.println(person.getAddress().addressToString());

        person.correctData("Jill Doe", "12346");

        System.out.println(person.personToString());

        person.getAddress().correctData("Scotland", "Craigland", "Eagle Heights 63", "GB3247");

        System.out.println(person.getAddress().addressToString());

    }
}
