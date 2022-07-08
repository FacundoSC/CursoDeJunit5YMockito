package mockito;

import Calculator.ValidNumber;

public class Add {
    private ValidNumber validatorNumber;
    private Print print;

    public Add(ValidNumber valid){
      this.validatorNumber =valid;
    }

    public Add(ValidNumber valid, Print imprimir) {
        this.validatorNumber = valid;
        this.print=imprimir;
    }

    public int add(Object a, Object b){
        if(validatorNumber.isNumber(a) && validatorNumber.isNumber(b))
        {
            return (Integer)a + (Integer)b;
        }
        else{
            return -99;
        }
    }

    public int addInt(Object a, Object b){
        return validatorNumber.doubleTointeger(a) + validatorNumber.doubleTointeger(b);
    }

    public void addMessage(Object a, Object b) {
        if(validatorNumber.isNumber(a) && validatorNumber.isNumber(b))
        {
            print.showMessage( (Integer)a + (Integer)b);
        }
        else{

            print.showError();
        }

    }

}
