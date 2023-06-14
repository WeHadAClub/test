package userInteraction.input;

import java.io.*;

/**
 * the class on which the reading of files is based
 * @author zubair
 */
public class ReadBase {
    /**
     * f - поле потока ввода
     */
    private InputStreamReader reader;

    /**
     *
     * @param is - Input Stream
     */
    public ReadBase(InputStream is){
        reader = new InputStreamReader(is);
    }

    /**
     * @return str - строка, полученная путем преобразования юникода введенных
     * в поток ввода символов в строку
     * @throws IOException
     */
    public String read() throws IOException {
        int rn = reader.read();
        String str = Character.toString((char)rn);
        String test = "";

        //все символы совмещаются в одну строку
        while(reader.ready()){
            rn = reader.read();
            test = Character.toString((char)rn);
            if(!test.equals("\n")){
                str += test;
            }
        }
        if(!str.equals("\n")) {
            return str;

        }
        else{
            return null;
        }

    }

    public String readLine() throws IOException {
        StringBuilder str = new StringBuilder();
        while(reader.ready()) {
            int a = reader.read();
            String now = Character.toString((char) a);
            if(now.equals("\n")){
                break;
            }
            str.append(now);
        }
        String fin = String.valueOf(str);
        return fin;
    }

    public boolean ready(){
        try {
            return reader.ready();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
