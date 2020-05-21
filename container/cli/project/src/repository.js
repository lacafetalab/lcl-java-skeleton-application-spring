const util = require("./util");

function config(file_name) {
  return [
    config_domain(file_name),
    config_jpa(file_name),
    config_sql(file_name)
  ];
}
function config_domain(file_name) {
  let d = util.read_yaml(file_name);
  let template = `/project/templates/domain/repository/repository`;
  let folder = `${util.get_path_main(d)}/${d["entity"]["package"]}`;
  let class_name = `${d["name"]}Repository`;
  let entity = `${d["name"]}`;
  let file = `${folder}/${class_name}.java`;
  let package = `${d["package"]}.${d["entity"]["package"]}`.replace(/\//g,".");

  return {
    folder,
    template,
    file,
    package,
    entity
  };
}

function config_jpa(file_name) {
  let d = util.read_yaml(file_name);
  let template = `/project/templates/domain/repository/jpaRepository`;
  let folder = `${util.get_path_main(d)}/infrastructure/repository`;
  let class_name = `${d["name"]}SpringCrudRepository`;
  let entity = `${d["name"]}`;
  let file = `${folder}/${class_name}.java`;
  let package = `${d["package"]}.infrastructure.repository`;

  return {
    folder,
    template,
    file,
    package,
    entity
  };
}

function config_sql(file_name) {
  let d = util.read_yaml(file_name);
  let template = `/project/templates/domain/repository/sqlRepository`;
  let folder = `${util.get_path_main(d)}/infrastructure/repository`;
  let class_name = `Sql${d["name"]}Repository`;
  let entity = `${d["name"]}`;
  let entity_id = `${d["name"]}Id`;
  let entity_repository = `${d["name"]}Repository`;
  let entity_dao = `${d["name"]}Dao`;
  let file = `${folder}/${class_name}.java`;
  let package = `${d["package"]}.infrastructure.repository`;
  let package_domain = `${d["package"]}.${d["entity"]["package"]}`.replace(/\//g,".");

  return {
    folder,
    template,
    file,
    package,
    entity,
    package_domain,
    class_name,
    entity_id,
    entity_repository,
    entity_dao
  };
}


/*
[
  {
    folder: '/application/src/communication/main/pe/lacafetalab/pao/communication/user/domain',
    template: '/project/templates/domain/repository/repository',
    file: '/application/src/communication/main/pe/lacafetalab/pao/communication/user/domain/UserRepository.java',
    package: 'pe.lacafetalab.pao.communication.user.domain',
    entity: 'User'
  },
  {
    folder: '/application/src/communication/main/pe/lacafetalab/pao/communication/user/infrastructure/repository',
    template: '/project/templates/domain/repository/jpaRepository',
    file: '/application/src/communication/main/pe/lacafetalab/pao/communication/user/infrastructure/repository/UserSpringCrudRepository.java',
    package: 'pe.lacafetalab.pao.communication.user.infrastructure.repository',
    entity: 'User'
  },
  {
    folder: '/application/src/communication/main/pe/lacafetalab/pao/communication/user/infrastructure/repository',
    template: '/project/templates/domain/repository/sqlRepository',
    file: '/application/src/communication/main/pe/lacafetalab/pao/communication/user/infrastructure/repository/SqlUserRepository.java',
    package: 'pe.lacafetalab.pao.communication.user.infrastructure.repository',
    entity: 'User',
    package_domain: 'pe.lacafetalab.pao.communication.user.domain',
    class_name: 'SqlUserRepository',
    entity_id: 'UserId',
    entity_repository: 'UserRepository',
    entity_dao: 'UserDao'
  }
]
*/
function generate_by_file(file_name) {
  let list_vo = config(file_name);
  util.generate_file(list_vo);
}

function show_configuration(file_name) {
  console.log(config(file_name));
}

module.exports = {
  generate_by_file,
  show_configuration,
};
