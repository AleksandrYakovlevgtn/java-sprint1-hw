public class Converter {
   double km = 0.075;
   double distanciy;
   double kKal;
   void distanciyInMonthKM (double sumStepInMonth){
      distanciy = sumStepInMonth * km;
      kKal = (sumStepInMonth * 50)/1_000;
   }
}
