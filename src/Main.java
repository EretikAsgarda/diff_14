import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    // ==================== блок 1: високосный год ====================
    public static void runTaskLeapYear(Scanner scanner) {
        System.out.print("Введите год для проверки високосности: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Ошибка: нужно ввести целое число.");
            // Пропускаем некорректный ввод, чтобы не ломать следующие задачи
            scanner.next();
            return;
        }
        int year = scanner.nextInt();
        printLeapYearStatus(year);
    }

    private static void printLeapYearStatus(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            System.out.println(year + " год — високосный год");
        } else {
            System.out.println(year + " год — невисокосный год");
        }
    }

    //---------------------блок 2: версия приложения---------------------
    public static void runTaskAppVersion(Scanner scanner) {
        System.out.print("Выберите ОС (0 — iOS, 1 — Android): ");
        if (!scanner.hasNextInt()) {
            System.out.println("Ошибка: нужно ввести 0 или 1.");
            scanner.next();
            return;
        }
        int osType = scanner.nextInt();

        System.out.print("Введите год выпуска устройства: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Ошибка: нужно ввести число.");
            scanner.next();
            return;
        }
        int deviceYear = scanner.nextInt();

        suggestAppVersion(osType, deviceYear);
    }

    private static void suggestAppVersion(int osType, int deviceYear) {
        int currentYear = LocalDate.now().getYear();

        String osName;
        if (osType == 0) {
            osName = "iOS";
        } else if (osType == 1) {
            osName = "Android";
        } else {
            System.out.println("Неизвестный тип операционной системы.");
            return;
        }

        if (deviceYear < currentYear) {
            System.out.println("Установите облегченную версию приложения для " + osName + " по ссылке.");
        } else {
            System.out.println("Установите обычную версию приложения для " + osName + " по ссылке.");
        }
    }


    //---------------------блок 3: доставка карты---------------------
    public static void runTaskDelivery() {
        int deliveryDistance = 95; // как в условии
        int days = calculateDeliveryDays(deliveryDistance);

        if (days == -1) {
            System.out.println("Свыше 100 км доставки нет.");
        } else {
            System.out.println("Потребуется дней: " + days);
        }
    }

    private static int calculateDeliveryDays(int deliveryDistance) {
        if (deliveryDistance <= 20) {
            return 1;
        } else if (deliveryDistance > 20 && deliveryDistance <= 60) {
            return 2;
        } else if (deliveryDistance > 60 && deliveryDistance <= 100) {
            return 3;
        } else {
            return -1; // доставка невозможна
        }
    }


    // ---------------------Порядок запуска---------------------
    public static void main(String[] args) {
        // Создаём Scanner ОДИН раз на всю программу
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("--- Задача 1 ---");
            runTaskLeapYear(scanner);

            System.out.println(); // разделитель

            System.out.println("--- Задача 2 ---");
            runTaskAppVersion(scanner);

            System.out.println(); // разделитель

            System.out.println("--- Задача 3 ---");
            runTaskDelivery();
        }
    }
}