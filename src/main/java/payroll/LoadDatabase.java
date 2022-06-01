package payroll;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {
    public static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository, OrderRepository oRepo) {
        return args -> {
            log.info("Preloading " + repository.save(new Employee("Test", "Testerson", "tester")));
            log.info("Preloading " + repository.save(new Employee("Tess", "Tester", "test writer")));
            log.info("Preloading " + oRepo.save(new Order("Clipboard", Status.IN_PROGRESS)));
            log.info("Preloading " + oRepo.save(new Order("Fake mustache", Status.COMPLETED)));
        };
    }

}
