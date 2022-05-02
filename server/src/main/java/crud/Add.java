package crud;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Reg
 */
@WebServlet("/Add")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBConnect cj = new DBConnect();
    	List<Pojo> Win = new ArrayList<>();
		try {
			Connection conn = cj.getConnection();
			int sl_no= Integer.parseInt(request.getParameter("sl_no")); 
			String business_code = request.getParameter("business_code");
			int cust_number = Integer.parseInt(request.getParameter("cust_number"));
			Date clear_date = java.sql.Date.valueOf(request.getParameter("clear_date"));
			int buisness_year = Integer.parseInt(request.getParameter("business_year"));
			long doc_id = Long.parseLong(request.getParameter("doc_id"));
			Date posting_date = java.sql.Date.valueOf(request.getParameter("posting_date"));
			Date document_create_date = java.sql.Date.valueOf(request.getParameter("document_create_date"));
			Date due_in_date = java.sql.Date.valueOf(request.getParameter("due_in_date"));
			String invoice_currency = request.getParameter("invoice_currency");
			String document_type = request.getParameter("document_type");
			int posting_id = Integer.parseInt(request.getParameter("posting_id"));
			float total_open_amount = Float.parseFloat(request.getParameter("total_open_amount"));
			Date baseline_create_date = java.sql.Date.valueOf(request.getParameter("baseline_create_date"));
			String cust_payment_terms = request.getParameter("cust_payment_terms");
			int invoice_id = Integer.parseInt(request.getParameter("invoice_id"));
			
			PreparedStatement ps= null;
			String query = "insert into winter_internship (sl_no,business_code,cust_number,clear_date,buisness_year,doc_id,posting_date,document_create_date,due_in_date,invoice_currency,document_type,posting_id,total_open_amount,baseline_create_date,cust_payment_terms,invoice_id) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(query);
			ps.setInt(1, sl_no);
			ps.setString(2, business_code);
			ps.setInt(3, cust_number);
			ps.setDate(4, clear_date );
			ps.setInt(5, buisness_year);
			ps.setLong(6, doc_id);
			ps.setDate(7, posting_date);
			ps.setDate(8, document_create_date);
			ps.setDate(9, due_in_date);
			ps.setString(10, invoice_currency);
			ps.setString(11, document_type);
			ps.setInt(12, posting_id);
			ps.setFloat(13, total_open_amount);
			ps.setDate(14, baseline_create_date);
			ps.setString(15, cust_payment_terms);
			ps.setInt(16, invoice_id);
			int count = ps.executeUpdate();
			if(count ==1) {
				response.getWriter().write("Success");
			}else {
				response.getWriter().write("Failure");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}