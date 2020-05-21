const util = require("./util");


function config(file_name) {
  let d = util.read_yaml(file_name);
  let items=[];
  for (const service in d["http"]) {
    if (d["http"][service]["method"]=="post"){
      items.push(config_post(service, d));
    }
  }
  return items;
}

function config_post(service, d) {
  let entity_class = `${d["name"]}`;
  let entity_name = util.lowerCaseFirstLetter(entity_class);
  let service_uppercase = util.capitalizeFirstLetter(service);
  let entity_folder = util.to_snake_case(entity_class);
  let template = `/project/templates/controller/post`;
  let folder = `${util.get_path_applications_main(d)}/${entity_folder}`;
  let class_name = `${entity_class}${service_uppercase}PostController`;
  let file = `${folder}/${class_name}.java`;
  let package = `${d["package_applications"]}.${entity_folder}`;
  let url = d["http"][service]["url"];
  let command_class = `${service_uppercase}${entity_class}Command`;
  let package_cqrs = `${d["package"]}.application.${service}`.replace(/\//g,".");

  let params=[];
  let str_request_property="";
  for (const propertie in d["entity"]["properties"]) {
    let propertieCapital = util.capitalizeFirstLetter(propertie);
    str_request_property = str_request_property+`, request.get${propertieCapital}()`;
    let obj_param = {
      propertie
    }
    params.push(obj_param);
  }
  str_request_property = util.remove_first_params(str_request_property).trim();
  return {
    folder,
    template,
    file,
    class_name,
    package,
    params,
    str_request_property,
    url,
    command_class,
    package_cqrs
  };
}


/*

*/
function generate_by_file(file_name) {
  let list_vo = config(file_name);
  util.generate_file(list_vo);
}

function show_configuration(file_name) {
  console.log(config(file_name));
  //console.log(config(file_name)[0]["params"]);
}

module.exports = {
  generate_by_file,
  show_configuration,
};
