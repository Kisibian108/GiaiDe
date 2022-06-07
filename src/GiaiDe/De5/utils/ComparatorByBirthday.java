package GiaiDe.De5.utils;

import GiaiDe.De5.model.Person;

import java.util.Comparator;

public class ComparatorByBirthday implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {

        if (o1.getBirthday().compareTo(o2.getBirthday()) > 0) {
            return 1;

        } else if (o1.getBirthday().compareTo(o2.getBirthday()) < 0) {
            return -1;
        } else {
            if (o1.getName().compareTo(o2.getName()) > 0) {
                return 1;
            } else if (o1.getName().compareTo(o2.getName()) < 0) {
                return -1;
            }
            return 0;
        }
    }
}
