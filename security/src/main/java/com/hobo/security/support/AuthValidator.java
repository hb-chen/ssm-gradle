package com.hobo.security.support;

import java.util.Map;

public abstract class AuthValidator {
    public abstract boolean auth(String username, String password, Map<String, Object> params);
}
