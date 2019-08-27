
package Project.Interface;

import java.util.List;

/**
 *
 * @author HrBbCi
 * @param <T>
 * @param <E>
 */
public interface Dao<T, E> {

  List<T> getAll() ;

  T getByID(E e);

  boolean newAdd(T t);

  boolean delete(E t);

  boolean edit(T t);

  List<T> find(E ...t);
  
}
