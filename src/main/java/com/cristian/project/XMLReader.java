package com.cristian.project;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by cavinalopez on 6/14/2017.
 */
public class XMLReader {
    public String main(){
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        String pathName = "C:\\Users\\cavinalopez\\IdeaProjects\\mp\\src\\main\\java\\com\\cristian\\project\\api_keys.xml";
        File xmlFile = new File(pathName);

        if (xmlFile.exists()){
            System.out.println("XML File Found");
        }else{
            System.out.println("File Does Not Exist...");
        }

        try {
            DocumentBuilder dBuilder = builderFactory.newDocumentBuilder();
            Document document = dBuilder.parse(xmlFile);
            String key = null;

            NodeList list = document.getElementsByTagName("API");

            for (int i = 0; i < list.getLength(); i++){
                Node node = list.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node;
                    key = element.getElementsByTagName("GOOGLETOKEN").item(0).getTextContent();
                }
            }
            System.out.println(key);
            return key;

//            System.out.println(node);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return " ";
    }
}
