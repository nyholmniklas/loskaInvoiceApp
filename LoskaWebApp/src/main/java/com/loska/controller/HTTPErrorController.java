package com.loska.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HTTPErrorController {

    @RequestMapping(value="/errors/404.html")
    public String handle404() {
    	return "errorPageTemplate";
    }
}