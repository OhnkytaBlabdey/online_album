package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;
import utility.Global;

/**
 * Servlet Filter implementation class CommentFilter
 */
@WebFilter(urlPatterns="/comment")
public class CommentFilter implements Filter {

    /**
     * Default constructor. 
     */
    public CommentFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		String username = (String) ((HttpServletRequest)request).getSession().getAttribute("username");
		if(username!=null) { // validate
			;
			// check if user name exists in database
			if(!Global.inited)
			{
				Global.conf_path=request.getServletContext().getRealPath(Global.conf);
				Global.inited=true;
			}
			UserService userService=new UserService();
			if(userService.findByUserNameService(username) != null) {
				chain.doFilter(request, response);
			}
		}
		else {
			HttpServletResponse resp=(HttpServletResponse) response;
			resp.sendRedirect("./Login.jsp");
			return;
		}

		// pass the request along the filter chain
		//chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
