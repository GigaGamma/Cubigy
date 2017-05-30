package com.cubigy.mods;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Cubimod {
	
	public String id();
	public String name();
	public String[] authors();
	public String description() default "No Description";
	public ModType type() default ModType.FEATURES;
	
}
