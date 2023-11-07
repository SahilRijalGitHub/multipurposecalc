package mainPackage;
import java.lang.*;
import java.util.*;

public class SplitedListDifferentiation {

    private static String getNewCoeff(String coeff, String multiplier){
        String newCoeff;
        if(multiplier.contains("x")){
            newCoeff = coeff + "(" +  multiplier + ")";
        }
        else{
            newCoeff = Integer.toString(Integer.parseInt(coeff)
                    * Integer.parseInt(multiplier));
            if (!newCoeff.contains("-")){
                newCoeff = "+" + newCoeff;
            }
        }
        return newCoeff;
    }

    private static String getPower(String term){
        String power;
        if ((!(term.contains("(") && term.contains(")")))
                || (!term.substring(term.indexOf("("),
                term.indexOf(")")).contains("x"))){
            power = term.substring(term.indexOf("<") + 1);
        }
        else{
            power = term.substring(term.lastIndexOf("<") + 1);
        }
        power = power.substring(0, power.lastIndexOf(">"));
        return power;
    }

    private static String getNewPower(String power){
        String newPower;
        try{
            newPower = Integer.toString(Integer.parseInt(power) - 1);
        }
        catch(Exception e){
            newPower = power + "-1";
        }
        return newPower;
    }

    private static String getArg(String term){
        String arg;
        arg = term.substring(term.indexOf("[") + 1);
        arg = arg.substring(0, arg.lastIndexOf(']'));
        return arg;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static String mainDiff(ArrayList<String> function){
        StringBuilder sb = new StringBuilder();
        String inFront;
        String inSide;
        int inFrontInt;
        int inSideInt;
        String derivative;
        boolean found;
        ArrayList<String> derivativeList = new ArrayList<String>();
        for (String currentTerm : function) {
            found = false;

            if (currentTerm.contains(")(")
                    && currentTerm.charAt(currentTerm.length() - 1) == ')'){
                try {
                    inFront = currentTerm.substring(0,
                            currentTerm.indexOf("("));
                    if ((inFront.equals("+")) || (inFront.equals("-"))) {
                        inFront = inFront + "1";
                    }
                    inFrontInt = Integer.parseInt(inFront);
                    derivativeList.add(productDiff(currentTerm));
                    found = true;
                }
                catch(Exception ignored){
                }
            }

            if (currentTerm.contains("e") && (!found)){
                try {
                    inFront = currentTerm.substring(0,
                            currentTerm.indexOf("e"));
                    if ((inFront.equals("+")) || (inFront.equals("-"))){
                        inFront = inFront + "1";
                    }
                    inFrontInt = Integer.parseInt(inFront);
                    derivativeList.add(eulersDiff(currentTerm));
                    found = true;
                }
                catch (Exception ignored) {
                }
            }

            if (currentTerm.contains("l")  && (!found)){
                try {
                    inFront = currentTerm.substring(0,
                            currentTerm.indexOf("l"));
                    if ((inFront.equals("+")) || (inFront.equals("-"))){
                        inFront = inFront + "1";
                    }
                    inFrontInt = Integer.parseInt(inFront);
                    derivativeList.add(nLogDiff(currentTerm));
                    found = true;
                }
                catch (Exception ignored) {
                }
            }

            if (currentTerm.contains("s")  && (!found)){
                try {
                    inFront = currentTerm.substring(0,
                            currentTerm.indexOf("s"));
                    if ((inFront.equals("+")) || (inFront.equals("-"))){
                        inFront = inFront + "1";
                    }
                    inFrontInt = Integer.parseInt(inFront);
                    derivativeList.add(sinDiff(currentTerm));
                    found = true;
                }
                catch (Exception ignored) {
                }
            }

            if (currentTerm.contains("c")  && (!found)){
                try {
                    inFront = currentTerm.substring(0,
                            currentTerm.indexOf("c"));
                    if ((inFront.equals("+")) || (inFront.equals("-"))){
                        inFront = inFront + "1";
                    }
                    inFrontInt = Integer.parseInt(inFront);
                    derivativeList.add(cosDiff(currentTerm));
                    found = true;
                }
                catch (Exception ignored) {
                }
            }

            if (currentTerm.contains("t")  && (!found)){
                try {
                    inFront = currentTerm.substring(0,
                            currentTerm.indexOf("t"));
                    if ((inFront.equals("+")) || (inFront.equals("-"))){
                        inFront = inFront + "1";
                    }
                    inFrontInt = Integer.parseInt(inFront);
                    derivativeList.add(tanDiff(currentTerm));
                    found = true;
                }
                catch (Exception ignored) {
                }
            }

            if (currentTerm.contains("(")
                    && currentTerm.contains(")") && (!found)){
                try {
                    inFront = currentTerm.substring(0,
                            currentTerm.indexOf("("));
                    if ((inFront.equals("+")) || (inFront.equals("-"))){
                        inFront = inFront + "1";
                    }
                    inFrontInt = Integer.parseInt(inFront);
                    inSide = currentTerm.substring(currentTerm.
                            indexOf("(") + 1, currentTerm.indexOf(")"));
                    inSideInt = Integer.parseInt(inSide);
                    derivativeList.add(constantToPowerXDiff(currentTerm));
                    found = true;
                }
                catch (Exception ignored) {
                }
            }

            if (currentTerm.contains("(")
                    && currentTerm.contains(")") && (!found)){
                try {
                    inFront = currentTerm.substring(0,
                            currentTerm.indexOf("("));
                    if ((inFront.equals("+")) || (inFront.equals("-"))){
                        inFront = inFront + "1";
                    }
                    inFrontInt = Integer.parseInt(inFront);
                    inSide = currentTerm.substring(currentTerm.
                            lastIndexOf("<") + 1,
                            currentTerm.lastIndexOf(">"));
                    inSideInt = Integer.parseInt(inSide);
                    derivativeList.add(chainedDiff(currentTerm));
                    found = true;
                }
                catch (Exception ignored) {
                }
            }

            if (!found){
                derivativeList.add(normalDiff(currentTerm));
                found = true;
            }
        }
        for (String currentTerm : derivativeList){
            try {
                if ((currentTerm.charAt(1) == '1')
                        && (currentTerm.charAt(2) == '(')) {
                    currentTerm = currentTerm.charAt(0)
                            + currentTerm.substring(2);
                }
            }
            catch(Exception ignored){
            }
            sb.append(currentTerm);
        }
        derivative = sb.toString();
        if (derivative.equals("")){
            derivative = "0";
        }
        try {
            if ((derivative.charAt(1) == '1')
                    && (derivative.charAt(2) == '(')) {
                derivative = derivative.charAt(0)
                        + derivative.substring(2);
            }
        }
        catch (Exception ignored){
        }
        if (derivative.charAt(0) == '+'){
            derivative = derivative.substring(1);
        }
        return derivative;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private static String normalDiff(String currentTerm){
        String derivative;
        String coeff;
        String power;
        String newCoeff;
        String newPower;
        if (!(currentTerm.contains("x"))){
            derivative = "";
            return derivative;
        }
        if (!(currentTerm.contains("<")
                && currentTerm.contains(">"))) {
            coeff = currentTerm.substring(0,
                    currentTerm.indexOf("x"));
            if (coeff.equals("+") || coeff.equals("-")) {
                coeff = coeff + "1";
            }
            derivative = coeff;
        }

        else {
            coeff = currentTerm.substring(0,
                    currentTerm.indexOf("x"));
            power = getPower(currentTerm);
            newPower = getNewPower(power);
            if (coeff.equals("+") || coeff.equals("-")) {
                coeff = coeff + "1";
            }
            newCoeff = getNewCoeff(coeff, power);
            if (newPower.equals("1")) {
                derivative = newCoeff + "x";
            }
            else {
                derivative = newCoeff + "x" + "<" + newPower + ">";
            }
        }
        return derivative;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private static String productDiff(String currentTerm){
        String derivative;
        String coeff;
        String initialBrackets;
        String firstBracket = "";
        String secondBracket = "";
        String firstBracketDiff;
        String secondBracketDiff;
        int inBracketCount = 0;
        boolean firstBracketFound = false;
        if (!currentTerm.contains("x")) {
            derivative = "";
            return derivative;
        }
        coeff = currentTerm.substring(0,
                currentTerm.indexOf("("));
        if (coeff.equals("+") || coeff.equals("-")) {
            coeff = coeff + "1";
        }
        initialBrackets = currentTerm.
                substring(currentTerm.indexOf("("));
        for (int i = 0; i < initialBrackets.length(); i = i + 1){
            if (initialBrackets.charAt(i) == '('){
                inBracketCount = inBracketCount + 1;
            }
            else if (initialBrackets.charAt(i) == ')'){
                inBracketCount = inBracketCount - 1;
            }
            if ((inBracketCount == 0) && (!firstBracketFound)){
                firstBracket = initialBrackets.substring(0, i + 1);
                secondBracket = initialBrackets.substring(i + 1);
                firstBracketFound = true;
            }
        }
        firstBracketDiff = SplitedListDifferentiation.mainDiff
                (PolynomialSplit.PolySplit(firstBracket.
                        substring(1, firstBracket.length() - 1)));
        secondBracketDiff = SplitedListDifferentiation.mainDiff
                (PolynomialSplit.PolySplit(secondBracket.
                        substring(1, secondBracket.length() - 1)));
        derivative = coeff + "(" + secondBracket + "(" + firstBracketDiff + ")"
                + "+" + "(" + secondBracketDiff + ")" + firstBracket + ")";
        return derivative;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private static String eulersDiff(String currentTerm){
        String derivative;
        String power;
        String coeff;
        String eChained;
        String newCoeff;
        if (!currentTerm.contains("x")){
            derivative = "";
            return derivative;
        }
        power = getPower(currentTerm);
        coeff = currentTerm.substring(0,
                currentTerm.indexOf("e"));
        if (coeff.equals("+") || coeff.equals("-")){
            coeff = coeff + "1";
        }
        if (currentTerm.equals("+e<x>")
                || currentTerm.equals("-e<x>")){
            derivative = currentTerm;
        }
        else{
            eChained = SplitedListDifferentiation.
                    mainDiff(PolynomialSplit.PolySplit(power));
            newCoeff = getNewCoeff(coeff, eChained);
            derivative =  newCoeff + "e" + "<" + power + ">";
        }
        return derivative;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private static String constantToPowerXDiff(String currentTerm){
        String derivative;
        String coeff;
        String newCoeff;
        String power;
        String powerChained;
        if (!currentTerm.contains("x")){
            derivative = "";
            return derivative;
        }
        power = getPower(currentTerm);
        coeff = currentTerm.substring(0, currentTerm.indexOf("("));
        if (coeff.equals("+") || coeff.equals("-")){
            coeff = coeff + "1";
        }
        powerChained = SplitedListDifferentiation.
                mainDiff(PolynomialSplit.PolySplit(power));
        newCoeff = getNewCoeff(coeff, powerChained);
        derivative = newCoeff + "(" + currentTerm.
                substring(currentTerm.indexOf("("))
                + ")(l[" + currentTerm.substring(currentTerm.indexOf("(")
                + 1, currentTerm.indexOf(")")) + "])";
        return derivative;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private static String nLogDiff(String currentTerm){
        String derivative;
        String coeff;
        String arg;
        String nLogChained;
        String newCoeff;
        if (!currentTerm.contains("x")) {
            derivative = "";
            return derivative;
        }
        arg = getArg(currentTerm);
        coeff = currentTerm.substring(0, currentTerm.indexOf("l"));
        if (coeff.equals("+") || coeff.equals("-")){
            coeff = coeff + "1";
        }
        if (currentTerm.equals("+l[x]")){
            derivative = "x<-1>";
        }
        else if (currentTerm.equals("-l[x]")){
            derivative = "-x<-1>";
        }
        else{
            nLogChained = SplitedListDifferentiation.
                    mainDiff(PolynomialSplit.PolySplit(arg));
            newCoeff = getNewCoeff(coeff, nLogChained);
            if (arg.equals(newCoeff + "x")){
                derivative = "x<-1>";
            }
            else{
                derivative =  newCoeff + "(" + arg + ")" + "<-1>";
            }
        }
        return derivative;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private static String sinDiff(String currentTerm){
        String derivative;
        String coeff;
        String arg;
        String sinChained;
        String newCoeff;
        if (!currentTerm.contains("x")) {
            derivative = "";
            return derivative;
        }
        arg = getArg(currentTerm);
        coeff = currentTerm.substring(0, currentTerm.indexOf("s"));
        if (coeff.equals("+") || coeff.equals("-")){
            coeff = coeff + "1";
        }
        if (currentTerm.equals("+s[x]")){
            derivative = "c[x]";
        }
        else if (currentTerm.equals("-s[x]")){
            derivative = "-c[x]";
        }
        else{
            sinChained = SplitedListDifferentiation.
                    mainDiff(PolynomialSplit.PolySplit(arg));
            newCoeff = getNewCoeff(coeff, sinChained);
            derivative = newCoeff + "c[" + arg + "]";
        }
        return derivative;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private static String cosDiff(String currentTerm){
        String derivative;
        String coeff;
        String arg;
        String cosChained;
        String newCoeff;
        if (!currentTerm.contains("x")) {
            derivative = "";
            return derivative;
        }
        arg = getArg(currentTerm);
        coeff = currentTerm.substring(0,
                currentTerm.indexOf("c"));
        if (coeff.equals("+") || coeff.equals("-")){
            coeff = coeff + "1";
        }
        if (currentTerm.equals("+c[x]")){
            derivative = "-s[x]";
        }
        else if (currentTerm.equals("-c[x]")){
            derivative = "s[x]";
        }
        else{
            cosChained = SplitedListDifferentiation.
                    mainDiff(PolynomialSplit.PolySplit(arg));
            newCoeff = getNewCoeff(coeff, cosChained);
            if (newCoeff.charAt(0) == '+'){
                newCoeff = "-" + newCoeff.substring(1);
            }
            else if (newCoeff.charAt(0) == '-'){
                newCoeff = "+" + newCoeff.substring(1);
            }
            derivative = newCoeff + "s[" + arg + "]";
        }
        return derivative;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private static String tanDiff(String currentTerm){
        String derivative;
        String coeff;
        String arg;
        String tanChained;
        String newCoeff;
        if (!currentTerm.contains("x")) {
            derivative = "";
            return derivative;
        }
        arg = getArg(currentTerm);
        coeff = currentTerm.substring(0,
                currentTerm.indexOf("t"));
        if (coeff.equals("+") || coeff.equals("-")){
            coeff = coeff + "1";
        }
        if (currentTerm.equals("+t[x]")){
            derivative = "(q[x])<2>";
        }
        else if (currentTerm.equals("-t[x]")){
            derivative = "-(q[x])<2>";
        }
        else{
            tanChained = SplitedListDifferentiation.
                    mainDiff(PolynomialSplit.PolySplit(arg));
            newCoeff = getNewCoeff(coeff, tanChained);
            derivative = newCoeff + "(q[" + arg + "])<2>";
        }
        return derivative;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private static String chainedDiff(String currentTerm){
        String derivative;
        String coeff;
        String newCoeff;
        String chained;
        String power;
        String newPower;
        String fOfX = currentTerm.substring(currentTerm.indexOf("(")
                + 1, currentTerm.lastIndexOf(")"));
        if (!currentTerm.contains("x")) {
            derivative = "";
            return derivative;
        }
        coeff = currentTerm.substring(0,
                currentTerm.indexOf("("));
        if (coeff.equals("+") || coeff.equals("-")){
            coeff = coeff + "1";
        }
        power = getPower(currentTerm);
        newPower = getNewPower(power);
        chained = SplitedListDifferentiation.
                mainDiff(PolynomialSplit.PolySplit(fOfX));
        newCoeff = getNewCoeff(coeff, power);
        newCoeff = getNewCoeff(newCoeff, chained);
        derivative = newCoeff + "(" + fOfX + ")"
                + "<" + newPower + ">";
        return derivative;
    }
}
