package pl.ing.rekrutacja;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class MainController {
    @Autowired
    ReadinessService readinessService;

    @GetMapping("/ready")
    public ResponseEntity isReady() {
        return readinessService.isReady() ? ResponseEntity.ok().build() : ResponseEntity.internalServerError().build();
    }

    @GetMapping("/")
    public String importantBusinessData() {
        return readinessService.isReady() ? UUID.randomUUID().toString() : "--- not ready yet ---";
    }
}
