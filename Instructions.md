# Requirements
1. Download IntelliJ Idea (version used : 15.0.2)
2. Download Andor's Trail from Github : https://github.com/oskarwiksten/andors-trail
3. Download the test module from Github : https://github.com/Dieulin/Andor-s-Trail-Test-Module


# Andor's Trail import
1. Launch Intellij Idea : "Import project" > (Select the Andor's Trail folder)
2. Next window "Import Project" : Select the option "Import project from external model" > then choose "Eclipse" > then "Next"
3. Next window "Import Project" : Check the option "Create module files near .classpath files" and select ".idea (directory based)" in the field "Project format" > then Next
4. Next window "Import Project" : Check the project name "AndorsTrail" > then "Next"
5. Next window "Import Project" : Click on the icon of the form of a cross > select "JDK" > Select the directory where the JDK 1.8 is saved (Example : C:\Program Files\Java\jdk1.8.0_66)
6. Click on the icon of the form of a cross > select "Android SDK" > Select the directory where the SDK is saved (Example : C:\Users\<username>\AppData\Local\Android\sdk) > then "Finish"
7. If the popup "Module Files Found" appears, click "Yes"

NB : Use the Android API 19 Platform (Target : Android 4.4.2) because in the most recent versions they removed some features used in Andor's Trail. Use the SDK Manager for that.


# Andor's Trail configuration
1. File > Project Structure
In the window "Project Structure" : Section "Project Settings" > Click on "Modules" > Then "AndorsTrail"
2. Click on the tab "Sources" > On the right blue panel, check that there are no two sources folder "gen". If it's the case, remove the "gen" folder and don't touch to "gen [generated]"
3. Click on the tab "Dependencies" > remove the dependency "com.android.ide.eclipse.adt.DEPENDENCIES" (if it is red)
4. In the main window : Click on "Apply" > then "Ok"

#### Method 1

1. Open the Project view
2. In "AndorsTrail/libs" > right click on the jar "android-support-v4.jar" > in the menu select "Add as library..."
3. In the popup "Create Library": Set the value of "Level" to "Project library" | and also the value of "Add to module" to "AndorsTrail" > then "Ok"

#### Method 2

1. "File" > "Project Structure"
2. In the window "Project Structure" : Section "Project Settings" > "Libraries"
3. Click on the icon of the form of a green cross > then "Java"
4. Select "AndorsTrail/libs/android-support-v4.jar"
5. In the window "Chose modules" : Select the module "AndorsTrail" > then click on "Apply" > then "OK"


# Import of the test module
1. "File" > "Project Structure" > in the section "Project Settings" select "Modules"
3. Click on the icon of the form of a green cross > then "Import module"
4. In the popup "Select Folder or Directory to Import" : select our test module
5. In the window "Import Module" : Select the option "Create module from existing sources" > then "Next"
6. In the next window : check all > then "Next"
7. In the next window : check libs > then "Next"
8. In the next window : check tests > then "Next"
9. If the popup "File Already Exists" appears, click on "Overwrite"
10. In the next window : check all > then "Finish"
11. In the main window : click on "Apply" > then "Ok"


#  Test module configuration
## Adding test dependencies
#### Method 1
1. Open the Project view > then go in "tests/libs" (If you notice a small black triangle on both Jar, go to the next step)
2. Right click on the jar "hamcrest-core-1.3.jar" > in the menu, select "Add as library..."
3. In the popup : Set the value of "Level" to "Project library" |  and also the value of "Add to module" to "tests"
4. Right click on the jar "junit-4.12.jar" > in the menu, select "Add as library..."
5. In the popup : Set the value of "Level" to "Project library" |  and also the value of "Add to module" to "tests"

#### Method 2
1. "File" > "Project Structure"
2. In the window "Project Structure" : in the section "Project Settings" > Select "Libraries"
3. Click on the icon of the form of a green cross > then "Java"
4. Select the jar "tests/libs/junit-4.12.jar"
5. In the window "Chose module" : Select the module "tests"
6. Click on the icon of the form of a green cross > then "Java"
7. Select the jar "tests/libs/hamcrest-core-1.3.jar"
8. In the window "Chose module" : Select the module "tests"


## Adding dependencies to Andor's Trail module
1. "File" > "Project Structure"
2. In the window "Project Structure" : in the section "Project Settings" select "Modules" > then "tests"
3. Click on the tab "dependencies"
4. Click on the icon of the form of a green cross > "Module dependency..." > Select "AndorsTrail" > then "Apply"


## Priority of dependencies
1. Always in the tab "Dependencies" : Select "Junit" and "Hamcrest" > then with the up arrow, move "Junit" and "Hamcrest" forward "Android API19 Platform"
  1. If "libs" is present in the list : move "libs" forward "Android API19 Platform"
3. Click on "Apply" > then "Ok"


# Run tests
1. Launch the AVD of your choice : Tools > Android > AVD Manager (in my case, I use : 3.4" WQVGA API 19)
2. Right click on the test class > Run (AndroidTest)
