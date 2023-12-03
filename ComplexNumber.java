/**
 * Класс для комплексного числа
 */
public class ComplexNumber  {
    private Integer realPart;
    private Integer imageringPart;

   
public ComplexNumber() {
    this.realPart = 0;
    this.imageringPart = 0;
}

public Integer getRealPart() {
    return realPart;
}

public void setRealPart(Integer realPart) {
    this.realPart = realPart;
}

public Integer getImageringPart() {
    return imageringPart;
}

public void setImageringPart(Integer imageringPart) {
    this.imageringPart = imageringPart;
}


@Override
public String toString() {
    String complxNum;
    String imageringNum;
    complxNum = (realPart == 0) ?  "" : 
                realPart.toString();
    if (imageringPart == 0) imageringNum = "";
    else {
        if (imageringPart == 0) imageringNum = "";
        else {if (imageringPart == 1) imageringNum = "+" + "i";
                else if (imageringPart == -1) imageringNum = "-i";
                    else imageringNum = (imageringPart > 0) ? 
                        "+" + imageringPart.toString() +"i":
                        imageringPart.toString() + "i";}
    }
    return complxNum = complxNum + imageringNum ; 
}
       
}


