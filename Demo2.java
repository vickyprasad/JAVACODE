package test;

import java.io.IOException;
import java.net.http.HttpClient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/searchlink")
public class Demo2 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String query=req.getParameter("searchq");
		resp.sendRedirect("http://google.com/search?q="+query);
	}
}
