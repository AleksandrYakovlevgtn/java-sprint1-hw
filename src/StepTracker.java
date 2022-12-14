import java.util.Scanner;
public class StepTracker {
    Scanner scanner = new Scanner(System.in);
        MonthData[] monthToData;

        public StepTracker() {
            monthToData = new MonthData[12];
            for (int i = 0; i < monthToData.length; i++) {
                monthToData[i] = new MonthData();
            }
        }
    class MonthData {
            int[] days = new int[30]; // Заполните класс самостоятельно
        }
        void addStep(int monthINT,int day, int step){
            monthToData[monthINT].days[day] =monthToData[monthINT].days[day] + step;

        }
}






      //    System.out.println("Введите количество шагов: ");
      //    monthToData[month].dayData[day]=scanner.nextInt();