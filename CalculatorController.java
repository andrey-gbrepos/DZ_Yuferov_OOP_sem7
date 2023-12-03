import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 * Модуль управления
 */
public class CalculatorController {
    private CalculatorModel model;
    private CalculatorView view;
    private CalculatorLog calculatorLog;
    private Date date = new Date();
    public CalculatorController(CalculatorModel model, 
                                CalculatorView view, 
                                CalculatorLog calculatorLog) {
        this.model = model;
        this.view = view;
        this.calculatorLog = calculatorLog;
        
    }   

    public void runCalculator() {
        List <ComplexNumber> complxNum = new ArrayList<>();
      
        //view.getScanner().close();
        int choice;
        do {
        System.out.println("Выберите операцию:");
        System.out.println("1. Сложение");
        System.out.println("2. Вычитание");
        System.out.println("3. Умножение");
        System.out.println("4. Деление");
        System.out.println("5. Посмотреть историю");
        System.out.println("0. Выход");
        
        choice = view.getUserInput("Введите номер операции: ");
        
        switch (choice) {
        case 1:
        view.inviteEnterComplxNum(complxNum); //Ввод комплексных чисел
        model.add(complxNum);
        calculatorLog.writeTofile(date.toString() + 
                                view.operationtoString("+", complxNum));
        complxNum.clear();
        break;
        case 2:
        view.inviteEnterComplxNum(complxNum); //Ввод комплексных чисел
        model.diff(complxNum);
        calculatorLog.writeTofile(date.toString() + 
                                view.operationtoString("-", complxNum));
        complxNum.clear();
        break;
        case 3:
        view.inviteEnterComplxNum(complxNum); //Ввод комплексных чисел
        model.multiply(complxNum);
        calculatorLog.writeTofile(date.toString() + 
                                view.operationtoString("*", complxNum));
        complxNum.clear();
        break;
        case 4:
        view.inviteEnterComplxNum(complxNum); //Ввод комплексных чисел
        model.divide(complxNum);
        calculatorLog.writeTofile(date.toString() + 
                                view.operationtoString("/", complxNum));
        complxNum.clear();
        break;
        case 5:
        List <String> file = new ArrayList<>();
        try {
            file = calculatorLog.readFromfile();
            }
         catch (IOException e) {
            e.printStackTrace();
        }
            for (int i = 0; i < file.size(); i++) {   
                System.out.println(file.get(i));
            }
        break;
        case 0:
        System.out.println("Программа завершена.");
        break;
        default:
        calculatorLog.writeTofile(date.toString() + 
                                "Неверный выбор. Попробуйте еще раз.");
        System.out.println("Неверный выбор. Попробуйте еще раз.");
        }
        } while (choice != 0);
        }
}

