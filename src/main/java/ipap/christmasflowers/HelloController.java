package ipap.christmasflowers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;

public class HelloController {
    @FXML private TextField daysField;
    @FXML private Label messageLabel;

    @FXML private Circle leftCircle;
    @FXML private Circle centerCircle;
    @FXML private Circle rightCircle;

    @FXML private Label leftName;
    @FXML private Label centerName;
    @FXML private Label rightName;

    private final FlowerOrderService orderService = new FlowerOrderService();
    private FlowerView flowerView;

    @FXML
    private void initialize() {
        flowerView = new FlowerView(
                leftCircle, centerCircle, rightCircle,
                leftName, centerName, rightName
        );

        try {
            flowerView.showOrder(orderService.getOrderAfterDays(0));
        } catch (InvalidDaysException e) {
            messageLabel.setText(e.getMessage());
        }
    }

    @FXML
    private void onCalculateClick() {
        final int days;

        try {
            days = Integer.parseInt(daysField.getText().trim());
        } catch (NumberFormatException e) {
            messageLabel.setText("Введите целое число.");
            return;
        }

        try {
            flowerView.showOrder(orderService.getOrderAfterDays(days));
        } catch (InvalidDaysException e) {
            messageLabel.setText(e.getMessage());
        }
    }
}