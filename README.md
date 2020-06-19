# Dove
Highly customizable material toast for android

[![](https://jitpack.io/v/kamaravichow/Dove.svg)](https://jitpack.io/#kamaravichow/Dove)


### Gradle

Add below code to your root `build.gradle` file (NOT module gradle file)

```gradle
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

Add this to your module `build.gradle` file

```gradle
dependencies {
	        implementation 'com.github.kamaravichow:Dove:Tag'
	}
```

### Usage

To make a defualt Dove Toast :
```java
DoveToast.makeText(view.getContext(),"This is a Dove DefaultToast", Dove.DOVE_LENGTH_LONG);
```

Making a custom Dove toast :
```java
DoveToast.makeText(view.getContext(), "This is custom Dove Toast", R.mipmap.ic_launcher, Dove.DOVE_LENGTH_SHORT).setBackgroundColor(Color.RED).show();
```

Complete Version :

```java
DoveToast toast = new DoveToast(this) // Make a dove toast object
                .setMessage("Message");
        toast.setIcon(R.mipmap.ic_launcher); // set values later
        toast.show(); // call to show
```

Refer the code in sample app for more details : [Sample/MainActivity.java](https://github.com/kamaravichow/Dove/blob/master/app/src/main/java/io/github/kamaravichow/MainActivity.java)
