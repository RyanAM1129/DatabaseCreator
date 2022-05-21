package controller;

import org.sqlite.SQLiteDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TrueFalseCreator implements Creator{
    SQLiteDataSource myDataSource;
    Connection myConnection;
    Statement myStatement;

    public TrueFalseCreator() {
        establishConnection("jdbc:sqlite:questions.db");
        createTable();
    }

    @Override
    public void establishConnection(String theURL) {
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

    @Override
    public void createTable() {
        final String myQuery = "CREATE TABLE IF NOT EXISTS true_false" +
                "( QUESTION TEXT NOT NULL, ANSWER TEXT NOT NULL )";

        try {
            myStatement.executeUpdate(myQuery);
        } catch (SQLException theException) {
            theException.printStackTrace();
            System.exit(0);
        }
    }

    public void addRow(final String theQuestion, final String theAnswer) {
        final String myQuery = "INSERT INTO true_false ( QUESTION, " +
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
