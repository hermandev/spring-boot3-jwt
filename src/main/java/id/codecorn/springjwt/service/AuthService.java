package id.codecorn.springjwt.service;

import id.codecorn.springjwt.dto.AuthRequest;
import id.codecorn.springjwt.dto.AuthResponse;
import id.codecorn.springjwt.dto.RegisterRequest;

public interface AuthService {

    AuthResponse login(AuthRequest req);

    void register(RegisterRequest req);

}
