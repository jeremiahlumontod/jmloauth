package org.jml.myeis.controller;

import java.util.Collections;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Controller
@RequestMapping("/test/adduser")
public class AuthenticationValidate {
	@Autowired
	BCryptPasswordEncoder b;
	
	@RequestMapping(value="/{username}/{password}", method = RequestMethod.GET)
	public @ResponseBody User getPersonInJSON(@PathVariable("username") String username, @PathVariable("password") String password) {
		//BCryptPasswordEncoder b = new BCryptPasswordEncoder();
		String pw = b.encode(password);
        User user = new User(username, pw, Collections.<GrantedAuthority>emptyList());
        return user;
	}

}
