import {Config} from "@sdk/Config";
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
        expect(config.valueObject).toEqual(["UserId", "UserName", "UserLastname", "UserDescription", "UserBirthdate"]);
    });

    test("path", () => {
        expect(config.path).toEqual("/application/src/communication");
    });

    test("package", () => {
        expect(config.package).toEqual("pe.lacafetalab.pao.communication.user");
    });

});