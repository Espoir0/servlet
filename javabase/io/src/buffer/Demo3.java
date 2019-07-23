package buffer;

import java.io.*;
import java.util.*;
/**
 * 对文本内容进行排序
 * 1.writeFile():方法向文件中写入乱序的文本行：
 *      1.在list中存储20个序号，然后打乱
 *      2.遍历list写入内容
 *  2.sortFile():
     *  1.读取文件，按行读入，将读到的内容以“ . ” 分割
 *      2.创建Map存储每行文本的序号和文本，创建list存储 序号
     *  3.对list中的字符串序号进行排序
 *      4.遍历list ，按list中的顺序,遍历Map,获取每一个键值对，并拼接为一个文本行
 *          向文件写入排好序的内容并释放资源
 */
public class Demo3 {
    public static void main(String[] args) throws IOException {
        writeFile();
        sortFile();
    }

    private static void sortFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("E:\\test\\12file.txt"));
        BufferedWriter bw = new BufferedWriter((new FileWriter("E:\\test\\12filesort.txt")));

        HashMap<String, String> map = new HashMap<>();
        String line;

        List<String> list = new ArrayList<>();
        while ((line=br.readLine())!=null){
            String[] arr = line.split("\\.");
            map.put(arr[0],arr[1]);
            list.add(arr[0]);
        }
        System.out.println(list);

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int result;
                if (o1.length()==o2.length()){
                    result=o1.charAt(0)-o2.charAt(0);
                    return result==0 ? result=o1.charAt(1)-o2.charAt(1) :result ;
                }else{
                   return o1.length() > o2.length() ? 1 : -1;
                }
            }
        });
        System.out.println(list);

        for (String key : list) {
            String s=key+"."+map.get(key);
            bw.write(s);
            bw.newLine();
        }
        bw.close();
        br.close();
    }

    private static void writeFile() throws IOException {
        /**
         * 在文本中写入20行文字，并在最前面添加序号，乱序写入文本中
         *
         */
        BufferedWriter bw = new BufferedWriter((new FileWriter("E:\\test\\12file.txt")));

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(i+1);
        }
        Collections.shuffle(list);

        String s=null;
        for (int i = 0; i < 20; i++) {
            s=list.get(i)+".我是黑客";
            bw.write(s);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
