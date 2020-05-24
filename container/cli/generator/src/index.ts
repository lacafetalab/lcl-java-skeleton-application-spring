import {generateFile, readYaml} from "./Util";
import {ValueObject} from "@sdk/domain/ValueObject";
import {ValueObjectMother} from "@sdk/domain/ValueObjectMother";
import {Event} from "@sdk/domain/Event";
import {Aggregate} from "@sdk/domain/Aggregate";
import {Dao} from "@sdk/infrastructure/Dao";


const _data = readYaml("/project/src/config.yml");

const valueObject = new ValueObject(_data);
const valueObjectMother = new ValueObjectMother(_data);
const events = new Event(_data);
const aggregate = new Aggregate(_data);
const dao = new Dao(_data);

//valueObject.log();
generateFile(valueObject.template);

//valueObjectMother.log();
generateFile(valueObjectMother.template);

//events.log();
generateFile(events.template);

//aggregate.log();
generateFile(aggregate.template);

//dao.log();
generateFile(dao.template);

