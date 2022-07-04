module FindFakeNews {
    requires javafx.controls;
    requires javafx.fxml;
	requires org.apache.commons.text;

    opens Project.FindFakeNews to javafx.fxml;
    exports Project.FindFakeNews;
}
