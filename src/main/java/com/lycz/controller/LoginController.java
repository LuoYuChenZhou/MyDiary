package com.lycz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lycz.design.CommonResult;
import com.lycz.design.ToolUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("Login")
public class LoginController {

	@RequestMapping(value = "loginCheck", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject loginCheck(@RequestParam("userName") String userName, @RequestParam("password") String password) {
		CommonResult<String> result = new CommonResult<String>();

		if (ToolUtil.isEmpty(userName) || ToolUtil.isEmpty(password)) {
			result.setData("");
			result.setMsg("请输入用户名和密码！");
			result.setStatus(400);
			return JSONObject.fromObject(result);
		}

		// 做给自己的日记系统，没有用户表,用户名密码保存在配置文件里面
		String loginName = ToolUtil.getProperty("diarySystem.properties", "loginName");
		String loginPwd = ToolUtil.getProperty("diarySystem.properties", "loginPwd");

		if (userName.equals(loginName) && loginPwd.equals(password)) {
			result.setData("");
			result.setMsg("登录成功");
			result.setStatus(200);
		} else {
			result.setData("");
			result.setMsg("用户名或密码错误！");
			result.setStatus(401);
		}

		return JSONObject.fromObject(result);
	}

}
