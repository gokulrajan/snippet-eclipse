package com.gokul.second.templates;

import java.io.IOException;
import java.util.logging.Logger;

import org.eclipse.jface.text.templates.ContextTypeRegistry;
import org.eclipse.jface.text.templates.Template;
import org.eclipse.jface.text.templates.persistence.TemplateStore;
import org.eclipse.ui.editors.text.templates.ContributionContextTypeRegistry;
import org.eclipse.ui.editors.text.templates.ContributionTemplateStore;

import com.gokul.second.Activator;
import com.gokul.second.editors.Logging;


public class TemplateManager {

	private static final String DJANGO_CUSTOM_TEMPLATES_KEY = "_django.editor.custom.templates";

    private static TemplateStore 					templatesStore = null;
    private static ContributionContextTypeRegistry	contextTypeRegistry = null;
    //public static Logger logger=new Logger("");

    public static TemplateStore getDjangoTemplateStore() {
        if (templatesStore == null) {
        	templatesStore = new ContributionTemplateStore(
        							getDjangoContextTypeRegistry(),
        							Activator.getDefault().getPreferenceStore(),
        							DJANGO_CUSTOM_TEMPLATES_KEY
        						);
            try {
            	Logging.info("Inside the TemplateStore Method");
            	templatesStore.load();
            	Logging.info("Outside the TemplateStore Method");
            	Template templates[]=templatesStore.getTemplates("com.gokul.second.templates.CryTemplateContext.cry");
            	Logging.info("Before the TemplateStore Method Loop"+templates.length);
            	for(int i=0;i<templates.length;i++)
            	{
            		Logging.info("Inside the Display TemplateStore Method"+templates[i].getDescription());
            		System.out.println(templates.toString());
            	}
            	//List<Template> list=new ArrayList<Template>(Arrays.asList(templates))
//            	for(Template template: templates)
//            	{
//            		System.out.println("Inside TemplateStore");
//            		System.out.println(template.getDescription());
//            		System.out.println(template.getContextTypeId());
//            	}
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        return templatesStore;
    }

    public static ContextTypeRegistry getDjangoContextTypeRegistry() {
        if (contextTypeRegistry == null) {
        	contextTypeRegistry = new ContributionContextTypeRegistry();
        	contextTypeRegistry.addContextType(CryTemplateContext.CRY);
        	contextTypeRegistry.addContextType(CryTemplateContext.EDI);
        	contextTypeRegistry.addContextType(CryTemplateContext.PLAY);
        }
        Logging.info("Before the Printing of ContextType");
        Logging.info(contextTypeRegistry.getContextType(CryTemplateContext.CRY).toString());
    	return contextTypeRegistry;
    }

//	@SuppressWarnings("deprecation")
//	public static void savePluginPreferences(){
//		Activator.getDefault().savePluginPreferences();
//	}

	
}
