package com.example.filters;

import com.example.service.UserAndRoleAndOperationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;


@WebFilter(urlPatterns = "/*",filterName = "reqResFilter")
public class ReqResFilter  implements Filter {

    private Logger log =  LogManager.getLogger(ReqResFilter.class);
    //1,doFilter方法的第一个参数为ServletRequest对象。
    //此对象给过滤器提供了对进入的信息（包括表单数据、cookie和HTTP请求头）的完全访问。
    //第二个参数为ServletResponse，通常在简单的过滤器中忽略此参数。
    //最后一个参数为FilterChain，此参数用来调用servlet或JSP页。
    private  FilterConfig filterConfig;
    private FilterChain chain;
    private  HttpServletRequest request;
    private HttpServletResponse response;


    @Autowired
    UserAndRoleAndOperationService userAndRoleService;


    @Override
    public void destroy() {
        this.filterConfig = null;
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try{
            this.chain = filterChain;
            this.request = (HttpServletRequest) servletRequest;
            //如果处理HTTP请求，并且需要访问诸如getHeader或getCookies等在ServletRequest中无法得到的方法，就要把此request对象构造成HttpServletRequest
            this.response = ((HttpServletResponse) servletResponse);
            String method=request.getMethod();
            if (method.equals("OPTIONS"))
            {
                //因为如果我们自定义了头部的话。浏览器会在发送真实的Get/POST请求前，发送一个OPTIONS请求，来验证一下（这个我们避免不了）。
                //这种情况下我们可以直接返回200。
                //String t_myHeader = httpServletRequest.getHeader("Access-Control-Request-Headers");
                //在这里我们可以看到我们添加的自定的header值"access_token"
                //因为我们不用处理这个值，因此这里直接屏蔽了
                response.setStatus(HttpServletResponse.SC_OK);
                return;
            }
            //处理跨域
            String origin = request.getHeader("Origin");
            System.out.println(origin);
            System.out.println(allowedOrigins.contains(origin));
            System.out.println("--------------------");
            response.setHeader("Access-Control-Allow-Origin",allowedOrigins.contains(origin) ? origin : "");
            response.setHeader("Access-Control-Allow-Credentials", "true");
            response.setHeader("Access-Control-Allow-Methods", "*");
            response.setHeader("Access-Control-Max-Age", "3600");
            // response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
            response.setHeader("Access-Control-Allow-Headers", "Authorization,Origin,X-Requested-With,Content-Type,Accept,"
                    + "content-Type,origin,x-requested-with,content-type,accept,authorization,token,id,X-Custom-Header,X-Cookie,Connection,User-Agent,Cookie,*");
            response.setHeader("Access-Control-Request-Headers", "Authorization,Origin, X-Requested-With,content-Type,Accept");
            response.setHeader("Access-Control-Expose-Headers", "*");
            chain.doFilter(servletRequest, servletResponse);
        }catch (Exception e){
            response.setStatus(HttpServletResponse.SC_OK);
        }

    }

    private final List<String> allowedOrigins = Arrays.asList(
            "http://127.0.0.1:8081",
            "http://127.0.0.1:8080"
            ,"http://localhost:8081"
            ,"http://localhost:8082"
            ,"http://192.168.1.5:8081"
            ,"http://192.168.43.129:8081"
            ,"http://127.0.0.1:8080/breUser/login"
    );



    /**
     * 登录拦截器，查看是否有权限

     */
    void roleFilter(){
        try{
            chain.doFilter(request, response);
        }catch(Exception e){
            e.printStackTrace();
        }


//            // 获取当前页面文件名此处url为：/Gzlkh/login.jsp
//        String url=request.getRequestURI();
//
//
//        // 此处截取的url为：login.jsp
//        url = url.substring(url.lastIndexOf("/") + 1, url.length());
//
//
//        try {
//            if (noFileUrl(url)) {  // 不需要判断权限的请求如登录页面，则跳过
//                chain.doFilter(request, response);
//            } else {
//                // 排除后台不作权限控制的页面名
//                // 登陆页面无需验证文件
//                try{
//                        // 获取网站访问根目录
//                        // String accessPath = request.getContextPath();
//                        //System.out.println(st.getRolename()+st.getUsername()+"-访问-"+url);
//                        // 判断当前user是否拥有访问此url的权限
//                        if(verifyUrl(url, "zhaoyuxing")){
//                            //System.out.println("有权访问！");
//                            chain.doFilter(request, response);
//                        }else{
//                            String  str="{\"status\":\"403\",\"message\":\"无权限！\"}";
//                            returnJson(str);
//                        }
//
//
//                }catch (Exception e){
//                    log.error("HttpSession"+e.toString(),e);
//                    String  str="{\"status\":\"403\",\"message\":\"无权限！\"}";
//                    returnJson(str);
//                }
//            }
//        } catch (Exception sx) {
//            sx.printStackTrace();
//        }
    }


    /**
     * @param url
     *  当前请求的url
     * @param userName
     *  当前登录用户
     * @throws IOException
     * @throws ServletException
     */

    private boolean verifyUrl(String url, String userName)throws IOException, ServletException {

        boolean isSuccess=true;
        try {
            if(!"root".equals(userName)){//root用户拥有所有权限
                String  operId = userAndRoleService.getOpenIdByLink(url);//未配置的action可直接访问
                if(null!=operId && !"".equals(operId)){
                    String rsNum = userAndRoleService.countOpenByLinkAndUser(operId,userName);
                    if("0".equals(rsNum)){
                        isSuccess=false;//未查到用户权限配置，即无权限
                    }else{
                        isSuccess=true;
                    }
                }
            }
        }catch (Exception e){
           log.error("verifyUrl"+e.toString(),e);
        }

        return isSuccess;
    }

    /**
     * 是否需要判断权限,如客户端浏览、登录页面则不需要判断权限
     */

    protected boolean noFileUrl(String url) {

        String[] exclude = {
                "getLoginUser.action",
                "login",
                "logout"
        };

        for(int i=0;i<exclude.length;i++){
            if (exclude[i].indexOf(url)>=0) {
                return true;
            }
        }
        return false;
    }
    private void returnJson(String json) throws Exception{
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        try {
            writer = response.getWriter();
            writer.print(json);

        } catch (IOException e) {
            log.error("response error",e);
        } finally {
            if (writer != null)
                writer.close();
        }
    }

//   void chainDoFilter(){
//       boolean isAjax = "XMLHttpRequest".equals(request.getHeader("x-requested-with"));
//
//
//       HttpSession httpSession = request.getSession(false);
//
//       if(isAjax){
//           if(isValidRequest(httpRequest, httpSession)){
//               chain.doFilter(request, response);
//           }else{
//               returnInvalidMessage(httpRequest, httpResponse);
//           }
//       }else{
//           chain.doFilter(request, response); /* Here is the exception occures */
//       }
//   }

}
