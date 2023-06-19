import java.util.*;

public class Main {
    public static void main(String[] args) {
        //zad 1
        Car car1 = new Car("Seria 3", 2007);
        Car car2 = new Car("Fiesta", 2010);
        Car car3 = new Car("307", 2008);
        Car car4 = new Car("Mustang", 2015);
        Car car5 = new Car("Seria 2", 2001);
        Car car6 = new Car("C klasa", 2020);
        Car car7 = new Car("Golf", 2009);
        Car car8 = new Car("Twingo", 2011);
        Car car9 = new Car("Yaris", 2021);
        Car car10 = new Car("Corolla", 2003);

        List<Car> cars = new ArrayList<>();

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);
        cars.add(car6);
        cars.add(car7);
        cars.add(car8);
        cars.add(car9);
        cars.add(car10);

        cars.sort(Comparable::compareTo);

        for (Car car : cars) {
            System.out.println(car);
        }
        //zad 2
        Item item1 = new Item(1, "Laptop");
        Item item2 = new Item(2, "Telefon");
        Item item3 = new Item(3, "Myszka");
        Item item4 = new Item(4, "Słuchawki");
        Item item5 = new Item(5, "Głośnik");

        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.add(item5);

        System.out.println("Zawartość kontenera to:");
        for (int i=0; i<items.size(); i++) {
            items.get(i).show();
        }

        Map <Integer, String> itemMap = new HashMap<>();
        for (Item item : items) {
            itemMap.put(item.getId(), item.getName());
        }

        System.out.println("Zawartość kontenera HashMap:");
        for (Map.Entry<Integer, String> entry : itemMap.entrySet()) {
            int id = entry.getKey();
            String name = entry.getValue();
            System.out.println("Identyfikator: " + id + ", Nazwa: " + name);
        }

        //zad 3
        for (int i = 1; i <= 10; i++) {
            Item item = new Item(i, "Item " + i);
            items.add(item);
        }

        List<Item> sublist = items.subList(0, 5);
        HashSet<Item> itemSet = new HashSet<>(sublist);
        for (Item item : itemSet) {
            System.out.println("ID: " + item.getId() + ", Name: " + item.getName());
        }

        //zad 4
        int[] array = new int[10];
        fillArray(array);

        System.out.println("Array values:");
        for (int value : array) {
            System.out.println(value);
        }
    }

    public static void fillArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            try {
                array[i] = readNumber();
            } catch (NegativeNumberException e) {
                System.out.println(e.getMessage());
                array[i] = 0;
            }
        }
    }

    public static int readNumber() throws NegativeNumberException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        if (number < 0) {
            throw new NegativeNumberException("Negative numbers are not allowed");
        }

        return number;
    }
}