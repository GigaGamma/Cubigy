package com.cubigy.mods;

public class ModDataExtractor {
	
	public static Cubimod getModAnnotation(Class<?> modClass) {
		return (Cubimod) modClass.getAnnotation(Cubimod.class);
	}
	
}
