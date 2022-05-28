package salestax.salestax;

import java.text.DecimalFormat;

public class receiptCalculation {

    private double taxAdded = 0;
    private double productPrice=0;
    private final double salesTaxRate = 10;
    private final double importTaxRate = 5;
    private final double perfumeTaxRate = 15;

    /*
    this method gets selectedItem and pass it to specifyProduct method to get values.
    It checks the type of product and calculate the tax based on that.
     */
    public product receiptCal(String selectedItem){

        product newProduct =  specifyProduct(selectedItem);

        productPrice = newProduct.getProductPrice();

        if (!newProduct.isExempted()&&!newProduct.isImported()){
            taxAdded = (salesTaxRate / 100) * newProduct.getQuantity() * newProduct.getProductPrice();
        } else if (newProduct.isImported() && newProduct.isPerfume()) {
            taxAdded = (perfumeTaxRate / 100) * newProduct.getQuantity() * newProduct.getProductPrice();
        } else if (newProduct.isImported()) {
            taxAdded = (importTaxRate / 100) * newProduct.getQuantity() * newProduct.getProductPrice();

        }

        taxAdded = roundOffTax(taxAdded);
        productPrice += taxAdded ;
        newProduct.setProductName(newProduct.getProductName());
        newProduct.setQuantity(newProduct.getQuantity());
        newProduct.setProductPrice(roundTwoDecimals(productPrice));
        newProduct.setSalesTax(roundTwoDecimals(taxAdded));

        return newProduct;
    }


    //a rounding double values to 2 decimals
    public double roundTwoDecimals(double num) {
        DecimalFormat twoDForm = new DecimalFormat("0.00");
        return Double.parseDouble(twoDForm.format(num));
    }

    // rounding tax to nearest 0.05
    public double roundOffTax(double number) {
        return Math.ceil(number * 20) / 20;
    }

    /*
    This method takes selectedItem as String and split it, to get the quantity, name, price, and whether it's
    imported item or not.
     */
    public product specifyProduct(String item){

        String[] divideItem = item.split(" ");
        int qty = Integer.parseInt(divideItem[0]); //first index is the quantity
        boolean isImported = item.contains("imported"); // check if it's imported item
        int specifyIndex = item.lastIndexOf("at");
        String productName = item.substring(1, specifyIndex); //product name is between quantity and 'at'
        double price = Double.parseDouble((item.substring(specifyIndex + 2)));//the price is after 'at'
        product addNewProduct ;
        if (!isImported){

            if (item.contains("book") ){
                addNewProduct= new product(productName,qty,price, product.productType.Book,true,false,
                        false);
            }else if (item.contains("chocolate")){
                addNewProduct= new product(productName,qty,price, product.productType.Food,true,false,
                        false);
            } else if (item.contains("pills")) {
                addNewProduct= new product(productName,qty,price, product.productType.Medical,true,false,
                        false);
            }else {
                addNewProduct= new product(productName,qty,price, product.productType.Others,false,false,
                        false);

            }

        }else {
            if (item.contains("perfume")) {
                addNewProduct = new product(productName, qty, price, product.productType.Imported, false,
                        true, true);
            }else {
                addNewProduct= new product(productName,qty,price, product.productType.Imported,false,
                        true, false);
            }

        }
        return addNewProduct;
    }
}
