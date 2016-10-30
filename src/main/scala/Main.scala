import akka.actor.ActorSystem
import auctionsearch.AuctionSearch
import conf.Conf
import users.{Buyer, Seller}

/**
  * Created by neo on 22.10.16.
  */
object Main extends App {
  val system = ActorSystem(Conf.defaultAuctionSystemName)
  val auctionSearch = system.actorOf(AuctionSearch.props, Conf.defaultAuctionSearchName)

  val seller1 = system.actorOf(Seller.props(List("Auto Czarne Audi", "Auto Czerwona Beemka", "Auto Zielony Fiat")), "seller1")
  val seller2 = system.actorOf(Seller.props(List("PC Lenovo", "PC Asus")), "seller2")

  val buyer1a = system.actorOf(Buyer.props("Auto", 10), "buyer1a")
  val buyer1b = system.actorOf(Buyer.props("Auto", 11), "buyer1b")
  val buyer1c = system.actorOf(Buyer.props("Audi", 9), "buyer1c")
  val buyer2a = system.actorOf(Buyer.props("PC", 8), "buyer2a")
  val buyer2b = system.actorOf(Buyer.props("Asus", 12), "buyer2b")
}
