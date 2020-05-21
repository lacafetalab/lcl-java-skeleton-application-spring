const coverageThreshold = 60;
const collectCoverageFrom = ["sdk/**/*.js", "!node_modules/**"];

module.exports = {
  verbose: false,
  collectCoverage: true,
  coverageThreshold: {
    global: {
      branches: coverageThreshold,
      functions: coverageThreshold,
      lines: coverageThreshold,
      statements: coverageThreshold,
    },
  },
  collectCoverageFrom,
};
