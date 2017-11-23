package com.xhx.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.xhx.froms.UserForm;


public class LoginAction extends Action{

	@Override
	public ActionForward execute (ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response ) throws Exception{
		
		 // 把form转成对应的UserForm对象
        UserForm userForm = (UserForm)form;
        //ActionErrors errors = new ActionErrors();
        System.out.println("用户名="+userForm.getUsername());
        System.out.println("密码="+userForm.getPassword());
        // 简单验证
        if("123".equals(userForm.getPassword())){
            // 如果用户密码为123，则为合法
        	request.setAttribute("userForm", userForm);
            return mapping.findForward("ok");
        }else{
            return mapping.findForward("error");
        }
		
	}
}
