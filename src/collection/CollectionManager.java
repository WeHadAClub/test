package collection;

import collection.baseClasses.MusicBand;
import commands.managers.CommandManager;
import exeptions.NoKeyExeptions;
import userInteraction.CTInput;
import userInteraction.Manager;
import userInteraction.input.InputHandler;

import java.security.cert.CertificateEncodingException;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

public class CollectionManager {
    Map<Integer, MusicBand> musicBandCatalogue = new LinkedHashMap<>();
    private final Manager mainManager;
    private final CTInput checker;
    private final InputHandler t2;
    private final CommandManager cM;
    private java.time.LocalDateTime creationDate;
    public CollectionManager(Manager main, InputHandler t1, CommandManager cM) {
        mainManager = main;
        checker = new CTInput();
        t2 = t1;
        this.cM = cM;
        creationDate = LocalDateTime.now();
    }

    public void help(){
        cM.getDescriptions();
    }
    public void info(){
        System.out.println("Коллекция музыкальных коллективов");
        System.out.println("Тип коллекции - " + musicBandCatalogue.getClass().getName() +"\n" +
                "Дата создания коллекции - " + creationDate + "\n" +
                "Количество элементов - " + musicBandCatalogue.size());
    }
    public void add() throws NoKeyExeptions {
        String[] input = mainManager.getInput();
        if(input.length == 1) throw new NoKeyExeptions();
        String cKey = input[1];
        if(!checker.checkKey(cKey)){
        }
        else {
            Integer key = Integer.valueOf(cKey);
            if(!musicBandCatalogue.containsKey(key)){
                //about music band
                MusicBand mb = new MusicBand();
                mb.setId(Long.valueOf(key));
                mb.setName(checker.setName(t2));
                mb.setCoordinates(checker.setCoordinates(t2));
                mb.setNumberOfParticipants(checker.setNOP(t2));
                mb.setGenre(checker.setMG(t2));
                mb.setFrontMan(checker.personality(t2, cKey));
                musicBandCatalogue.put(key, mb);
                System.out.println("Музыкальный коллектив записан в коллекцию.");
            }
            else{
                System.out.println("Группа с таким ключом уже существует, попробуйте ввести другой");
            }
        }
    }

    public void exit(){
        System.out.println("Завершаем работу");
        System.exit(0);
    }
}
