package controller;

import org.sqlite.SQLiteDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ShortAnswerCreator {
    SQLiteDataSource myDataSource;
    Connection myConnection;
    Statement myStatement;

    public void establishConnection(final String theURL) {
        try {
            myDataSource = new SQLiteDataSource();
            myDataSource.setUrl(theURL);
            myConnection = myDataSource.getConnection();
            myStatement = myConnection.createStatement();
        } catch (Exception theException) {
            theException.printStackTrace();
            System.exit(0);
        }
    }

    public void createTable(final String theName) {
        final String myQuery = "CREATE TABLE IF NOT EXISTS " + theName + " ( " +
                "QUESTION TEXT NOT NULL, ANSWER TEXT NOT NULL )";

        try {
            myStatement.executeUpdate(myQuery);
        } catch (SQLException theException) {
            theException.printStackTrace();
            System.exit(0);
        }
    }
}
