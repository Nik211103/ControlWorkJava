import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Laptop> notebooks = new ArrayList<>();
        notebooks.add(new Laptop("Lenovo", 8.0, 500.0, "Windows", "Black"));
        notebooks.add(new Laptop("MacBook", 16.0, 1000.0, "MacOS", "Silver"));
        notebooks.add(new Laptop("Dell", 12.0, 750.0, "Windows", "Silver"));
        notebooks.add(new Laptop("Asus", 16.0, 1000.0, "Windows", "Gray"));
        notebooks.add(new Laptop("Acer", 8.0, 512.0, "Linux", "Black"));

        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;

        while (!validInput) {
            short choice = 0;
            try {
                System.out.println("Выберите критерии фильтрации:");
                System.out.println("1. Операционная система");
                System.out.println("2. Объем ОЗУ");
                System.out.println("3. Объем памяти ЖД");
                System.out.println("4. Цвет");
                choice = scanner.nextShort();

                if (choice == 1) {
                    System.out.println("Введите операционную систему (например, Windows):");
                    String os = scanner.next();
                    ArrayList<Laptop> filteredNotebooksOS = filterLaptopsByOS(notebooks, os);
                    displayFilteredLaptops(filteredNotebooksOS);
                } else if (choice == 2) {
                    System.out.println("Введите объем ОЗУ:");
                    double ram = scanner.nextDouble();
                    ArrayList<Laptop> filteredNotebooksRAM = filterLaptopsByRAM(notebooks, ram);
                    displayFilteredLaptops(filteredNotebooksRAM);
                } else if (choice == 3) {
                    System.out.println("Введите объем ЖД:");
                    double hdd = scanner.nextDouble();
                    ArrayList<Laptop> filteredNotebooksHDD = filterLaptopsByHDD(notebooks, hdd);
                    displayFilteredLaptops(filteredNotebooksHDD);
                } else if (choice == 4) {
                    System.out.println("Введите цвет: ");
                    String color = scanner.nextLine();
                    color = scanner.nextLine();
                    ArrayList<Laptop> filteredNotebooksColor = filterLaptopsByColor(notebooks, color);
                    displayFilteredLaptops(filteredNotebooksColor);
                }else System.out.println("Ошибка!");
            } catch (InputMismatchException e) {
                System.out.println("Неверный формат ввода. Пожалуйста, введите целое число.");
                scanner.next();
            }
        }
    }

    public static ArrayList<Laptop> filterLaptops(ArrayList<Laptop> laptops, String os, double ram) {
        ArrayList<Laptop> filteredLaptops = new ArrayList<>();
        for (Laptop laptop : laptops) {
            if (laptop.getNameOS().equals(os) && laptop.getRam() == ram) {
                filteredLaptops.add(laptop);
            }
        }
        return filteredLaptops;
    }

    public static ArrayList<Laptop> filterLaptopsByOS(ArrayList<Laptop> laptops, String os) {
        ArrayList<Laptop> filteredLaptops = new ArrayList<>();
        for (Laptop laptop : laptops) {
            if (laptop.getNameOS().equals(os)) {
                filteredLaptops.add(laptop);
            }
        }
        return filteredLaptops;
    }
    public static ArrayList<Laptop> filterLaptopsByRAM(ArrayList<Laptop> laptops, double ram) {
        ArrayList<Laptop> filteredLaptops = new ArrayList<>();
        for (Laptop laptop : laptops) {
            if (laptop.getRam() == ram) {
                filteredLaptops.add(laptop);
            }
        }
        return filteredLaptops;
    }
    public static ArrayList<Laptop> filterLaptopsByHDD(ArrayList<Laptop> laptops, double hdd) {
        ArrayList<Laptop> filteredLaptops = new ArrayList<>();
        for (Laptop laptop : laptops) {
            if (laptop.getCapacityHDD() == hdd) {
                filteredLaptops.add(laptop);
            }
        }

        return filteredLaptops;
    }
    public static ArrayList<Laptop> filterLaptopsByColor(ArrayList<Laptop> laptops, String color) {
        ArrayList<Laptop> filteredLaptops = new ArrayList<>();
        for (Laptop laptop : laptops) {
            if (laptop.getColor().equals(color)) {
                filteredLaptops.add(laptop);
            }
        }

        return filteredLaptops;
    }

    public static void displayFilteredLaptops(ArrayList<Laptop> laptops) {
        for (Laptop laptop : laptops) {
            System.out.println("Найден ноутбук: " + laptop.getBrand());
        }
        System.exit(0);
    }
}

class Laptop {
    private String brand;
    private double ram;
    private double capacityHDD;
    private String nameOS;
    private String color;

    public Laptop(String brand, double ram, double capacityHDD, String nameOS, String color){
        this.brand = brand;
        this.ram = ram;
        this.capacityHDD = capacityHDD;
        this.nameOS = nameOS;
        this.color = color;
    }

    public String getColor() {
        return color;
    }
    public double getCapacityHDD() {
        return capacityHDD;
    }
    public String getBrand() {
        return brand;
    }

    public double getRam() {
        return ram;
    }

    public String getNameOS() {
        return nameOS;
    }
}
