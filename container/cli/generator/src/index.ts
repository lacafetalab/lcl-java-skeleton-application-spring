import {Config} from "@sdk/config/Config";
import {readYaml} from "@sdk/Util";

const object = readYaml("/project/src/config.yml");

let config: Config = new Config({params: "hola"});
console.log("saludos");