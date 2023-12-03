public class Main {
    public static void main(String[] args) {
        CalculatorModel model = new CalculatorModel();
        CalculatorView view = new CalculatorView();
        CalculatorLog calculatorLog = new CalculatorLog();
        CalculatorController controller = new CalculatorController(model, view, calculatorLog);
        controller.runCalculator();
    }
}
