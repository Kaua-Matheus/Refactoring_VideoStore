import java.util.Enumeration;

public abstract class Statement {
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

    protected abstract String getHeader(Customer aCustomer);
    protected abstract String getRentalFigures(Rental each);
    protected abstract String getFooter(Customer aCustomer);
}
