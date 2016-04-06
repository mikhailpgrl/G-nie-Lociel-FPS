package com.g4.utils.excel;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;

public class UseFile {

	
	private String folderInput;
	private long interval;

	public UseFile(long interval, String folderInput){
		this.folderInput = folderInput;
		this.interval = interval;
	}
	
	public void start(){
	        FileAlterationObserver observer = new FileAlterationObserver(folderInput);
	        FileAlterationMonitor monitor =
	                new FileAlterationMonitor(interval);
	        FileAlterationListener listener = new FileAlterationListenerAdaptor() {
	            // Is triggered when a file is created in the monitored folder
	            @Override
	            public void onFileCreate(File file) {
	                try {
	                    // "file" is the reference to the newly created file
	                    System.out.println("New Files: "
	                            + file.getCanonicalPath());
	                    if (file.getCanonicalPath().substring(file.getCanonicalPath().lastIndexOf(".")).equals(".xslt") ||
	                    	file.getCanonicalPath().substring(file.getCanonicalPath().lastIndexOf(".")).equals(".xsl")){
	                    		ReadFile af = new ReadFile(folderInput);
	                    	
	                    	
	        			}
	                } catch (IOException e) {
	                    e.printStackTrace(System.err);
	                }
	            }
	            // Is triggered when a file is deleted from the monitored folder
	            @Override
	            public void onFileDelete(File file) {
	                try {
	                    // "file" is the reference to the removed file
	                    System.out.println("File removed: "
	                            + file.getCanonicalPath());
	                    // "file" does not exists anymore in the location
	                    System.out.println("File still exists in location: "
	                            + file.exists());
	                } catch (IOException e) {
	                    e.printStackTrace(System.err);
	                }
	            }
	        };
	        observer.addListener(listener);
	        monitor.addObserver(observer);
	        try {
				monitor.start();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
        }
	}
	
}
