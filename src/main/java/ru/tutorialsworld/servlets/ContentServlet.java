package ru.tutorialsworld.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ru.tutorialsworld.models.ArticleModel;
import ru.tutorialsworld.models.entities.Article;

/**
 * Servlet implementation class ContentServlet
 */
@WebServlet("/add_content")
public class ContentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContentServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String contentType = request.getParameter("content-type");
        String articleIdParam = request.getParameter("article-id");
        if ("article".equals(contentType)) {
            String title = request.getParameter("title");
            String url = request.getParameter("url");
            int categoryId = Integer.valueOf(request.getParameter("category"));
            String content = request.getParameter("editor1");
            String userName = (String) request.getSession().getValue("user");
            Article article = null;
            if (!articleIdParam.equals("")) {
                article = ArticleModel.updateArticle(Integer.valueOf(articleIdParam), title, url, categoryId,
                        content, userName);
            } else {
                article = ArticleModel.createArticle(title, url, categoryId,
                        content, userName);

            }
            request.setAttribute("article-save-ok", true);
            request.setAttribute("id", article.getId());
        }
        request.getRequestDispatcher("/add_article.jsp").forward(request,
                response);
    }

}
