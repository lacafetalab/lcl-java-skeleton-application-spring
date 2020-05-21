.DEFAULT_GOAL := help


up:
	@docker-compose -f ../container/docker-compose.local.yml up -d

down:
	@docker-compose -f ../container/docker-compose.local.yml down

log: ## Show container logs make : make log
	@docker-compose -f ../container/docker-compose.local.yml logs -f
clean:
	./gradlew clean

tests:
	@make clean
	@./gradlew test --warning-mode all

report:
	@make clean
	@./gradlew jacocoTestReport

# Start the app
run:
	@./gradlew bootRun

docker-kill: ## Execute migrate : make migrate
	docker rm -f $$(docker ps -aq)
## Target Help ##
help:
	@printf "\033[31m%-16s %-59s %s\033[0m\n" "Target" "Help" "Usage"; \
	printf "\033[31m%-16s %-59s %s\033[0m\n" "------" "----" "-----"; \
	grep -hE '^\S+:.*## .*$$' $(MAKEFILE_LIST) | sed -e 's/:.*##\s*/:/' | sort | awk 'BEGIN {FS = ":"}; {printf "\033[32m%-16s\033[0m %-58s \033[34m%s\033[0m\n", $$1, $$2, $$3}'
