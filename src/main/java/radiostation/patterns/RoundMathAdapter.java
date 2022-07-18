package radiostation.patterns;

public class RoundMathAdapter {

    // ADAPTER pattern used
    public static int roundDivisionToInt(int dividend, int divider){
        double a = (double) dividend;
        double b = (double) divider;
        double result = Math.round( a / b );
        return Double.valueOf(result).intValue(); // (int) result ;

    }
}
