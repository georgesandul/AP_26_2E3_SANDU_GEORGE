module org.example.lab12 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.lab12 to javafx.fxml;
    exports org.example.lab12;
}