package _6.Практика.service;

import _6.Практика.dto.TicketDto;
import _6.Практика.dao.TicketDao;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class TicketService {

    private static final TicketService INSTANCE = new TicketService();
    private final TicketDao ticketDao = TicketDao.getInstance();

    public TicketService() {
    }
    public List<TicketDto> findAllByFlightId(Integer flightId){

       return ticketDao.findAllByFlightId(flightId).stream()
               .map(ticket -> new TicketDto(
                ticket.getId(),
                ticket.getFlightId(),
                ticket.getSeatNo()

               )).collect(toList());
    }

    public static TicketService getInstance(){
        return INSTANCE;
    }

}
