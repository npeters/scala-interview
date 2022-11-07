import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers
import play.api.libs.json.{JsValue, Json, OFormat, Reads}

import java.io.FileInputStream

case class Person(id: Long,
                  firstName: String,
                  lastName: String,
                  email: String,
                  gender: String,
                  age: Int,
                  countryCode:String
                 )

object Person {
  def format: OFormat[Person] = Json.format[Person]
}






class QuestionTest extends AnyFlatSpec with Matchers {

  def loadData(): Seq[Person] = {
    val dateJs = Json.parse(getClass.getResourceAsStream("persons.json"))
    dateJs.as[Seq[Person]](  Reads.seq(Person.format))
  }

  val data: Seq[Person] = loadData()

  "question" should "get person with id 42" in {

  }

  it should "compute max and avg age" in {

  }

  it should "sort by firstName" in {

  }

  it should "get firstName of person where countryCode is FR" in {

  }

  it should "count person by countryCode and sort it" in {

  }






}