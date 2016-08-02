package com.gokul.second.templates;

import org.eclipse.jface.text.templates.GlobalTemplateVariables;
import org.eclipse.jface.text.templates.TemplateContextType;

public class CryTemplateContext extends TemplateContextType{

	public static final String CRY = 
		"com.gokul.second.templates.contextType.cry";
	public static final String EDI = 
			"com.gokul.second.templates.contextType.edi";
	public static final String PLAY = 
			"com.gokul.second.templates.contextType.play";
	
	public CryTemplateContext() {
		addResolver(new GlobalTemplateVariables.Cursor());
		addResolver(new GlobalTemplateVariables.WordSelection());
		addResolver(new GlobalTemplateVariables.LineSelection());
		
	}
	
}
