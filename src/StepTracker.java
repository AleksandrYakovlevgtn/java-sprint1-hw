public class StepTracker {
    Converter converter = new Converter();
    MonthData[] monthToData;
    int targetStep = 10_000;
    String[] months = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};


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
        monthToData[monthINT - 1].days[day - 1] = monthToData[monthINT - 1].days[day - 1] + step;

    }

    void statistiсStepByDays(int monthINT) {
        for (int i = 0; i < monthToData[monthINT].days.length; i++) {
            System.out.print((i + 1) + " день: " + monthToData[monthINT].days[i] + ", ");
        }
        System.out.println();
    }

    void sumStepInMonth(int monthINT) {
        int sumStepInMonth = 0;
        for (int i = 0; i < monthToData[monthINT].days.length; i++) {
            sumStepInMonth = sumStepInMonth + monthToData[monthINT].days[i];
        }
        System.out.println("Общее количество шагов за " + months[monthINT] + " составляет " + sumStepInMonth);
        converter.distanceInMonthKM(sumStepInMonth, monthINT, months);
        converter.energySpent(sumStepInMonth, monthINT, months);
    }

    void maxStepInMonth(int monthINT) {
        double maxStep = 0;
        for (int i = 0; i < monthToData[monthINT].days.length; i++) {
            if (monthToData[monthINT].days[i] > maxStep) {
                maxStep = monthToData[monthINT].days[i];
            }
        }
        System.out.println("Максимальное количество шагов за " + months[monthINT] + ": " + maxStep);
    }

    void averageStepInMonth(int monthINT) {
        int averageStepInMonth = 0;
        int sum = 0;
        for (int i = 0; i < monthToData[monthINT].days.length; i++) {
            sum += monthToData[monthINT].days[i];
        }
        averageStepInMonth = sum / monthToData.length;
        System.out.println("Среднее количество шагов за " + months[monthINT] + " " + averageStepInMonth);
    }

    void seriesStep(int monthINT) {
        int longestSeries = 0;
        int longestSeriesDays = 0;
        for (int i = 0; i < monthToData[monthINT].days.length; i++) {
            if (monthToData[monthINT].days[i] >= targetStep) {
                longestSeries++;

            } else if (longestSeries > longestSeriesDays) {
                longestSeriesDays = longestSeries;
                longestSeries = 0;
            }
        }
        System.out.println("Лучшая серия дней " + longestSeriesDays);
    }

    void changeTargetStep(int newTargetStep) {
        targetStep = newTargetStep;
    }
}


