import "jest";
import {Event} from "@sdk/domain/Event";
import {complete} from "../config/data/data";
import {Template} from "@sdk/AbstractGenerate";

let event: Event;
describe("config value obeject one aggregate", () => {
    beforeEach(() => {
        event = new Event(complete());
    });

    test("event folder", () => {
        expect(event.folder).toEqual("/application/src/communication/main/pe/lacafetalab/pao/communication/user/domain");
    });
    test("event package", () => {
        expect(event.package).toEqual("pe.lacafetalab.pao.communication.user.domain");
    });

});
let templates: Template[] = [];
describe("config value obeject one aggregate", () => {
    beforeEach(() => {
        const eventb = new Event(complete());
        templates = eventb.template;
    });

    test("event template id", () => {
        expect(templates[0].folder).toEqual("/application/src/communication/main/pe/lacafetalab/pao/communication/user/domain");
        expect(templates[0].file).toEqual("/application/src/communication/main/pe/lacafetalab/pao/communication/user/domain/UserId.java");
        expect(templates[0].template).toEqual("/project/templates/domain/vo/id");
        expect(templates[0].dataTemplate).toEqual({
            "className": "UserId",
            "message": {
                "required": null,
                "valid": null
            },
            "package": "pe.lacafetalab.pao.communication.user.domain",
            "type": {
                "default": null,
                "required": true,
                "type": "id"
            }
        });
    });

    test("event template name", () => {
        expect(templates[1].folder).toEqual("/application/src/communication/main/pe/lacafetalab/pao/communication/user/domain");
        expect(templates[1].file).toEqual("/application/src/communication/main/pe/lacafetalab/pao/communication/user/domain/UserName.java");
        expect(templates[1].template).toEqual("/project/templates/domain/vo/string");
        expect(templates[1].dataTemplate).toEqual({
            "className": "UserName",
            "message": {
                "required": "El nombre es requerido",
                "valid": "El nombre no es un valor válido"
            },
            "package": "pe.lacafetalab.pao.communication.user.domain",
            "type": {
                "default": null,
                "required": true,
                "type": "string"
            }
        });
    });
});

/*
{
  folder: '/application/src/communication/main/pe/lacafetalab/pao/communication/user/domain',
  file: '/application/src/communication/main/pe/lacafetalab/pao/communication/user/domain/UserId.java',
  template: '/project/templates/domain/vo/id',
  dataTemplate: {
    className: 'UserId',
    package: 'pe.lacafetalab.pao.communication.user.domain',
    type: { type: 'id', required: true, default: null },
    message: { required: null, valid: null }
  }
}
{
  folder: '/application/src/communication/main/pe/lacafetalab/pao/communication/user/domain',
  file: '/application/src/communication/main/pe/lacafetalab/pao/communication/user/domain/UserName.java',
  template: '/project/templates/domain/vo/string',
  dataTemplate: {
    className: 'UserName',
    package: 'pe.lacafetalab.pao.communication.user.domain',
    type: { type: 'string', required: true, default: null },
    message: {
      required: 'El nombre es requerido',
      valid: 'El nombre no es un valor válido'
    }
  }
}
{
  folder: '/application/src/communication/main/pe/lacafetalab/pao/communication/user/domain',
  file: '/application/src/communication/main/pe/lacafetalab/pao/communication/user/domain/UserLastname.java',
  template: '/project/templates/domain/vo/text',
  dataTemplate: {
    className: 'UserLastname',
    package: 'pe.lacafetalab.pao.communication.user.domain',
    type: { type: 'text', required: true, default: null },
    message: {
      required: 'El apellido es requerido',
      valid: 'El apellido no es un valor válido'
    }
  }
}
{
  folder: '/application/src/communication/main/pe/lacafetalab/pao/communication/user/domain',
  file: '/application/src/communication/main/pe/lacafetalab/pao/communication/user/domain/UserDescription.java',
  template: '/project/templates/domain/vo/text',
  dataTemplate: {
    className: 'UserDescription',
    package: 'pe.lacafetalab.pao.communication.user.domain',
    type: { type: 'text', required: false, default: null },
    message: { required: null, valid: null }
  }
}
{
  folder: '/application/src/communication/main/pe/lacafetalab/pao/communication/user/domain',
  file: '/application/src/communication/main/pe/lacafetalab/pao/communication/user/domain/UserBirthdate.java',
  template: '/project/templates/domain/vo/datetime',
  dataTemplate: {
    className: 'UserBirthdate',
    package: 'pe.lacafetalab.pao.communication.user.domain',
    type: { type: 'datetime', required: true, default: null },
    message: { required: null, valid: null }
  }
}

* */