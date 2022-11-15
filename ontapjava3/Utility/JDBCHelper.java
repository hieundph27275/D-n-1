/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ontapjava3.Utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import ontapjava3.Repository.DBContext;

/**
 *
 * @author Admin
 */
public class JDBCHelper implements AutoCloseable{
    private Connection _connection;
    private PreparedStatement _preparedStatement;
    private ResultSet _resultSet;

    public ResultSet executeQuery(String sql, Object... args) {
        try {
            _connection = DBContext.getConnection();
            _preparedStatement = _connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                _preparedStatement.setObject(i + 1, args[i]);
            }
            _resultSet = _preparedStatement.executeQuery();

        } catch (Exception ex) {
            System.out.println("Lỗi truy vấn câu lệnh: " + sql);
            release(_resultSet, _preparedStatement, _connection);
        }

        return _resultSet;
    }

    @Override
    public void close() {
        release(_resultSet, _preparedStatement, _connection);
    }

    public static Integer executeUpdate(String sql, Object... args) {
        Connection connection = null;
        PreparedStatement preparedstatement = null;
        Integer affectedRows = null;

        try {
            connection = DBContext.getConnection();
            preparedstatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedstatement.setObject(i + 1, args[i]);
            }
            affectedRows = preparedstatement.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Lỗi thực thi câu lệnh: " + sql);
        } finally {
            release(preparedstatement, connection);
        }

        return affectedRows;
    }

    private static void release(Statement statement, Connection connection) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Không đóng được Statement");
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e2) {
                System.out.println("Không đóng được Connection");
            }
        }
    }

    private static void release(ResultSet resultSet,
            Statement statement, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                System.out.println("Không đóng được ResultSet");
            }
        }
        release(statement, connection);
    }
}
