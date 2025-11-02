package solipsismal.olympiacosfcapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import solipsismal.olympiacosfcapp.dto.OlympiacosDTO;
import solipsismal.olympiacosfcapp.repository.OlympiacosRepository;

@RestController
@RequestMapping("/api/history")
@RequiredArgsConstructor
public class OlympiacosController {

    private final OlympiacosRepository olympiacosRepository;

    @GetMapping
    public OlympiacosDTO getOlympiacosInfo() {
        return olympiacosRepository.findAll()
                .stream()
                .findFirst()
                .map(OlympiacosDTO::new)
                .orElseThrow(() -> new RuntimeException("Olympiacos info not found."));
    }
}