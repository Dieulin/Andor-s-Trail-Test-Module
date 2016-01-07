# Prérequis
1. Télécharger Intellij Idea (moi j'utilise la version 15.0.2)
2. Télécharger Andor's Trail depuis le dépôt Github : https://github.com/oskarwiksten/andors-trail
3. Télécharger le module de test depuis le dépôt : https://github.com/Dieulin/CAL-Andor-s-Trail.git


# Import d'Andor's Trail
1. Lancer Intellij Idea : "Import project" > (Selectionner le dossier Andor's Trail téléchargé)
2. Fenêtre suivante "Import Project" : Sélectionner l'option "Import project from external model" > puis sélectionner "Eclipse" > puis "Next"
3. Fenêtre suivante "Import Project" : Cocher l'option "Create module files near .classpath files" et Sélectionner ".idea (directory based)" dans le champ "Project format" > puis Next
4. Fenêtre suivante "Import Project" : Cocher le nom du projet "AndorsTrail" > puis "Next"
5. Fenêtre suivante "Import Project" : Clic sur l'icone en forme de plus > sélectionner "JDK" > Sélectionner le repertoire où est sauvegardé le JDK 1.8 (Exemple : C:\Program Files\Java\jdk1.8.0_66 sur Windows)
6. Encore clic sur l'icone en forme de plus > sélectionner "Android SDK" > Sélectionner le repertoire où est sauvegardé le SDK (Exemple : C:\Users\<username>\AppData\Local\Android\sdk sur Windows) > puis "Finish"
7. Si la popup Module Files Found s'ouvre cliquez sur "Yes"

NB : Utilisez l'Android API 19 Platform (Target : Android 4.4.2) car dans les plus recentes versions ont supprimés certaines fonctions qui sont utilisées dans Andor's Trail. Il est facilement téléchargeable depuis le SDK Manager.


# Configuration d'Andor's Trail
1. File > Project Structure
Dans la fênetre "Project Structure" : Section "Projet Settings" > Clic sur "Modules" > Puis sur "AndorsTrail"
2. Clic sur la tabulation "Sources" > Sur le pannel bleu à droite vérifier qu'il n'y ait pas 2 sources folder "gen". Si c'est le cas alors supprimer le folder "gen" et laisser "gen [generated]"
3. Clic tabulation "Dependencies" > supprimer la la dependence "com.android.ide.eclipse.adt.DEPENDENCIES" (Si elle est rouge)
4. Dans la fenetre principale : Clic sur "Apply" > puis sur "Ok"

1. Ouvrir la perspective Project
2. Aller dans "AndorsTrail/libs" > clic droit sur le jar "android-support-v4.jar" > dans le menu selectionner "Add as library..."
3. Dans la popup "Create Library": Définir la valeur de "Level" à "Project library" | et celle de "Add to module" à "AndorsTrail" > Puis "Ok"

--- Alternative

1. "File" > "Project Structure"
2. Dans la fênetre "Project Structure" : Section "Projet Settings" > "Librairies"
3. Clic sur l'icone en forme de plus vert > puis "Java"
4. Selectionner "AndorsTrail/libs/andoid-support-v4.jar"
5. Dans la fenetre "Chose modules" : Selectionner le module "AndorsTrail" > Puis clic sur "Apply" > puis "OK"


# Ajout La classe TestUtil
1. Copier la classe "TestUtil.java" (fournit avec le module de test) dans le package "src.com.gpl.rpg.AndorsTrail" du projet "AndorsTrail"


# Import du module de test
1. "File" > "Project Structure" > dans la section "Projet Settings" selectionner "Modules"
3. Clic sur l'icone en forme de plus vert > puis "Import module"
4. Dans la popup "Select Fole or Directory to Import" : Selectionner notre module tests
5. Dans la fenetre "Import Module" : Selectionner l'option "Create module from existing sources" > Puis "Next"
6. Dans la fenetre suivante : Tout cocher > puis "Next"
7. Dans la fenetre suivante : Cocher libs > puis "Next"
8. Dans la fenetre suivante : Cocher tests > puis "Next"
9. Si la popup "File Already Exists" s'ouvre Clic sur "Overwrite"
10. Dans la fenetre suivante : tout cocher > puis "Finish"
11. Dans la fenetre principale : Clic sur "Apply" > puis "Ok"


# Configuration du module de test
## ajout dependences de test
1. Ouvrir la perspective Project > puis aller dans "tests/libs" (Si vous remarqez un petit triangle noir sur les deaux Jar alors sauter l'étape et aller à B)
2. Clic droit sur le jar "hamcrest-core-1.3.jar" > dans le menu selectionner "Add as library..."
3. Dans la popup : Définir la valeur de "Level" à "Project library" |  et celle de "Add to module" à "tests"
4. Clic droit sur le jar "junit-4.12.jar" > dans le menu selectionner "Add as library..."
Dans la popup : Définir la valeur de "Level" à Project library | et celle de "Add to module" à "tests"

--- Alternative

1. "File" > "Project Structure"
2. Dans la fênetre "Project Structure" : Dans la section "Projet Settings" > Selectionner "Librairies"
3. Clic sur l'icone en forme de plus vert > Puis "Java"
4. Selectionner le jar "tests/libs/junit-4.12.jar"
5. Dans la fenetre "Chose module" : Selectionner le module "tests"
6. De nouveau Clic sur l'icone en forme de plus vert > Puis "Java"
7. Selectionner le fichier "tests/libs/hamcrest-core-1.3.jar"
8. Dans la fenetre "Chose module" : Selectionner le module "tests"


## Ajout dependence au module Andor's Trail
1. "File" > "Project Structure"
2. Dans la fênetre "Project Structure" : Dans la section "Projet Settings" sselectionner "Modules" > puis "tests"
3. Clic sur la tabulation "dependencies"
4. Clic sur l'icone en forme de plus vert > "Module dependency..." > Selectionner "AndorsTrail" > puis "Apply"


## Priorité des dépendences
1.
  1. Toujours dans la tabulation "Dependencies" : Selectionner "Junit-*" et "Hamcrest-*" > Puis avec la flèche du haut déplacer les avant "Android API19 Platform"
  2. Si "libs" est présent dans la liste : déplacer "libs" avant "Android API19 Platform"
2. Clic sur "Apply" > puis "Ok"


# Run tests
Lancer l'AVD de votre choix : Tools > Android > AVD Manager (dans mon cas j'utilise : 3.4" WQVGA API 19)
Clic droit sur la classe de test > Run (AndroidTest)
