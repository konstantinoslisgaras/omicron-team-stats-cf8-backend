package solipsismal.olympiacosfcapp.config.data;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import solipsismal.olympiacosfcapp.model.Season;
import solipsismal.olympiacosfcapp.repository.SeasonRepository;

@Component
@Order(2)
public class SeasonDataLoader implements CommandLineRunner {

    private final SeasonRepository seasonRepository;

    public SeasonDataLoader(SeasonRepository seasonRepository) {
        this.seasonRepository = seasonRepository;
    }

    @Override
    public void run(String... args) {
        // 2025 - 2026
        seasonRepository.save(new Season(2025, 2026));
    }
}