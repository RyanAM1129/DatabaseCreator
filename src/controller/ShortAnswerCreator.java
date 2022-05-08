package controller;

import org.sqlite.SQLiteDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ShortAnswerCreator implements Creator{
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

    public void createTable() {
        final String myQuery = "CREATE TABLE IF NOT EXISTS short_answer" +
                "( QUESTION TEXT NOT NULL, ANSWER TEXT NOT NULL )";

        try {
            myStatement.executeUpdate(myQuery);
        } catch (SQLException theException) {
            theException.printStackTrace();
            System.exit(0);
        }
    }

    public void addRow(final String theQuestion, final String theAnswer) {
        final String myQuery = "INSERT INTO short_answer ( QUESTION, " +
                "ANSWER ) VALUES ( '" + theQuestion + "', '" + theAnswer +
                "' )";
        try {
            myStatement.executeUpdate(myQuery);
        } catch (SQLException theException) {
            theException.printStackTrace();
            System.exit(0);
        }
    }
}
