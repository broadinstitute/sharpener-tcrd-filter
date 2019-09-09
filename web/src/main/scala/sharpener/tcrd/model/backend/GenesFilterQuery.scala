package sharpener.tcrd.model.backend

case class GenesFilterQuery(
  genes: List[String],
  filters: List[Filter])
