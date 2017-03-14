package com.xcesys.extras.framework.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class CookieUtils {

    public static void setCookie(String name, boolean value, HttpServletResponse response) {
        setCookie(name, Boolean.toString(value), response);
    }

    public static void setCookie(String name, String value, HttpServletResponse response) {
        response.addCookie(new Cookie(name, value));
    }
}
