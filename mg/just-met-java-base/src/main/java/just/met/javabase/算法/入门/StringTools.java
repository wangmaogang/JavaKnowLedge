package just.met.javabase.算法.入门;

public class StringTools {

    public static void main(String[] args) {
        System.out.println(isPalindromicString("1112111"));
        System.out.println(isPalindromicString("11122111"));
        System.out.println(isPalindromicString("11121111"));
        System.out.println(isPalindromicString("11112111"));
        System.out.println(isPalindromicString("11"));
        System.out.println(isPalindromicString("1"));
    }

    /**
     * 判定是否为回文字符串 - 1
     * @param s
     * @return
     */
    public static boolean isPalindromicString(String s){
        char[] chars = s.toCharArray();
        for(int i = 0 ;i <s.length()/2;i++){
            if(chars[i] != chars[s.length()-1-i]){
                return false;
            }
        }
        return true;
    }

}
