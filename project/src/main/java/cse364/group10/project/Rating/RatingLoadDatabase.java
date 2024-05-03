package cse364.group10.project.Rating;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class RatingLoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(RatingLoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(RatingRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Rating("Ace", "The FirstMovie", 3.4, 5, 6, -1, -1, -1)));
            log.info("Preloading " + repository.save(new Rating("Bill", "ABC", 2.1, 2, 3, 8, -1, -1)));
        };
    }
}
