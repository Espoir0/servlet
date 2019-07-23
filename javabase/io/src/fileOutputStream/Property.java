package fileOutputStream;

import java.util.Properties;
import java.util.Set;

/**
 * java.util.Properties集合 extends HashTable<k,v> implements Map<k,v>
 *     是一个持久性的属性集，可以保存到流中或者从流中加载
 *     是唯一一个可以和IO相结合的 集合
 *
 *     stores 把集合中的临时数据持久化写入到硬盘中存储
 *     load()，把硬盘中保存的文件(键值对),读取到集合中使用
 *
 *     属性列表中的每一个键和对应的值都是字符串
 */
public class Property {
    public static void main(String[] args) {
        test();
    }

    private static void test() {
        //创建 Properties对象
        Properties prop = new Properties();
        //向prop集合中添加属性
        prop.setProperty("aa","19");
        prop.setProperty("bb","19");
        prop.setProperty("cc","19");
        Set<String> keys = prop.stringPropertyNames();

        for (String key : keys) {
            String value = prop.getProperty(key);
            System.out.println(key+": "+value);
        }
    }
}
