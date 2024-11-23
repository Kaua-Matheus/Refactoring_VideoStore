public abstract class Statement {
    protected abstract String getHeader(Customer aCustomer);
    protected abstract String getRentalFigures(Rental each);
    protected abstract String getFooter(Customer aCustomer);
}
