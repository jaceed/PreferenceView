[![](https://jitpack.io/v/jaceed/preference-view.svg)](https://jitpack.io/#jaceed/preference-view)

# PreferenceView
A handful preference item view

## Usage

Use `gradle`

First, add it in your root build.gradle at the end of repositories:

```gradle
    allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

Then, add the dependency:

```gradle
      dependencies {
	        implementation 'com.github.jaceed:preference-view:1.0.0'
	}
```

Or use `maven` with the following two contents instead of the above

```gradle
      <repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
```

and

```gradle
      <dependency>
	    <groupId>com.github.jaceed</groupId>
	    <artifactId>preference-view</artifactId>
	    <version>1.0.0</version>
	</dependency>
```


