import {generateFile, readYaml} from "@sdk/Util";
import {ValueObject} from "@sdk/domain/ValueObject";
import {ValueObjectMother} from "@sdk/domain/ValueObjectMother";
import {Event} from "@sdk/domain/Event";


const _data = readYaml("/project/src/config.yml");

const valueObject = new ValueObject(_data);
const valueObjectMother = new ValueObjectMother(_data);
const events = new Event(_data);

//valueObject.log();
generateFile(valueObject.template);

//valueObjectMother.log();
generateFile(valueObjectMother.template);

events.log();
generateFile(events.template);

