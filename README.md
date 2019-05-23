# Projet DevOps

Ce projet s’intéresse à la mise en œuvre d’une bibliothèque de manipulation et d’analyse de données en Java. 

## Description
Le type d’objet principal manipulé par cette bibliothèque sont les Dataframe. La bibliothèque supporte:
	- la création de dataframes soit à partir d'un fichier CSV qui a un format précis, soit à partir d'un tableau deux dimensions 
	- des méthodes d'affichage d'un dataframe
	- des méthodes pour créer un nouveau dataframe en sélectionnant un sous-ensemble des données d’un dataframe existant.



## Functionalities
	* public void showAll() : affiche toutes les données dans le Dataframe
	
	* public void showHead(int n): affiche les n prémières lignes dans le Dataframe
	
	* public void showTail(int n): affiche les n derières lignes dans le Dataframe
	
	* public Dataframe selectRow(int idx): renvoie un nouveau Dataframe constitué de données dans la ligne pointé par idx dans un Dataframe existant
	
	
	* public Dataframe selectRows(int[] idx): renvoie un nouveau Dataframe constitué de données dans les lignes pointées par les valeurs dans le tableau idx 
	
	
	* public Dataframe selectColumn(String column): renvoie un nouveau Dataframe constitué des lignes de données de la colonne dont son nom est passé en argument
	
	
	* public Dataframe selectColumns(String[] columns): renvoie un nouveau Dataframe constitué des lignes de données dans les colonnes dont leurs noms sont passés en argument
	
	
	* public Double[] min(String[] columns): renvoie un tableau de valeurs flottantes correspondant aux maximum des valeurs dans les colonnes passées en argument
	
	
	* public Double[] max(String[] columns): renvoie un tableau de valeurs flottantes correspondant aux maximum des valeurs dans les colonnes passées en argument
	
	
	*public Double[] mean(String[] column): renvoie un tableau de valeurs flottantes correspondant aux moyennes arithmétiques des valeurs dans les colonnes passées en argument

Ces méthodes sont plus détaillés dans la documentation (voir dossier "doc").


## Outils

 1. Maven:
pour automatiser le processus de création de la structure de dossier initiale de l’application, pour faire les compilations, les tests, le packaging et le déploiement du produit final.

 2. Github: 
 pour la gestion de versions et la collaboration
 
 3. TravisCI
en liaison avec le dépôt github pour l'intégration continue et couverture de code


## Feedback
Ce projet nous a permis de manipuler des structures de données dans la representation de notre Dataframe. 
Ça nous a aussi présenté l'opportunité de mettre en pratique des notions et des outils vus en cours et en TP pour la prémière fois.
Nous avons pu découvrir  en travaillant que ces outils sont beaucoup plus utiles et moins compliqués qu'ils avaient l'aire  au départ. 
En plus, nous avons découvert quelques améliorations dans JUnit 5 par rapport à Junit 4, par exemple la possibilité de faire des tests parametrés
