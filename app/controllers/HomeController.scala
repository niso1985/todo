package controllers

import java.sql.SQLException
import javax.inject._
import play.api.db.Database
import play.api.mvc._


@Singleton
class HomeController @Inject()(db: Database,
  cc: MessagesControllerComponents) extends MessagesAbstractController(cc) {

  def index() = Action { implicit request: Request[AnyContent] =>
    var msg = "database recode:<br><ul>"
    try {
      db.withConnection { conn =>
        val stmt = conn.createStatement
        val rs = stmt.executeQuery("SELECT * FROM todo")
        while (rs.next) {
          msg += "</li>" + rs.getInt("id") + ":" +
            rs.getString("title") + "</li>"
        }
        msg += "</ul>"
      }
    } catch {
      case e:SQLException =>
        msg = "<li> no record</li>"
    }
    Ok(views.html.index(msg))
  }
}
