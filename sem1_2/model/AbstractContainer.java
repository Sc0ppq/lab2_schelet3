package sem1_2.model;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractContainer implements Container {
    protected List<Task> tasks = new ArrayList<>(); //lista comuna de taskuri

    @Override
    public void add(Task task) {
        tasks.add(task);
    }

    @Override
    public int size() {
        return tasks.size();
    }

    @Override
    public boolean isEmpty() {
        return tasks.isEmpty();
    }

    //remove e abstracta, implementata specific in subclase
    @Override
    public abstract Task remove();
}

/*
public class StackContainer implements Container {
    List<Task> tasks = new ArrayList<>();

    @Override
    public Task remove() {
        if (!tasks.isEmpty()) {
            return tasks.remove(tasks.size() - 1);
        } else {
            return null;
        }
    }

    @Override
    public void add(Task task) {
        tasks.add(task);
    }

    @Override
    public int size() {
        return tasks.size();
    }

    @Override
    public boolean isEmpty() {
        return tasks.isEmpty();
    }
}
*/

