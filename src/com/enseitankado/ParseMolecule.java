package com.enseitankado;


import java.util.Map;
import java.util.TreeMap;


public class ParseMolecule {


    public static Map<String, Integer> getAtoms(String formula) {

        TreeMap<String, Integer> resultsTable = new TreeMap<>();

        System.out.println(formula);
        //System.out.println(String.format("|%2$-15s|%3$-30s", " Molecule", " Elemenatry", " Count"));
        int thirdMultiplier = 1;
        int startpoint;
        int endpoint;
        int fourthMultiplier = 1;

        int firstMultiplier = 1;

        if (((Character.isDigit(formula.charAt(0))) || Character.isDigit(formula.charAt(1))) && (Character.isLetter(formula.charAt(1))) || Character.isLetter(formula.charAt(2))) {
            StringBuilder multiplier = new StringBuilder();
            if (Character.isDigit(formula.charAt(0))) {
                multiplier.append(formula.charAt(0));
                formula = formula.substring(1, formula.length());
                firstMultiplier = Integer.parseInt(multiplier.toString());
            }
            if (Character.isDigit(formula.charAt(0))) {
                multiplier.append(formula.charAt(0));
                formula = formula.substring(1, formula.length());
                firstMultiplier = Integer.parseInt(multiplier.toString());
            }
        }


        for (int i = 0; i <= formula.length() - 1; i++) {



            char previousSign;
            char nextNextSign;
            char nextSign;
            char currentSign;

            if (i < 1) {
                previousSign = 0;
            } else {
                previousSign = formula.charAt(i - 1);
            }
            if (i == formula.length() - 2) {
                nextSign = formula.charAt(i + 1);
                nextNextSign = 0;
            } else if (i == formula.length() - 1) {
                nextSign = 0;
                nextNextSign = 0;

            } else {
                nextSign = formula.charAt(i + 1);
                nextNextSign = formula.charAt(i + 2);
            }

            currentSign = formula.charAt(i);

            if(nextSign == ' '){
                System.out.println("found null");
                continue;
            }

            boolean isDigitBefore = Character.isDigit(previousSign);
            boolean isUpperCaseBefore = Character.isUpperCase(previousSign);
            boolean isLowerCaseBefore = Character.isLowerCase(previousSign);

            boolean isNextDigit = Character.isDigit(nextSign);
            boolean isNextNextDigit = Character.isDigit(nextNextSign);
            boolean isNextUpperCase = Character.isUpperCase(nextSign);
            boolean isNextLowerCase = Character.isLowerCase(nextSign);
            boolean isNextLeftBracket = (nextSign == ')');
            boolean isNextRightBracket = (nextSign == '(');


            boolean isCurrentDigit = Character.isDigit(currentSign);
            boolean isCurrentUpperCase = Character.isUpperCase(currentSign);
            boolean isCurrentLowerCase = Character.isLowerCase(nextSign);


            if ((isCurrentUpperCase && (isNextLowerCase || isNextDigit || isNextUpperCase
                    || nextSign == 0 || isNextLeftBracket || isNextRightBracket))

                    ) {
                StringBuilder elementary = new StringBuilder();
                elementary.append(currentSign);
                if (!isNextDigit && !isNextUpperCase && !isNextLeftBracket && !isNextRightBracket) {
                    elementary.append(nextSign);
                }


                int secondMultiplier = 1;
                if (isNextDigit) {

                    secondMultiplier = Character.getNumericValue(nextSign);


                } else if (((isNextNextDigit && isNextLeftBracket) && !isNextUpperCase && (!isNextLeftBracket)) || (isNextNextDigit && !isNextLeftBracket && !isNextUpperCase)) {
                    secondMultiplier = Character.getNumericValue(nextNextSign);
                }

                startpoint = formula.indexOf("(");
                endpoint = formula.indexOf(")");

                if (formula.indexOf(currentSign) > startpoint && startpoint > 0) {
                    thirdMultiplier = Character.getNumericValue(formula.charAt(endpoint + 1));


                }

                // FOURTH MULTIPLIER

                startpoint = formula.indexOf("[");
                endpoint = formula.indexOf("]");

                if (formula.indexOf(currentSign) > startpoint && startpoint > 0) {
                    fourthMultiplier = Character.getNumericValue(formula.charAt(endpoint + 1));


                }

                int result = firstMultiplier * secondMultiplier * thirdMultiplier * fourthMultiplier;

                // Uncomment this line to check 1,2 and 3 multipliers
                // System.out.println("            "+elementary + "." + " -> " + firstMultiplier + " : " + secondMultiplier + " : " + thirdMultiplier);


                String tempElementary = elementary.toString();

                if (!resultsTable.containsKey(tempElementary)) {


                    resultsTable.put(tempElementary, result);

                } else if (resultsTable.containsKey(tempElementary)) {

                    Integer tempInt = resultsTable.get(tempElementary);

                    Integer newValue = result + resultsTable.get(tempElementary);
                    resultsTable.put(tempElementary, newValue);


                } else {
                    System.out.println("Error");
                }

            }


        }
        return resultsTable;

    }
}