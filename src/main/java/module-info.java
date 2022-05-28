module com.example.salestax {
    requires javafx.controls;
    requires javafx.fxml;



    opens salestax.salestax to javafx.fxml;
    exports salestax.salestax;
}