package logic.calculation;

import java.io.*;
import java.sql.*;

/**
 * Created by Mark.W on 2017/6/1.
 */
public class DAO {

    private static String DRIVER = "com.mysql.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/quantgee_data";
    private static String USERNAME = "root";
    private static String PASSWORD = "wycg55967568w";

    private static DAO data;

    public static DAO getInstance() {
        if (data == null) {
            data = new DAO();
        }

        return data;
    }

    private static Connection getConn() {
        Connection conn = null;
        try {
            Class.forName(DRIVER);          //classLoader,加载对应驱动
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        assert (conn != null) : "DAO.initConn异常: conn为null";

        return conn;
    }

    public boolean saveBpNet(String code, BpNet bpNet) {
        Connection conn = getConn();
        String sql = "insert into BpNet (code, bpnet) values (?, ?)";
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, code);
            pstmt.setObject(2, bpNet);

            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public BpNet getBpNet(String code) {
        Connection conn = getConn();
        String sql = "select bpnet from BpNet WHERE code = '" + code + "'";
        Statement statement;
        BpNet result = null;
        try {
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if (rs.next()) {
                Blob blob = rs.getBlob("bpnet");
                BufferedInputStream inputStream = new BufferedInputStream(blob.getBinaryStream());

                byte[] bytes = new byte[(int)blob.length()];

                while (-1 != (inputStream.read(bytes, 0, bytes.length)));

                ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bytes));

                result = (BpNet)in.readObject();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return result;
    }
}
