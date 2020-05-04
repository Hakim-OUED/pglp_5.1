package pgpl;

import java.util.List;

public interface Dao<T> {

  T get(String nom);

  List<T> getAll();

  void create(T t);

  void update(T t, String[] params);

  void delete(T t);


}
