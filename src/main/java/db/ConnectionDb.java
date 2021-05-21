package db;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDb {
    private String dbServer = "jdbc:mysql://sofka-training.cpxphmd1h1ok.us-east-1.rds.amazonaws.com/testdata_Selenium";
    private String dbUser = "sofka_training";
    private String password ="BZenX643bQHw";
    Connection driverConnection;
    private static final Logger LOGGER = LogManager.getLogger(ConnectionDb.class);
    public Connection ConnectionDb(){
        try {
            Class.forName("com.mysql.Driver");
            driverConnection = DriverManager.getConnection(dbServer,dbUser,password);
            LOGGER.info("successful connection to the database");

        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException throwables){
            throwables.printStackTrace();
            System.out.println("Error al conectar");
        }
        return driverConnection;
    }
    public void closeDriverConnection()   {
        try{

            driverConnection.close();

        }catch(SQLException ex){

            System.out.println("Error al desconectar "+ex);

        }

    }
}
