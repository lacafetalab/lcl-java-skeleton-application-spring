const util = require("./util");

function config(file_name) {
  let d = util.read_yaml(file_name);
  let events=[];
  for (const event_entity in d["events"]) {
    let event_type = util.capitalizeFirstLetter(event_entity);
    let event_name = d["events"][event_entity];
    let template = `/project/templates/domain/aggregate/event`;
    let folder = `${util.get_path_main(d)}/${d["entity"]["package"]}`;
    let class_name = `${d["name"]}${event_type}DomainEvent`;
    let file = `${folder}/${class_name}.java`;
    let package = `${d["package"]}.${d["entity"]["package"]}`.replace(/\//g,".");

    let params=[];
    let str_property="";
    let str_string_property="";
    let str_map_property="";
    let str_vo_equals="";
    for (const propertie in d["entity"]["properties"]) {
      if(propertie=='id'){
        continue;
      }
      str_property = str_property+`, ${propertie}`;
      str_string_property = str_string_property+`, String ${propertie}`;
      str_map_property = str_map_property+`, (String) body.get("${propertie}")`;
      str_vo_equals = str_vo_equals + ` && Objects.equals(${propertie}, that.${propertie})`;
      
      params.push(propertie);
    }
    str_string_property = util.remove_first_params(str_string_property).trim();
    str_map_property = util.remove_first_params(str_map_property).trim();
    str_property = util.remove_first_params(str_property).trim();
    str_vo_equals = str_vo_equals.substring(4);
    events.push({
        folder,
        template,
        file,
        class_name,
        package,
        params,
        event_name,
        str_property,
        str_string_property,
        str_map_property,
        str_vo_equals
      });
  }

  
  return events;
}


/*
[
  {
    folder: '/application/src/communication/main/pe/lacafetalab/pao/communication/announcement/domain',
    template: '/project/templates/domain/aggregate/event',
    file: '/application/src/communication/main/pe/lacafetalab/pao/communication/announcement/domain/AnnouncementCreatedDomainEvent.java',
    class_name: 'AnnouncementCreatedDomainEvent',
    package: 'pe.lacafetalab.pao.communication.announcement.domain',
    params: [ 'title', 'description', 'authorId', 'classRoomId', 'publishAt' ],
    event_name: 'comunication.announcement.created',
    str_property: 'title, description, authorId, classRoomId, publishAt',
    str_string_property: 'String title, String description, String authorId, String classRoomId, String publishAt',
    str_map_property: '(String) body.get("title"), (String) body.get("description"), (String) body.get("authorId"), (String) body.get("classRoomId"), (String) body.get("publishAt")',
    str_vo_equals: 'Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(authorId, that.authorId) && Objects.equals(classRoomId, that.classRoomId) && Objects.equals(publishAt, that.publishAt)'
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
