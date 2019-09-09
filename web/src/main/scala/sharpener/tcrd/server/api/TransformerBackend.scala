package sharpener.tcrd.server.api

import sharpener.tcrd.model.{ Gene_info, Gene_info_identifiers, Parameter, Transformer_info, Transformer_query }
import com.softwaremill.sttp._
import com.softwaremill.sttp.circe._
import io.circe
import io.circe.generic.auto._
import sharpener.tcrd.model.backend.{ Filter, FilterOptions, GenesFilterQuery }

object TransformerBackend {

  case class Error(message: String)

  val baseUrl: String = "http:/localhost:8888/Default/"

  def getTransformerInfo: Either[Error, Transformer_info] = {
    val url = baseUrl + "/possibleFilters"
    val request = sttp.get(Uri(url)).response(asJson[Seq[FilterOptions]])
    implicit val backend = HttpURLConnectionBackend()
    val response: Id[Response[Either[DeserializationError[circe.Error], Seq[FilterOptions]]]] = request.send()
    response.body match {
      case Left(message) => Left(Error(message))
      case Right(Left(DeserializationError(_, _, message))) => Left(Error(message))
      case Right(Right(filterOptionsList)) =>
        val name = "TCRD-Filter"
        val function = "filter"
        val description = "Filters by condition based on TCRD data."
        val fieldNameParam = Parameter("field", "string", "", None)
        val opNameParam = Parameter("op", "string", "", None)
        val valueParam = Parameter("value", "string", "", None)
        val parameters = List(fieldNameParam, opNameParam, valueParam)
        val required_attributes = List.empty[String]
        val transformer_info = Transformer_info(name, function, description, parameters, required_attributes)
        Right(transformer_info)
    }
  }

  val fieldParamKey = "field"
  val opParamKey = "op"
  val valueParamKey = "value"

  def transform(query: Transformer_query): Either[Error, Seq[Gene_info]] = {
    val url = baseUrl + "filterGenes"
    val paramsByKey = query.controls.map(control => (control.name, control.value)).toMap
    (paramsByKey.get(fieldParamKey), paramsByKey.get(opParamKey), paramsByKey.get(valueParamKey)) match {
      case (None, _, _) => Left(Error("No parameter given for field"))
      case (_, None, _) => Left(Error("No parameter given for op"))
      case (_, _, None) => Left(Error("No parameter given for value"))
      case (Some(field), Some(op), Some(value)) =>
        val filter = Filter(field, op, value)
        query.genes match {
          case None => Left(Error("Need list of genes"))
          case Some(gene_infos) =>
            val geneInfosById = gene_infos.collect {
              case gene_info @ Gene_info(_, Some(Gene_info_identifiers(Some(entrez), _, _, _)), _) =>
                (entrez, gene_info)
            }.toMap
            val geneIds = geneInfosById.keys.toList
            val backendQuery = GenesFilterQuery(geneIds, List(filter))
            implicit val backend = HttpURLConnectionBackend()
            val response = sttp.post(Uri(url)).body(backendQuery).response(asJson[List[String]]).send()
            response.body match {
              case Left(message) => Left(Error(message))
              case Right(Left(DeserializationError(_, _, message))) => Left(Error(message))
              case Right(Right(geneIdsFiltered)) =>
                Right(geneIdsFiltered.flatMap(geneInfosById.get))
            }
        }
    }
  }
}
