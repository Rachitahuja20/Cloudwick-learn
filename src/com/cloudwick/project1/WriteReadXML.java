package com.cloudwick.project1;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.w3c.dom.*;

/**
 * Created by ahuja on 4/5/15.
 */
public class WriteReadXML {

    private void WriteWithDOM(HashMap hm1) {
        try {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Integer i = 0;
            //for (Object entry : hm1.entrySet()) {

            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("words");
            doc.appendChild(rootElement);

            Iterator<Map.Entry<String, WordDto>> itr1 = hm1.entrySet().iterator();
            while (itr1.hasNext()) {

                Map.Entry<String, WordDto> pairs = itr1.next();
                String newword = pairs.getKey().toString();
                String Count = pairs.getValue().getCount().toString();
                String len = pairs.getValue().getLength().toString();
                String syn = " "; //pairs.getValue().getSynonyms().toString();
                long time = pairs.getValue().getReadOn().getTime();
                String times = Long.toString(time);

                i++;

                // root elements


                // staff elements
                Element wordElement = doc.createElement("word");
                rootElement.appendChild(wordElement);

                // set attribute to staff element
                Attr attr = doc.createAttribute("id");
                wordElement.setAttributeNode(attr);

                // shorten way
               wordElement.setAttribute("id", i.toString());

                // firstname elements
                Element word = doc.createElement("value");
                word.appendChild(doc.createTextNode(newword));
                wordElement.appendChild(word);

                // lastname elements
                Element count = doc.createElement("count");
                count.appendChild(doc.createTextNode(Count));
                wordElement.appendChild(count);

                // nickname elements
                Element length = doc.createElement("length");
                length.appendChild(doc.createTextNode(len));
                wordElement.appendChild(length);

                //Synonym elements
                Element synonym = doc.createElement("synonym");
                synonym.appendChild(doc.createTextNode(syn));
                wordElement.appendChild(synonym);

                //Synonym elements
                Element Time = doc.createElement("time");
                Time.appendChild(doc.createTextNode(times));
                wordElement.appendChild(Time);


            }
            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("/Users/ahuja/Desktop/file.xml"));


            transformer.transform(source, result);


            System.out.println("File saved!");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }


    private void WriteWithSerialization(HashMap hm1) throws Exception {

//        Iterator<Map.Entry<String, WordDto>> itr1 = hm1.entrySet().iterator();
//        while (itr1.hasNext()) {

//            Map.Entry<String, WordDto> pairs = itr1.next();
//            String newword = pairs.getKey().toString();
//            String Count = pairs.getValue().getCount().toString();
//            String len = pairs.getValue().getLength().toString();
//            String syn = " "; //pairs.getValue().getSynonyms().toString();
//            long time = pairs.getValue().getReadOn().getTime();
//            String times = Long.toString(time);

        WordDto word = (WordDto) hm1.values().toArray()[0];
        Serializer serializer = new Persister();
        // WordDto word = new WordDto(s);
        File result = new File("/Users/ahuja/Desktop/xml2.xml");

        serializer.write(word, result);
    }
    //}

    public void ReadXML() {

        try {

            File fXmlFile = new File("/Users/ahuja/Desktop/file.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            //optional, but recommended
            //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("word");

            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    System.out.println("Word id : " + eElement.getAttribute("id"));
                    System.out.println("Word : " + eElement.getElementsByTagName("value").item(0).getTextContent());
                    System.out.println("Count : " + eElement.getElementsByTagName("count").item(0).getTextContent());
                    System.out.println("length : " + eElement.getElementsByTagName("length").item(0).getTextContent());
                    System.out.println("Synonym : " + eElement.getElementsByTagName("synonym").item(0).getTextContent());
                    System.out.println("Time : " + eElement.getElementsByTagName("time").item(0).getTextContent());

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void Write(HashMap hm, String xmlMethod) throws Exception {

        if (xmlMethod.toLowerCase() == "dom") {

            WriteWithDOM(hm);
        }

        if (xmlMethod.toLowerCase() == "serialization") {

            WriteWithSerialization(hm);
        }


    }
}


