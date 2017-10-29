package utils;

import data_objects.Products;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBHelper {

    public static List<Float> getProductsCampaignPrice() throws SQLException {
        String query = "SELECT USD FROM `lc_products_campaigns`";
        ResultSet rs = executeQuery(query);
        List<Float> campaignPriceList = new ArrayList<>();

        while (rs.next()){
            campaignPriceList.add(rs.getFloat("USD"));
        }
        return campaignPriceList;
    }

    public static List<Float> getProductsPrice() throws SQLException {
        String query = "SELECT USD FROM `lc_products_prices`";
        ResultSet rs = executeQuery(query);
        List<Float> priceList = new ArrayList<>();

        while (rs.next()) {
            priceList.add(rs.getFloat("USD"));
        }
        return priceList;
    }

    public static List<Products> getProducts() throws SQLException {
        String query = "SELECT * FROM `lc_products`";
        ResultSet rs = executeQuery(query);
        List<Products> result = new ArrayList<>();

        while (rs.next()) {
            Products currentProduct = new Products();
            currentProduct.setId(rs.getString("id"));
            currentProduct.setCode(rs.getString("code"));
            currentProduct.setQuantity(rs.getString("quantity"));
            result.add(currentProduct);
        }

        return result;
    }

    public static List<String> getProductNames() throws SQLException {
        String query = "SELECT name FROM `lc_products_info`";
        ResultSet rs = executeQuery(query);
        List<String> response = new ArrayList<>();

        while (rs.next()) {
            response.add(rs.getString("name"));
        }
        return response;
    }

    private static ResultSet executeQuery(String query) {
        Connection connection = getDatabaseConnection();
        ResultSet response = null;
        try {
            response = connection.prepareStatement(query).executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return response;
    }

    private static Connection getDatabaseConnection() {
        String databaseUrl = PropertyHelper.getProperty("dbUrl");
        String dbUser = PropertyHelper.getProperty("dbUser");
        String dbPassword = PropertyHelper.getProperty("dbPassword");
        Connection connection = null;
        try {
            //DriverManager.getDriver(PropertyHelper.getProperty("dbDriverUrl"));
            connection = DriverManager.getConnection(databaseUrl, dbUser, dbPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
