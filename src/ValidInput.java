/**
 * Created by Joseph Natel 108470761 CSE 214 HW4 on 7/11/2017.
 */

public class ValidInput {

    public ValidInput() {


    }
    /**
     * A method check if a string is a single non digit non whitespace character.
     *@param input
     * the input given by the user is passed in
     * @return char
     * returns a char if the input was valid
     * @throws IllegalArgumentException
     * throws exception if the input was not valid
     */
    public char checkChar(String input) throws IllegalArgumentException{


        if(input.isEmpty()||Character.isWhitespace(input.charAt(0))||Character.isDigit(input.charAt(0)))
            throw new RuntimeException("Input can not be a whitespace character or a digit or empty");



        return Character.toUpperCase(input.charAt(0));


    }
    /**
     * A method to check if a string input is valid.
     * @param input
     * input from the user that needs to be checked
     *@return input
     * returns input unchanged if the input is valid
     * @throws IllegalArgumentException
     * throws exception if the input is null of an empty string
     */
    public String checkString(String input) throws IllegalArgumentException{
        if(input == null || input == "")
            throw new IllegalArgumentException("You must enter a value");
        return input;
    }
    /**
     * A method to check if an int input is valid.
     *@param input
     * input from that user is passed in as a string in case the user did not input a digit
     *@param max
     * the max value that will be accepted
     *@return value
     * returns -1 if the input is invalid or input as an int if it is valid
     */
//todo make this work better
    public int checkInt(String input, int max){
        //check if int
        if(input.isEmpty()){
            System.out.println("Please enter a value.");
            return -1;

        }
        int length = input.length();
        int i = 0;
        int value = 0;
        while(length > i) {

            if (Character.isDigit(input.charAt(i))) {
                value = Character.getNumericValue( input.charAt(i)) + value * 10 ;
                i++;


            } else {
                System.out.println("Please enter a integer.");
                return -1;

            }

        }

        if(value > max){
            System.out.println("Value is out of acceptable range.");
            return -1;
        }
        else if(value < 0){
            System.out.println("Value can not be negtive");
            return -1;
        }


        return value;

    }

    /**
     * A method to check if the RFID code is a valid format
     * @param input
     * the RFID input by the user
     * @throws IllegalArgumentException
     * throw expection if the input is not a valid RFID number
     */
    //todo test me
    public void checkRFID (String input) throws IllegalArgumentException {

        if(input.length() != 9){
            throw new IllegalArgumentException("RFID must be a 9 digit Hex number");

        }

        for(int i = 0; i<9; i++){
            if(Character.isDigit(input.charAt(i))){
                continue;
            }
            //continue if char is A-F
            else if(input.codePointAt(i) >= 0x41 && input.codePointAt(i) <= 0x46) {
                continue;
            }
            //continue if char is a-f
            else if(input.codePointAt(i) >= 0x61 && input.codePointAt(i) <= 0x66) {
                continue;
            }
            else
                throw  new IllegalArgumentException("RFID must be a 9 digit Hex number");


        }


    }

    /**
     * A method to check if the original location is in a valid format
     * @param input
     * original location given by the user to be checked
     * @throws IllegalArgumentException
     * throws expcetion if the format is not valid
     */
//todo test this
    public void checkOriginalLocation (String input) throws IllegalArgumentException {
        if(input.length() != 6) {
            throw new IllegalArgumentException("Original Location must be of length 6");  //todo make this statement more clear

        }
        if(input.charAt(0) != 's')  {
            throw new IllegalArgumentException("Original Location must start with 's'");
        }
        for(int i = 1; i<input.length(); i++) {
            if(Character.isDigit(input.charAt(1))) {
                continue;
            }else{
                throw new IllegalArgumentException("Original Location must have a 5 digit code");
            }

        }

    }

    /**
     * A method to check if the current location is in a valid format
     * @param input
     * current location given by the user to be checked
     * @return
     * returens current location if it is valid
     * @throws IllegalArgumentException
     * throws expection of the location is not valid
     */

    //todo test this
    public String checkCurrentLocation (String input) throws IllegalArgumentException {
        if(input.equalsIgnoreCase("out"))
            return input;
        if(input.length() != 4) {
            throw new IllegalArgumentException("Original Location must be of length 4");  //todo make this statement more clear

        }
        if(input.charAt(0) != 'c')  {
            throw new IllegalArgumentException("Original Location must start with 'c'");
        }
        for(int i = 1; i<input.length(); i++) {
            if(Character.isDigit(input.charAt(1))) {
                continue;
            }else{
                throw new IllegalArgumentException("Original Location must have a 3 digit code");
            }

        }
        return input;

    }
    public char checkCharLoose(String input) throws IllegalArgumentException{


        if(input.isEmpty()||Character.isWhitespace(input.charAt(0))) {
            throw new RuntimeException("Input can not be a whitespace character or empty");
        }
        if(Character.isDigit(input.charAt(0))){
            return input.charAt(0);
        }else {
            return Character.toUpperCase(input.charAt(0));
        }

    }






}
