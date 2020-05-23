.DEFAULT_GOAL := help
SHELL:=/bin/bash

## GENERAL ##
OWNER 			= pao
SERVICE_NAME 	= skeleton

## RESULT_VARS ##
PROJECT_NAME			= $(OWNER)-$(SERVICE_NAME)
export IMAGE_DEV 		= $(PROJECT_NAME):dev
export IMAGE_BUILD 		= $(PROJECT_NAME):latest
export IMAGE_RAML		= $(PROJECT_NAME):raml
export PORT_RAML_LIVE	= 3020


UID:=$(shell id -u)
GID:=$(shell id -g)

install-cli: ## build image to dev: make build
	docker build -f container/cli/Dockerfile -t $(PROJECT_NAME):cli container/cli/

run-cli: ## build image to dev: make build
	@docker run --user $(UID):$(GID) --rm -v $(PWD)/container/cli/generator:/project  -v $(PWD)/application:/application $(PROJECT_NAME):cli
	@cat $(PWD)/application/cli/diff/diff_color.txt

run-cli-test: ## build image to dev: make build
	@docker run -t --rm -v $(PWD)/container/cli/generator:/project --workdir /project --entrypoint /project/test.sh $(PROJECT_NAME):cli

install: ## build image to dev: make build
	docker build -f container/doc/Dockerfile -t $(IMAGE_RAML) container/doc/

build: ## build image to dev: make build
	docker build -f container/run/DockerFile -t $(IMAGE_DEV) container/run/

build-jar: ## build image to dev: make build
	docker build -f container/jar/DockerFile --no-cache -t $(IMAGE_DEV) .

build-ci:  ## build jar for ci process 
	@make build-jar
	docker create -ti --name tempy $(IMAGE_DEV) bash
	mkdir -p deploy/jar/
	docker cp tempy:/application/applications/build/libs/applications.jar deploy/jar/
	docker rm -f tempy
	cp container/build/* deploy/jar/

logs: 
	cd container/ && docker-compose logs  -f

start: 
	cd container/ && docker-compose up -d

stop:
	cd container/ && docker-compose down

## Documentation RAML##
raml-generate: ## build image to raml: make build-raml
	docker run --rm -v $(PWD):/workdir $(IMAGE_RAML) -i /workdir/doc/api.raml -o /workdir/application/applications/resources/custom-files/docs/api.html
	docker run --rm -v $(PWD):/workdir $(IMAGE_RAML) --theme raml2html-markdown-theme -i /workdir/doc/api.raml -o /workdir/doc.md

raml-live: ## build image to raml: make raml-live
	docker run -d --name api-designer -v $(PWD)/doc:/raml -p $(PORT_RAML_LIVE):3000 loostro/api-designer:0.3.2
	open http://localhost:$(PORT_RAML_LIVE)/

docker-kill: ## kill docker instances
	docker rm -f $$(docker ps -aq)

help:
	@printf "\033[31m%-16s %-59s %s\033[0m\n" "Target" "Help" "Usage"; \
	printf "\033[31m%-16s %-59s %s\033[0m\n" "------" "----" "-----"; \
	grep -hE '^\S+:.## .$$' $(MAKEFILE_LIST) | sed -e 's/:.##\s/:/' | sort | awk 'BEGIN {FS = ":"}; {printf "\033[32m%-16s\033[0m %-58s \033[34m%s\033[0m\n", $$1, $$2, $$3}'