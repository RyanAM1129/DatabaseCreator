package controller;

import org.sqlite.SQLiteDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class MultipleChoiceCreator implements Creator{
    SQLiteDataSource myDataSource;
    Connection myConnection;
    Statement myStatement;

    public MultipleChoiceCreator() {
        establishConnection("jdbc:sqlite:questions.db");
        createTable();
    }

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
        final String myQuery = "CREATE TABLE IF NOT EXISTS multiple_choice" +
                "( QUESTION TEXT NOT NULL, ANSWER TEXT NOT NULL," +
                "WRONG1 TEXT NOT NULL, WRONG2 TEXT NOT NULL," +
                "WRONG3 TEXT NOT NULL )";

        try {
            myStatement.executeUpdate(myQuery);
        } catch (SQLException theException) {
            theException.printStackTrace();
            System.exit(0);
        }
    }

    public void addRow(final String theQuestion, final String theCorrect,
                       final String theWrong1, final String theWrong2,
                       final String theWrong3) {
        final String myQuery = "INSERT INTO multiple_choice ( QUESTION, " +
                "ANSWER, WRONG1, WRONG2, WRONG3 ) VALUES ( '" + theQuestion +
                "', '" + theCorrect + "', '" + theWrong1 + "', '" +
                theWrong2 + "', '" + theWrong3 + "' )";
        try {
            myStatement.executeUpdate(myQuery);
        } catch (SQLException theException) {
            theException.printStackTrace();
            System.exit(0);
        }
    }
}
