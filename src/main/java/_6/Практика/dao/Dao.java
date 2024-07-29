package _6.Практика.dao;

import java.util.List;
import java.util.Optional;
//Интерфейс Dao<K, T> определяет основные методы для работы с данными в базе данных, используя паттерн Data Access Object (DAO). Вот что делает каждый метод:
//
//List<T> findAll(): Возвращает список всех объектов типа T из базы данных.
//Optional<T> findById(K id): Ищет объект по его идентификатору id и возвращает его, если он найден, обернутый в Optional, иначе возвращает Optional.empty().
//boolean delete(K id): Удаляет объект по его идентификатору id и возвращает true, если удаление прошло успешно.
//void update(T entity): Обновляет существующий объект в базе данных.
//T save(T entity): Сохраняет новый объект в базе данных и возвращает его.

public interface Dao<K,T> {

    List<T> findAll();

    Optional<T> findById(K id);

    boolean delete(K id);

    void update(T entity);

    T save(T entity);
}
