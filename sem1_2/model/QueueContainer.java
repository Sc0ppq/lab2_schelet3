package sem1_2.model;

public class QueueContainer extends AbstractContainer {
    @Override
    public Task remove() {
        //FIFO - eliminam primul task adaugat
        if (!tasks.isEmpty()) {
            return tasks.remove(0);
        } else return null;
    }
}
