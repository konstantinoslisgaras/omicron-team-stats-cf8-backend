package solipsismal.olympiacosfcapp.dto;

import lombok.Getter;
import lombok.Setter;
import solipsismal.olympiacosfcapp.model.Player;

import static solipsismal.olympiacosfcapp.utils.PlayerUtils.formatPlayerFullName;

@Getter
@Setter
public class PlayerListDTO {
    private String id;
    private String name;
    private Integer shirtNumber;

    public PlayerListDTO(Player player) {
        this.id = player.getId();
        this.name = formatPlayerFullName(player);
        this.shirtNumber = player.getShirtNumber();
    }
}