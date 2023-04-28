package commands;
import  collection.CollectionManager;
import collection.baseClasses.MusicBand;
import commands.managers.Command;

public class InsertCommand implements Command {
    Integer key;
    MusicBand mb;
    public InsertCommand(Integer i){
        this.key = i;
        this.mb = mb;
    }
    @Override
    public String descr() {
        return "insert - добавление нового элемента с заданным ключом. \n" +
                "Инструкция: insert [key]";
    }

    @Override
    public void execute(CollectionManager manager) {
        /*manager.add(key, mb);*/
    }
}
