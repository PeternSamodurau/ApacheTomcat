package _6.Практика.dto;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@Data
public class TicketDto {
    private final Integer id;
    private final Integer flightId;
    private final String seatNo;
}
