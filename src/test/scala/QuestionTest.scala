import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers
import play.api.libs.json.{ Json, OFormat, Reads }

import scala.concurrent.Future

case class Person(id: Long,
                  firstName: String,
                  lastName: String,
                  email: Option[String],
                  gender: String,
                  age: Int,
                  countryCode: String)

object Person {
  def format: OFormat[Person] = Json.format[Person]
}

class QuestionTest extends AnyFlatSpec with Matchers {

  def loadData(): Seq[Person] = {
    val dateJs = Json.parse(getClass.getResourceAsStream("persons.json"))
    dateJs.as[Seq[Person]](Reads.seq(Person.format))
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

  it should "age min/avg/max by country" in {

  }

  it should "get all defined email" in {

  }

  it should "get the unique characters used in firstName in the whole dataset" in {

  }

  it should "apply a function" in {
    def fun(p: Person): Int = p.hashCode()
  }

  it should "apply a multi param function" in {
    def fun2(factor: Int)(p: Person): Int = p.hashCode() * factor
  }

  it should "apply an async function on all persons and return a single Future" in {
    def funAsync(p: Person): Future[String] = Future("write some stuff in DB")(scala.concurrent.ExecutionContext.global)
  }

  it should "apply 2 consecutive async functions and return a single Future" in {
    def funAsync(p: Person): Future[String] = Future("write some stuff in DB")(scala.concurrent.ExecutionContext.global)
    def funAsync2(p: Person): Future[String] = Future("write some stuff in some file")(scala.concurrent.ExecutionContext.global)
  }

}

class PolymorphismTest extends AnyFlatSpec with Matchers {

  trait Id {
    val id: Int
  }

  case class A(id: Int, a: Int) extends Id

  case class B(id: Int, b: Int) extends Id

  val idA = A(1, 2)
  val idB = B(3, 4)

  "write a getId function that" should "return the id value of idA or idB" in {
    /*
    getId(idA) -> 1
    getId(idB) -> 3
    */
  }

  "write a getIdSum function that" should "return the sum of id + a for type A, or id + b for type B" in {
    /*
      getIdSum(idA) -> 3
      getIdSum(idB) -> 7
     */
  }

  "write a getTuple function that" should "return a tuple of the object and its id, without loosing the type" in {
    /*
      getTuple(idA): (Int, A) -> (1, idA)
      getTuple(idB): (Int, B) -> (3, idB)
     */
  }

}