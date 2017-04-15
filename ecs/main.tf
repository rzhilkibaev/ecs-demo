resource "aws_ecs_cluster" "ecs-demo" {
  name = "ecs-demo"
}

resource "aws_ecs_task_definition" "ecs-demo" {
  family                = "ecs-demo"
  container_definitions = "${file("task-definitions/ecs-demo.json")}"
}

resource "aws_ecs_service" "ecs-demo" {
  name            = "ecs-demo"
  cluster         = "${aws_ecs_cluster.ecs-demo.id}"
  task_definition = "${aws_ecs_task_definition.ecs-demo.arn}"
  desired_count   = 1
  #iam_role        = "${aws_iam_role.foo.arn}"
  #depends_on      = ["aws_iam_role_policy.foo"]

  #placement_strategy {
  #  type  = "binpack"
  #  field = "cpu"
  #}

  #load_balancer {
  #  elb_name       = "${aws_elb.foo.name}"
  #  container_name = "mongo"
  #  container_port = 8080
  #}

  #placement_constraints {
  #  type       = "memberOf"
  #  expression = "attribute:ecs.availability-zone in [us-west-2a, us-west-2b]"
  #}
}
