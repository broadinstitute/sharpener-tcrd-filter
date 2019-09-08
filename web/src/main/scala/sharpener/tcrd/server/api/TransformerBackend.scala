package sharpener.tcrd.server.api

import sharpener.tcrd.model.{ Gene_info, Transformer_info, Transformer_query }

object TransformerBackend {

  val baseUrl: String = "http:/localhost:8888/Default/"

  def getTransformerInfo: Transformer_info = {
    ???
  }

  def transform(query: Transformer_query): Seq[Gene_info] = ???

}
