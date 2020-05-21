const YAML = require("yaml");
const fs = require("fs");

class Config {
  constructor(data = {}) {
    this._data = data;
  }
  get data() {
    return this._data;
  }
  get name() {
    return this.data["name"];
  }
  get entity() {
    return this.data["entity"];
  }
  get repository() {
    return this.data["repository"];
  }
  get path() {
    return this.data["path"];
  }
  get package() {
    return this.data["package"];
  }
}

class ConfigYaml extends Config {
  constructor(file_name) {
    super();
    this._data = this._read_yaml(file_name);
  }
  _read_yaml(file_name) {
    const file = fs.readFileSync(file_name, "utf8");
    let data = YAML.parse(file);
    return data["module"];
  }
}

module.exports = ConfigYaml;
