package bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Balance {
    private final Connection connection;

    public Balance(Connection connection) {
        this.connection = connection;
    }

    public void balance(int id) throws SQLException {
        String sql = "select amount from bank_account where account_num = ? ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int amount = rs.getInt("amount");

            System.out.println("Balance : " + amount);
        }

        rs.close();

    }
}