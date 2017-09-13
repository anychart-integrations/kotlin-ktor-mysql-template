package com.anychart

import com.google.gson.Gson
import kotlinx.html.*
import kotlinx.html.stream.appendHTML
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.ktor.netty.*
import org.jetbrains.ktor.routing.*
import org.jetbrains.ktor.host.*
import org.jetbrains.ktor.http.*
import org.jetbrains.ktor.response.*

object Fruits : Table("fruits") {
    val id = integer("id").primaryKey()
    val name = varchar("name", length = 64)
    val value = integer("value")
}

data class Fruit(val id: Int, val name: String, val value: Int)

/*
    Init MySQL database connection
 */
fun initDB() {
    val url = "jdbc:mysql://anychart_user:anychart_pass@localhost:3306/anychart_db?useUnicode=true&serverTimezone=UTC"
    val driver = "com.mysql.cj.jdbc.Driver"
    Database.connect(url, driver)
}

/*
    Getting fruit data from database
 */
fun getTopFruits(): String {
    var json: String = ""
    transaction {
        val res = Fruits.selectAll().orderBy(Fruits.value, false).limit(5)
        val c = ArrayList<Fruit>()
        for (f in res) {
            c.add(Fruit(id = f[Fruits.id], name = f[Fruits.name], value = f[Fruits.value]))
        }
        json = Gson().toJson(c);
    }
    return json
}

/*
    Main function
 */
fun main(args: Array<String>) {
    initDB()
    embeddedServer(Netty, 8080) {
        routing {
            get("/") {
                call.respondText(template(getTopFruits()), ContentType.Text.Html)
            }
        }
    }.start(wait = true)
}

/*
    HTML template
 */
fun template(fruitsJson: String): String {
    return StringBuilder().appendHTML().html {
        lang = "en"
        head {
            meta { charset = "UTF-8" }
            title { +"AnyChart Kotlin Ktor MySQL template" }
            script { src = "https://cdn.anychart.com/js/latest/anychart-bundle.min.js" }
            link {
                href = "https://cdn.anychart.com/css/latest/anychart-ui.min.css"
                rel = "stylesheet"
            }
            style {
                +"""html, body, #container {
                        width: 400px;
                        height: 400px;
                        margin: 0;
                        padding: 0;
                    }""".trimIndent()
            }
        }
        body {
            div { id = "container" }
            script {
                unsafe {
                    +"""var chart = anychart.pie($fruitsJson);
                    chart.title('Top 5 fruits');
                    chart.container('container');
                    chart.draw();
                """
                }
            }
        }
    }.toString()
}