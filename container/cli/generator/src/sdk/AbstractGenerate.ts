import {Config} from "@sdk/config/Config";

export class Template {
    constructor(private _folder: string, private _file: string, private _template: string, private _dataTemplate: any) {
    }

    get folder(): string {
        return this._folder;
    }

    get file(): string {
        return this._file;
    }

    get template(): string {
        return this._template;
    }

    get dataTemplate(): any {
        return this._dataTemplate;
    }
}

// tslint:disable-next-line:max-classes-per-file
export abstract class AbstractGenerate {
    abstract get template(): Template[];
}