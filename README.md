# TP-5 : Intégration de Spring et Hibernate

## Description

Le projet illustre les concepts de base tels que :
- Configuration de Spring Boot avec Hibernate.
- Création d'entités JPA.
- Configuration de la base de données (par exemple, H2 pour les tests ou MySQL/PostgreSQL pour la production).
- Opérations CRUD via un repository Spring Data JPA.
- Gestion des transactions.

**Note :** Le dépôt semble actuellement vide. Ajoutez vos fichiers de code (pom.xml, classes Java, etc.) pour compléter le TP. La description du repo mentionne un TP-1 sur la programmation dynamique par réflexion, mais le nom du repo indique un focus sur Spring et Hibernate pour TP-5 – mettez à jour la description si nécessaire.

## Technologies utilisées
- **Hibernate** : ORM (Object-Relational Mapping) pour la persistance des données.
- **Spring Data JPA** : Abstraction pour les repositories.
- **Maven** : Outil de build (ou Gradle si préféré).
- **Base de données** : H2 (en mémoire pour les démos) ou une BDD externe.
- **Java** : Version 8 ou supérieure (recommandé : 17+ pour Spring Boot 3.x).

## Prérequis
- JDK installé (version 11 ou 17 recommandée).
- Maven installé (ou utilisez l'IDE pour gérer les dépendances).
- Un IDE comme IntelliJ IDEA, Eclipse ou VS Code avec extensions Java/Spring.
- Accès à une base de données si non utilisant H2.

## Installation et Configuration
1. **Cloner le dépôt :**
   ```
   git clone https://github.com/yassir2222/TP-5-Int-gration-de-Spring-et-Hibernate.git
   cd TP-5-Int-gration-de-Spring-et-Hibernate
   ```

2. **Importer le projet dans votre IDE :**
   - Ouvrez le dossier dans IntelliJ/Eclipse.
   - Laissez l'IDE importer le projet Maven.

3. **Configurer la base de données :**
   - Dans `src/main/resources/application.properties` (ou `application.yml`), ajoutez :
     ```
     spring.datasource.url=jdbc:h2:mem:testdb
     spring.datasource.driverClassName=org.h2.Driver
     spring.datasource.username=sa
     spring.datasource.password=
     spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
     spring.jpa.hibernate.ddl-auto=update
     spring.h2.console.enabled=true
     ```
     Pour une BDD externe (ex. MySQL) :
     ```
     spring.datasource.url=jdbc:mysql://localhost:3306/madb
     spring.datasource.username=root
     spring.datasource.password=votremotdepasse
     spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
     ```

4. **Dépendances Maven :**
   Assurez-vous que `pom.xml` inclut :
   ```xml
   <dependencies>
       <dependency>
           <groupId>org.springframework.boot</groupId>
           <artifactId>spring-boot-starter-data-jpa</artifactId>
       </dependency>
       <dependency>
           <groupId>com.h2database</groupId>
           <artifactId>h2</artifactId>
           <scope>runtime</scope>
       </dependency>
       <!-- Autres dépendances comme spring-boot-starter-web si needed -->
   </dependencies>
   ```

## Comment exécuter le projet
1. **Build le projet :**
   ```
   mvn clean install
   ```

2. **Lancer l'application :**
   ```
   mvn spring-boot:run
   ```
   Ou via l'IDE : Exécutez la classe principale annotée avec `@SpringBootApplication`.

3. **Accéder à H2 Console (si activée) :**
   - Ouvrez `http://localhost:8080/h2-console` dans un navigateur.
   - JDBC URL : `jdbc:h2:mem:testdb`

4. **Tester les fonctionnalités :**
   - Créez des contrôleurs REST pour tester les opérations CRUD sur vos entités.
   - Exemple : Utilisez Postman ou curl pour interagir avec les endpoints.

## Structure du projet
```
TP-5-Int-gration-de-Spring-et-Hibernate/
├── pom.xml                  # Fichier Maven
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/demo/  # Package principal
│   │   │       ├── DemoApplication.java  # Classe principale
│   │   │       ├── entity/     # Entités JPA (ex. User.java)
│   │   │       ├── repository/ # Repositories Spring Data (ex. UserRepository.java)
│   │   │       └── service/    # Services métier
│   │   └── resources/
│   │       └── application.properties  # Configuration
│   └── test/                 # Tests unitaires
└── README.md                 # Ce fichier
```

## Exemple de code
### Entité JPA (ex. User.java)
```java
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    private Long id;
    private String name;
    // Getters et setters...
}
```

### Repository
```java
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
```

## Demonstration 
<img width="1611" height="354" alt="image" src="https://github.com/user-attachments/assets/2221b15e-750e-49f1-8bed-143115a33023" />
### Page index.jsp
<img width="436" height="573" alt="image" src="https://github.com/user-attachments/assets/708f51d2-c07f-49c7-adb2-e6f1413d40fb" />



Auteur : yassir2222  
Email : 
