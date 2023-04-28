package userInteraction;

import java.io.IOException;
import collection.CollectionManager;
import commands.managers.Command;
import commands.managers.CommandList;
import commands.managers.CommandManager;

public class Manager {
    private InputHandler t1;
    private final CommandManager commM;
    private final CollectionManager collM;

    {
        try{
            t1 = new InputHandler(new ReadBase(System.in));
        }
        catch (IOException e){
            e.getStackTrace();
        }
        commM = new CommandManager();
        collM = new CollectionManager();
    }

    public Manager(){

    }

    public void start(){
        System.out.println("Привет! \nВведи 'help', чтобы увидеть список комманд. ");
        String[] input;
        Command command;
        while(true){
            input = t1.read();
            if(commM.isCommand(input[0])){
                command = commM.getCommand(input[0]);
                command.execute(collM);
            }

        }
    }
}
