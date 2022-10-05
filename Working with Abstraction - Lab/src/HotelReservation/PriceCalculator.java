package HotelReservation;

public class PriceCalculator {

  public static double calculator(double pricePerDay,int numberOfDays,Season season,DiscountType discountType){

      double price = pricePerDay * numberOfDays * season.getMultiplayer();
      return  price * discountType.getPriceWithDiscount();

  }

}
