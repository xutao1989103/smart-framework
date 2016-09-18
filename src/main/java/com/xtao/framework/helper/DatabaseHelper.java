package com.xtao.framework.helper;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by xutao on 16/9/18.
 */
public final class DatabaseHelper {

    private static final Logger logger = LoggerFactory.getLogger(DatabaseHelper.class);

    private static final ThreadLocal<Connection> connContainer = new ThreadLocal<Connection>();

    public static Connection getConnection() {
        Connection conn;
        try {
            conn = connContainer.get();
            if(conn == null){

            }
        }catch (Exception e){
            logger.error("get database connection error", e);
            throw new RuntimeException(e);
        }
        return conn;
    }

    public static void beginTransaction() {
        Connection conn = getConnection();
        if(conn != null) {
            try {
                conn.setAutoCommit(false);
            }catch (SQLException e){
                logger.error("begin transaction error", e);
                throw new RuntimeException(e);
            }finally {
                connContainer.set(conn);
            }
        }
    }

    public static void commitTransaction() {
        Connection conn = getConnection();
        if (conn != null) {
            try {
                conn.commit();
                conn.close();
            }catch (SQLException e){
                logger.error("commit transaction error", e);
                throw new RuntimeException(e);
            }finally {
                connContainer.remove();
            }

        }
    }

    public static void rollbackTransaction() {
        Connection conn = getConnection();
        if (conn != null) {
            try {
                conn.rollback();
                conn.close();
            }catch (SQLException e){
                logger.error("rollback transaction error", e);
                throw new RuntimeException(e);
            }finally {
                connContainer.remove();
            }

        }
    }
}
