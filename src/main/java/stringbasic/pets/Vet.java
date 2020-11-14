package stringbasic.pets;

import java.util.ArrayList;
import java.util.List;

public class Vet {

    private List<Pet> pets = new ArrayList<>();

    public void add(Pet newPet) {
        boolean foundPet = false;
        for (Pet pet: pets) {
            if (areEquals(pet, newPet)) {
                foundPet = true;
                break;
            }
        }
        if (!foundPet) {
            pets.add(newPet);
        }
    }

    private boolean areEquals(Pet pet1, Pet pet2) {
       return  pet1.getRegistrationNumber() == pet2.getRegistrationNumber();
    }

    public List<Pet> getPets() {
        return pets;
    }
}
