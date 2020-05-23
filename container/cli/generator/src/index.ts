import {Config} from "@sdk/config/Config";
import {generateFile, readYaml} from "@sdk/Util";
import {ConfigValueObject} from "@sdk/config/ConfigValueObject";
import {ValueObject} from "@sdk/domain/ValueObject";

const object = readYaml("/project/src/config.yml");

const configValueObject = new ConfigValueObject(object);
const valueObject = new ValueObject(configValueObject);

valueObject.log();
generateFile(valueObject.template)

