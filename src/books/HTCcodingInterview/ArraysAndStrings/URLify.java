package books.HTCcodingInterview.ArraysAndStrings;

/**
 * Write a method to replace all spaces in a string with "%20". Assume that the string has
 * sufficient space at the end to hold aditional charaters, and given true length of string.
 *
 * Solution:
 * Time Complexity: O(n) -> iterating for loop
 * Space Complexity: O(n) -> creating new array
 */
public class URLify {

    public static void main(String[] args){
        System.out.println(convertStringtoUrl("Mr John Smith   ", 13));
    }

    public static String convertStringtoUrl(String input, int actualLength){
        int spaceCounter = 0;
        for (int i=0;i<actualLength;i++){
            if(input.charAt(i)==' '){
                spaceCounter++;
            }
        }

        int sizeRequired = actualLength + spaceCounter*2;

        char[] urlString = new char[sizeRequired];
        int count = 0;
        for (int i = 0; i< actualLength;i++) {
            if (input.charAt(i) == ' ') {
                urlString[count++] = '%';
                urlString[count++] = '2';
                urlString[count++] = '0';
            }else{
                urlString[count++] = input.charAt(i);
            }
        }

        return String.valueOf(urlString);
    }
}
