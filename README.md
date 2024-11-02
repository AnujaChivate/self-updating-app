# Steps to execute:

## Client side: https://github.com/AnujaChivate/self-updating-program.git
**i**. Compile Java file: javac -cp ./libs/gson-2.11.0.jar src/com/selfupdate/Update.java -d ./bin
**ii**. Create Jar file: jar cfm update-version-1.0.0.jar MANIFEST.MF -C bin .
**iii**. Copy this Jar file in server project
**vii**. Run jar file of old version and see console.log: java -jar update-version-1.1.0.jar 


## Server project:
**iv**: Create checksum of jar file: md5sum ./src/main/resources/update/update-version-1.2.0.jar
**v**. Copy the created hash code in Client project inside Update-info.json file and also update version to new version
**vi**. Run server: mvn clean install AND mvn spring-boot:run
