package com.xtao.framework;

import com.google.common.collect.Maps;
import com.xtao.framework.bean.*;
import com.xtao.framework.enums.RequestMethod;
import com.xtao.framework.helper.BeanHelper;
import com.xtao.framework.helper.ConfigHelper;
import com.xtao.framework.helper.ControllerHelper;
import com.xtao.framework.util.*;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;

/**
 * Created by xutao on 16/9/15.
 */
@WebServlet(urlPatterns = "/*")
public class DispatcherServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        HelperLoader.init();
        ServletContext servletContext = config.getServletContext();
        ServletRegistration jspServlet = servletContext.getServletRegistration("jsp");
        jspServlet.addMapping(ConfigHelper.getAppJspPath() + "*");
        ServletRegistration defaultServlet = servletContext.getServletRegistration("default");
        defaultServlet.addMapping(ConfigHelper.getAppAssetPath() + "*");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //get method and path
        String requestMethod = req.getMethod().toUpperCase();
        String requestPath = req.getPathInfo();
        //get handler
        Handler handler = ControllerHelper.getHandler(RequestMethod.getRequestMethod(requestMethod), requestPath);
        if (handler != null) {
            Object controllerBean = BeanHelper.getBean(handler.getCotrollerClass());
            Map<String, Object> paramMap = Maps.newHashMap();
            Enumeration<String> paramNames = req.getParameterNames();
            while (paramNames.hasMoreElements()) {
                String paramName = paramNames.nextElement();
                String paramValue = req.getParameter(paramName);
                paramMap.put(paramName, paramValue);
            }
            String body = CodecUtil.decodeURL(StreamUtil.getString(req.getInputStream()));
            if (StringUtils.isNotEmpty(body)) {
                String[] params = StringUtils.split(body, "&");
                if (ArrayUtils.isNotEmpty(params)) {
                    for (String param : params) {
                        String[] array = StringUtils.split(param, "=");
                        if (ArrayUtils.isNotEmpty(array) && array.length == 2) {
                            paramMap.put(array[0], array[1]);
                        }
                    }
                }
            }

            Param param = new Param(paramMap);

            // call controller method
            Object result = ReflectionUtil.invokeMethod(controllerBean, handler.getActionMethod(), param);

            //deal result and return
            if (result instanceof View) {
                responseView(req, resp, result);
            } else if (result instanceof Data) {
                Data data = (Data) result;
                Object model = data.getModel();
                if (model != null) {
                    responseJson(resp, model);
                }
            } else {
                responseJson(resp, result);
            }
        }
    }

    private void responseView(HttpServletRequest req, HttpServletResponse resp, Object result) throws ServletException, IOException {
        View view = (View) result;
        String path = view.getPath();
        if (StringUtils.isNotEmpty(path)) {
            if (path.startsWith("/")) {
                resp.sendRedirect(req.getContextPath() + path);
            } else {
                Map<String, Object> model = view.getModel();
                for (Map.Entry<String, Object> entry : model.entrySet()) {
                    req.setAttribute(entry.getKey(), entry.getValue());
                }
                req.getRequestDispatcher(ConfigHelper.getAppJspPath() + path).forward(req, resp);
            }
        }
    }

    private void responseJson(HttpServletResponse resp, Object result) throws IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        String json = JsonUtil.toJosn(result);
        writer.write(json);
        writer.flush();
        writer.close();
    }
}
