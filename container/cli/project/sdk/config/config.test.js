const Config = require("./config");

describe("config", () => {
  let config;
  
  beforeAll(() => {
    config = new Config("/project/sdk/config/config.yml");
  });

  test("read config", () => {
    expect(typeof config.data).toBe("object");
  });

  test("types parameters", () => {
    //console.log(config.data);
    expect(typeof config.name).toBe("string");
    expect(typeof config.entity).toBe("object");
    expect(typeof config.repository).toBe("object");
    expect(typeof config.path).toBe("string");
    expect(typeof config.package).toBe("string");
  });
});
