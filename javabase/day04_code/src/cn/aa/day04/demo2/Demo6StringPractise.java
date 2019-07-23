package cn.aa.day04.demo2;
/**
 * 将数组{1,2,3} 按指定格式拼接成字符串，
 * 格式：[word1#word2#word3]
 */
public class Demo6StringPractise {
    public static void main(String[] args) {
        int[] arr={1,2,3};
        System.out.println(splice(arr));
    }

    private static String splice(int[] arr) {
        String s="[";
        for (int i = 0; i < arr.length; i++) {
            if(i==arr.length-1){
                s=s+"word"+arr[i]+"#]";
            }else {
                s = s + "word" + arr[i] + "#";
            }
        }
        return s;
    }
}
