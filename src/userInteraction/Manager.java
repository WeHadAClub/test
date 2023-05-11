package userInteraction;

import collection.CollectionManager;
import commands.managers.Command;
import commands.managers.CommandManager;
import userInteraction.input.InputHandler;
import userInteraction.input.ReadBase;
import java.io.IOException;


public class Manager {
    private InputHandler t1;
    private final CommandManager commM;
    private final CollectionManager collM;
    String[] input;
    {
        try{
            t1 = new InputHandler(new ReadBase(System.in));
        }
        catch (IOException e){
            e.getStackTrace();
        }
        commM = new CommandManager();
        collM = new CollectionManager(this, t1, commM);
    }
    public Manager(){

    }
    public String[] getInput(){
        return input;
    }

    public void start(){
        System.out.println("Привет! \nВведи 'help', чтобы увидеть список комманд. ");
        Command command;
        while(true){
            System.out.println("Введите комманду: ");
            input = t1.read();
            try {
                if(commM.isCommand(input[0])){
                    command = commM.getCommand(input[0]);
                    command.execute(collM);
                }
            }
            catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Вы ввели пустую строку");
            }

        }
    }
}
