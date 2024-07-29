package _6.Практика.service;

import _6.Практика.dto.FlightDto;
import _6.Практика.dao.FlightDao;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class FlightService {

    private static final FlightService INSTANCE = new FlightService(); // singleton паттерн

    private final FlightDao flightDao = FlightDao.getInstance();

    private FlightService() {
    }

    public List<FlightDto> findAll(){
         return  flightDao.findAll().stream()
                 .map(flight -> new FlightDto(
                         flight.getId(),
                         """
                         %s - %s - %s
                         """.formatted(flight.getDepartureAirportCode(), flight.getArrivalAirportCode(), flight.getStatus()))).collect(toList());
    }

    public static FlightService getInstance() {
        return INSTANCE;
    }
}
