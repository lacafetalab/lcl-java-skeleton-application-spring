const s = require("underscore.string");

export class Config {

    constructor(private _data: any) {
    }

    get properties(): Array<string> {
        let data: Array<string> = [];
        for (const propertie in this._data["properties"]["aggregate"]) {
            data.push(propertie);
        }
        return data
    }

    get entity(): string {
        return this._data["name"];
    }

    get path(): string {
        return this._data["path"];
    }

    get package(): string {
        return this._data["package"];
    }

    get valueObject(): Array<string> {
        let data: Array<string> = [];
        for (const propertie in this._data["properties"]["aggregate"]) {
            let propertiecapitalize = s(propertie).trim().capitalize().value();
            data.push(`${this.entity}${propertiecapitalize}`);
        }
        return data
    }
}