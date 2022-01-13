import java.util.Scanner;
import java.util.Arrays;
public class SimpleAlgebraicExpressionSolver {

    static Scanner input = new Scanner(System.in);
    static int lengthArr=-1;
    static char[] expressionChar;
    static char charInUse;
    static int i=-1;
    public static void main(String[] args) {

         System.out.println("Enter your expression: ");
         String expressionIn = input.nextLine();
         System.out.print("your expression is :  " + expressionIn + "\n\nThe output = ");
         expressionChar=expressionIn.toCharArray();
         System.out.print(solveAddSub());
    }
        static double solve () {
                double result = 0;
                i = -1;
                getChar();
                int startPos = lengthArr;
                if (charInUse == '('){
                    invalid();
                    result=solveAddSub();
                    getChar();
                }
                if (charInUse >= '0' && charInUse <= '9') {
                    while (charInUse >= '0' && charInUse <= '9')
                        getChar();
                    result = Double.parseDouble(String.valueOf(expressionChar, startPos, i));
                }
                if (charInUse == '^') {
                    result = Math.pow(result, solve());
                }
                invalid();
                return result;
    }
        static void getChar () {
            i++;
            if (++lengthArr < expressionChar.length) {
                charInUse = expressionChar[lengthArr];
            } else charInUse = ' ';
        }
        static double solveMultiDivid () {
            double result = solve();
            while (true){
                if (charInUse == '*')
                      result *= solve();
                else if (charInUse == '/')
                      result /= solve();
                else return result;
            }
        }
        static double solveAddSub () {
            double result = solveMultiDivid();
            while (true) {
                if (charInUse == '+')
                    result += solveMultiDivid();
                else if (charInUse == '-')
                    result -= solveMultiDivid();
                else return result;
            }
        }
    static void invalid(){
        if (charInUse == ')' || charInUse=='('){
            String exprString= Arrays.toString(expressionChar);
            if (!exprString.contains("(") || !exprString.contains(")")){
                System.out.println("invalid expression");
                System.exit(-1);
            }
        }

    }
}