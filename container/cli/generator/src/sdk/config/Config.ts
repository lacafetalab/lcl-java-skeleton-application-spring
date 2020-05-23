// tslint:disable-next-line:no-var-requires
const s = require("underscore.string");

export class Config {

    constructor(protected _data: any) {
    }

    get properties(): string[] {
        const data: string[] = [];
        for (const propertie in this._data.properties.aggregate) {
            data.push(propertie);
        }
        return data
    }

    get entity(): string {
        return this._data.name;
    }

    get path(): string {
        return this._data.path;
    }

    get package(): string {
        return this._data.package;
    }

    get mainPath(): string {
        return `${this._data.path}/main/${this._data.package}`.replace(/\./g, "/");
    }

    get testPath(): string {
        return `${this._data.path}/test/${this._data.package}`.replace(/\./g, "/");
    }

    valueObject(propertie: string): string {
        const propertieCapitalize: string = s(propertie).trim().capitalize().value();
        return `${this.entity}${propertieCapitalize}`;
    }
}