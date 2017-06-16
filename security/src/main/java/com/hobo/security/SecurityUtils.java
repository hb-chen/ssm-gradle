package com.hobo.security;

import com.hobo.common.utils.EncryptUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 * 封装一些常用的Shiro操作
 */
public class SecurityUtils{
    public static String getUsername() {
        Subject subject = getSubject();
        if (subject.getPrincipal()!=null){
            return subject.getPrincipal().toString();
        }
        else{
            return null;
        }
    }

    public static Session getSession() {
        return SecurityUtils.getSubject().getSession();
    }

    public static String getSessionId() {
        Session session = getSession();
        if (null == session) {
            return null;
        }
        return getSession().getId().toString();
    }

    public static boolean isAuthenticated() {
        return getSubject().isAuthenticated();
    }

    public static Subject getSubject() {
        return org.apache.shiro.SecurityUtils.getSubject();
    }

    /**
     * 对传入的明文密码进行加密
     */
    public static String entryptPassword(String plainPassword, String salt) {
        byte[] saltByte = EncryptUtils.decodeHex(salt);
        return entryptPassword(plainPassword, saltByte);
    }

    public static String entryptPassword(String plainPassword, byte[] saltByte) {
        byte[] hashPassword = EncryptUtils.sha(plainPassword.getBytes(), saltByte, SecurityConstants.HASH_INTERATIONS);
        return EncryptUtils.encodeHex(hashPassword);
    }

    /**
     * 生成一个随机的Salt,添加用户或者修改用户密码的时候,都会自动生成一个8位的随机数做为密码加密的盐
     */
    public static String generateSalt() {
        return EncryptUtils.generateKey(SecurityConstants.SALT_SIZE);
    }
}
