import java.util.HashSet;

public class palindromePermutation {


    public boolean getPalindromePermutation(String str) {
        HashSet<Character> unpairedChar = new HashSet<>();
        for(char c : str.toCharArray()) {
            if(unpairedChar.contains(c)) {
                unpairedChar.remove(c);
            }else {
                unpairedChar.add(c);
            }
        }
        return unpairedChar.size() <= 1;
    }

    public static void main(String[] args) {
        String str = "hello ";
        palindromePermutation ss = new palindromePermutation();
        System.out.println(ss.getPalindromePermutation(str));
    }
}
