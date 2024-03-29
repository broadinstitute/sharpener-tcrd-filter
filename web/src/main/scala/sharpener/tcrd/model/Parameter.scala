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

case class Parameter(
  /* Name of the parameter. */
  name: String,
  /* Type of the parameter, one of 'Boolean', 'int', 'double', 'string'. */
  `type`: String,
  /* Default value of the parameter. */
  `default`: String,
  /* Allowed values for the parameter. */
  allowed_values: Option[List[String]],
  /* Suggested value range for the parameter. */
  suggested_values: Option[String],
  /* URL to search for suitable parameter values. */
  lookup_url: Option[String])
