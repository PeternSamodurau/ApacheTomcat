package _6.Практика.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

    private static final Properties PROPERTIES = new Properties();

    public PropertiesUtil() { //приватный конструктор, чтобы предотвратить создание экземпляров класса.
    }

    static {
        loadProperties();
    }

    private static void loadProperties(){
        ClassLoader classLoader = PropertiesUtil.class.getClassLoader();// Получаем загрузчик классов, используемый для загрузки классов в программе
         //Переменная classLoader содержит объект загрузчика классов, который можно использовать для загрузки классов и ресурсов в программе.
        // В данном контексте, classLoader будет представлять загрузчик классов, который загрузил класс PropertiesUtil и который мы используем для доступа к файлу application.properties.
        try (InputStream inputStream = classLoader.getResourceAsStream("application.properties")) {

            PROPERTIES.load(inputStream);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String get(String key){
          return PROPERTIES.getProperty(key);
    }
}
