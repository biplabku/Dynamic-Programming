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

    public static void main(String[] args) {
        System.out.println(getReverseString("my name is biplab"));
    }
}
