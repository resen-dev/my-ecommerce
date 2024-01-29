package resendev.my.ecommerce.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import resendev.my.ecommerce.backend.dtos.LoginDTO;
import resendev.my.ecommerce.backend.dtos.RegisterDTO;
import resendev.my.ecommerce.backend.entities.User;
import resendev.my.ecommerce.backend.services.UserService;

@RestController
@RequestMapping(name = "/v1/auth")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginRequest) {
        Authentication authenticationRequest =
                UsernamePasswordAuthenticationToken.unauthenticated(loginRequest.username(), loginRequest.password());

        var auth = authenticationManager.authenticate(authenticationRequest);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterDTO registerDTO){
        User user = new User();

        user.setUsername(registerDTO.username());
        user.setFirstName(registerDTO.firstName());
        user.setLastName(registerDTO.lastName());
        user.setEmail(registerDTO.email());
        user.setPassword(new BCryptPasswordEncoder().encode(registerDTO.password()));

        userService.saveUser(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }
}
