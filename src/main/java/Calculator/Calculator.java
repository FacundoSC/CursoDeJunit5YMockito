package Calculator;

public class Calculator {
    private Integer a;
    private Integer b;
    private Suma suma;
    private Potencia potencia;

    public Calculator(Suma suma, Potencia potencia){
        this.suma = suma;
        this.potencia = potencia;
    }
    public Integer getA() {
        return a;
    }

    public Integer getB() {
        return b;
    }
    public void setB(Integer b) {
        this.b = b;
    }
    public void setA(Integer a) {
        this.a = a;
    }

    public int add(){
        return suma.operar(a,b);
    }
    public int sub(){
        return a - b;
    }

    public int divide(){
        if( b == 0){
            throw new ArithmeticException("el denominador no puede ser cero");
        }
        else{
            return a/b;
        }
    }

    public void longTimeTask(){
        try {
            Thread.sleep(2000);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    public int potencia(){
        return potencia.operar(a,b);
    }

    public int raiz(){
        return 4;
    }








}
