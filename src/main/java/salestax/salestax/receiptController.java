package salestax.salestax;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.scene.control.TextArea;

public class receiptController implements Initializable {

    private final String filePathInput1= "Input 1.txt";
    private final String filePathInput2= "Input 2.txt";
    private final String filePathInput3= "Input 3.txt";
    private fileReader fileReader = new fileReader();
    private receiptCalculation receiptCalculation;
    private ArrayList<product> receiptList = new ArrayList<>();

    @FXML
    private ComboBox<String> comb0;
    @FXML
    private ComboBox<String> comb1;
    @FXML
    private ComboBox<String> comb2;
    @FXML
    private TextArea view;


    /*
    This method will be called when (add Button) is pressed. It takes selected item from the combo box list
    and send it to controller to calculate the receipt and add it to receiptList.
     */
    @FXML
    protected void addItem() {

        view.clear();     // clear Text Area view after adding a product

        receiptCalculation = new receiptCalculation();
        String selectedItem0 = comb0.getValue();
        String selectedItem1 = comb1.getValue();
        String selectedItem2 = comb2.getValue();

        //check which comboBox is selected
        if (selectedItem0!=null) {
            receiptList.add(receiptCalculation.receiptCal(selectedItem0));
        } else if (selectedItem1!=null) {
            receiptList.add(receiptCalculation.receiptCal(selectedItem1));
        }else if (selectedItem2!=null){
            receiptList.add(receiptCalculation.receiptCal(selectedItem2));
        }
    }
    /*
    This method will run when (Submit Button) is pressed. It loops over receiptList ArrayList and print
    the receipt in TextArea view.
     */
    @FXML
    protected void submitItem() {

        double salesTax =0;
        double total=0;
        for (product x: receiptList) {

                salesTax += x.getSalesTax(); //adding each of tax that been added to the product
                total += x.getProductPrice();//add all product prices to get the total

               view.appendText(">"+" "+x.getQuantity() + " " + x.getProductName() + " : " + x.getProductPrice() + "\n");
        }
        view.appendText(">"+" "+"Sales Tax "+" : " + salesTax+ " \n"+">" + "Total"+" : " + total + " \n"  );

        receiptList.clear(); //empty receiptList ArrayList

        // reset all ComboBox to null
        comb0.setValue(null);
        comb1.setValue(null);
        comb2.setValue(null);


    }
    /*
    this method will be called when running the Sales Tax app.
    It sends the Input file name fileReader class to load the items list to ComboBoxes.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        comb0.getItems().addAll(fileReader.readInputFile(filePathInput1));
        comb1.getItems().addAll(fileReader.readInputFile(filePathInput2));
        comb2.getItems().addAll(fileReader.readInputFile(filePathInput3));


    }

}