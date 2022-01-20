package model.data;

import model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerRepository {
    private static Connection connection = MyConnection.connection;
    static {
        String sql = "create table if not exists customer(" +
                "        id serial primary key ," +
                "        first_name varchar(255)," +
                "        last_name varchar(255)," +
                "        national_code char(10)," +
                "        branch_id integer," +
                "        constraint fk_b foreign key (branch_id) references branch(id)" +
                ");";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insert(Customer customer) throws SQLException {
        String sql ="insert into customer (first_name, last_name, national_code, branch_id) VALUES (?,?,?,?);";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,customer.getFirstName());
        preparedStatement.setString(2,customer.getLastName());
        preparedStatement.setString(3,customer.getNationalCode());
        preparedStatement.setInt(4,customer.getBranch().getBranchId());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

//    public












}
