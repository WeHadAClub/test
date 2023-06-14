package userInteraction.input;
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.w3c.dom.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class InputHandler{
    ReadBase handler; //база чтения
    String[] words;
    public InputHandler(ReadBase n) throws IOException{
        handler = n;
    }
    public InputHandler(String path){
        try{
            handler = new ReadBase(new FileInputStream(path));
        }
        catch (FileNotFoundException e){
            System.out.println("Файла с таким названием нет");
        }
    }

    /**
     *Проверка опциональна, так как лишь от программиста изначально зависит, будет ли вылетать ошибка
     * @return returns an array of strings that are words in the terminal input
     */
    public String[] read(){

        try {
            words = handler.read().split(" ");
            return words;
        }
        catch (NullPointerException e){
            return new String[0];
        } catch (IOException e) {
            return new String[0];
        }
    }

    public String readLine(){
        try {
            return handler.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean ready(){
        return handler.ready();
    }
}
