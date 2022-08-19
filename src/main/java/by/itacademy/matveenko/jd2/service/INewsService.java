package by.itacademy.matveenko.jd2.service;

import java.util.List;

import by.itacademy.matveenko.jd2.bean.News;
import by.itacademy.matveenko.jd2.bean.User;

public interface INewsService {	  
	  List<News> latestList(int count)  throws ServiceException;
	  List<News> newsList(Integer pageNumber, Integer pageSize)  throws ServiceException;
	  News findById(Integer idNews) throws ServiceException;
	  boolean save(News news) throws ServiceException;
	  int update(News news, String login) throws ServiceException;
	  void find(String[] idNewses) throws ServiceException;
	}