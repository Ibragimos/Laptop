import java.util.*;

public class Laptop {
    private String brand;
    private int ram;
    private int storage;
    private String operatingSystem;
    private String color;

    public Laptop(String brand, int ram, int storage, String operatingSystem, String color) {
        this.brand = brand;
        this.ram = ram;
        this.storage = storage;
        this.operatingSystem = operatingSystem;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getColor() {
        return color;
    }

   
    public String toString() {
        return "Ноутбук = '" + brand + "', ОЗУ = " + ram + ", Объем ЖД = " + storage + ", Операционная система = '"
                + operatingSystem + "', Цвет = '" + color + "'";
    }
}

class Main {
    public static void main(String[] args) {
        Set<Laptop> laptops = createLaptops();
        Map<String, List<Object>> filters = getFiltersFromUser();
        List<Laptop> filteredLaptops = filterLaptops(laptops, filters);
        printFilteredLaptops(filteredLaptops, filters);
    }

    public static Set<Laptop> createLaptops() {
        Set<Laptop> laptops = new HashSet<>();
        laptops.add(new Laptop("HP", 8, 512, "Windows 10", "Silver"));
        laptops.add(new Laptop("Dell", 16, 256, "Windows 10", "Black"));
        laptops.add(new Laptop("Lenovo", 8, 1, "Windows 10", "Gray"));
        laptops.add(new Laptop("Apple", 16, 512, "MacOS", "Silver"));
        laptops.add(new Laptop("Asus", 8, 256, "Windows 10", "Black"));
        return laptops;
    }

    public static Map<String, List<Object>> getFiltersFromUser() {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Object>> filters = new HashMap<>();

        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");
        System.out.println("0 - Завершить ввод критериев");

        int criteria;
        do {
            criteria = scanner.nextInt();
            switch (criteria) {
                case 1:
                    System.out.println("Введите минимальное значение ОЗУ:");
                    int minRam = scanner.nextInt();
                    filters.put("ram", new ArrayList<>());
                    filters.get("ram").add(minRam);
                    break;
                case 2:
                    System.out.println("Введите минимальный объем ЖД:");
                    int minStorage = scanner.nextInt();
                    filters.put("storage", new ArrayList<>());
                    filters.get("storage").add(minStorage);
                    break;
                case 3:
                    System.out.println("Введите операционную систему:");
                    String os = scanner.next();
                    filters.put("operatingSystem", new ArrayList<>());
                    filters.get("operatingSystem").add(os);
                    break;
                case 4:
                    System.out.println("Введите цвет:");
                    String color = scanner.next();
                    filters.put("color", new ArrayList<>());
                    filters.get("color").add(color);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Некорректный номер критерия.");
                    break;
            }
        } while (criteria != 0);

        return filters;
    }

    public static List<Laptop> filterLaptops(Set<Laptop> laptops, Map<String, List<Object>> filters) {
        List<Laptop> filteredLaptops = new ArrayList<>(laptops);

        for (Map.Entry<String, List<Object>> entry : filters.entrySet()) {
            String attribute = entry.getKey();
            List<Object> values = entry.getValue();

            filteredLaptops.removeIf(laptop -> !values.contains(getAttributeValue(laptop, attribute)));
        }

        return filteredLaptops;
    }

    public static void printFilteredLaptops(List<Laptop> laptops, Map<String, List<Object>> filters) {
        if (laptops.isEmpty()) {
            System.out.println("Ноутбуки, удовлетворяющие фильтру, не найдены.");
        } else {
            System.out.println("Ноутбуки, удовлетворяющие фильтру:");
            for (Laptop laptop : laptops) {
                System.out.println(laptop);
            }
            System.out.println("Критерии фильтрации:");
            for (Map.Entry<String, List<Object>> entry : filters.entrySet()) {
                String filterKey = entry.getKey();
                List<Object> filterValues = entry.getValue();
                System.out.println(filterKey + ": " + filterValues);
            }
        }
    }

    public static Object getAttributeValue(Laptop laptop, String attribute) {
        switch (attribute) {
            case "ram":
                return laptop.getRam();
            case "storage":
                return laptop.getStorage();
            case "operatingSystem":
                return laptop.getOperatingSystem();
            case "color":
                return laptop.getColor();
            default:
                return null;
        }
    }
}