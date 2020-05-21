const util = require("./../util");

function config(file_name) {
  let d = util.read_yaml(file_name);
  let items=[];
  for (const service in d["services"]) {
    if (d["services"][service]["type"]=="command"){
      items.push(config_command(service, d))
      items.push(config_command_handler(service, d))
      items.push(config_service(service, d))
    }
  }
  return items;
}


function config_command(service, d) {
  let class_service = util.capitalizeFirstLetter(service);
  let template = `/project/templates/application/command/command`;
  let folder = `${util.get_path_main(d)}/application/${service}`;
  let class_name = `${class_service}${d["name"]}Command`;
  let file = `${folder}/${class_name}.java`;
  let package = `${d["package"]}.application.${service}`;

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

function config_command_handler(service, d) {
  let class_service = util.capitalizeFirstLetter(service);
  let template = `/project/templates/application/command/handler`;
  let folder = `${util.get_path_main(d)}/application/${service}`;
  let class_name = `${class_service}${d["name"]}CommandHandler`;
  let class_command = `${class_service}${d["name"]}Command`;
  let service_class = `${class_service}${d["name"]}`;
  let file = `${folder}/${class_name}.java`;
  let package = `${d["package"]}.application.${service}`;
  let package_domain = `${d["package"]}.${d["entity"]["package"]}`.replace(/\//g,".");


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
    class_command,
    service_class,
    package,
    params,
    package_domain,
    str_vo_property
  };
}

function config_service(service, d) {
  let class_service = util.capitalizeFirstLetter(service);
  let template = `/project/templates/application/command/service`;
  let folder = `${util.get_path_main(d)}/application/${service}`;
  let class_name = `${class_service}${d["name"]}`;
  let class_repository = `${d["name"]}Repository`;
  let class_entity = d["name"];
  let service_template = d["services"][service]["template"];
  let entity_name = util.lowerCaseFirstLetter(d["name"]);
  let file = `${folder}/${class_name}.java`;
  let package = `${d["package"]}.application.${service}`;
  let package_domain = `${d["package"]}.${d["entity"]["package"]}`.replace(/\//g,".");


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
    str_vo_property_item
  };
}


/*
[
  {
    folder: '/application/src/communication/main/pe/lacafetalab/pao/communication/user/application/create',
    template: '/project/templates/application/command/command',
    file: '/application/src/communication/main/pe/lacafetalab/pao/communication/user/application/create/CreateUserCommand.java',
    class_name: 'CreateUserCommand',
    package: 'pe.lacafetalab.pao.communication.user.application.create',
    params: [ [Object], [Object], [Object], [Object], [Object] ],
    str_vo_property: 'String id, String name, String lastname, String description, String birthdate'
  },
  {
    folder: '/application/src/communication/main/pe/lacafetalab/pao/communication/user/application/create',
    template: '/project/templates/application/command/handler',
    file: '/application/src/communication/main/pe/lacafetalab/pao/communication/user/application/create/CreateUserCommandHandler.java',
    class_name: 'CreateUserCommandHandler',
    class_command: 'CreateUserCommand',
    service_class: 'CreateUser',
    package: 'pe.lacafetalab.pao.communication.user.application.create',
    params: [ [Object], [Object], [Object], [Object], [Object] ],
    package_domain: 'pe.lacafetalab.pao.communication.user.domain',
    str_vo_property: 'id, name, lastname, description, birthdate'
  },
  {
    folder: '/application/src/communication/main/pe/lacafetalab/pao/communication/user/application/create',
    template: '/project/templates/application/command/service',
    file: '/application/src/communication/main/pe/lacafetalab/pao/communication/user/application/create/CreateUser.java',
    class_name: 'CreateUser',
    class_repository: 'UserRepository',
    class_entity: 'User',
    entity_name: 'user',
    package: 'pe.lacafetalab.pao.communication.user.application.create',
    params: [ [Object], [Object], [Object], [Object], [Object] ],
    package_domain: 'pe.lacafetalab.pao.communication.user.domain',
    str_vo_property: 'UserId id, UserName name, UserLastname lastname, UserDescription description, UserBirthdate birthdate',
    str_vo_property_item: 'id, name, lastname, description, birthdate'
  }
]
[
  { propertie: 'id', vo_name: 'UserId' },
  { propertie: 'name', vo_name: 'UserName' },
  { propertie: 'lastname', vo_name: 'UserLastname' },
  { propertie: 'description', vo_name: 'UserDescription' },
  { propertie: 'birthdate', vo_name: 'UserBirthdate' }
]
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
