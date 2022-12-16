public class Converter {
    double km = 0.0075;
    double distance;
    double kKal;

    void distanceInMonthKM(double sumStepInMonth) {
        distance = sumStepInMonth * km;
    }
    void energySpent(double sumStepInMonth){
        kKal = (sumStepInMonth * 50) / 1_000;
    }
}
