import java.util.Enumeration;

public class TextStatement extends Statement {
    public String value(Customer aCustomer) {
        StringBuilder result = new StringBuilder();
        result.append(getHeader(aCustomer));
        
        Enumeration rentals = aCustomer.getRentals();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result.append(getRentalFigures(each));
        }

        result.append(getFooter(aCustomer));
        return result.toString();
    }

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
