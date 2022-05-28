package salestax.salestax;

public class product {

    private String productName;
    private int quantity;
    private double productPrice;
    private productType type;
    private boolean isImported;
    private boolean isExempted;
    private boolean isPerfume;
    private double salesTax;


    enum productType {
        Book,
        Medical,
        Food,
        Others,
        Imported;


    }

    public product(String productName, int quantity, double productPrice, productType type, boolean isExempted,
                   boolean isImported, boolean isPerfume) {
        this.productName = productName;
        this.quantity = quantity;
        this.productPrice = productPrice;
        this.type = type;
        this.isImported = isImported;
        this.isExempted = isExempted;
        this.isPerfume = isPerfume;
    }


    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public boolean isImported() {
        return isImported;
    }

    public boolean isExempted() {
        return isExempted;
    }

    public double getSalesTax() {
        return salesTax;
    }

    public void setSalesTax(double salesTax) {
        this.salesTax = salesTax;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public boolean isPerfume() {
        return isPerfume;
    }

    public void setPerfume(boolean perfume) {
        isPerfume = perfume;
    }
    @Override
    public String toString() {
        return "product{" +
                "productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", productPrice=" + productPrice +
                ", type=" + type +
                ", salesTax=" + salesTax +
                '}';
    }
}
