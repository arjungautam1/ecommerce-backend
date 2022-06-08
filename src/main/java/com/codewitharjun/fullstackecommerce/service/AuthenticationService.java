package com.codewitharjun.fullstackecommerce.service;

import com.codewitharjun.fullstackecommerce.model.User;

public interface AuthenticationService {
    User signInAndReturnJWT(User signInRequest);
}
