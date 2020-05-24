const vo = require("./src/vo");
const vo_mother = require("./src/vo_mother");
const aggregate = require("./src/aggregate");
const event = require("./src/event");
const repository = require("./src/repository");
const dao = require("./src/dao");
const command = require("./src/cqrs/command");
const query = require("./src/cqrs/query");
const http = require("./src/http");

let file_name = "/home/jguillermo/project/lcl-java-skeleton-spring/application/cli/communication/user.yml";

//vo.generate_by_file(file_name);
//vo.show_configuration(file_name);

//vo_mother.generate_by_file(file_name);
//vo_mother.show_configuration(file_name);

//event.generate_by_file(file_name);
//event.show_configuration(file_name);

//aggregate.generate_by_file(file_name);
//aggregate.show_configuration(file_name);

//dao.generate_by_file(file_name);
dao.show_configuration(file_name);

//repository.generate_by_file(file_name);
//repository.show_configuration(file_name);

//command.generate_by_file(file_name);
//command.show_configuration(file_name);

//query.generate_by_file(file_name);
//query.show_configuration(file_name);

//http.generate_by_file(file_name);
//http.show_configuration(file_name);
