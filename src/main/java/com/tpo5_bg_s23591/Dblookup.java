package com.tpo5_bg_s23591;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Dblookup", value = "/Dblookup")
public class Dblookup extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String out = searchForCars(
                (String) request.getAttribute("cBrand"),
                (String) request.getAttribute("cModel"),
                (String) request.getAttribute("cProd"),
                (String) request.getAttribute("cFuel"),
                (String) request.getAttribute("cMileage"),
                (String) request.getAttribute("cType")

        );

        request.setAttribute("out",out);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Table");
        requestDispatcher.forward(request,response);


    }

    public String searchForCars(String brand, String model, String prodyear, String fuelcons,String mileage, String type){

        List<Car> resultList = new ArrayList<>();

        String query = "SELECT * FROM Car WHERE ";

        if (!brand.isEmpty()){
            query += "Brand = '" + brand + "' AND ";
        }
        if (!model.isEmpty()){
            query += "Model = '" + model + "' AND ";
        }
        if (!prodyear.isEmpty()){
            query += "ProdYear = " + prodyear + " AND ";
        }
        if (!fuelcons.isEmpty()){
            query += "FuelCons = " + fuelcons + " AND ";
        }
        if (!mileage.isEmpty()){
            query += "Milage = " + mileage + " AND ";
        }
        if (!type.isEmpty()){
            query += "Type = '" + type + "' AND ";
        }

        query = query.substring(0,query.length()-4);

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://gralux.pl:3306/mgglrbib_bart","mgglrbib_bart", "Babel123#");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                resultList.add(new Car(
                        resultSet.getString("Brand"),
                        resultSet.getString("Model"),
                        resultSet.getInt("ProdYear"),
                        resultSet.getInt("FuelCons"),
                        resultSet.getInt("Milage"),
                        resultSet.getString("Type")

                ));
            }
            connection.close();
            statement.close();
            resultSet.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (resultList.isEmpty()){
            return "<h1> No matches found </h1>";
        }

        String resultString =
                "<center>" +
                        "<table style = \"text-align\": center border = \"1\">" +
                        "<tr>" +
                        "<th>Type</th>" +
                        "<th>Brand</th>" +
                        "<th>Model</th>" +
                        "<th>Production Year</th>" +
                        "<th>Fuel Consumption L/100km</th>" +
                        "<th>Mileage</th>" +
                        "</tr>";

        for (Car c : resultList){
            resultString = resultString + "<tr>" +
                    "<td>" + c.getType() + " </td>" +
                    "<td>" + c.getBrand() + " </td>" +
                    "<td>" + c.getModel() + " </td>" +
                    "<td>" + c.getProdyear() + " </td>" +
                    "<td>" + c.getFuelcons() + " </td>" +
                    "<td>" + c.getMileage() + " </td>" + "</tr>";
        }

        resultString = resultString + "</table></center>";

        return resultString;


    }
}
