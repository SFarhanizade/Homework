package dto;

public class PlayerDto {
    private Long id;
    private Integer teamPoints;

    public PlayerDto(Long id, Integer teamPoints) {
        this.id = id;
        this.teamPoints = teamPoints;
    }

}
