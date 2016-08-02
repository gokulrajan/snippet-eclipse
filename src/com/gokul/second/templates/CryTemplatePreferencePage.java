package com.gokul.second.templates;

import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.texteditor.templates.TemplatePreferencePage;

import com.gokul.second.Activator;

public class CryTemplatePreferencePage extends TemplatePreferencePage implements
IWorkbenchPreferencePage {

public CryTemplatePreferencePage() {
setDescription("Templates for Cry Editor");

setPreferenceStore(Activator.getDefault().getPreferenceStore());
setTemplateStore(TemplateManager.getDjangoTemplateStore());
setContextTypeRegistry(TemplateManager.getDjangoContextTypeRegistry());
}

protected boolean isShowFormatterSetting() {
return false;
}


}
