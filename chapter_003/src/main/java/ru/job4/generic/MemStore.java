package ru.job4.generic;

import java.util.ArrayList;
import java.util.List;
/**
 * create universal storage
 *  author DmitryF17
 *  version 01
 *  since 27/06/2019
 */
public final class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        T replaced = findById(id);
        if (replaced != null) {
            mem.set(mem.indexOf(replaced), model);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        T deleted = findById(id);
        if (deleted != null) {
            mem.remove(deleted);
            return true;
        }
        return false;
    }

    @Override
    public T findById(String id) {
            for (T findout : mem) {
                if (findout.getId().equals(id)) {
                    return findout;
                }
            }
        return null;
    }
}
