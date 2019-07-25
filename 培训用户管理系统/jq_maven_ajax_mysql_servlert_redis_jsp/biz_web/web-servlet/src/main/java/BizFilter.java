

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class BizFilter
 */
public class BizFilter implements Filter {

    /**
     * Default constructor. 
     */
    public BizFilter() {
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
		HttpServletRequest hRequest=(HttpServletRequest)request;
		HttpServletResponse hResponse=(HttpServletResponse)response;
        String path=((HttpServletRequest)request).getServletPath();//取得当前路径
        String user_name=(String)hRequest.getSession().getAttribute("user_name");
        String rexp=".*/((login)|(loginCheck)|(Register)|(loginOut)).*";//这是登录和注册的，直接放权通过
        
        //这里进行是否自动登录的判断
        Cookie[] cookies = ((HttpServletRequest) request).getCookies();
        //如果存在了自动登录的cookie但是session里的user数据被删了，就重新创建一个user数据,即关闭了浏览器重新要登录的时候
        if (cookies!= null&&user_name==null) {
        	Cookie autoCookie=new Cookie("autologin","");
                   for (int i = 0; i < cookies.length; i++) {
                       if ("autologin".equalsIgnoreCase(cookies[i].getName())) {
                           autoCookie=cookies[i];
                           break;
                       }
                    }
                   if(autoCookie.getValue()!="") {
                	   ((HttpServletRequest)request).getSession().setAttribute("user_name",autoCookie.getValue());
                	   hResponse.sendRedirect("http://localhost:8888"+hRequest.getContextPath()+"/userMenu.jsp");
                	   
                   }
               }
        
        if(path.matches(rexp)) {
        	chain.doFilter(hRequest, hResponse);
        }else if(user_name==""||user_name==null) {
        	hResponse.sendRedirect("http://localhost:8888"+hRequest.getContextPath()+"/login.jsp");
        	
        }else {
        	chain.doFilter(hRequest, hResponse);
        }
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
