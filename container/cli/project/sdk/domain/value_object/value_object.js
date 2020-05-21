const Config = require("../../config/config");

class ValueObject{
    constructor(config) {
      this._config = config;
    }
    get config(){
        return this._config;
    }
  }