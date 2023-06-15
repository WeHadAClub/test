package commands.managers;

import collection.CollectionManager;

public interface Command {
    void execute(CollectionManager mg, String[] input);
    String descr();
}
