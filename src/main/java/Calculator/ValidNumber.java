package Calculator;

public class ValidNumber {

    public ValidNumber() {

    }

    public boolean isNumber(Object o) {
        if (o instanceof Integer) {
            if ((Integer) o < 10 && (Integer) o >= 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean isZero(Object o) {
        if (o instanceof Integer) {
            if ((Integer) o == 0) {
                throw new ArithmeticException("no se puede recibir un cero");
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public int doubleTointeger(Object o) {
        if (o instanceof Double) {
            return ((Double) o).intValue();
        } else {
            return 0;
        }

    }


}
