package com.yc.springtest4.jdbcTemplate;

import com.yc.springtest4.datasource.MyDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class JdbcTemplate<T> {
    private DataSource dataSource;  //数据源

    public JdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    //查询方法的模块
    public List<T> executeQuery(String sql,RowMapper<?>rowMapper,Object ... params){
        List<T> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            //获取连接对象
            con = dataSource.getConnection();
            //根据连接对象创建预编译对象
            pstmt = con.prepareStatement(sql); //对一条
            //占位符？设置
            setParams(pstmt,params);
            //查询
            rs = pstmt.executeQuery();
            //循环resultset
            int i =  0;
            while (rs.next()){
                T t = (T)rowMapper.mapper(rs,i);
                i++;
                list.add(t);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (rs!=null){
                try {
                    rs.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if (pstmt!=null){
                try {
                    pstmt.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            ((MyDataSource)dataSource).returnConnection(con);
        }
        return list;
    }

    private void setParams(PreparedStatement pstmt, Object[] params) throws SQLException {
        if (null==params || params.length<=0){
            return;
        }
        for (int i=0;i<params.length;i++){
            pstmt.setObject(i+1,params[i]);   //?从1开始  第一个参数i+1
        }
    }

}
