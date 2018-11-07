package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.Collection;
import java.util.Map;
 
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

import utils.*;
import Connection.*;
/**
 * Servlet implementation class JDBCFilter
 */
@WebFilter(filterName = "JDBCFilter", urlPatterns = { "" })
public class JDBCFilter implements Filter{

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;        
 
            System.out.println("Open Connection for: " + req.getServletPath());
 
            Connection conn = null;
            try {
                // Tạo đối tượng Connection kết nối database.
                conn = SQLServerConnUtils_SQLJDBC.getConnection("TimetableAssume");
                // Sét tự động commit false, để chủ động điều khiển.
                conn.setAutoCommit(false);
 
                // Lưu trữ đối tượng Connection vào attribute của request.
                MyUtils.storeConnection(request, conn);
 
                // Cho phép request đi tiếp.
                // (Đi tới Filter tiếp theo hoặc đi tới mục tiêu).
                chain.doFilter(request, response);
 
                // Gọi phương thức commit() để hoàn thành giao dịch với DB.
                conn.commit();
            } catch (Exception e) {
                e.printStackTrace();
                throw new ServletException();
            } 
        }

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	

}
