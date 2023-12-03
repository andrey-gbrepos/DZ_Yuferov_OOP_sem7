import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CalculatorModel {
    
    public void add(List <ComplexNumber> complexNum) {
       
        ComplexNumber complexNumber = new ComplexNumber();
        complexNumber.setRealPart(complexNum.get(0).getRealPart() 
                                + complexNum.get(1).getRealPart()) ;
        complexNumber.setImageringPart(complexNum.get(0).getImageringPart() 
                                    + complexNum.get(1).getImageringPart());  
        complexNum.add(complexNumber);  
           
    }
    
     public void diff(List <ComplexNumber> complexNum) { 
        ComplexNumber complexNumber = new ComplexNumber();
        complexNumber.setRealPart(complexNum.get(0).getRealPart() 
                                - complexNum.get(1).getRealPart()) ;
        complexNumber.setImageringPart(complexNum.get(0).getImageringPart() 
                                    - complexNum.get(1).getImageringPart());  
        complexNum.add(complexNumber);   
    }
    
    public void multiply(List <ComplexNumber> complexNum) { 
        ComplexNumber complexNumber = new ComplexNumber();
        complexNumber.setRealPart(complexNum.get(0).getRealPart() 
                                * complexNum.get(1).getRealPart() 
                                - complexNum.get(0).getImageringPart()
                                * complexNum.get(1).getImageringPart()) ;
        complexNumber.setImageringPart(complexNum.get(0).getRealPart()  
                                * complexNum.get(1).getImageringPart()
                                + complexNum.get(0).getImageringPart()
                                * complexNum.get(1).getRealPart());
        complexNum.add(complexNumber);   
    }
    
   
    
    public void divide(List <ComplexNumber> complexNum) {
    if (complexNum.get(1).getRealPart() == 0 || 
        complexNum.get(1).getImageringPart() == 0) {
      CalculatorLog calculatorLog = new CalculatorLog();
     Date date = new Date();
     calculatorLog.writeTofile(date.toString() + 
                              "Попытка деления на 0");      
    throw new ArithmeticException("Деление на ноль!");
    } 
    List <ComplexNumber> tempComplexNum = new ArrayList<>(); 
     ComplexNumber conjugate = new ComplexNumber();
     conjugate.setRealPart(complexNum.get(1).getRealPart());
     conjugate.setImageringPart(complexNum.get(1).getImageringPart()*-1);
     tempComplexNum.add(0,complexNum.get(0));
     tempComplexNum.add(conjugate);
     multiply(tempComplexNum);
     complexNum.add(tempComplexNum.get(2));
     tempComplexNum.add(0,complexNum.get(1));
     tempComplexNum.add(1,conjugate);
     multiply(tempComplexNum);
     complexNum.add(tempComplexNum.get(5));
    }
    public void clearingList(List<ComplexNumber> complexNum){
        for (int i = 0; i < complexNum.size(); i++) {
            complexNum.clear();
        }
    }
    }