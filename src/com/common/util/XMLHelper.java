package com.common.util;

import javax.xml.parsers.DocumentBuilder; 
import javax.xml.parsers.DocumentBuilderFactory;  
import javax.xml.parsers.ParserConfigurationException;
 
import org.jdom.Document;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;  

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;


import java.io.*;
//¸ü¤JJDOMÃþ§O
import org.jdom.*;
import org.jdom.output.XMLOutputter;




public class XMLHelper
{
    
    public static org.w3c.dom.Document createDocument(String xmlStr)
    {
        org.w3c.dom.Document document = null; 
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        //factory.setValidating(true);   
        //factory.setNamespaceAware(true);
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            document = builder.parse(new InputSource(new StringReader(xmlStr)));
        } catch (SAXException sxe) {
            Exception  x = sxe;
            if (sxe.getException() != null)
                x = sxe.getException();
            x.printStackTrace();
        } catch (ParserConfigurationException pce) {
            // Parser with specified options can't be built
            pce.printStackTrace();
        } catch (IOException ioe) {
            // I/O error
            ioe.printStackTrace();
        }
        
        return document;
    }
 
    public static org.jdom.Document createJdomDocument(String xmlStr)
    {
        org.jdom.Document document = null; 
        
        try {
            SAXBuilder builder = new SAXBuilder();       
            builder.setValidation(false);
            document = builder.build(new InputSource(new StringReader(xmlStr)));
        } catch (JDOMException sxe) {
            sxe.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return document;
    }
    
    
    public static void createXmlFile(Document document,String filename){
        try {
            FileOutputStream output = new FileOutputStream(filename);	
            XMLOutputter outputter = new XMLOutputter();
            outputter.setNewlines(true);
            outputter.setIndent(true);
            outputter.output(document, output);              
            output.close();
          }catch (Exception e) {          
              System.out.println(e.toString());
            }  
    }

    
}
