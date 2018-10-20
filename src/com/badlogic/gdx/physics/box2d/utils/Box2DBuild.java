package com.badlogic.gdx.physics.box2d.utils;

import java.io.File;

import com.badlogic.gdx.jnigen.AntScriptGenerator;
import com.badlogic.gdx.jnigen.BuildConfig;
import com.badlogic.gdx.jnigen.BuildTarget;
import com.badlogic.gdx.jnigen.NativeCodeGenerator;
import com.badlogic.gdx.jnigen.BuildTarget.TargetOs;

public class Box2DBuild {
	public static void main(String[] args) throws Exception {
		//BuildTarget win32 = BuildTarget.newDefaultTarget(TargetOs.Windows, false);
		BuildTarget win64 = BuildTarget.newDefaultTarget(TargetOs.Windows, true);
		//BuildTarget lin32 = BuildTarget.newDefaultTarget(TargetOs.Linux, false);
		BuildTarget lin64 = BuildTarget.newDefaultTarget(TargetOs.Linux, true);
		BuildTarget android = BuildTarget.newDefaultTarget(TargetOs.Android, false);
		//BuildTarget mac32 = BuildTarget.newDefaultTarget(TargetOs.MacOsX, false);
		BuildTarget mac64 = BuildTarget.newDefaultTarget(TargetOs.MacOsX, true);
		BuildTarget ios = BuildTarget.newDefaultTarget(TargetOs.IOS, false);

		win64.compilerPrefix="";

		//new NativeCodeGenerator().generate("src", "bin" + File.pathSeparator + "../../../gdx/bin", "jni");
		//new NativeCodeGenerator().generate("src", "jni/maven/target/classes", "jni");
		new NativeCodeGenerator().generate("src", "jni/maven/target/classes;libs/gdx.jar", "jni");
		//new AntScriptGenerator().generate(new BuildConfig("gdx-liquidfun"), win32, win64, lin32, lin64, mac32, mac64, android, ios);
		new AntScriptGenerator().generate(new BuildConfig("gdx-liquidfun"), win64, lin64, mac64, android, ios);
		//new AntScriptGenerator().generate(new BuildConfig("gdx-liquidfun"), win64, lin64, android, ios);
	}
}