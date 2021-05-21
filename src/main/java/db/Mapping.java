package db;

import com.saucedemo.dto.CustomerDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Mapping {
    private ConnectionDb connectionDb;
    public Mapping(){connectionDb = new ConnectionDb();}

    public List<CustomerDto> createDTO(){
        List<CustomerDto> customerDtoList = new ArrayList<>();
        String query = "select username, user_lastname, user_zipcode, from testdata_Selenium";
        try {
            Statement statement = connectionDb.driverConnection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                CustomerDto customerDto = new CustomerDto();
                customerDto.setUserName(resultSet.getString("username"));
                customerDto.setUserLastName(resultSet.getString("user_lastname"));
                customerDto.setUserZipCode(resultSet.getString("user_zipcode"));
                createDTO().add(customerDto);
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        connectionDb.closeDriverConnection();
        return customerDtoList;
    }

}
