package _6.Практика.util;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// утилит класс для подключения к базе данных MySql

@UtilityClass
public final class ConnectionManager {

    private static final String URL_KEY = "db.url";
    private static final String USER_KEY = "db.user";
    private static final String PASSWORD_KEY = "db.password";

    static {
        loadDriver();
    }

    private static void loadDriver() {                              //должен работать без этого кода, но не работает не знаю почему
        try {
            Class.forName(PropertiesUtil.get("db.driver"));
        } catch (ClassNotFoundException e) {
            System.out.println("Failed to load MySQL driver" + e);
        }
    }
    @SneakyThrows        // Lombok обозначает, что этот метод может выбрасывать исключения, теперь try - catch не нужен
    public static Connection get(){
                  return DriverManager.getConnection(
                    PropertiesUtil.get(URL_KEY),
                    PropertiesUtil.get(USER_KEY),
                    PropertiesUtil.get(PASSWORD_KEY));
    }
}
