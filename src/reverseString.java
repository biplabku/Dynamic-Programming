import java.util.Collections;
import java.util.HashSet;

public class reverseString {


    // Time complexity - O(N)
    // Space complexity - O(1) - even if its 100 input sze it will still use 3 space which implies
    // it will remain constant irrespective of the input size.

    public static String getReverseString(String str) {
        char[] array = str.toCharArray();
        // reversing the string in place
        char temp;
        int len = str.length() - 1;
        for(int i = 0; i < array.length; i++) {
            temp = str.charAt(i);
            array[i] = str.charAt(len - i);
            array[len - i] = temp;

        }
        return new String(array);
    }

    public static HashSet<String> getPermutation(String str) {
        if(str.length() <= 1) {
            return new HashSet<>(Collections.singletonList(str));
        }

        String stringExceptLastChar = str.substring(0,str.length() - 1);
        char lastChar = str.charAt(str.length() - 1);
        HashSet<String> allPermutationsExceptLast = getPermutation(stringExceptLastChar);

        HashSet<String> permutations = new HashSet<>();
        for(String stringExceptLast : allPermutationsExceptLast) {
            for(int position = 0; position <= stringExceptLastChar.length(); position++) {
                String permutation = stringExceptLast.substring(0, position) + lastChar +
                        stringExceptLast.substring(position);
                permutations.add(permutation);
            }
        }
        return permutations;
    }

    public static void main(String[] args) {
        System.out.println(getReverseString("my name is biplab"));
        System.out.println(getPermutation("Cats"));
    }
}
