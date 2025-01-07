
import java.math.BigDecimal;
import java.time.LocalDate;

public interface ExpenseInterface {
    String getName();
    BigDecimal getAmount();
    LocalDate getDate();
}
