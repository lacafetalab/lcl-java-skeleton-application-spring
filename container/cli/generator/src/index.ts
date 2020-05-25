import {generateFile, logTemplate, readYaml} from "./Util";
import {ValueObject} from "@sdk/domain/ValueObject";
import {ValueObjectMother} from "@sdk/domain/ValueObjectMother";
import {Event} from "@sdk/domain/Event";
import {Aggregate} from "@sdk/domain/Aggregate";
import {Dao} from "@sdk/infrastructure/persistence/Dao";


const _data = readYaml("/project/src/config.yml");

const valueObject = new ValueObject(_data);
const valueObjectMother = new ValueObjectMother(_data);
const events = new Event(_data);
const aggregate = new Aggregate(_data);
const dao = new Dao(_data);


logTemplate(valueObject.template);
generateFile(valueObject.template);

logTemplate(valueObjectMother.template);
generateFile(valueObjectMother.template);

logTemplate(events.template);
generateFile(events.template);

logTemplate(aggregate.template);
generateFile(aggregate.template);

logTemplate(dao.template);
generateFile(dao.template);

