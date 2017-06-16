package com.hobo.security;

/**
 * Created by Steven on 2017/3/7.
 */
/**
 * 权限模块的全局定义
 */
public class SecurityConstants {
    public final static String AUTH_TYPE_SSO = "SSO";
    public final static String AUTH_TYPE_FORM = "FORM";
    public final static String AUTH_TYPE_API = "API";

    public final static String HASH_ALGORITHM = "SHA-256";
    public final static int HASH_INTERATIONS = 1024;
    public final static int SALT_SIZE = 8;
}
