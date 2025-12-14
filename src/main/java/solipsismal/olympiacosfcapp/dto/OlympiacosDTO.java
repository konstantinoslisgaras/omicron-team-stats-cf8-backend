package solipsismal.olympiacosfcapp.dto;

import lombok.Getter;
import lombok.Setter;
import solipsismal.olympiacosfcapp.model.Olympiacos;

@Getter
@Setter
public class OlympiacosDTO {
    private String id;
    private String name;
    private String trophies;
    private String history;

    public OlympiacosDTO(Olympiacos olympiacos) {
        this.id = olympiacos.getId();
        this.name = olympiacos.getName();
        this.trophies = olympiacos.getTrophies();
        this.history = olympiacos.getHistory();
    }
}