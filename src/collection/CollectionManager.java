package collection;

import collection.baseClasses.MusicBand;
import collection.baseClasses.MusicGenre;

import java.util.LinkedHashMap;
import java.util.Map;

public class CollectionManager {
    Map<Integer, MusicBand> musicBandCatalogue = new LinkedHashMap<>();

   /* public void add(Integer key, MusicBand mb){

        musicBandCatalogue.put(key, mb);
    }*/

    public void exit(){
        System.out.println("Завершаем работу");
        System.exit(0);
    }
}
