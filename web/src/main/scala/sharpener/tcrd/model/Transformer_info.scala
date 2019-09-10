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

case class Transformer_info(
/* Name of the transformer. */
  name: String,
  /* Function of the transformer, one of 'producer', 'expander', 'filter'. */
  function: String,
  /* Description of the transformer. */
  description: String,
  /* Parameters used to control the transformer. */
  parameters: List[Parameter],
  /* Gene attributes required by the transformer */
  required_attributes: List[String]
  )
