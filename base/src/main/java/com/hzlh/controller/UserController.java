package com.hzlh.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hzlh.entity.User;
import com.hzlh.service.UserService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@RestController
/*
 * 带m的要token令牌才能访问 对应spring-security.xml配置 mobile http configuration
 */
@RequestMapping("/m/user")
@Api(value = "UserController", description = "用户")
public class UserController {
	Logger log = LoggerFactory.getLogger(this.getClass());
	@Resource
	UserService userService;

	@RequestMapping(value = "findAll", method = RequestMethod.GET)
	@ApiOperation(value = "查询所有用户信息", notes = "查询所有用户信息")
	public List<User> findAll(HttpServletRequest request,
			@ApiParam(name = "access_token", value = "令牌") @RequestParam(value = "access_token", required = true) String access_token) {
		log.info("当前请求地址:"+request.getLocalAddr()+":"+request.getLocalPort());
		System.out.println(request.getServerName()+":"+request.getServerPort());
		return userService.findAll();
	}

}