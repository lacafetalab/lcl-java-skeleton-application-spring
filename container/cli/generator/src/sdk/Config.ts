export class Config {
    constructor(private _data: any) {
    }

    get properties(): Array<string> {
        let data: Array<string> = [];
        for (const propertie in this._data["properties"]["aggregate"]) {
            data.push(<string>propertie);
        }
        return data
    }

    get entity(): string {
        return this._data["name"];
    }
}