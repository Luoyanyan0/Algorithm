package offer.niuke;

/**
 * @Auther: yanyan.luo
 * @Date: 2019/3/10 09:59
 * @Description:请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class replaceSpace_2 {

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("hello world");
        System.out.println(replaceSpace(str));
    }

    public static String replaceSpace(StringBuffer str) {
        StringBuffer newStr = new StringBuffer();
        for (int i = 0; i < str.length(); i++){
            if (' ' == str.charAt(i)){
                newStr.append("%20");
            }else{
                newStr.append(str.charAt(i));
            }
        }
        return newStr.toString();
    }
}
