package cse364.group10.project.Review;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadReviewDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadReviewDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ReviewRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Review("James", "The View", 3.4, "This is so funny.")));
            log.info("Preloading " + repository.save(new Review("Peter", "UNIST", 2.1, "This is so funny.")));
        };
    }
}
