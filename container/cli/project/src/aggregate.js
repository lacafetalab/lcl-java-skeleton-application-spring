const util = require("./util");

function config(file_name) {
  let d = util.read_yaml(file_name);
  let template = `/project/templates/domain/aggregate/aggregate_root`;
  let folder = `${util.get_path_main(d)}/${d["entity"]["package"]}`;
  let class_name = `${d["name"]}`;
  let file = `${folder}/${class_name}.java`;
  let package = `${d["package"]}.${d["entity"]["package"]}`.replace(/\//g,".");

  let params=[];
  let str_vo_property="";
  let str_property="";
  let str_property_to_string="";
  let str_vo_equals="";
  for (const propertie in d["entity"]["properties"]) {
    let prop = util.get_properties(d["entity"]["properties"][propertie]);
    let propertieCapital = util.capitalizeFirstLetter(propertie);
    let vo_name = `${d["name"]}${propertieCapital}`;
    str_vo_property = str_vo_property+`, ${vo_name} ${propertie}`;
    str_property = str_property+`, ${propertie}`;
    str_property_to_string = str_property_to_string+`, ${propertie}.toString()`;
    str_vo_equals = str_vo_equals + ` && Objects.equals(${propertie}, that.${propertie})`;
    let obj_param = {
      propertie,
      vo_name
    }
    params.push(obj_param);
  }
  str_vo_property = util.remove_first_params(str_vo_property).trim();
  str_property = util.remove_first_params(str_property).trim();
  str_property_to_string = util.remove_first_params(str_property_to_string).trim();
  str_vo_equals = str_vo_equals.substring(4);
  return [{
    folder,
    template,
    file,
    class_name,
    package,
    params,
    str_vo_property,
    str_property,
    str_property_to_string,
    str_vo_equals
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
