package ipap.christmasflowers;

import java.util.ArrayList;
import java.util.List;

public class FlowerOrderService {
    private static final List<Flower> INITIAL_ORDER =
            List.of(Flower.GERANIUM, Flower.CROCUS, Flower.VIOLET);

    public List<Flower> getOrderAfterDays(int days) throws InvalidDaysException {
        validateDays(days);

        List<Flower> order = new ArrayList<>(INITIAL_ORDER);

        for (int day = 0; day < days; day++) {
            swap(order, 1, 2); // утром: центральный и правый
            swap(order, 0, 1); // вечером: левый и центральный
        }

        return List.copyOf(order);
    }

    public String getOrderLetterCodesAfterDays(int days) throws InvalidDaysException {
        return getOrderAfterDays(days).stream()
                .map(Flower::getLetterCode)
                .reduce("", String::concat);
    }

    private void validateDays(int days) throws InvalidDaysException {
        if (days < 0) {
            throw new InvalidDaysException("Число дней не может быть отрицательным.");
        }
    }

    private void swap(List<Flower> flowers, int first, int second) {
        Flower temp = flowers.get(first);
        flowers.set(first, flowers.get(second));
        flowers.set(second, temp);
    }
}