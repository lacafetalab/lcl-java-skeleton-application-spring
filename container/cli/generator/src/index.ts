import {generateFile, readYaml} from "@sdk/Util";
import {ValueObject} from "@sdk/domain/ValueObject";


const _data = readYaml("/project/src/config.yml");

const valueObject = new ValueObject(_data);

valueObject.log();
generateFile(valueObject.template)

