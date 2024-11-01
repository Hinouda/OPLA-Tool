package br.otimizes.oplatool.architecture.base;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.eclipse.uml2.uml.resource.XMI2UMLResource;
import org.eclipse.uml2.uml.resources.util.UMLResourcesUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;

/**
 * Initialization of the necessary resources.
 *
 * @author edipofederle<edipofederle @ gmail.com>
 */
public class InitializeResources {

    public static ThreadLocal<InitializeResources> initializeResources = ThreadLocal.withInitial(InitializeResources::new);
    public ResourceSet RESOURCE_SET;

    private InitializeResources() {
        RESOURCE_SET = new ResourceSetImpl();
        init();
    }

    protected void init() {
        try {
            UMLResourcesUtil.init(RESOURCE_SET);
            registerPathmaps();

            RESOURCE_SET.getPackageRegistry().put(UMLPackage.eNS_URI, UMLPackage.eINSTANCE);

            RESOURCE_SET.getResourceFactoryRegistry().getExtensionToFactoryMap().put(UMLResource.FILE_EXTENSION,
                    UMLResource.Factory.INSTANCE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Records the necessary resources (libraries, metamodels, UMLPrimitivesTypes and Profiles).
     */
    private void registerPathmaps() {
        String umlResourcePath = UMLResourcesUtil.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        try {
            umlResourcePath = URLDecoder.decode(umlResourcePath, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            URI umlResourcePluginURI = URI.createURI("jar:file:" + umlResourcePath + "!/");

            RESOURCE_SET.getURIConverter().getURIMap().put(URI.createURI(UMLResource.LIBRARIES_PATHMAP),
                    umlResourcePluginURI.appendSegment("libraries").appendSegment(""));

            RESOURCE_SET.getURIConverter().getURIMap().put(URI.createURI(UMLResource.METAMODELS_PATHMAP),
                    umlResourcePluginURI.appendSegment("metamodels").appendSegment(""));

            RESOURCE_SET.getURIConverter().getURIMap().put(URI.createURI(UMLResource.UML_PRIMITIVE_TYPES_LIBRARY_URI),
                    umlResourcePluginURI.appendSegment("libraries").appendSegment("UMLPrimitiveTypes.library.uml"));

            RESOURCE_SET.getURIConverter().getURIMap().put(URI.createURI(UMLResource.UML_METAMODEL_URI),
                    umlResourcePluginURI.appendSegment("metamodels").appendSegment("UML.metamodel.uml"));

            RESOURCE_SET.getURIConverter().getURIMap().put(URI.createURI(UMLResource.UML2_PROFILE_URI),
                    umlResourcePluginURI.appendSegment("profiles").appendSegment("UML2.profile.uml"));

            RESOURCE_SET.getURIConverter().getURIMap().put(URI.createURI(UMLResource.STANDARD_L2_PROFILE_URI),
                    umlResourcePluginURI.appendSegment("profiles").appendSegment("StandardL2.profile.uml"));

            Map<String, Object> extensionToFactoryMap = RESOURCE_SET.getResourceFactoryRegistry()
                    .getExtensionToFactoryMap();
            extensionToFactoryMap.put(UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE);
            extensionToFactoryMap.put(UMLResource.PROFILE_FILE_EXTENSION, UMLResource.Factory.INSTANCE);
        } catch (Exception a) {
            a.printStackTrace();

        }
    }

    /**
     * Returns a RESOURCE_SET setted.
     *
     * @return ResourceSet
     */
    public ResourceSet getResources() {
        return RESOURCE_SET;
    }

}