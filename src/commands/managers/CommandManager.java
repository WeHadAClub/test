package commands.managers;

import commands.ExitCommand;
import commands.InsertCommand;

import java.util.HashMap;
import java.util.Map;

public class CommandManager {
    Map<String, Command> commandMap = new HashMap<>();

    public CommandManager() {
        commandMap.put("exit", new ExitCommand());
    }

    /**
     *the command checks whether the entered line is in the list of commands
     * @param com - input from the terminal
     * @return
     */
    public boolean isCommand(String com){
        if(commandMap.containsKey(com)){
            return true;
        }
        else{
            System.out.println("CommandManager: Друг, такой комманды у нас нет. Попробуй еще раз");
            return false;
        }
    }

    public Command getCommand(String com){
        return commandMap.get(com);
    }

}
