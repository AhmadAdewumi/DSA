package striversAtoZ.recursion;

public class PalindromicString {
    static boolean palindromicCheck(String s) {
        if (s.isEmpty()) return true;

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            int leftChar = s.charAt(left);
            int rightChar = s.charAt(right);

            if (!Character.isLetterOrDigit(leftChar)) {
                left++;
            } else if (!Character.isLetterOrDigit(rightChar)) {
                right--;
            } else if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)){
                return false;
            } else {
                left++;
                right--;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(palindromicCheck("A man, a plan, a canal: Panama"));
    }
}
