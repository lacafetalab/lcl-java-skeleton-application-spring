import {generateFile, logTemplate, readYaml} from "./Util";
import {ValueObject} from "@sdk/codeMain/domain/ValueObject";
import {ValueObjectMother} from "@sdk/codeTest/domain/ValueObjectMother";
import {Event} from "@sdk/codeMain/domain/Event";
import {Aggregate} from "@sdk/codeMain/domain/Aggregate";
import {Repository} from "@sdk/codeMain/domain/Repository";
import {Dao} from "@sdk/codeMain/infrastructure/persistence/Dao";
import {JpaRepository} from "@sdk/codeMain/infrastructure/persistence/JpaRepository";
import {SqlRepository} from "@sdk/codeMain/infrastructure/persistence/SqlRepository";
import {CommnadService} from "@sdk/codeMain/application/CommandService";


const _data = readYaml("/project/src/config.yml");

const valueObject = new ValueObject(_data);
const valueObjectMother = new ValueObjectMother(_data);
const events = new Event(_data);
const aggregate = new Aggregate(_data);
const repository = new Repository(_data);
const dao = new Dao(_data);
const jpaRepository = new JpaRepository(_data);
const sqlRepository = new SqlRepository(_data);


logTemplate(valueObject.template);
generateFile(valueObject.template);

logTemplate(valueObjectMother.template);
generateFile(valueObjectMother.template);

logTemplate(events.template);
generateFile(events.template);

logTemplate(aggregate.template);
generateFile(aggregate.template);

logTemplate(repository.template);
generateFile(repository.template);

logTemplate(dao.template);
generateFile(dao.template);

logTemplate(jpaRepository.template);
generateFile(jpaRepository.template);

logTemplate(sqlRepository.template);
generateFile(sqlRepository.template);


const commandCreate = new CommnadService(_data, "create", null, "create");
const commandUpdate = new CommnadService(_data, "update", null, "update");
const commandDelete = new CommnadService(_data, "delete", ["id"], "delete");

logTemplate(commandCreate.template);
generateFile(commandCreate.template);

logTemplate(commandUpdate.template);
generateFile(commandUpdate.template);

logTemplate(commandDelete.template);
generateFile(commandDelete.template);