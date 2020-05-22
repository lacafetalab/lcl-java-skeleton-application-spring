import {Config} from "@sdk/config/Config";
import "jest";
import {min} from "./data/data"

let config: Config;
describe("config base one aggregate", () => {
    beforeEach(() => {
        config = new Config(min());
    });

    test("properties", () => {
        expect(config.properties).toEqual(["id", "name", "lastname", "description", "birthdate"]);
    });

    test("entity", () => {
        expect(config.entity).toEqual("User");
    });

    test("value object", () => {
        expect(config.valueObject("id")).toEqual("UserId");
        expect(config.valueObject("name")).toEqual("UserName");
        expect(config.valueObject("lastname")).toEqual("UserLastname");
        expect(config.valueObject("description")).toEqual("UserDescription");
        expect(config.valueObject("birthdate")).toEqual("UserBirthdate");
    });

    test("path", () => {
        expect(config.path).toEqual("/application/src/communication");
    });

    test("package", () => {
        expect(config.package).toEqual("pe.lacafetalab.pao.communication.user");
    });

});