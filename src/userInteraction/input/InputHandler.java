package userInteraction.input;
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.w3c.dom.*;

import java.io.IOException;

public class InputHandler{
    ReadBase handler;
    String[] words;
    public InputHandler(ReadBase n) throws IOException{
        handler = n;
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
    /**
     * reading data from a xml file
     */
    public void readXmlFile(String fileName){
        try {
            // Создается построитель документа
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            // Создается дерево DOM документа из файла
            Document document = documentBuilder.parse(fileName);

            // Получаем корневой элемент
            Node root = document.getDocumentElement();
            // Просматриваем все подэлементы корневого
            NodeList musicbands = root.getChildNodes();
            for (int i = 0; i < musicbands.getLength(); i++) {
                Node music = musicbands.item(i);
                // Если нода не текст, то это музыкальная группа - заходим внутрь
                if (music.getNodeType() != Node.TEXT_NODE) {
                    NodeList musicProps = music.getChildNodes();
                    for (int j = 0; j < musicProps.getLength(); j++) {
                        Node musicProp = musicProps.item(j);
                        // Если нода не текст, то это один из параметров
                        if (musicProp.getNodeType() != Node.TEXT_NODE) {
                            System.out.println(musicProp.getChildNodes().item(0).getTextContent());
                        }
                    }
                }

            }
        }
        catch (IOException e) {
            System.out.println("Упс... возможно ты ввел неверный путь или указал несуществующий xml файл. \n Попробуй еще раз: ");
        }
        catch (ParserConfigurationException | SAXException e) {
            System.out.println("Упс... это не твоя вина. Попробуй еще раз");
        }
    }
}
