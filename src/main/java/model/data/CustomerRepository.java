package model.data;

import model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public  void insert(Customer customer) throws SQLException {
        String sql ="insert into customer (first_name, last_name, national_code, branch_id) VALUES (?,?,?,?);";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,customer.getFirstName());
        preparedStatement.setString(2,customer.getLastName());
        preparedStatement.setString(3,customer.getNationalCode());
        preparedStatement.setInt(4,customer.getBranch().getBranchId());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public Customer findById(int id)throws SQLException{
        String sql = "SELECT * FROM customer WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        Customer customer = null;
        BankBranchRepository b = new BankBranchRepository();
        if(resultSet.next()){
            customer = new Customer(resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getString("national_code"),
                    b.findById(resultSet.getInt("branch_id")));
        }
        return customer;
    }












}
