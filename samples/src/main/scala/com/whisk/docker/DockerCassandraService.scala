package com.whisk.docker

trait DockerCassandraService extends DockerKit {

  val DefaultCqlPort = 9042

  val cassandraContainer = DockerContainer("whisk/cassandra:2.1.8")
    .withPorts(DefaultCqlPort -> None)
    .withReadyChecker(DockerReadyChecker.LogLineContains("Starting listening for CQL clients on"))

  abstract override def dockerContainers = cassandraContainer :: super.dockerContainers
}
