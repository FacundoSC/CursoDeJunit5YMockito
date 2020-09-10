package junit;

public class Calculator {


    public int add(int a , int b){

        return a + b;
    }

    public int sub(int a , int b){

        return a - b;
    }

    public int divide(int a , int b){

        return a/b;
    }

    public int divideByZero(int a , int b){
        if( b == 0){
            throw new ArithmeticException("el denominador no puede ser cero");
        }
        else{
            return a/b;
        }
    }


    public int divideZero(int a , int b){
        if( b == 0){
            throw new ArithmeticException("el denominador no puede ser cero");
        }
        return 0;
    }


    public void longTimeTask(){

         try {
             Thread.sleep(2000);
         }
          catch (Exception e) {
             e.printStackTrace();
         }

    }




}
