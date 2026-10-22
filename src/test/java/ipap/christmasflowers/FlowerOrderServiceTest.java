package ipap.christmasflowers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlowerOrderServiceTest {
    private final FlowerOrderService service = new FlowerOrderService();

    @Test
    void returnsInitialOrderForZeroDays() throws InvalidDaysException {
        assertEquals("GCV", service.getOrderLetterCodesAfterDays(0));
    }

    @Test
    void returnsExpectedOrderForOneDay() throws InvalidDaysException {
        assertEquals("VGC", service.getOrderLetterCodesAfterDays(1));
    }

    @Test
    void returnsExpectedOrderForFiveDays() throws InvalidDaysException {
        assertEquals("CVG", service.getOrderLetterCodesAfterDays(5));
    }

    @Test
    void orderRepeatsEveryThreeDays() {
        try {
            assertEquals(
                    service.getOrderLetterCodesAfterDays(2),
                    service.getOrderLetterCodesAfterDays(5)
            );
        } catch (InvalidDaysException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void rejectsNegativeDays() {
        assertThrows(
                InvalidDaysException.class,
                () -> service.getOrderAfterDays(-1)
        );
    }
}