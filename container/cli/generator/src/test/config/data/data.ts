export function complete() {
    return {
        "path": "/application/src/communication",
        "path_applications": "/application/applications",
        "package_applications": "pe.lacafetalab.pao.controller",
        "package": "pe.lacafetalab.pao.communication.user",
        "name": "User",
        "properties": {
            "aggregate": {
                "id": "id",
                "name": "string",
                "lastname": "text",
                "description": {
                    "type": "text",
                    "required": false
                },
                "birthdate": "datetime"
            }
        },
        "message": {
            "validate": {
                "valueObject": {
                    "name": {
                        "required": "El nombre es requerido",
                        "valid": "El nombre no es un valor válido"
                    },
                    "lastname": {
                        "required": "El apellido es requerido",
                        "valid": "El apellido no es un valor válido"
                    }
                }
            }
        },
        "events": {
            "created": "comunication.user.created"
        },
        "services": {},
        "repository": {
            "pk": "id",
            "table": "users",
            "columnName": {
                "birthdate": "birth_date"
            }
        },
        "http": {
            "create": {
                "cqrs": "command",
                "method": "post",
                "url": "/user"
            }
        }
    }
}

export function min() {
    return {
        "path": "/application/src/communication",
        "package": "pe.lacafetalab.pao.communication.user",
        "name": "User",
        "properties": {
            "aggregate": {
                "id": "id",
                "name": "string",
                "lastname": "text",
                "description": {
                    "type": "text",
                    "required": false
                },
                "birthdate": "datetime"
            }
        }
    }
}