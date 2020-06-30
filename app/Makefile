.DEFAULT_GOAL := help

clean:
	./gradlew clean

build:
	./gradlew build --console=plain

tasks:
	./gradlew tasks

view_paths:
	./gradlew view_paths

tests:
	@make clean
	@./gradlew test --warning-mode all

report:
	@make clean
	@./gradlew jacocoTestReport

# Start the app
run:
	@./gradlew :applications:bootRun

up:
	@docker-compose -f docker-compose.dev.yml up -d

down:
	@docker-compose -f docker-compose.dev.yml down

restart:
	@make down
	@make up


log: ## Show container logs make : make log
	@docker-compose -f docker-compose.dev.yml logs -f

docker-kill: ## Execute migrate : make migrate
	docker rm -f $$(docker ps -aq)
## Target Help ##
help:
	@printf "\033[31m%-16s %-59s %s\033[0m\n" "Target" "Help" "Usage"; \
	printf "\033[31m%-16s %-59s %s\033[0m\n" "------" "----" "-----"; \
	grep -hE '^\S+:.*## .*$$' $(MAKEFILE_LIST) | sed -e 's/:.*##\s*/:/' | sort | awk 'BEGIN {FS = ":"}; {printf "\033[32m%-16s\033[0m %-58s \033[34m%s\033[0m\n", $$1, $$2, $$3}'
