module FindFakeNews {
    requires javafx.controls;
    requires javafx.fxml;

    opens Project.FindFakeNews to javafx.fxml;
    exports Project.FindFakeNews;
}
