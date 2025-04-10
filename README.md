TAGNE SOUOP Thomas Disney
22p238
TP de POO pour un apprentissage de la programmation orientée objet et évènementielle
/*Thème: Monter une application permettant d'enregistrer un appareils comme volé, de vérifier à partir des données 
       enregistrées si un appareils est volé et d'alerter éventuellement le propriétaire.*/
       
/*Besoin: 
-Base de donneés SQl contenant les tables suivante:
  - userMySQL pour enregister les utilisateurs:
  +-----------+--------------+------+-----+---------+----------------+
| Field     | Type         | Null | Key | Default | Extra          |
+-----------+--------------+------+-----+---------+----------------+
| UserId    | int          | NO   | PRI | NULL    | auto_increment |
| Name      | varchar(20)  | YES  |     | NULL    |                |
| Firstname | varchar(20)  | YES  |     | NULL    |                |
| Tel       | int unsigned | YES  |     | NULL    |                |
| Password  | varchar(20)  | YES  |     | NULL    |                |
+-----------+--------------+------+-----+---------+----------------+
 -Phone pour Enregistrer les téléphones:
 +-----------------+-------------+------+-----+---------+-------+
| Field           | Type        | Null | Key | Default | Extra |
+-----------------+-------------+------+-----+---------+-------+
| IdPhone         | varchar(50) | NO   | PRI | NULL    |       |
| NamePhone       | varchar(50) | YES  |     | NULL    |       |
| TelProprioPhone | int         | YES  |     | NULL    |       |
+-----------------+-------------+------+-----+---------+-------+
 -Computer pour enregistrer les Ordinateurs: 
 +--------------------+-------------+------+-----+---------+-------+
| Field              | Type        | Null | Key | Default | Extra |
+--------------------+-------------+------+-----+---------+-------+
| IdComputer         | varchar(50) | NO   | PRI | NULL    |       |
| NameComputer       | varchar(50) | YES  |     | NULL    |       |
| TelProprioComputer | int         | YES  |     | NULL    |       |
+--------------------+-------------+------+-----+---------+-------+
- Un environnement de travail Java (tel que IntelliJ) pour compiler le programme et un JDBC pour gérer la connection
à la Base de Donnée*/
/*Technologies utilisées: 
   - Java Swing pour le front-end
   - Java pour le Back-end
*/
/*La fonction <<alerter le propiétaire>> est encore fictive*/
