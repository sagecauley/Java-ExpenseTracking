import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

public class CommonExpense implements ExpenseInterface{
    private String name = null;
    private LocalDate date = null;
    private BigDecimal amount = null;

    /*
    This will take in a name, date, and amount for the expense
     */
    public CommonExpense(String n, LocalDate d, BigDecimal a){
        name = n;
        date = d;
        amount = a;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public LocalDate getDate(){
        return date;
    }

    @Override
    public BigDecimal getAmount(){
        return amount;
    }
}
