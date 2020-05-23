import {Template} from "@sdk/AbstractGenerate";

const fs = require("fs");
const YAML = require("yaml");
const ejs = require("ejs");

export function readYaml(fileName: string) {
    const file = fs.readFileSync(fileName, "utf8");
    return YAML.parse(file);
}

export function generateFile(list: Template[]) {
    list.forEach((param) => {
        // se copia el archjvo original y se genera un render para luego sacar la comparacion con GIT
        if (fs.existsSync(param.file)) {
            console.error(`exist : ${param.file}`);
            // copia el archivo original a /compare/....
            fs.mkdir(`/compare${param.folder}`, { recursive: true }, (err) => {
                if (err) throw err;
                fs.copyFile(param.file, `/compare${param.file}`, (err) => {
                    if (err) throw err;
                });
            });
            // genera el archivo renderizado en la carpeta /render/....
            fs.mkdir(`/render${param.folder}`, { recursive: true }, (err) => {
                if (err) throw err;
                ejs.renderFile(param.template, param, {}, function (err, str) {
                    if (err) throw err;
                    fs.writeFile(`/render${param.file}`, str, (err) => {
                        if (err) throw err;
                    });
                });
            });

        }else{
            fs.mkdir(param.folder, { recursive: true }, (err) => {
                if (err) throw err;
                ejs.renderFile(param.template, param, {}, function (err, str) {
                    if (err) throw err;
                    fs.writeFile(param.file, str, (err) => {
                        if (err) throw err;
                        console.log(`generated : ${param.file}`);
                    });
                });
            });
        }
    });

}