package bb;

import bb.utils.JDBCUtil;
import org.springframework.jdbc.core.JdbcTemplate;

public class JDBCTemplate {
    public static void main(String[] args) {
        //1.导入jar包
        //2.创建JDBCTemplate 对象
        JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCUtil.getDataSource());

        //3.调用方法
        String sql="update meinv4 set xw=0 where id=5";
        jdbcTemplate.update(sql);
    }

}
