package com.sun.fox.uc.server.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 密码帮助类
 */
public class PassWordUtils {

    /**
     * Salt 默认自己添加盐值
     * @param passWord
     * @return
     */
    public static String getBCryptPasswordEncoder( String passWord ) {
        return new BCryptPasswordEncoder(4).encode(passWord);
    }

}
