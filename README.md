# ZoomX

Tool to log all network calls in a suitable format.

# Feature Examples

[![Webp.net-gifmaker.gif](https://s17.postimg.org/8gz1mfrin/Webp.net-gifmaker.gif)](https://postimg.org/image/cq3rolurv/)

# Usage 

Gradle:

Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			maven { url 'https://jitpack.io' }
		}
	}
  
Step 2. Add the dependency [ make sure that you are on the latest release number ]

	dependencies {
	        compile 'com.github.fathallah92:ZoomX:0.5'
	}
    
  # TODO
  
  - App dependency version abstraction
  - Revisit implementing map
  - Revisit request adapter
  
