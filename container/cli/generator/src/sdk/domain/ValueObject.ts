import {ConfigValueObject} from "@sdk/config/ConfigValueObject";
import {AbstractGenerate, Template} from "@sdk/AbstractGenerate";

export class ValueObject extends AbstractGenerate {

    constructor(private config: ConfigValueObject) {
        super()
    }

    get folder(): string {
        return `${this.config.mainPath}/domain`;
    }

    get package(): string {
        return `${this.config.package}.domain`;
    }

    get template(): Template[] {
        let template: Template[] = [];
        this.config.properties.forEach(propertie => {
            const type = this.config.propertieType(propertie);
            const message = this.config.propertieMessage(propertie);

            const className = this.config.valueObject(propertie);
            const file = `${this.folder}/${className}.java`;
            const fileTemplate = `/project/templates/domain/vo/${type.type}`;
            const data = {
                className,
                package: this.package,
                type,
                message
            };
            template.push(new Template(this.folder, file, fileTemplate, data));
        });
        return template;
    }

}