package radiostation.patterns;

// ADAPTER pattern used
public class RoundMathAdapter {

    public static int roundDivisionToInt(int dividend, int divider){
        double result = Math.round( (double) dividend / (double) divider );
        return Double.valueOf(result).intValue(); // (int) result ;
    }

    // ADAPTER pattern used
    public static int floorMultiplyIntByDouble(int a, double b){
        return Double.valueOf(Math.floor((double) a * b)).intValue();
    }
}
