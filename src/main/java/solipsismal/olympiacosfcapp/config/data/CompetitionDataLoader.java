package solipsismal.olympiacosfcapp.config.data;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import solipsismal.olympiacosfcapp.model.Competition;
import solipsismal.olympiacosfcapp.repository.CompetitionRepository;

import java.util.List;

@Component
@Order(6)
public class CompetitionDataLoader implements CommandLineRunner {

    private final CompetitionRepository competitionRepository;

    public CompetitionDataLoader(CompetitionRepository competitionRepository) {
        this.competitionRepository = competitionRepository;
    }

    @Override
    public void run(String... args) {
        competitionRepository.saveAll(List.of(
                new Competition("CO49863283", "Greek Super League", 48,
                        "Super League Greece is the top-tier professional football division in Greece, originating from the Panhellenic Championship and established in its modern form in 1959. It features 14 clubs competing annually under the Hellenic Football Federation, with promotion and relegation to the lower tiers. The league is known for its fierce rivalries, passionate supporters, and its dominance by a few historic teams that have shaped Greek football’s legacy. As of the 2024–2025 season, the most successful clubs are Olympiacos with 48 titles, Panathinaikos with 20, AEK Athens with 13, PAOK Thessaloniki with 4, and Aris Thessaloniki with 3."),
                new Competition("CO53612495", "Greek Football Cup", 29,
                        "Greek Football Cup is the premier domestic knockout tournament in Greece, organized annually by the Hellenic Football Federation since 1931. It brings together clubs from all professional divisions and often delivers dramatic matches and surprise finalists. The competition holds great prestige as its winner secures a place in European competition, adding to the intensity of each edition. Known for passionate finals and fierce rivalries, the Cup has seen many unforgettable moments in Greek football history. As of the 2024–2025 season, the most successful clubs are Olympiacos with 29 titles, Panathinaikos with 19, AEK Athens with 16, PAOK Thessaloniki with 8, and Panionios with 2.",
                        false),
                new Competition("CO69590241", "Greek Super Cup", 5,
                        "Greek Super Cup is a single-match competition between the reigning champions of the Super League Greece and the winners of the Greek Football Cup. First contested in 1980, it symbolizes national supremacy by pitting the season’s best teams against each other. Although not held every year, the Super Cup has gained recognition for marking the traditional opening of the Greek football season and for the rivalries it reignites. As of the 2024–2025 season, the leading winners are Olympiacos with 4 titles, Panathinaikos with 3, AEK Athens with 3, PAOK Thessaloniki with 2, and Larissa with 1.",
                false),
                new Competition("CO15230140", "UEFA Champions League", 0,
                        "UEFA Champions League is Europe’s most prestigious annual football competition, organized by UEFA and contested by top clubs from domestic leagues across the continent. Established in 1955 as the European Cup and rebranded in 1992, it has become the ultimate stage for football excellence, culminating in a single-match final watched worldwide. Participation is a mark of prestige for Greek clubs, most notably Olympiacos, Panathinaikos, and AEK Athens. As of the 2024–2025 season, the top five titleholders are Real Madrid with 15 championships, AC Milan with 7, Bayern Munich with 6, Liverpool with 6, and Barcelona with 5."),
                new Competition("CO20421975", "UEFA Europa League", 0,
                        "The UEFA Europa League is Europe’s secondary club football competition, organised annually by UEFA since 1971 (formerly the UEFA Cup). It features clubs from across the continent who qualify via their domestic leagues or by transferring from the Champions League. The competition has become known for its strong knockout format and its opportunity for clubs outside the traditional elite to shine. As of the 2025 season, the most successful clubs are Sevilla FC with 7 titles, followed by Liverpool F.C. and Juventus F.C. each with 3. Greek-side Olympiacos have been frequent participants but are still trying for their first triumph in this competition.",
                        false),
                new Competition("CO39761624", "UEFA Conference League", 1,
                        "The UEFA Europa Conference League is Europe’s tertiary club football competition, inaugurated in the 2021-22 season by UEFA to give wider access to clubs from smaller leagues across the continent. It delivers a fresh chance for clubs to achieve continental success and boost their international profile. In the 2023-24 season, Olympiacos made history by winning the trophy with a 1-0 extra-time victory over ACF Fiorentina, becoming the first Greek club ever to lift a major European trophy. The competition continues to evolve as a platform where emerging clubs make their mark.",
                        false))
        );
    }
}