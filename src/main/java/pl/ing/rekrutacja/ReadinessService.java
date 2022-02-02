package pl.ing.rekrutacja;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class ReadinessService {
    private Boolean isReady;
    private Long startupTime;
    private Long startupDelay;

    @PostConstruct
    public void init() throws InterruptedException {
        this.isReady = false;
        this.startupDelay = 10000L;
        this.startupTime = System.currentTimeMillis();
    }

    public Boolean isReady() {
        Long now = System.currentTimeMillis();
        return now - this.startupTime > startupDelay;
    }
}
