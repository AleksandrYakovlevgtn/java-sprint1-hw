import java.util.Scanner;
1
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        int targetStep = 10_000;
        String[] months = {"Январь","Февраль","Март","Апрель","Май", "Июнь","Июль","Август","Сентябрь","Октябрь","Ноябрь","Декабрь"};
        System.out.println("Здравствуйте это приложение \"Счетчик шагов!\"");


        while (true){
            System.out.println("Ваше целевое значение шагов в день - " + targetStep + " !");
            printMenu();
            int userInput = scanner.nextInt();

            if (userInput == 1){
                System.out.println("За какой месяц внести количество шагов?");
                System.out.println(" Январь - 1 ... Декабрь - 12 ");
                int monthINT = scanner.nextInt();
                String month = months[monthINT - 1];
                System.out.println("за какой день \"" + month + "\" внести шаги ?");
                int day = scanner.nextInt();
                System.out.println("Введите колличество шагов !");
                int step = scanner.nextInt();
                // Надо отправить в класс StepTracker в в метод добавления шагов
            }




        }

    }
    public static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести количество шагов за определённый день месяца");
        System.out.println("2 - Вывод статистики за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выход");
    }
}
