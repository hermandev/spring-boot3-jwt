package id.codecorn.springjwt.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import id.codecorn.springjwt.dao.RolesDao;
import id.codecorn.springjwt.dao.UsersDao;
import id.codecorn.springjwt.dto.AuthRequest;
import id.codecorn.springjwt.dto.AuthResponse;
import id.codecorn.springjwt.dto.RegisterRequest;
import id.codecorn.springjwt.entity.Roles;
import id.codecorn.springjwt.entity.Users;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final RolesDao rolesDao;
    private final UsersDao usersDao;

    @Override
    public AuthResponse login(AuthRequest req) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword()));

        var user = usersDao.findByEmail(req.getUsername()).orElseThrow();
        var jwt = jwtService.generateToken(user);
        return AuthResponse.builder()
                .token(jwt)
                .build();
    }

    @Override
    public void register(RegisterRequest req) {
        Roles roles = rolesDao.findByName("USER");
        List<Roles> r = new ArrayList<>();
        r.add(roles);
        var user = Users.builder()
                .firstName(req.getFirstName())
                .lastName(req.getLastName())
                .email(req.getEmail())
                .password(passwordEncoder.encode(req.getPassword()))
                .roles(r)
                .build();
        usersDao.save(user);
    }

}
