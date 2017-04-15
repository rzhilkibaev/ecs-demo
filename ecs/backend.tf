terraform {
  backend "s3" {
    key = "ecs.tfstate"
    region = "us-west-2"
  }
}
