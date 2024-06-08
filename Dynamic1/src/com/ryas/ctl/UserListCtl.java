package com.ryas.ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.UserBean;
import com.rays.model.UserModel;

@WebServlet("/UserListCtl")
public class UserListCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserBean bean = new UserBean();
		UserModel model = new UserModel();

		int pageNo = 1;
		int pageSize = 10;
		RequestDispatcher rd = request.getRequestDispatcher("UserList.jsp");

		try {
			List list = model.search(bean, pageNo, pageSize);

			List nextList = model.search(bean, pageNo + 1, pageSize);

			request.setAttribute("userList", list);
			request.setAttribute("nextUser", nextList);
			request.setAttribute("pageNo", pageNo);

			rd.forward(request, response);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserBean bean = new UserBean();
		UserModel model = new UserModel();

		int pageNo = 1;
		int pageSize = 10;

		pageNo = Integer.parseInt(request.getParameter("pageNo"));

		String op = request.getParameter("operation");

		System.out.println("op>>" + op);

		if (op.equals("search")) {

			String fname = request.getParameter("firstName");
			bean.setFirstName(fname);

		}

		if (op.equals("delete")) {

			String[] ids = request.getParameterValues("ids");

			for (String id : ids) {

				try {
					model.delete(Integer.parseInt(id));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}

		if (op.equals("next")) {

			pageNo++;

		}

		if (op.equals("previous")) {

			pageNo--;

		}

		try {
			List list = model.search(bean, pageNo, pageSize);

			List nextList = model.search(bean, pageNo + 1, pageSize);

			request.setAttribute("userList", list);
			request.setAttribute("nextUser", nextList);
			request.setAttribute("pageNo", pageNo);
			RequestDispatcher rd = request.getRequestDispatcher("UserList.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
