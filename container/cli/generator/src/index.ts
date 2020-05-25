import {generateFile, logTemplate, readYaml} from "./Util";
import {ValueObject} from "@sdk/main/domain/ValueObject";
import {ValueObjectMother} from "@sdk/test/domain/ValueObjectMother";
import {Event} from "@sdk/main/domain/Event";
import {Aggregate} from "@sdk/main/domain/Aggregate";
import {Repository} from "@sdk/main/domain/Repository";
import {Dao} from "@sdk/main/infrastructure/persistence/Dao";
import {JpaRepository} from "@sdk/main/infrastructure/persistence/JpaRepository";


const _data = readYaml("/project/src/config.yml");

const valueObject = new ValueObject(_data);
const valueObjectMother = new ValueObjectMother(_data);
const events = new Event(_data);
const aggregate = new Aggregate(_data);
const repository = new Repository(_data);
const dao = new Dao(_data);
const jpaRepository = new JpaRepository(_data);


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