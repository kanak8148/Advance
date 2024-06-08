package com.ryas.ctl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.UserBean;
import com.rays.model.UserModel;

@WebServlet("/UserRegistrationCtl")
public class UserRegistrationCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");

		System.out.println("edit id >=" + id);

		UserModel model = new UserModel();

		try {
			UserBean bean = model.findByPk(Integer.parseInt(id));
			req.setAttribute("bean", bean);
			RequestDispatcher rd = req.getRequestDispatcher("UserRegistration.jsp");
			rd.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		UserBean bean = new UserBean();
		UserModel model = new UserModel();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("in userRegistration doPost");

		String op = req.getParameter("operation");
		System.out.println("edit id>>> " + req.getParameter("id"));
		String id = req.getParameter("id");
		System.out.println("String id >= " + id);
		String fname = req.getParameter("firstName");
		String lname = req.getParameter("lastName");
		String loginId = req.getParameter("loginId");
		String password = req.getParameter("password");
		String phoneNo = req.getParameter("phoneNo");
		String dob = req.getParameter("dob");
		String gender = req.getParameter("gender");

		if (fname.equals("")) {

			System.out.println("fname is null");

			req.setAttribute("fname", "First Name is required");

		}

		System.out.println(fname);
		System.out.println(lname);
		System.out.println(loginId);
		System.out.println(password);
		System.out.println(phoneNo);
		System.out.println(dob);
		System.out.println(gender);

		bean.setFirstName(fname);
		bean.setLastName(lname);
		bean.setLoginId(loginId);
		bean.setPassword(password);
		bean.setPhoneNo(phoneNo);
		try {
			bean.setDob(sdf.parse(dob));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bean.setGender(gender);

		if (op.equals("save")) {
			try {
				model.add(bean);
				req.setAttribute("succ", "User added Successfully..!!");
			} catch (Exception e) {
				req.setAttribute("error", "User not added Successfully..!!");
				e.printStackTrace();
			}
		}

		if (op.equals("update")) {
			bean.setId(Integer.parseInt(id));
			try {
				model.update(bean);
				bean = model.findByPk(bean.getId());
				req.setAttribute("succ", "User updated Successfully..!!");
				req.setAttribute("bean", bean);
			} catch (Exception e) {
				req.setAttribute("error", "User updated Successfully..!!");
				e.printStackTrace();
			}

		}
		RequestDispatcher rd = req.getRequestDispatcher("UserRegistration.jsp");
		rd.forward(req, resp);

	}

}
