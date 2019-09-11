/**
 * API for remove-gene filter
 * API for remove-gene filter.
 *
 * OpenAPI spec version: 1.2.0
 * Contact: apiteam@swagger.io
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 */

package sharpener.tcrd.model

case class Gene_info_identifiers(
  /* Entrez gene id (CURIE). */
  entrez: Option[String],
  /* HGNC gene id (CURIE). */
  hgnc: Option[String],
  /* OMIM gene id (CURIE). */
  mim: Option[String],
  /* ENSEMBL gene id (CURIE). */
  ensembl: Option[List[String]],
  /* myGene.info primary id. */
  mygene_info: Option[String])
