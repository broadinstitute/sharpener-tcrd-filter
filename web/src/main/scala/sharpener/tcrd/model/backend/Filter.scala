package sharpener.tcrd.model.backend

case class Filter(
  field: String,
  op: String,
  value: String)
