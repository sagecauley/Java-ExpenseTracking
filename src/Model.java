import java.util.ArrayList;
import java.util.List;

public class Model {
    public List<CommonExpense> expenseList = new ArrayList<>();
    public List<CommonIncome> incomeList = new ArrayList<>();

    public Model(){

    }

    public void AddIncome(CommonIncome i){
        incomeList.add(i);
    }

    public void RemoveIncome(CommonIncome i){
        incomeList.remove(i);
    }

    public void AddExpense(CommonExpense e){
        expenseList.add(e);
    }

    public void RemoveExpense(CommonExpense e){
        expenseList.remove(e);
    }
}
