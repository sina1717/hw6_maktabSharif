package model.data;

import model.BankBranch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BankBranchRepository {
        private static Connection connection = MyConnection.connection;

        static {
            String sql ="create table if not exists branch(\n" +
                    "    id serial primary key ,\n" +
                    "    name varchar(255),\n" +
                    "    address varchar(255)\n" +
                    ");";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.execute();
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void insert(BankBranch branch) throws SQLException {
            String sql = "insert into branch (name, address) values (?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,branch.getName());
            preparedStatement.setString(2,branch.getAddress());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        public BankBranch findById(int id) throws SQLException {
            String sql = "select * from branch where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            BankBranch branch = null;
            if(resultSet.next()){
                branch = new BankBranch(resultSet.getInt("id"),resultSet.getString("name"),resultSet.getString("address"));
            }
            return branch;
        }
}
