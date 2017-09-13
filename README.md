[<img src="https://cdn.anychart.com/images/logo-transparent-segoe.png?2" width="234px" alt="AnyChart - Robust JavaScript/HTML5 Chart library for any project">](https://anychart.com)

Kotlin Ktor basic template
=========================

This example shows how to use AnyChart library with the Kotlin programming language, Ktor framework and MySQL database.

## Running

To use this sample you must have Gradle installed on your computer.
You can use SDKMAN to install it:
```
$ curl -s get.sdkman.io | bash
$ source "$HOME/.sdkman/bin/sdkman-init.sh"
$ sdk install gradle

# or simply
$ sudo apt-get install gradle

```
Also you must have MySQL installed and running. If not, please check out [MySQL Download page](https://dev.mysql.com/downloads/installer/) and follow [these instructions]( http://dev.mysql.com/doc/refman/5.7/en/installing.html).

To check your installations, run the following command in the command line:
```
$ gradle -version
------------------------------------------------------------
Gradle 2.10
...

$ mysql --version
mysql  Ver 14.14 Distrib 5.5.52, for debian-linux-gnu (x86_64) using readline 6. # sample output
```

To start this example run commands listed below.

Clone the repository from github.com:
```
$ git clone git@github.com:anychart-integrations/kotlin-ktor-mysql-template.git
```

Navigate to the repository folder:
```
$ cd kotlin-ktor-mysql-template
```

Set up MySQL database, use `-u -p` flags to provide username and password:
```
$  mysql < database_backup.sql
```

Run application:
```
$ gradle run
```

Open browser at http://localhost:8000/

## Workspace
Your workspace should look like:
```
groovy-grails-mysql-template/
    src/
        main/
            kotlin/
                com/
                    anychart/
                        Main.kt   # main Kotlin code
    .gitignore
    build.gradle    #gradle settings
    database_backup.sql   # MySQL database dump
    gradlew
    gradlew.bat
    README.md
    LICENSE
```

## Technologies
Language - [Kotlin](https://kotlinlang.org/)<br />
Web framework - [Ktor](http://ktor.io/)<br />
Template engine - [kotlinx.html](https://github.com/Kotlin/kotlinx.html)<br />
Build tool - [Gradle](https://gradle.org/)<br />
Database - [MySQL](https://www.mysql.com/)<br />
Database mapping - [Exposed](https://github.com/JetBrains/Exposed)<br />

## Further Learning
* [Documentation](https://docs.anychart.com)
* [JavaScript API Reference](https://api.anychart.com)
* [Code Playground](https://playground.anychart.com)
* [Technical Support](https://anychart.com/support)

## License
[© AnyChart.com - JavaScript charts](http://www.anychart.com). Released under the [Apache 2.0 License](https://github.com/anychart-integrations/kotlin-ktor-mysql-template/blob/master/LICENSE).
