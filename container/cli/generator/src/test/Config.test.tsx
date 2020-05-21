import {Config} from "@sdk/Config";
import "jest";
import {min} from "./data/data"

let config: Config;
describe("config base one aggregate", () => {
    beforeEach(() => {
        config = new Config(min());
    });

    test("properties", () => {
        expect(["id", "name", "lastname", "description", "birthdate"]).toEqual(config.properties);
    });
    test("entity", () => {
        expect(config.entity).toEqual("User");
    });

});