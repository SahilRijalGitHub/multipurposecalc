package mainPackage;
import java.util.ArrayList;
public class PolynomialSplit {
    public static ArrayList<String> PolySplit(String function){
        //Initialise variables
        boolean inBracket = false;
        int inBracketCount = 0;
        boolean inPower = false;
        int inPowerCount = 0;
        boolean inFunc = false;
        int inFuncCount = 0;
        char currentChar;
        ArrayList<String> functionList = new ArrayList<>();
        String currentTerm = "";
        //Go through every character to create a list of terms
        for (int i = 0; i < function.length(); i = i + 1){
            currentChar = function.charAt(i);
            if (currentChar == '('){
                inBracket = true;
                inBracketCount = inBracketCount + 1;
            }
            if (currentChar == ')'){
                inBracketCount = inBracketCount - 1;
                if (inBracketCount == 0) {
                    inBracket = false;
                }
            }
            if (currentChar == '<'){
                inPower = true;
                inPowerCount = inPowerCount + 1;
            }
            if (currentChar == '>'){
                inPowerCount = inPowerCount - 1;
                if (inPowerCount == 0) {
                    inPower = false;
                }
            }
            if (currentChar == '['){
                inFunc = true;
                inFuncCount = inFuncCount + 1;
            }
            if (currentChar == ']'){
                inFuncCount = inFuncCount - 1;
                if (inFuncCount == 0) {
                    inFunc = false;
                }
            }
            if ((i == 0) && ((currentChar != '-'))){
                currentTerm = "";
                currentTerm = currentTerm + "+";
                currentTerm = currentTerm + currentChar;
                if (function.length() == 1){
                    functionList.add(currentTerm);
                }
            }
            else if ((currentChar == '-') && (!inBracket) && (!inPower) && (!inFunc)){
                if (!(currentTerm.equals(""))){
                    functionList.add(currentTerm);
                }
                currentTerm = "";
                currentTerm = currentTerm + currentChar;
            }
            else if ((currentChar == '+') && (!inBracket) && (!inPower) && (!inFunc)){
                if (!(currentTerm.equals(""))){
                    functionList.add(currentTerm);
                }
                currentTerm = "";
                currentTerm = currentTerm + currentChar;
            }
            else if (i == function.length() - 1) {
                currentTerm = currentTerm + currentChar;
                functionList.add(currentTerm);
            }
            else{
                currentTerm = currentTerm + currentChar;
            }
        }
        return functionList;
    }
}
