package com.company;

public class WordToNumber {
    /**
     * @author Rayan Gendre - highschool student and soon to be university software engineering students
     *
     * The objective of this program is to create an algorithm which follows the number conversion guidline of
     * "get" = 2069, "more" = 5191716, "insight" = 209912231915
     * The program will depend on two methods
     *  - wordToNumber - will contain the algorithm to convert the String to a number
     *  - indexAlphabet - will accept a char and return an int position of the letter in the alphabet
     *
     * Wanted to add a large amount of checks to make sure nothing would be able to make it through the program
     *
     * Improvement of the code below
     *
     * String alphabet = "abcdefghijklmnopqrstuvwxyz";
     *     String input = "insight";
     *     String reverse = new StringBuilder(input).reverse().toString()
     *     for(int i = 0; i < reverse.length(); i++) {
     *         System.out.print(alphabet.indexOf(reverse.charAt(i))+1+i+"");
     *      }
     *
     * @param args
     */


    /**
     * wordToNumber will accept a String and convert it to the appropriate number
     * this method will print out to console
     * @param input - the word being converted
     */

    public String convert(String input) {

        String result = "";

            //utilize the StringBuilders method to reverse input
            String reverse = new StringBuilder(input).reverse().toString().toLowerCase();

            //one iteration for each letter in the word
            //for each letter print (the alphabet index + letter index) and repeat
            for (int i = 0; i < reverse.length(); i++) {
                result += (indexAlphabet(reverse.charAt(i)) + i);
            }

            return result;

    }





    /**
     * indexAlphabet accepts a character and returns an int which coresponds to the character's position in the alphabet
     * contains a check to make sure letter is a character in the alphabet
     * @param letter - char letter of a word
     * @return int index of the letter in the alphabet starting at (a = 1)
     *         - possible returns are 1-24, or -1 character is not a letter
     *
     */

    private int indexAlphabet(char letter){
        final String alphabet = "abcdefghijklmnopqrstuvwxyz";

        //check to make sure that the character is contained in the alphabet before the index is returned
        if (alphabet.indexOf(letter) > -1){
            return alphabet.indexOf(letter) + 1;

        }else{
            //error statement and return of -1
            System.out.println("ERROR: The character entered was not a letter");
            return -1;
        }

    }




    /**
     * the purpose of isAToZ is to check that the String input only contains characters through A-Z, a-z
     * @param name - String input
     * @return boolean expression - true if String contains all letter
     *                            - false if String has characters other than a-z, A-Z
     */

    public boolean isAToZ(String name) {
        return name.matches("[a-zA-Z]+");
    }


}
