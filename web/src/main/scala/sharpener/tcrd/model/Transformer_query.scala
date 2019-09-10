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

case class Transformer_query(
/* List of genes that will be transformed. Required for expanders and filters; should be omitted for producers. */
  genes: Option[List[Gene_info]],
  /* Values that control the behavior of the transformer. Names of the controls must match the names specified in the transformer's definition and values must match types (and possibly  allowed_values) specified in the transformer's definition. */
  controls: List[Property]
  )
