package com.gokul.second.editors;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.gokul.second.Activator;

/**
 * Logging helper class
 * @author Zbigniew Kacprzak
*/
public class Logging {
	private static Activator plugin = Activator.getDefault();


	public static void info(String message){
		ILog log = plugin.getLog();
		IStatus status = new Status(IStatus.INFO, plugin.getPluginId(),0,message,null);
		log.log(status);
	}

	public static void warn(String message){
		warning(message);
	}
	public static void warning(String message){
		ILog log = plugin.getLog();
		IStatus status = new Status(IStatus.WARNING, plugin.getPluginId(),0,message,null);
		log.log(status);
	}

	public static void error(String message){
		ILog log = plugin.getLog();
		IStatus status = new Status(IStatus.ERROR, plugin.getPluginId(),0,message,null);
		log.log(status);
	}

	public static void exception(Throwable ex){
		ILog log = plugin.getLog();
		IStatus status = null;
		if(ex instanceof CoreException){
			status = ((CoreException)ex).getStatus();
		} else {
			status = new Status(IStatus.ERROR, plugin.getPluginId(),0,ex.toString(),ex);
		}
		log.log(status);
	}

}
