const util = require("./../util");

function config(file_name) {
  let d = util.read_yaml(file_name);
  let items=[];
  for (const service in d["services"]) {
    if (d["services"][service]["type"]=="query"){
      items.push(config_query(service, d))
      items.push(config_query_handler(service, d))
      items.push(config_service(service, d))
      items.push(config_response(d))
      items.push(config_list_response(d))
    }
  }
  return items;
}


function config_query(service, d) {
  let service_folder = util.to_snake_case(service);
  let class_service = util.capitalizeFirstLetter(service);
  let template = `/project/templates/application/query/query`;
  let folder = `${util.get_path_main(d)}/application/${service_folder}`;
  let class_name = `${d["name"]}${class_service}Query`;
  let file = `${folder}/${class_name}.java`;
  let package = `${d["package"]}.application.${service_folder}`;

  let params=[];
  let str_vo_property="";
  for (const propertie in d["entity"]["properties"]) {
    if(d["services"][service]["params"] && !d["services"][service]["params"].includes(propertie)){
      continue;
    }
    let propertieCapital = util.capitalizeFirstLetter(propertie);
    let vo_name = `${d["name"]}${propertieCapital}`;
    str_vo_property = str_vo_property+`, String ${propertie}`;
    let obj_param = {
      propertie,
      vo_name
    }
    params.push(obj_param);
  }
  str_vo_property = util.remove_first_params(str_vo_property).trim();
  return {
    folder,
    template,
    file,
    class_name,
    package,
    params,
    str_vo_property
  };
}

function config_query_handler(service, d) {
  let service_folder = util.to_snake_case(service);
  let service_name = util.capitalizeFirstLetter(service);
  let template = `/project/templates/application/query/handler`;
  let folder = `${util.get_path_main(d)}/application/${service_folder}`;
  let entity_class = `${d["name"]}`;
  let base_class = `${entity_class}${service_name}`;
  let class_name = `${base_class}QueryHandler`;
  let class_query = `${base_class}Query`;
  let class_service = base_class;
  let params_list = (d["services"][service]["return"] && d["services"][service]["return"] == "list")? "List":"";
  let class_response = `${params_list}${entity_class}Response`;
  let file = `${folder}/${class_name}.java`;
  let package = `${d["package"]}.application.${service_folder}`;
  let package_domain = `${d["package"]}.${d["entity"]["package"]}`.replace(/\//g,".");
  let package_application = `${d["package"]}.application`;


  let params=[];
  let str_vo_property="";
  for (const propertie in d["entity"]["properties"]) {
    if(d["services"][service]["params"] && !d["services"][service]["params"].includes(propertie)){
      continue;
    }
    let propertieCapital = util.capitalizeFirstLetter(propertie);
    let vo_name = `${d["name"]}${propertieCapital}`;
    str_vo_property = str_vo_property+`, ${propertie}`;
    let obj_param = {
      propertie,
      vo_name
    }
    params.push(obj_param);
  }
  str_vo_property = util.remove_first_params(str_vo_property).trim();
  return {
    folder,
    template,
    file,
    class_name,
    class_query,
    class_service,
    class_response,
    package,
    params,
    package_domain,
    package_application,
    str_vo_property
  };
}

function config_service(service, d) {
  let service_folder = util.to_snake_case(service);
  let class_service = util.capitalizeFirstLetter(service);
  let template = `/project/templates/application/query/service`;
  let folder = `${util.get_path_main(d)}/application/${service_folder}`;
  let entity_class = `${d["name"]}`;
  let base_class = `${entity_class}${class_service}`;
  let class_name = base_class;
  let class_repository = `${entity_class}Repository`;
  let class_entity = entity_class;
  let service_template = d["services"][service]["template"];
  let entity_name = util.lowerCaseFirstLetter(entity_class);
  let params_list = (d["services"][service]["return"] && d["services"][service]["return"] == "list")? "List":"";
  let return_type = (d["services"][service]["return"])? d["services"][service]["return"]:"entity";
  let class_response = `${params_list}${entity_class}Response`;
  let class_response_entity = `${entity_class}Response`;
  let class_response_list = `List${entity_class}Response`;
  let file = `${folder}/${class_name}.java`;
  let package = `${d["package"]}.application.${service_folder}`;
  let package_domain = `${d["package"]}.${d["entity"]["package"]}`.replace(/\//g,".");
  let package_application = `${d["package"]}.application`;

  let params=[];
  let str_vo_property="";
  let str_vo_property_item="";
  for (const propertie in d["entity"]["properties"]) {
    if(d["services"][service]["params"] && !d["services"][service]["params"].includes(propertie)){
        continue;
    }
    let propertieCapital = util.capitalizeFirstLetter(propertie);
    let vo_name = `${d["name"]}${propertieCapital}`;
    str_vo_property = str_vo_property+`, ${vo_name} ${propertie}`;
    str_vo_property_item = str_vo_property_item+`, ${propertie}`;
    let obj_param = {
      propertie,
      vo_name
    }
    params.push(obj_param);
  }
  str_vo_property = util.remove_first_params(str_vo_property).trim();
  str_vo_property_item = util.remove_first_params(str_vo_property_item).trim();
  return {
    folder,
    template,
    file,
    class_name,
    class_repository,
    class_entity,
    entity_name,
    service_template,
    package,
    params,
    package_domain,
    str_vo_property,
    str_vo_property_item,
    class_response,
    package_application,
    return_type,
    class_response_entity,
    class_response_list
  };
}

function config_response(d) {
  let template = `/project/templates/application/query/response`;
  let folder = `${util.get_path_main(d)}/application`;
  let entity_class = `${d["name"]}`;
  let class_name = `${entity_class}Response`;
  let file = `${folder}/${class_name}.java`;
  let package = `${d["package"]}.application`;
  let package_domain = `${d["package"]}.${d["entity"]["package"]}`.replace(/\//g,".");
  let entity_name = util.lowerCaseFirstLetter(entity_class);

  let params=[];
  let str_vo_property="";
  let str_property="";
  let str_property_to_string="";
  let str_vo_equals="";
  let str_vo_property_string="";
  for (const propertie in d["entity"]["properties"]) {
    let propertieCapital = util.capitalizeFirstLetter(propertie);
    let vo_name = `${d["name"]}${propertieCapital}`;
    str_vo_property = str_vo_property+`, ${vo_name} ${propertie}`;
    str_property = str_property+`, ${propertie}`;
    str_property_to_string = str_property_to_string+`, ${entity_name}.${propertie}().toString()`;
    str_vo_equals = str_vo_equals + ` && Objects.equals(${propertie}, that.${propertie})`;
    str_vo_property_string = str_vo_property_string+`, String ${propertie}`;
    let obj_param = {
      propertie,
      vo_name
    }
    params.push(obj_param);
  }
  str_vo_property = util.remove_first_params(str_vo_property).trim();
  str_property = util.remove_first_params(str_property).trim();
  str_property_to_string = util.remove_first_params(str_property_to_string).trim();
  str_vo_property_string = util.remove_first_params(str_vo_property_string).trim();
  str_vo_equals = str_vo_equals.substring(4);
  return {
    folder,
    template,
    file,
    class_name,
    package,
    params,
    str_vo_property,
    str_property,
    str_property_to_string,
    str_vo_equals,
    str_vo_property_string,
    package_domain,
    entity_class,
    entity_name
  };
}

function config_list_response(d) {
  let template = `/project/templates/application/query/list_response`;
  let folder = `${util.get_path_main(d)}/application`;
  let entity_class = `${d["name"]}`;
  let class_name = `List${entity_class}Response`;
  let file = `${folder}/${class_name}.java`;
  let package = `${d["package"]}.application`;
  let package_domain = `${d["package"]}.${d["entity"]["package"]}`.replace(/\//g,".");
  let entity_name = util.lowerCaseFirstLetter(entity_class);
  let response_class = `${d["name"]}Response`;
  let response_name = `${entity_name}Responses`;

  return {
    folder,
    template,
    file,
    class_name,
    package,
    response_class,
    response_name
  };
}
/*
[
  {
    folder: '/application/src/communication/main/pe/lacafetalab/pao/communication/user/application/find_by_id',
    template: '/project/templates/application/query/query',
    file: '/application/src/communication/main/pe/lacafetalab/pao/communication/user/application/find_by_id/UserFindByIdQuery.java',
    class_name: 'UserFindByIdQuery',
    package: 'pe.lacafetalab.pao.communication.user.application.find_by_id',
    params: [ [Object] ],
    str_vo_property: 'String id'
  },
  {
    folder: '/application/src/communication/main/pe/lacafetalab/pao/communication/user/application/find_by_id',
    template: '/project/templates/application/query/handler',
    file: '/application/src/communication/main/pe/lacafetalab/pao/communication/user/application/find_by_id/UserFindByIdQueryHandler.java',
    class_name: 'UserFindByIdQueryHandler',
    class_query: 'UserFindByIdQuery',
    class_service: 'UserFindById',
    class_response: 'UserResponse',
    package: 'pe.lacafetalab.pao.communication.user.application.find_by_id',
    params: [ [Object] ],
    package_domain: 'pe.lacafetalab.pao.communication.user.domain',
    package_application: 'pe.lacafetalab.pao.communication.user.application',
    str_vo_property: 'id'
  },
  {
    folder: '/application/src/communication/main/pe/lacafetalab/pao/communication/user/application/find_by_id',
    template: '/project/templates/application/query/service',
    file: '/application/src/communication/main/pe/lacafetalab/pao/communication/user/application/find_by_id/UserFindById.java',
    class_name: 'UserFindById',
    class_repository: 'UserRepository',
    class_entity: 'User',
    entity_name: 'user',
    service_template: 'findById',
    package: 'pe.lacafetalab.pao.communication.user.application.find_by_id',
    params: [ [Object] ],
    package_domain: 'pe.lacafetalab.pao.communication.user.domain',
    str_vo_property: 'UserId id',
    str_vo_property_item: 'id',
    class_response: 'UserResponse',
    package_application: 'pe.lacafetalab.pao.communication.user.application',
    return_type: 'entity'
  },
  {
  folder: '/application/src/communication/main/pe/lacafetalab/pao/communication/user/application',
  template: '/project/templates/application/query/response',
  file: '/application/src/communication/main/pe/lacafetalab/pao/communication/user/application/UserResponse.java',
  class_name: 'UserResponse',
  package: 'pe.lacafetalab.pao.communication.user.application',
  params: [ [Object], [Object], [Object], [Object], [Object] ],
  str_vo_property: 'UserId id, UserName name, UserLastname lastname, UserDescription description, UserBirthdate birthdate',
  str_property: 'id, name, lastname, description, birthdate',
  str_property_to_string: 'user.id().toString(), user.name().toString(), user.lastname().toString(), user.description().toString(), user.birthdate().toString()',
  str_vo_equals: 'Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(lastname, that.lastname) && Objects.equals(description, that.description) && Objects.equals(birthdate, that.birthdate)',
  str_vo_property_string: 'String id, String name, String lastname, String description, String birthdate',
  package_domain: 'pe.lacafetalab.pao.communication.user.domain',
  entity_class: 'User',
  entity_name: 'user'
},
{
    folder: '/application/src/communication/main/pe/lacafetalab/pao/communication/user/application',
    template: '/project/templates/application/query/list_response',
    file: '/application/src/communication/main/pe/lacafetalab/pao/communication/user/application/ListUserResponse.java',
    class_name: 'ListUserResponse',
    package: 'pe.lacafetalab.pao.communication.user.application',
    response_class: 'UserResponse',
    response_name: 'userResponses'
  }
]
[ { propertie: 'id', vo_name: 'UserId' } ]
*/
function generate_by_file(file_name) {
  let list_vo = config(file_name);
  util.generate_file(list_vo);
}

function show_configuration(file_name) {
  console.log(config(file_name));
  console.log(config(file_name)[0]["params"]);
}

module.exports = {
  generate_by_file,
  show_configuration,
};
