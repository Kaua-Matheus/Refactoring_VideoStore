public class TextStatement extends Statement {
   @Override
   protected String getHeader(Customer aCustomer) {
       return "Rental Record for " + aCustomer.getName() + "\n";
   }

   @Override
   protected String getRentalFigures(Rental each) {
       return "\t" + each.getMovie().getTitle() + "\t" +
              String.valueOf(each.getCharge()) + "\n";
   }

   @Override
   protected String getFooter(Customer aCustomer) {
       return "Amount owed is " + String.valueOf(aCustomer.getTotalCharge()) + "\n" +
              "You earned " + String.valueOf(aCustomer.getTotalFrequentRenterPoints()) +
              " frequent renter points";
   }
}
