
import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration._

class BasicSimulation extends Simulation {

  val httpProtocol = http
    .baseURL("http://ec2-54-146-21-195.compute-1.amazonaws.com")
    .inferHtmlResources()


  val uri1 = "https://localhost:8443/v4/companies/4771989/searchResults?userInput=cambo&queryByEntityCategory=true&offset=0&pageSize=10"

  val dev = scenario("DevSimulation")
    .exec(http("dev")
      .get(":10010/dev")
    )

  val e2e = scenario("E2ESimulation")
    .exec(http("e2e")
      .get(":10011/e2e")
    )

  setUp(
    dev.inject(
      rampUsers(100) over (10 seconds)
    ),
    e2e.inject(
      rampUsers(100) over (10 seconds)
    )
  ).protocols(httpProtocol)
}
