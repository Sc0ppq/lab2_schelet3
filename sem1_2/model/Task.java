package sem1_2.model;

import java.util.Objects;

//abstract pt ca nu avem impl la execute
//subclasele care mostenesc Task trebuie sa aiba o impl concreta a metodei execute
public abstract class Task {
    private String id;
    private String description;

    public Task(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public abstract void execute();

    @Override
    public String toString() {
        return "Task{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    //CONTRACTUL equals-hashCode
    //-> daca 2 obiecte sunt considerate egale conform equals(), atunci ele trebuie sa aiba si acelasi cod hash
    //daca 2 obiecte au aceleasi valori pentru id si description, atunci equals() va returna TRUE, iar codul lor
    // hash va fi identic
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id) && Objects.equals(description, task.description);
    }

    //hash unic bazat pe id si descr.
    @Override
    public int hashCode() {
        return Objects.hash(id, description);
    }
}
