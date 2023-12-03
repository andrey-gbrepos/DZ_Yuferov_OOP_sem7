
import java.util.List;
import java.util.Scanner;
import java.util.Date;

public class CalculatorView {
private Scanner scanner;

public CalculatorView() {
scanner = new Scanner(System.in);
}


/**
 * Приглашение для ввода комплексных чисел
 * @param complxNum
 */
public void inviteEnterComplxNum(List <ComplexNumber> complxNum){ //Номер воводимого числа
     System.out.println();
     for(int i = 1; i < 3; i++){
     ComplexNumber complexNumber = new ComplexNumber();
     System.out.println("Ввод " + i + "-го комплексного числа");
     complexNumber.setRealPart(getUserInput("Введите действительную часть числа: "));
     complexNumber.setImageringPart(getUserInput("Введите мнимую часть числа: ")); 
     complxNum.add(complexNumber); 
 }
     System.out.println();
}
/**
 * Выводит результаты на печать
 * @param operation
 * @param complxNum
 * @return
 */
public String operationtoString (String operation, List <ComplexNumber> complxNum){
     String resultToString;
     System.out.println("Выполнено действие: ");
     System.out.println("1-е компл.число "+complxNum.get(0));
     System.out.println(operation);
     System.out.println("2-е компл.число "+complxNum.get(1));
     System.out.println("---------------------");
     if(operation.equals("/")) System.out.println("Результат: " + 
                                                            complxNum.get(2)
                                                            + "/" + 
                                                            complxNum.get(3));
     else System.out.println("Результат:      " + complxNum.get(2));
     resultToString = "("+complxNum.get(0)+") "+ "("+complxNum.get(1)+") " + "= " + complxNum.get(1);
     System.out.println();
     return resultToString;
     }

/**
 * Получает введенные данные с консоли
 * @param prompt
 * @return
 */   
public Integer getUserInput(String prompt) {
System.out.print(prompt);
Integer tmpVal = 0;
try {   
     tmpVal = Integer.parseInt(scanner.next());  
} catch (Exception e) {
     CalculatorLog calculatorLog = new CalculatorLog();
     Date date = new Date();
     calculatorLog.writeTofile(date.toString() + 
                              "Введено не целочисленное значение. Присвоено значение 0");
     System.out.println("Введено не целочисленное значение. Присвоено значение 0");
}  
 return tmpVal;
}

}