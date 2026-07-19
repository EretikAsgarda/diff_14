import java.util.Scanner;

public class Main {

    //-------------------- Задача 1: високосный год --------------------
    public static void printLeapYearStatus(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            System.out.println(year + " год — високосный год");
        } else {
            System.out.println(year + " год — невисокосный год");
        }
    }

    //-------------------- Задача 2: версия приложения --------------------
    public static void suggestAppVersion(int osType, int clientDeviceYear) {
        String osName;
        if (osType == 0) {
            osName = "iOS";
        } else if (osType == 1) {
            osName = "Android";
        } else {
            System.out.println("Неизвестный тип операционной системы.");
            return;
        }

        if (clientDeviceYear < 2015) {
            System.out.println("Установите облегченную версию приложения для " + osName + " по ссылке");
        } else {
            System.out.println("Установите обычную версию приложения для " + osName + " по ссылке");
        }
    }

    //-------------------- Задача 3: доставка карт --------------------
    /**
     * Рассчитывает количество дней доставки в зависимости от расстояния.
     * @param distance расстояние в км
     * @return количество дней доставки (0, если доставка невозможна)
     */
    public static int calculateDeliveryDays(int distance) {
        // Доставка свыше 100 км невозможна
        if (distance > 100) {
            return 0;
        }

        // В пределах 20 км — 1 день
        if (distance <= 20) {
            return 1;
        }

        // От 20 до 60 км — +1 день (итого 2 дня)
        if (distance <= 60) {
            return 2;
        }

        // От 60 до 100 км — ещё +1 день (итого 3 дня)
        return 3;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // --- Запуск задачи 1 ---
        System.out.println("=== Задача 1: Проверка високосного года ===");
        int year = 2021; // можно менять значение
        printLeapYearStatus(year);
        System.out.println();

        // --- Запуск задачи 2 ---
        System.out.println("=== Задача 2: Версия приложения ===");
        System.out.print("Введите номер вашей ОС (0 — iOS, 1 — Android): ");
        int osClient = scanner.nextInt();

        System.out.print("Введите год выпуска устройства: ");
        int clientDeviceYear = scanner.nextInt();

        suggestAppVersion(osClient, clientDeviceYear);
        System.out.println();

        // --- Запуск задачи 3 ---
        System.out.println("=== Задача 3: Доставка карты ===");

        // По условию задания: объявляем переменную с дистанцией 95 км
        int deliveryDistance = 95;

        int days = calculateDeliveryDays(deliveryDistance);

        if (days == 0) {
            System.out.println("Доставка на расстояние более 100 км не осуществляется.");
        } else {
            System.out.println("Потребуется дней: " + days);
        }

        scanner.close();
    }
}