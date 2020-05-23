import "jest";
import {ConfigValueObject} from "@sdk/config/ConfigValueObject";
import {ValueObject} from "@sdk/domain/ValueObject";
import {complete} from "../config/data/data";
import {Template} from "@sdk/AbstractGenerate";

let valueObject: ValueObject;
describe("config value obeject one aggregate", () => {
    beforeEach(() => {
        const config = new ConfigValueObject(complete());
        valueObject = new ValueObject(config);
    });

    test("valueObject folder", () => {
        expect(valueObject.folder).toEqual("/application/src/communication/main/pe/lacafetalab/pao/communication/user/domain");
    });
    test("valueObject package", () => {
        expect(valueObject.package).toEqual("pe.lacafetalab.pao.communication.user.domain");
    });

});
let templates: Template[] = [];
describe("config value obeject one aggregate", () => {
    beforeEach(() => {
        const config = new ConfigValueObject(complete());
        const valueObjectb = new ValueObject(config);
        templates = valueObjectb.template;
    });

    test("valueObject template id", () => {
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

    test("valueObject template name", () => {
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
[
  {
    "_dataTemplate": {
      "className": "User0",
      "message": {},
      "package": "pe.lacafetalab.pao.communication.user.domain",
      "type": {
        "default": null,
        "required": true,
        "type": ""
      }
    },
    "_file": "/application/src/communication/main/pe/lacafetalab/pao/communication/user/domain/User0.java",
    "_folder": "/application/src/communication/main/pe/lacafetalab/pao/communication/user/domain",
    "_template": "/project/templates/domain/vo/"
  },
  {
    "_dataTemplate": {
      "className": "User1",
      "message": {},
      "package": "pe.lacafetalab.pao.communication.user.domain",
      "type": {
        "default": null,
        "required": true,
        "type": ""
      }
    },
    "_file": "/application/src/communication/main/pe/lacafetalab/pao/communication/user/domain/User1.java",
    "_folder": "/application/src/communication/main/pe/lacafetalab/pao/communication/user/domain",
    "_template": "/project/templates/domain/vo/"
  },
  {
    "_dataTemplate": {
      "className": "User2",
      "message": {},
      "package": "pe.lacafetalab.pao.communication.user.domain",
      "type": {
        "default": null,
        "required": true,
        "type": ""
      }
    },
    "_file": "/application/src/communication/main/pe/lacafetalab/pao/communication/user/domain/User2.java",
    "_folder": "/application/src/communication/main/pe/lacafetalab/pao/communication/user/domain",
    "_template": "/project/templates/domain/vo/"
  },
  {
    "_dataTemplate": {
      "className": "User3",
      "message": {},
      "package": "pe.lacafetalab.pao.communication.user.domain",
      "type": {
        "default": null,
        "required": true,
        "type": ""
      }
    },
    "_file": "/application/src/communication/main/pe/lacafetalab/pao/communication/user/domain/User3.java",
    "_folder": "/application/src/communication/main/pe/lacafetalab/pao/communication/user/domain",
    "_template": "/project/templates/domain/vo/"
  },
  {
    "_dataTemplate": {
      "className": "User4",
      "message": {},
      "package": "pe.lacafetalab.pao.communication.user.domain",
      "type": {
        "default": null,
        "required": true,
        "type": ""
      }
    },
    "_file": "/application/src/communication/main/pe/lacafetalab/pao/communication/user/domain/User4.java",
    "_folder": "/application/src/communication/main/pe/lacafetalab/pao/communication/user/domain",
    "_template": "/project/templates/domain/vo/"
  }
]

* */