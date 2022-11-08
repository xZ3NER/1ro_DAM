package SourceCode.model.classes;

import SourceCode.MainClass;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Vector;

import static SourceCode.model.DDBB.IRestaurantSentences.PRODUCT_ID_BY_NAME;
import static SourceCode.model.DDBB.IRestaurantSentences.PRODUCT_PRICE_BY_NAME;

public class Customer {

    private java.lang.String clientID;
    private java.lang.String tableNumber;
    private java.lang.String date;
    private java.lang.String ticketCode;
    private final Vector<java.lang.String> products = new Vector<java.lang.String>();
    private final Vector<Integer> products_amount = new Vector<Integer>();

    public Customer(java.lang.String clientID, java.lang.String tableNumber) {
        this.clientID = clientID;
        this.tableNumber = tableNumber;

        this.ticketCode = RandomTicket();
        this.date = SystemDate();
    }

    private java.lang.String SystemDate() {
        Date date = new Date();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return formatter.format(date);
    }

    private java.lang.String RandomTicket() {
        Random random = new Random();
        java.lang.String ticketCode="";

        for (int i=0;i<4;i++) {
            ticketCode += random.nextInt(5);
        }

        return ticketCode;
    }

    public java.lang.String getClientID() {
        return clientID;
    }

    public void setClientID(java.lang.String clientID) {
        this.clientID = clientID;
    }

    public java.lang.String getTicketCode() {
        return ticketCode;
    }

    public void setTicketCode(java.lang.String ticketCode) {
        this.ticketCode = ticketCode;
    }

    public java.lang.String getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(java.lang.String tableNumber) {
        this.tableNumber = tableNumber;
    }

    public java.lang.String getDate() {
        return date;
    }

    public void setDate(java.lang.String date) {
        this.date = date;
    }

    public Vector<java.lang.String> getProducts() {
        return products;
    }

    public Vector<Integer> getProducts_amount() {
        return products_amount;
    }

    public double Total_Price() throws SQLException {
        ArrayList<Double> productPrices = new ArrayList<>();

        for (java.lang.String product: products) {
            ResultSet price = MainClass.getDataBase().executeQuery(PRODUCT_PRICE_BY_NAME+product+"'");

            while (price.next()) {
                productPrices.add(price.getDouble(1));
            }
        }

        double total=0;

        for (int i=0;i<productPrices.size();i++) {
            total+=products_amount.get(i)*productPrices.get(i);
        }

        return total;
    }

    public void ProductsNameToID() throws SQLException {
        Vector<String> productsClone = (Vector<String>) products.clone();

        products.clear();

        for (java.lang.String product: productsClone) {
            ResultSet productID = MainClass.getDataBase().executeQuery(PRODUCT_ID_BY_NAME+product+"'");

            while (productID.next()) {
                products.add(productID.getString(1));
            }
        }
    }

    public void addProducts(Integer amounts, java.lang.String products) {
        this.products.add(products);
        this.products_amount.add(amounts);
    }
}
