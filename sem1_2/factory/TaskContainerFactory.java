package sem1_2.factory;

import sem1_2.model.Container;
import sem1_2.model.AbstractContainer;
import sem1_2.model.QueueContainer;
import sem1_2.model.StackContainer;

public class TaskContainerFactory implements Factory {

    //singura instanta a clasei TaskContainerFactory
    private static TaskContainerFactory instance;

    //constructor
    public TaskContainerFactory() {}

    //metoda statica pentru obtinerea instantei unice
    public static TaskContainerFactory getInstance() {
        if (instance == null) {
            instance = new TaskContainerFactory();
        }
        return instance;
    }
    
    @Override
    public Container createContainer(Strategy strategy) {
        if (strategy == Strategy.FIFO) {
            return new QueueContainer();
        } else {
            //return new AbstractContainer();
            return new StackContainer();
        }
    }
}
