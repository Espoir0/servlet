package fileOutputStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *
 *
 */
public class Hfm {
    public static void main(String[] args)  {
        readFile();
        coding();
    }

    private static void coding() {

    }

    /**
     * 从文本文件读取字符并统计字符出现个数并存入map中
     */
    private static void readFile() {

        HashMap<Character, Integer> map = null;
        try (
                InputStreamReader isr = new InputStreamReader( new FileInputStream("E:\\test\\hfm.txt"),"gbk");
                ){
            int len=0;
            char[] data=new char[1024];
            map = new HashMap<>();

            while ((len=isr.read(data) )!= -1) {
                int count=0;

                for (int i = 0; i < len; i++) {
                    char c=data[i];
                    if (null==map){
                        map.put(c,1);
                    }else if (null==map.get(c)){
                        map.put(c,1);
                    }else {
                        count=map.get(c);
                        count++;
                        map.put(c,count);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(map);
    }
}

class Node{
    int weight;
    int prient,lchild,child;
}

class HfmTree{
    Node node;
}
