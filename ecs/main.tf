resource "aws_ecs_cluster" "ecs_demo" {
  name = "ecs-demo"
}

resource "aws_ecs_task_definition" "ecs-demo" {
  family                = "ecs-demo"
  container_definitions = "${file("task-definitions/ecs-demo.json")}"
}
