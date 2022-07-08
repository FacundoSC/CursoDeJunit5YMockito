package Calculator;

public class Potencia implements Operacion{
    @Override
    public int operar(int a, int b) {
        return (int) Math.pow(a,b);
    }
}
