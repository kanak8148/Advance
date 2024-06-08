package com.ryas.ctl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rays.bean.UserBean;
import com.rays.model.UserModel;

@WebServlet("/LoginCtl")
public class LoginCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String op = req.getParameter("operation");
		HttpSession session = req.getSession();

		if (op != null && op.equals("logout")) {

			session.invalidate();
			req.setAttribute("succ", "User Logout Successfully");
			RequestDispatcher rd = req.getRequestDispatcher("LoginView.jsp");
			rd.forward(req, resp);

		} else {

			resp.sendRedirect("LoginView.jsp");

		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		UserBean bean = new UserBean();
		UserModel model = new UserModel();
		HttpSession session = req.getSession();

		String loginId = req.getParameter("loginId");
		String password = req.getParameter("password");

		try {
			bean = model.authenticate(loginId, password);
			if (bean != null) {

				session.setAttribute("user", bean);
				System.out.println("user Login Successfully");

				RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
				rd.forward(req, resp);

			} else {
				System.out.println("user login id is invalid");
			}
		} catch (Exception e) {
			System.out.println("user login id is invalid");
			e.printStackTrace();
		}

	}

}
