const fs = require("fs");
const YAML = require("yaml");
const ejs = require("ejs");

function read_yaml(file_name) {
  const file = fs.readFileSync(file_name, "utf8");
  let data = YAML.parse(file);
  return data["module"];
}

function get_path_applications_main(d) {
  return `${d["path_applications"]}/main/${d["package_applications"]}`.replace(/\./g, "/");
}
function get_path_main(d) {
  return `${d["path"]}/main/${d["package"]}`.replace(/\./g, "/");
}
function get_path_test(d) {
  return `${d["path"]}/test/${d["package"]}`.replace(/\./g, "/");
}
function capitalizeFirstLetter(string) {
  return string.replace(/^./, string[0].toUpperCase());
}
function lowerCaseFirstLetter(string) {
  return string.replace(/^./, string[0].toLowerCase());
}
function remove_first_params(string) {
  return string.replace(/^./, "");
}
function get_properties(expr) {
  //todo validar los tipos
  let obj = {
    type: "",
    required: true,
    default: null,
  };
  switch (expr) {
    case "id":
    case "string":
    case "datetime":
    case "text":
      obj["type"] = expr;
      break;
    default:
      obj["type"] = expr["type"];
      obj["required"] = expr["required"];
      obj["default"] = expr["default"];
  }
  obj.primitive = getPrimitiveParams(obj.type);
  return obj;
}

function getPrimitiveParams(type){
  let primitive = 'undefined';
  switch (type) {
    case "id":
    case "string":
    case "text":
      primitive = "String";
      break;
    case "datetime":
      primitive = "Date";
      break;
    
  }
  return primitive;
}

function generate_file(list_params) {
  list_params.forEach((param) => {
     //console.log(param)
     // se copia el archjvo original y se genera un render para luego sacar la comparacion con GIT
    if (fs.existsSync(param["file"])) {
      console.error(`exist : ${param["file"]}`);
      // copia el archivo original a /compare/....
      fs.mkdir(`/compare${param["folder"]}`, { recursive: true }, (err) => {
        if (err) throw err;
        fs.copyFile(param["file"], `/compare${param["file"]}`, (err) => {
          if (err) throw err;
        });
      });
      // genera el archivo renderizado en la carpeta /render/....
      fs.mkdir(`/render${param["folder"]}`, { recursive: true }, (err) => {
        if (err) throw err;
        ejs.renderFile(param["template"], param, {}, function (err, str) {
          if (err) throw err;
          //console.log(str);
          fs.writeFile(`/render${param["file"]}`, str, (err) => {
            if (err) throw err;
          });
        });
      });
      
    }else{
      fs.mkdir(param["folder"], { recursive: true }, (err) => {
        if (err) throw err;
        ejs.renderFile(param["template"], param, {}, function (err, str) {
          if (err) throw err;
          //console.log(str);
          fs.writeFile(param["file"], str, (err) => {
            if (err) throw err;
            console.log(`generated : ${param["file"]}`);
          });
        });
      });
    } 
  });
}

function to_snake_case(str) {
  var upperChars = str.match(/([A-Z])/g);
  if (! upperChars) {
      return str;
  }

  for (var i = 0, n = upperChars.length; i < n; i++) {
      str = str.replace(new RegExp(upperChars[i]), '_' + upperChars[i].toLowerCase());
  }

  if (str.slice(0, 1) === '_') {
      str = str.slice(1);
  }

  return str;
};

module.exports = {
  get_path_main,
  get_path_test,
  capitalizeFirstLetter,
  lowerCaseFirstLetter,
  get_properties,
  read_yaml,
  generate_file,
  remove_first_params,
  to_snake_case,
  get_path_applications_main
};
