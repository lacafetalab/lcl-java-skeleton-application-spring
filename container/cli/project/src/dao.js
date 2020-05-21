const util = require("./util");

function config(file_name) {
  let d = util.read_yaml(file_name);
  let template = `/project/templates/domain/repository/dao`;
  let folder = `${util.get_path_main(d)}/infrastructure/repository`;
  let class_name = `${d["name"]}Dao`;
  let file = `${folder}/${class_name}.java`;

  let package = `${d["package"]}.infrastructure.repository`;
  let package_domain = `${d["package"]}.${d["entity"]["package"]}`.replace(/\//g,".");
  let entity = `${d["name"]}`;
  let table = (d["repository"]["table"])? d["repository"]["table"] : util.to_snake_case(d["name"]);

  let params=[];
  let to_domain="";
  for (const propertie in d["entity"]["properties"]) {
    let prop = util.get_properties(d["entity"]["properties"][propertie]);
    let propertieCapital = util.capitalizeFirstLetter(propertie);
    let vo_name = `${d["name"]}${propertieCapital}`;
    let column_name = (d["repository"]["columnName"][propertie])? d["repository"]["columnName"][propertie] : util.to_snake_case(propertie);
    to_domain = to_domain+`, new ${vo_name}(this.${propertie})`;
    let obj_param = {
      propertie,
      is_pk: d["repository"]["pk"]==propertie,
      //vo_name,
      type: prop["type"],
      primitive: prop["primitive"],
      column_name
    }
    params.push(obj_param);
  }
  to_domain = util.remove_first_params(to_domain).trim();
  return [{
    folder,
    template,
    file,
    class_name,
    package,
    params,
    to_domain,
    package_domain,
    entity,
    table
  }];
}


/*
{
    folder: '/application/src/communication/main/pe/lacafetalab/pao/communication/announcement/domain',
    template: '/project/templates/domain/aggregate/aggregate_root',
    file: '/application/src/communication/main/pe/lacafetalab/pao/communication/announcement/domain/Announcement.java',
    class_name: 'Announcement',
    package: 'pe.lacafetalab.pao.communication.announcement.domain',
    params: [ [Object], [Object], [Object], [Object], [Object], [Object] ],
    str_vo_property: 'AnnouncementId id, AnnouncementTitle title, AnnouncementDescription description, AnnouncementAuthorId authorId, AnnouncementClassRoomId classRoomId, AnnouncementPublishAt publishAt',
    str_property: 'id, title, description, authorId, classRoomId, publishAt',
    str_property_to_string: 'id.toString(), title.toString(), description.toString(), authorId.toString(), classRoomId.toString(), publishAt.toString()',
    str_vo_equals: 'Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(authorId, that.authorId) && Objects.equals(classRoomId, that.classRoomId) && Objects.equals(publishAt, that.publishAt)'
  }
  [
  { propertie: 'id', vo_name: 'AnnouncementId' },
  { propertie: 'title', vo_name: 'AnnouncementTitle' },
  { propertie: 'description', vo_name: 'AnnouncementDescription' },
  { propertie: 'authorId', vo_name: 'AnnouncementAuthorId' },
  { propertie: 'classRoomId', vo_name: 'AnnouncementClassRoomId' },
  { propertie: 'publishAt', vo_name: 'AnnouncementPublishAt' }
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
