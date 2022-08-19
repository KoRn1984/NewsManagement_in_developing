package by.itacademy.matveenko.jd2.controller.impl;

import java.io.IOException;
import java.time.LocalDate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.itacademy.matveenko.jd2.bean.News;
import by.itacademy.matveenko.jd2.controller.Command;
import by.itacademy.matveenko.jd2.controller.JspPageName;
import by.itacademy.matveenko.jd2.controller.NewsParameterName;
import by.itacademy.matveenko.jd2.controller.UserParameterName;
import by.itacademy.matveenko.jd2.service.INewsService;
import by.itacademy.matveenko.jd2.service.ServiceException;
import by.itacademy.matveenko.jd2.service.ServiceProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DoUpdateNews implements Command {
	private final INewsService newsService = ServiceProvider.getInstance().getNewsService();
	private static final Logger log = LogManager.getRootLogger();
		
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter(NewsParameterName.JSP_ID_NEWS);
		String title = request.getParameter(NewsParameterName.JSP_TITLE_NEWS);
	    String brief = request.getParameter(NewsParameterName.JSP_BRIEF_NEWS);
		String content = request.getParameter(NewsParameterName.JSP_CONTENT_NEWS);
		//String dateNews = request.getParameter(NewsParameterName.JSP_DATE_NEWS);
		String idReporter = request.getParameter(NewsParameterName.JSP_DATE_ID_REPORTER);
	    String login = (String) request.getSession().getAttribute(UserParameterName.JSP_LOGIN_PARAM);
	    
	    //News news = new News(Integer.parseInt(id), titleNews, briefNews, contentNews, Integer.parseInt(idReporter));
	    //try {
	    	//newsService.update(news, login);
	    	//response.sendRedirect("controller?command=go_to_news_list&message=News updated!");
	    //} catch (ServiceException e) {
			//log.error(e);
			//response.sendRedirect(JspPageName.ERROR_PAGE);
		//}	    
	}
}