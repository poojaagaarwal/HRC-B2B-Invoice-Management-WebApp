package crud;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * servlet implementation class add
 */
@WebServlet("/View")
public class View extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public View() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DBConnect cj = new DBConnect();
        try {

            Connection conn = cj.getConnection();
            Statement st = conn.createStatement();
            String query = "select * from winter_internship where is_deleted=0";
            ResultSet rs = st.executeQuery(query);
            List<Pojo> ar = new ArrayList<>();
            while (rs.next()) {
                Pojo obj = new Pojo();
                obj.setSlNo(rs.getInt("sl_no"));
                obj.setBusinessCode(rs.getString("business_code"));
                obj.setCustNumber(rs.getInt("cust_number"));
                obj.setClearDate(rs.getDate("clear_date"));
                obj.setBuisnessYear(rs.getInt("business_year"));
                obj.setDocID(rs.getString("doc_id"));
                obj.setPostingDate(rs.getDate("posting_date"));
                obj.setDocumentCreateDate(rs.getDate("document_create_date"));
                obj.setDueInDate(rs.getDate("due_in_date"));
                obj.setInvoiceCurrency(rs.getString("invoice_currency"));
                obj.setDocumentType(rs.getString("document_type"));
                obj.setPostingID(rs.getInt("posting_id"));
                obj.setTotalOpenAmount(rs.getDouble("total_open_amount"));
                obj.setBaselineCreateDate(rs.getDate("baseline_create_date"));
                obj.setCustPaymentTerms(rs.getString("cust_payment_terms"));
                obj.setInvoiceID(rs.getInt("invoice_id"));
                obj.setIsOpen(rs.getInt("isOpen"));

                ar.add(obj);

            }
            response.addHeader("Access-Control-Allow-Origin", "*");
            response.addHeader("Access-Control-Allow-Methods","GET, OPTIONS, HEAD, PUT, POST");
            if (request.getMethod().equals("OPTIONS")) {
            	System.out.println("Sent to response!1");
                response.setStatus(HttpServletResponse.SC_ACCEPTED);
            }
            String json = new Gson().toJson(ar);
            try {
            	response.getWriter().write(json);
            } catch(IOException e) {
            	e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}