rootProject.name = "microservice-container"

include(
    "microservices:gateway",
    "microservices:eureka",
    "microservices:config",
    "microservices:student",
    "microservices:course"
)