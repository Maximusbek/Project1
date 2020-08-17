package steps.com.myApp;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.com.myApp.MyAppHomePage;
import utils.ConfigReader;
import utils.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MyAppSteps {

    WebDriver driver = Driver.getDriver();
    MyAppHomePage homePage = new MyAppHomePage();
    List<Map<String,Object>> UIData = new ArrayList<>();
    private String url = "jdbc:oracle:thin:@ec2-13-59-6-225.us-east-2.compute.amazonaws.com:1521:xe";
    private String userName = "hr";
    private String password = "hr";

    @Given("User go to MyApp homepage")
    public void user_go_to_MyApp_homepage()
    {
        driver.get(ConfigReader.getProperty("myAppUrl"));
    }

    @When("User gets data from UI")
    public void user_gets_data_from_UI() throws InterruptedException {
        Map<String,Object> row1 = new LinkedHashMap<>();
        Map<String,Object> row2 = new LinkedHashMap<>();
        Map<String,Object> row3 = new LinkedHashMap<>();
        Map<String,Object> row4 = new LinkedHashMap<>();

        Thread.sleep(2000);
        String[] fields = {"FIRST_NAME","LAST_NAME","EMPLOYEE_ID","JOB_TITLE"};
        for (int i = 0; i < homePage.row1Elements.size(); i++){
            row1.put(fields[i],homePage.row1Elements.get(i).getText());
        }

        for (int i = 0; i < homePage.row2Elements.size(); i++){
            row2.put(fields[i],homePage.row2Elements.get(i).getText());
        }

        for (int i = 0; i < homePage.row3Elements.size(); i++){
            row3.put(fields[i],homePage.row3Elements.get(i).getText());
        }

        for (int i = 0; i < homePage.row4Elements.size(); i++){
            row4.put(fields[i],homePage.row4Elements.get(i).getText());
        }

        UIData.add(row1);
        UIData.add(row2);
        UIData.add(row3);
        UIData.add(row4);

    }

    @Then("User validates UI data with DB")
    public void user_validates_UI_data_with_DB() throws SQLException {
        Connection connection = DriverManager.getConnection(url, userName, password);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSet = statement.executeQuery("Select * From apps");
        resultSet.next();
        DatabaseMetaData databaseMetaData = connection.getMetaData();
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        int columnCount = resultSetMetaData.getColumnCount();

        resultSet.beforeFirst();
        List<Map<String, Object>> data = new ArrayList<>();
        while (resultSet.next()) {
            Map<String, Object> rowData = new LinkedHashMap<>();
            for (int i = 1; i <= columnCount; i++) {
                rowData.put(resultSetMetaData.getColumnName(i), resultSet.getObject(resultSetMetaData.getColumnName(i)));
            }
            data.add(rowData);
        }

        Assert.assertEquals(data.toString(),UIData.toString());
    }


}
