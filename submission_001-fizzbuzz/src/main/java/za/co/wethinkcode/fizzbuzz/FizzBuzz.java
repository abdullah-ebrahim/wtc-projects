package za.co.wethinkcode.fizzbuzz;

public class FizzBuzz {
    public String checkNumber(int number) {
        boolean divisibleBy3 = number % 3 == 0;
        boolean divisibleBy5 = number % 5 == 0;

        if ( divisibleBy3 && divisibleBy5 ) {
            return "FizzBuzz";
        } else if ( divisibleBy5) {
            return "Buzz";
        } else if ( divisibleBy3) {
            return "Fizz";
        } else {
            return String.valueOf(number);
        }
    }

    public String arrayToString(String[] array){
//        convert array to string
        String listString = "";
        for (String s: array) {
            listString += s;
        }
        return listString;
    }

    public String countTo(int number) {
//        for loop that loops to number given
        String[] array = new String[number];
        for (int i = 1; i <= number; i++) {
            if (i == 1) {
                array[i-1] = "[" + checkNumber(i) + ", ";
            } else if (i == number) {
                array[i-1] = checkNumber(i) + "]";
            } else {
                array[i-1] = checkNumber(i) + ", ";
            }
        }
        return arrayToString(array);
    }
    public static void main(String[] args){
        FizzBuzz fizzbuzz = new FizzBuzz();
        System.out.println(fizzbuzz.countTo(15));
    }
}