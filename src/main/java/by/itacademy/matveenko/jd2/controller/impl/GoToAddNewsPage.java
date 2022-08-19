package by.itacademy.matveenko.jd2.controller.impl;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.itacademy.matveenko.jd2.bean.ConnectorStatus;
import by.itacademy.matveenko.jd2.controller.AttributsName;
import by.itacademy.matveenko.jd2.controller.Command;
import by.itacademy.matveenko.jd2.controller.JspPageName;
import by.itacademy.matveenko.jd2.service.INewsService;
import by.itacademy.matveenko.jd2.service.IUserService;
import by.itacademy.matveenko.jd2.service.ServiceProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class GoToAddNewsPage implements Command {	
	//private final IUserService service = ServiceProvider.getInstance().getUserService();
	//private final INewsService newsService = ServiceProvider.getInstance().getNewsService();
	//private static final Logger log = LogManager.getRootLogger();
	public static final String ADD_NEWS = "addNews";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		HttpSession getSession = request.getSession(true);		
		getSession.setAttribute(AttributsName.USER, ConnectorStatus.ACTIVE);
		//getSession.setAttribute(AttributsKey.ROLE, UsersRole.ADMIN.getTitle());
		//getSession.removeAttribute(AttributsKey.REG_USER);
		getSession.setAttribute(AttributsName.NEWS_COMMANDS_NAME, ADD_NEWS);
		request.getRequestDispatcher(JspPageName.BASELAYOUT_PAGE).forward(request, response);
		//response.sendRedirect("controller?command=go_to_base_page&addnews=active");
	}
}