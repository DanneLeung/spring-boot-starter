package com.xcesys.extras.epa.web.api.controller;

import java.util.Date;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xcesys.extras.epa.entity.AppToken;
import com.xcesys.extras.epa.entity.User;
import com.xcesys.extras.epa.repository.AppTokenRepository;
import com.xcesys.extras.epa.service.UserService;
import com.xcesys.extras.framework.core.bean.Result;
import com.xcesys.extras.framework.core.service.ICrudService;

import io.swagger.annotations.Api;

/**
 * 用户数据RESTFUL API
 * 
 * @author danne
 *
 */
@Api(value = "用户数据")
@RestController
@RequestMapping("/api/user")
public class UserApiController extends BaseApiController<User, Long> {
	// @Autowired(required = false)
	// PasswordEncoder passwordEncoder = NoOpPasswordEncoder.getInstance();
	@Autowired
	UserService service;

	@Autowired
	AppTokenRepository appTokenRepository;

	@GetMapping(value = "login")
	public Result<String> login(String username, String password) {
		Result<String> result = new Result<String>(0, "登录成功");
		User user = service.findByUsername(username);
		if (user == null) {
			return new Result<String>(1, "系统中找不到该用户");
		}
		// if (!passwordEncoder.matches(password, user.getPassword())) {
		// return new Result<String>(1, "登录密码错误");
		// }
		UUID token = UUID.randomUUID();
		AppToken appToken = new AppToken(user, token.toString());
		Date now = new Date();
		appToken.setLastLogonTime(now);
		appToken.setTimeout(DateUtils.addSeconds(now, AppToken.TIMEOUT));
		appToken = appTokenRepository.save(appToken);
		result.setContent(appToken.getToken());
		return result;
	}

	@GetMapping(value = "resetpwd")
	public int resetpwd(Long[] ids) {
		if (ids != null && ids.length > 0) {
			return service.resetpwd(ids);
		}
		return -1;
	}

	@GetMapping(value = "unique")
	public boolean unique(String username, String oldUsername) {
		if (!StringUtils.isBlank(oldUsername) && oldUsername.trim().equals(username))
			return true;
		return service.countByUsername(username) <= 0;
	}

	@Override
	protected ICrudService<User, Long> getCrudService() {
		return service;
	}
}
