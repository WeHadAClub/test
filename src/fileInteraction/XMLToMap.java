package fileInteraction;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import userInteraction.input.InputHandler;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMLToMap {
    
    public XMLToMap(){
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
                            for(int f = 0; f < musicProp.getChildNodes().getLength(); f++){
                                String text = musicProp.getChildNodes().item(f).getTextContent();
                                String[] lastText = text.split("\n");
                                try {
                                    if(lastText[0].length() == 0) continue;
                                    System.out.println(lastText[0]);}
                                catch (ArrayIndexOutOfBoundsException e){
                                }
                            }
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
