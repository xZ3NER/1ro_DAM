package SourceCode;

import SourceCode.model.DDBB.JDBC;
import SourceCode.model.classes.Customer;
import SourceCode.view.MenuFrame;

public class MainClass {

    private static JDBC dataBase = new JDBC();

    public static JDBC getDataBase() {
        return dataBase;
    }

    public static void main(String[] args) {
        new MenuFrame();
    }
}
