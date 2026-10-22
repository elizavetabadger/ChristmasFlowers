package ipap.christmasflowers;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.List;

public class FlowerView {
    private final Circle leftCircle;
    private final Circle centerCircle;
    private final Circle rightCircle;

    private final Label leftName;
    private final Label centerName;
    private final Label rightName;

    public FlowerView(
            Circle leftCircle,
            Circle centerCircle,
            Circle rightCircle,
            Label leftName,
            Label centerName,
            Label rightName
    ) {
        this.leftCircle = leftCircle;
        this.centerCircle = centerCircle;
        this.rightCircle = rightCircle;
        this.leftName = leftName;
        this.centerName = centerName;
        this.rightName = rightName;
    }

    public void showOrder(List<Flower> flowers) {
        showFlower(leftCircle, leftName, flowers.get(0));
        showFlower(centerCircle, centerName, flowers.get(1));
        showFlower(rightCircle, rightName, flowers.get(2));
    }

    private void showFlower(Circle circle, Label label, Flower flower) {
        circle.setFill(colorFor(flower));
        label.setText(flower.getName() + " (" + flower.getLetterCode() + ")");
    }

    private Color colorFor(Flower flower) {
        return switch (flower) {
            case GERANIUM -> Color.HOTPINK;
            case CROCUS -> Color.MEDIUMSLATEBLUE;
            case VIOLET -> Color.SKYBLUE;
        };
    }
}