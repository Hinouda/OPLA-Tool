package br.otimizes.oplatool.core.wizard;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class LeitorPLA {

    public PLAInfo processarArquivoEntrada(String caminhoArquivo) {
        Document doc = null;  // Declara a variável `doc` fora do bloco `try`

        try {
            File inputFile = new File(caminhoArquivo);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(inputFile);  // Inicializa `doc` dentro do bloco `try`
            doc.getDocumentElement().normalize();

            NodeList classList = doc.getElementsByTagName("class");
            int numClasses = classList.getLength();

            NodeList packageList = doc.getElementsByTagName("package");
            int numComponentes = packageList.getLength(); 

            NodeList variabilityList = doc.getElementsByTagName("variability");
            int numVariabilidades = variabilityList.getLength();

            NodeList interfaceList = doc.getElementsByTagName("interface");
            int numInterfaces = interfaceList.getLength();

            Set<String> uniqueMethods = new HashSet<>();
            NodeList methodList = doc.getElementsByTagName("method");
            for (int i = 0; i < methodList.getLength(); i++) {
                Element method = (Element) methodList.item(i);
                String methodName = method.getAttribute("name");
                uniqueMethods.add(methodName);
            }
            int numUniqueMethods = uniqueMethods.size();

            Set<String> uniqueStereotypes = new HashSet<>();
            NodeList stereotypeList = doc.getElementsByTagName("stereotype");
            for (int i = 0; i < stereotypeList.getLength(); i++) {
                Element stereotype = (Element) stereotypeList.item(i);
                String name = stereotype.getAttribute("name").toLowerCase();
                uniqueStereotypes.add(name);
            }
            int numUniqueStereotypes = uniqueStereotypes.size();

            return new PLAInfo(numClasses, numComponentes, numInterfaces, numVariabilidades, numUniqueMethods, numUniqueStereotypes);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
