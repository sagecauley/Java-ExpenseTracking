import java.math.BigDecimal;
import java.time.LocalDate;

public interface IncomeInterface {
    String getName();
    BigDecimal getAmount();
    LocalDate getDate();
}
