import java.util.Scanner;
public class StepTracker {
    Scanner scanner = new Scanner(System.in);
    MonthData[] monthToData;
    int targetStep = 10_000;
    String[] months = {"Январь","Февраль","Март","Апрель","Май", "Июнь","Июль","Август","Сентябрь","Октябрь","Ноябрь","Декабрь"};


    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    class MonthData {
        int[] days = new int[30];
    }

    void addStep(int monthINT, int day, int step) {
        monthToData[monthINT].days[day - 1] = monthToData[monthINT].days[day - 1] + step;

    }

    void statistikaStepByDays(int monthINT) {
        for (int i = 0; i < 30; i++) {
            System.out.print((i + 1) + " день: " + monthToData[monthINT].days[i] + " ");
           // System.out.println();
        }
        System.out.println();
    }

    void sumStepInMonth(int monthINT) {
        int sumStepInMonth = 0;
        for (int i = 0; i < 30; i++) {
            sumStepInMonth = sumStepInMonth + monthToData[monthINT].days[i];
        }
        System.out.println("Общее количество шагов за " + months[monthINT - 1] + " составляет " + sumStepInMonth);
    }
    void maxStepInMonth(int monthINT){
        int maxStep = 0;
        for (int i = 0; i < 30; i++ ){
          if (monthToData[monthINT].days[i] > maxStep) {
              maxStep = monthToData[monthINT].days[i];
          }
        }
        System.out.println("Максимальное количество шагов за " + months[monthINT - 1] +": " + maxStep);
    }
}






      //    System.out.println("Введите количество шагов: ");
      //    monthToData[month].dayData[day]=scanner.nextInt();