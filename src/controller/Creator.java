package controller;

public interface Creator {
    void establishConnection(final String theURL);
    void createTable();
}
