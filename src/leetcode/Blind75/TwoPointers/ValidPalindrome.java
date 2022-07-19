package leetcode.Blind75.TwoPointers;

/**
 * A phrase is a palindrome if, after converting all uppercase letters into
 * lowercase letters and removing all non-alphanumeric characters,
 * it reads the same forward and backward. Alphanumeric characters include letters and numbers.
 *
 * Given a string s, return true if it is a palindrome, or false otherwise.
 */
public class ValidPalindrome {
    public static void main(String[] args) {

        System.out.println(isValid("A man, a plan, a canal: Panama"));
    }

    public static boolean isValid(String s){

        if(s.length()==1 || s.length() == 0){
            return true;
        }
        s = s.toLowerCase();
        for(int i=0, j=s.length()-1;i<j;){
            if(!Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }else if(!Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }else{
                if(s.charAt(i++)!=s.charAt(j--)){
                    return false;
                }
            }
        }

        return true;

    }
}
