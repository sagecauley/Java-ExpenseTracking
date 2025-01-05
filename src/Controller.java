public class Controller {
    private Model model;
    
    public Controller(Model m){
        model = m;
    }

    public void AddIncome(CommonIncome i){
        model.AddIncome(i);
    }

    public void RemoveIncome(CommonIncome i){
        model.RemoveIncome(i);
    }
    public void RemoveExpense(CommonExpense e){
        model.RemoveExpense(e);
    }

    public void AddExpense(CommonExpense e){
        model.AddExpense(e);
    }
}
