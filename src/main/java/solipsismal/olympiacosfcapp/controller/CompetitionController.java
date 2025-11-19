package solipsismal.olympiacosfcapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import solipsismal.olympiacosfcapp.core.exceptions.CompetitionNotFoundException;
import solipsismal.olympiacosfcapp.dto.CompetitionDTO;
import solipsismal.olympiacosfcapp.dto.OlympiacosDTO;
import solipsismal.olympiacosfcapp.model.Competition;
import solipsismal.olympiacosfcapp.repository.CompetitionRepository;
import solipsismal.olympiacosfcapp.repository.OlympiacosRepository;

import java.util.List;

@RestController
@RequestMapping("/api/competitions")
@RequiredArgsConstructor
public class CompetitionController {

    private final CompetitionRepository competitionRepository;

    @GetMapping
    public List<CompetitionDTO> getCompetitionsInfo() throws CompetitionNotFoundException {
        return competitionRepository.findAll()
                .stream()
                .map(CompetitionDTO::new)
                .toList();
    }
}