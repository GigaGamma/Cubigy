package com.cubigy.mods;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class ModLoader {
	
	public static ArrayList<Mod> mods = new ArrayList<Mod>();
	
	public void load_mods() {
		try {
			if (new File("mods").exists()) {
				File[] mods = new File("mods").listFiles();
			
				for (File mod : mods) {
					if (!mod.getName().endsWith(".jar"))
						continue;
					
					//System.out.println("Found mod: " + mod.getName().split(".jar")[0]);
					JarFile jar = null;
					
					jar = new JarFile(mod);
				
					Enumeration<?> e = jar.entries();
					URL[] urls = { new URL("jar:file:" + mod.getAbsolutePath() +"!/") };
					URLClassLoader cl = URLClassLoader.newInstance(urls);
				
					while (e.hasMoreElements()) {
						JarEntry je = (JarEntry) e.nextElement();
						
						if(je.isDirectory() || !je.getName().endsWith(".class")) {
							continue;
						}

						String className = je.getName().substring(0, je.getName().length() - 6);
						className = className.replace('/', '.');
						Class c = cl.loadClass(className);
						//System.out.println("Loaded mod class file: " + className);
						Class[] argTypes = new Class[] { };
						String[] args = {};
						if (c.isAnnotationPresent(Cubimod.class)) {
							try {
								//c.getConstructor(argTypes).newInstance(args);
								this.mods.add(new Mod(c, c.newInstance()));
								System.out.println("Loaded mod: '" + ((Cubimod) c.getAnnotation(Cubimod.class)).id()  + "'");
							} catch (Exception e2) {e2.printStackTrace();} 
						}
					}
				}
			} else {
				System.out.println("No 'mods' directory found");
			}
		} catch (Exception e) {e.printStackTrace();}
		
		
	}
	
}
