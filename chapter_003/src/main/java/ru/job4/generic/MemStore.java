package ru.job4.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * create universal storage
 * author DmitryF17
 * version 01
 * since 27/06/2019
 */
public final class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        int indexreplace = indexOf(id);
        if (indexreplace != -1) {
            mem.set(indexreplace, model);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        int indexdelete = indexOf(id);
        if (indexdelete != -1) {
            mem.remove(indexdelete);
            return true;
        }
        return false;
    }

    @Override
    public T findById(String id) {
        int indexfind = indexOf(id);
        if (indexfind == -1) {
            return null;
        }
        return mem.get(indexfind);
    }

    private int indexOf(String id) {
        int rsl = -1;
        for (int index = 0; index != mem.size(); index++) {
            if (mem.get(index).getId().equals(id)) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }
}
