module be.inf1.crossyroads {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires javafx.media;
    
    opens be.inf1.crossyroads to javafx.fxml;
    exports be.inf1.crossyroads;
}
