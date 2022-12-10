//package com.tvn.elements;
//
//import java.util.Arrays;
//import java.util.Comparator;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class Day6 {
//    public static void main(String[] args) {
//        Person person1 = new Person("Luke Skywalker", 172, 77, "blond", "fair", "blue", "19BBY", "male");
//        Person person2 = new Person("Darth Vader", 202, 136, "none", "white", "yellow", "41.9BBY", "male");
//        Person person3 = new Person("Leia Organa", 150, 49, "brown", "light", "brown", "19BBY", "female");
//        Person person4 = new Person("Owen Lars", 178, 120, "brown, grey", "light", "blue", "52BBY", "male");
//        Person person5 = new Person("Beru Whitesun lars", 165, 75, "brown", "light", "blue", "47BBY", "female");
//        Person person6 = new Person("Biggs Darklighter", 183, 84, "black", "light", "brown", "24BBY", "male");
//        Person person7 = new Person("Obi-Wan Kenobi", 182, 77, "auburn, white", "fair", "blue-gray", "57BBY", "male");
//
//        //TODO: Convert JSON ARRAY TO ARRAY OBJECT
//        List<Person> characters = Arrays.asList(person1, person2, person3, person4, person5, person6, person7);
////        characters.forEach(Person::info);
//
//        //1. TODO: find person that has mass >100
//        List<Person> personHasMassGreater100 = characters
//                .stream()
//                .filter(person -> person.getMass()>100)
//                .collect(Collectors.toList());
//
////        personHasMassGreater100.forEach(Person::info);
//
//        //TODO: 2. total mass of characters
//        Integer totalMass = characters
//                .stream()
//                .mapToInt(Person::getMass)
//                .sum();
//
////        System.out.println(totalMass);
//
//        //TODO: 3. total height of characters
//        Integer totalHeight = characters
//                .stream()
//                .mapToInt(Person::getHeight)
//                .sum();
//
//        // TODO: REDUCE
//        Integer heightSum =  characters.stream()
//                .reduce(0,(height,person)->height+person.getHeight(),Integer::sum);
//        System.out.printf("total height %d",heightSum);
//
//
//        //TODO: 4. get list name of person
//        List<String> names = characters
//                .stream()
//                .map(Person::getName)
//                .collect(Collectors.toList());
////        System.out.println(names);
//
//        //TODO: 5. find max mass person
//        Person maxMassPerson = characters
//                .stream()
//                .max(Comparator.comparingInt(Person::getMass))
//                .get();
////        maxMassPerson.info();
//
//        //TODO: 6. find smallest person
//        Person smallerPerson = characters.stream()
//                .min(Comparator.comparingInt(Person::getHeight)).get();
////        smallerPerson.info();
//
//        //TODO: 7. Sort by name
//        List<Person> sortPerson = characters.stream()
//                .sorted(Comparator.comparing(Person::getName).reversed())
//                .collect(Collectors.toList());
////        sortPerson.forEach(Person::info);
//
//        //TODO: 8. sort by mass
//        List<Person> sortMassPerson = characters.stream()
//                .sorted(Comparator.comparingInt(Person::getMass).reversed())
//                .collect(Collectors.toList());
//        sortMassPerson.forEach(Person::info);
//
//        //TODO: 9. get list of first name of person in list
//    }
//}
