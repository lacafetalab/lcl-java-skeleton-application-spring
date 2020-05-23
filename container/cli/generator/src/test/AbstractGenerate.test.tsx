import "jest";
import {AbstractGenerate, Template} from "@sdk/AbstractGenerate";

class GenerateImplement extends AbstractGenerate {
    get template(): Template[] {
        return [];
    }
}

let generateImplement: GenerateImplement;
describe("AbstractGenerate str", () => {
    beforeEach(() => {
        generateImplement = new GenerateImplement();
    });
    test("AbstractGenerate str properties", () => {
        expect(generateImplement.strProperties(['id', 'name', 'lastname'])).toEqual("id, name, lastname");
    });
    test("AbstractGenerate str one propertie", () => {
        expect(generateImplement.strProperties(['id'])).toEqual("id");
    });
    test("AbstractGenerate str one empty", () => {
        expect(generateImplement.strProperties([])).toEqual("");
    });

    test("AbstractGenerate str properties prefix", () => {
        expect(generateImplement.strProperties(['id', 'name', 'lastname'],"String")).toEqual("String id, String name, String lastname");
    });
    test("AbstractGenerate str one propertie prefix", () => {
        expect(generateImplement.strProperties(['id'],"String")).toEqual("String id");
    });
});

describe("AbstractGenerate strEquals", () => {
    beforeEach(() => {
        generateImplement = new GenerateImplement();
    });
    test("AbstractGenerate strEquals properties", () => {
        expect(generateImplement.strPropertiesEquals(['id', 'name', 'lastname'])).toEqual("Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(lastname, that.lastname)");
    });
    test("AbstractGenerate strEquals one propertie", () => {
        expect(generateImplement.strPropertiesEquals(['id'])).toEqual("Objects.equals(id, that.id)");
    });
    test("AbstractGenerate strEquals one empty", () => {
        expect(generateImplement.strPropertiesEquals([])).toEqual("");
    });
});



