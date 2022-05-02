package crud;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/Search")
public class Search extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Search() {}

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        DBConnect cj = new DBConnect();
        List<Pojo> Win = new ArrayList<>();
        try {

            // creating connection object
            // jdbc connection setup
            try {
                Connection connection = cj.getConnection();

                String doc_id = request.getParameter("doc_id");
                String buisness_year = request.getParameter("business_year");
                String cust_number = request.getParameter("cust_number");
                String invoice_id = request.getParameter("invoice_id");
                String query = "select * from winter_internship "
                        + "where doc_id = " + doc_id + " and cust_number = " + cust_number + " "
                        + "and buisness_year = " + buisness_year + " and invoice_id = " + invoice_id;

                Statement s = connection.createStatement();
                ResultSet resultSet = s.executeQuery(query);

                while (resultSet.next()) {
                    Pojo win = new Pojo();

                    // getting data based on column name
                    win.setSlNo(resultSet.getInt("sl_no"));
                    win.setDocID(resultSet.getString("doc_id"));
                    win.setCustNumber(resultSet.getInt("cust_number"));
                    win.setInvoiceID(resultSet.getInt("invoice_id"));
                    win.setBuisnessYear(resultSet.getInt("business_year"));
                    win.setBusinessCode(resultSet.getString("business_code"));
                    win.setPostingDate(resultSet.getDate("posting_date"));
                    win.setDocumentCreateDate(resultSet.getDate("document_create_date"));
                    win.setDueInDate(resultSet.getDate("due_in_date"));
                    win.setInvoiceCurrency(resultSet.getString("invoice_currency"));
                    win.setDocumentType(resultSet.getString("document_type"));
                    win.setPostingID(resultSet.getInt("posting_id"));
                    win.setTotalOpenAmount(resultSet.getDouble("total_open_amount"));
                    win.setBaselineCreateDate(resultSet.getDate("baseline_create_date"));
                    win.setCustPaymentTerms(resultSet.getString("cust_payment_terms"));
                    win.setClearDate(resultSet.getDate("clear_date"));

                    System.out.println(win.toString());
                    Win.add(win);
                }

                // converting list into JSON Data
                GsonBuilder gb = new GsonBuilder();
                Gson g = gb.create();
                String result = g.toJson(Win);

                // setting the response headers
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");

                // sending JSON Data
                PrintWriter writer = response.getWriter();
                writer.print(result);
                writer.flush();
                writer.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}
}