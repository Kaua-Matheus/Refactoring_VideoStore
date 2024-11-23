import java.util.Enumeration;

public class HtmlStatement extends Statement {
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
        return "<H1>Rentals for <EM>" + aCustomer.getName() + "</EM></H1><P>\n";
    }

    @Override
    protected String getRentalFigures(Rental each) {
        return each.getMovie().getTitle() + ": " +
               String.valueOf(each.getCharge()) + "<BR>\n";
    }

    @Override
    protected String getFooter(Customer aCustomer) {
        return "<P>You owe <EM>" + String.valueOf(aCustomer.getTotalCharge()) + "</EM><P>\n" +
               "On this rental you earned <EM>" + 
               String.valueOf(aCustomer.getTotalFrequentRenterPoints()) + 
               "</EM> frequent renter points<P>";
    }
}
