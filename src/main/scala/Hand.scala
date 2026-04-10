import rangos.Rangos

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer



class Hand (cards: ArrayBuffer[Card]) {

  val counter: mutable.Map[Int, Int] = mutable.Map()

  def check(): String = {
    for (card <- cards) {
      if (counter.contains(card.rank.order)) {
        counter(card.rank.order) += 1
      }
      else {
        counter(card.rank.order) = 1
      }
    }
    val (maxRank, count) = counter.maxBy(_._2)

    counter.remove(maxRank)

    val (secondMax, secondCount) = counter.maxBy(_._2)

    if (count == 2) {
      f"La mano más alta es un par de $maxRank"
    }
    else {
      "La mano más alta es carta más alta"
    }
  }
}
