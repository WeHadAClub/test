package userInteraction;

import collection.CollectionManager;
import commands.managers.Command;
import commands.managers.CommandManager;
import fileInteraction.MapToXML;
import fileInteraction.XMLToMap;
import userInteraction.input.InputHandler;
import userInteraction.input.ReadBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


public class Manager {
    private InputHandler tNow;
    private final CommandManager commM;
    private final CollectionManager collM;
    private MapToXML mtx;
    String[] input;
    {
        try{
            tNow = new InputHandler(new ReadBase(System.in));
        }
        catch (IOException e){
            e.getStackTrace();
        }
        commM = new CommandManager();
        mtx = new MapToXML();
        collM = new CollectionManager(this, tNow, commM, mtx);
    }
    public Manager(String file){
        initlReading(file);
    }
    public String[] getInput(){
        return input;
    }
    public void initlReading(String file){
        XMLToMap xml = new XMLToMap();
        xml.readXmlFile(file);
    }

    public void start(){
        System.out.println("Привет! \nВведи 'help', чтобы увидеть список комманд. ");
        Command command;
        while(true){
            System.out.println("Введите комманду: ");
            input = tNow.read();
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
