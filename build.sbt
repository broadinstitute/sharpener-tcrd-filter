lazy val root = (project in file(".")).aggregate(web)

lazy val web = (project in file("web"))
