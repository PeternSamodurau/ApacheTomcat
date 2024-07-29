package _6.Практика.dao;

import _6.Практика.entity.Flight;
import _6.Практика.entity.FlightStatus;
import _6.Практика.util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FlightDao implements Dao<Integer, Flight> {

    private static final FlightDao INSTANCE = new FlightDao();

    private static final String FIND_ALL = """
            select *
            from flight
            """;

    private FlightDao() {
    }

    @Override
    public List<Flight> findAll() {
        try (Connection connection = ConnectionManager.get(); // подключение к базе данных, если не подключено, то ошибка

            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL)) { //подготовка запроса к базе данных, если не подготовлен, то ошибка

            ResultSet resultSet = preparedStatement.executeQuery(); // выполнение запроса к базе данных, если не выполнено, то ошибка

            List<Flight> flights = new ArrayList<>();

            while (resultSet.next()) {

                flights.add(buildFlight(resultSet));
            }

            return flights;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    @Override
    public Optional<Flight> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public void update(Flight entity) {

    }

    @Override
    public Flight save(Flight entity) {
        return null;
    }

    public static FlightDao getInstance(){
        return INSTANCE;
    }

    private Flight buildFlight(ResultSet resultSet) {
        try {
            return new Flight(
                    resultSet.getObject("id", Integer.class),
                    resultSet.getObject("flight_no", String.class),
                    resultSet.getObject("departure_date", Timestamp.class).toLocalDateTime(),
                    resultSet.getObject("departure_airport_code", String.class),
                    resultSet.getObject("arrival_date", Timestamp.class).toLocalDateTime(),
                    resultSet.getObject("arrival_airport_code", String.class),
                    resultSet.getObject("aircraft_id", Integer.class),
                    FlightStatus.valueOf(resultSet.getObject("status", String.class))

            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
