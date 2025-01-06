import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

public class CommonIncome implements IncomeInterface{
    private String name = null;
    private LocalDate date = null;
    private BigDecimal amount = null;

    /*
    This will take in a name, date, and amount for the income
     */
    public CommonIncome(String n, LocalDate d, BigDecimal a){
        name = n;
        date = d;
        amount = a;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public Date getDate(){
        return date;
    }

    @Override
    public BigDecimal getAmount(){
        return amount;
    }
}
