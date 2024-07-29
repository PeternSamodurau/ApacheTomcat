package _6.Практика.entity;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.Objects;


//  Уровень Data Access Object (DAO) работает с сущностями поэтому создаем сущность Flight к которой будем обращаться в My Sql
// для выполнения операций над сущностями описываем поля таблицы My Sql
@Setter
@Getter
public class Flight {
    private int id;
    private String flightNo;
    private LocalDateTime departureDate;
    private String departureAirportCode;
    private LocalDateTime arrivalDate;
    private String arrivalAirportCode;
    private Integer aircraftId;
    private FlightStatus status;               // это enum перечисления см пакет _6.Практика.entity.FlightStatus

    public Flight(int id, String flightNo, LocalDateTime departureDate, String departureAirportCode, LocalDateTime arrivalDate, String arrivalAirportCode, Integer aircraftId, FlightStatus status) {
        this.id = id;
        this.flightNo = flightNo;
        this.departureDate = departureDate;
        this.departureAirportCode = departureAirportCode;
        this.arrivalDate = arrivalDate;
        this.arrivalAirportCode = arrivalAirportCode;
        this.aircraftId = aircraftId;
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return id == flight.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", flightNo='" + flightNo + '\'' +
                ", departureDate=" + departureDate +
                ", departureAirportCode='" + departureAirportCode + '\'' +
                ", arrivalDate=" + arrivalDate +
                ", arrivalAirportCode='" + arrivalAirportCode + '\'' +
                ", aircraftId=" + aircraftId +
                ", status=" + status +
                '}';
    }
}
