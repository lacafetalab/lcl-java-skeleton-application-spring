const util = require("./util");

function config_vo(file_name) {
  let d = util.read_yaml(file_name);
  let vo = [];
  for (const propertie in d["entity"]["properties"]) {
    let prop = util.get_properties(d["entity"]["properties"][propertie]);
    let propertieCapital = util.capitalizeFirstLetter(propertie);
    let name = `${d["name"]}${propertieCapital}`;
    let template = `/project/templates/domain/vo/${prop["type"]}`;
    let folder = `${util.get_path_main(d)}/${d["entity"]["package"]}`;
    let file = `${folder}/${name}.java`;
    let package = `${d["package"]}.${d["entity"]["package"]}`.replace(
      /\//g,
      "."
    );
    let message = d["entity"]["message"]["validate"]["vo"][propertie];
    message = (typeof message == "undefined")? {}:message;
    let vo_object = {
      folder,
      template,
      file,
      name,
      package,
      prop,
      message
    };
    vo.push(vo_object);
  }

  return vo;
}


/*
{
    name: 'AnnouncementId',
    template: '/project/templates/domain/vo/id',
    folder: '/application/src/communication/main/pe/lacafetalab/pao/communication/announcement2/domain',
    file: '/application/src/communication/main/pe/lacafetalab/pao/communication/announcement2/domain/AnnouncementId.java',
    package: 'pe.lacafetalab.pao.communication.announcement2.domain',
    prop: { type: 'id', required: true, default: null }
  }
*/
function generate_by_file(file_name) {
  let list_vo = config_vo(file_name);
  util.generate_file(list_vo);
}

function show_configuration(file_name) {
  console.log(config_vo(file_name));
}

module.exports = {
  generate_by_file,
  show_configuration,
};
