import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Abiturient {
    private int id;
    private String lastName;
    private String firstName;
    private String middleName;
    private String address;
    private String phone;
    private double[] grades;

    // Конструктор класса Abiturient
    public Abiturient(int id, String lastName, String firstName, String middleName,
            String address, String phone, double[] grades) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.address = address;
        this.phone = phone;
        this.grades = grades.clone();
    }

    // Get-методы для доступа к полям
    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public double[] getGrades() {
        return grades.clone();
    }

    // Set-методы для изменения полей
    public void setId(int id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setGrades(double[] grades) {
        this.grades = grades.clone();
    }

    @Override
    public String toString() {
        // Преобразуем оценки в целые числа для вывода
        int[] intGrades = new int[grades.length];
        for (int i = 0; i < grades.length; i++) {
            intGrades[i] = (int) grades[i];
        }

        return String.format("ID: %d | %s %s %s | Адрес: %s | Тел: %s | Оценки: %s | Средний балл: %.2f5",
                id, lastName, firstName, middleName, address, phone,
                Arrays.toString(intGrades), getAverageGrade());
    }

    // Вычисление среднего балла
    public double getAverageGrade() {
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.length;
    }

    // Проверка на неудовлетворительные оценки
    public boolean hasFailingGrades() {
        for (double grade : grades) {
            if (grade < 4.0) {
                return true;
            }
        }
        return false;
    }

    // Получение минимальной оценки
    public double getMinGrade() {
        double min = grades[0];
        for (double grade : grades) {
            if (grade < min) {
                min = grade;
            }
        }
        return min;
    }

}

public class lab1 {
    private static Abiturient[] abiturients;

    public static void main(String[] args) {
        // Создание массива абитуриентов
        createAbiturients();

        System.out.println();
        System.out.println("АБИТУРИЕНТЫ");
        System.out.println();
        printAllAbiturients();

        // a) Список абитуриентов с неудовлетворительными оценками
        System.out.println("\nАБИТУРИЕНТЫ С НЕУДОВЛЕТВОРИТЕЛЬНЫМИ ОЦЕНКАМИ");
        printAbiturientWithFailingGrades();

        // b) Список абитуриентов с средним баллом выше заданного
        Scanner scanner = new Scanner(System.in);
        double minGrade = 5;
        System.out.println("\nАБИТУРИЕНТЫ СО СРЕДНИМ БАЛЛОМ ВЫШЕ " + minGrade + "");
        printAbiturientWithHighGrade(minGrade);

        // c) Выбрать заданное число абитуриентов с самым высоким средним баллом
        System.out.print("\nВведите количество лучших абитуриентов для вывода: ");
        int count = scanner.nextInt();
        System.out.println("\n" + count + " АБИТУРИЕНТА ПО СРЕДНЕМУ БАЛЛУ ===");
        printTopAbiturients(count);

        scanner.close();
    }

    // Инициализация массива абитуриентов
    private static void createAbiturients() {
        abiturients = new Abiturient[] {
                new Abiturient(1, "Азёма", "Николай", "Иванович",
                        "ул. Ленина 15", "+375-44-26...",
                        new double[] { 1, 3, 4, 1, 2 }),

                new Abiturient(2, "Петрова", "Анастасия", "Никитечна",
                        "пр. Мира 23", "+375-29-46...",
                        new double[] { 3, 3, 5, 4, 5 }),

                new Abiturient(3, "Сидоров", "Алексей", "Владимирович",
                        "ул. Пушкина 7", "+375-33-52...",
                        new double[] { 5, 5, 4, 6, 6 }),

                new Abiturient(4, "Козлов", "Макстим", "Андреев",
                        "ул. Гагарина 45", "+375-44-67...",
                        new double[] { 9, 10, 9, 10, 10 }),

                new Abiturient(5, "Морозова", "Мария", "Николаевна",
                        "пер. Короткий 3", "+375-29-33...",
                        new double[] { 8, 8, 9, 8, 9 })
        };
    }

    // Вывод всех абитуриентов
    private static void printAllAbiturients() {
        for (Abiturient abiturient : abiturients) {
            System.out.println(abiturient);
        }
    }

    // a) Абитуриенты с неудовлетворительными оценками
    private static void printAbiturientWithFailingGrades() {
        boolean found = false;
        for (Abiturient abiturient : abiturients) {
            if (abiturient.hasFailingGrades()) {
                System.out.println(abiturient);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Абитуриенты с неудовлетворительными оценками не найдены.");
        }
    }

    // b) Абитуриенты со средним баллом выше заданного
    private static void printAbiturientWithHighGrade(double minGrade) {
        boolean found = false;
        for (Abiturient abiturient : abiturients) {
            if (abiturient.getAverageGrade() > minGrade) {
                System.out.println(abiturient);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Абитуриенты с средним баллом выше " + minGrade + " не найдены.");
        }
    }

    // c) Топ N абитуриентов по среднему баллу
    private static void printTopAbiturients(int count) {
        // Создаем копию массива для сортировки
        List<Abiturient> sortedList = new ArrayList<>(Arrays.asList(abiturients));

        // Сортируем по убыванию среднего балла
        sortedList.sort((a1, a2) -> Double.compare(a2.getAverageGrade(), a1.getAverageGrade()));

        // Выводим топ N
        int limit = Math.min(count, sortedList.size());
        for (int i = 0; i < limit; i++) {
            System.out.println(sortedList.get(i));
            System.out.println();
        }
    }
}
