// tslint:disable-next-line:no-var-requires
import {ConfigUtil, ValueObjectPropertie} from "@sdk/config/ConfigUtil";

const s = require("underscore.string");

interface Event {
    name: string,
    className: string
}

interface RepositoryDao {
    pk: string,
    table: string,
    columnName: any
}

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

    get events(): Event[] {
        const data: Event[] = [];
        for (const eventName in this._data.events) {
            data.push({
                className: s.capitalize(eventName),
                name: this._data.events[eventName]
            });
        }
        return data
    }

    get repository(): RepositoryDao {
        const table: string = (this._data.repository.table) ? this._data.repository.table : s.underscored(this.entity);
        const columnName: any = (this._data.repository.columnName) ? this._data.repository.columnName : {};
        return {
            pk: this._data.repository.pk,
            table,
            columnName
        }
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
        return ConfigUtil.valueObject(propertie, this.entity);
    }

    valueObjectProperties(properties: string[]): ValueObjectPropertie[] {
        return ConfigUtil.valueObjectProperties(properties, this.entity);
    }
}