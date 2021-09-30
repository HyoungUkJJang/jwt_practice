package ukjjang.jwt.com;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jwt")
public class JwtController {

    @GetMapping("/hello")
    public ResponseEntity<String> getJwt() {
        return ResponseEntity.ok("hello");
    }

}
