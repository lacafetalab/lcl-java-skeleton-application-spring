class Device {
  constructor({status = "off", brand = "ACME",firmware = "unknown"} = {}) {
      this._status = status;
      this._brand = brand;
      this._firmware = firmware;
  }

  start() {
    this._status = "on";
  }

  get status() {
    return this._status;
  }

  get brand() {
    return this._brand;
  }

  get firmware() {
    return this._firmware;
  }

  static strToURL(str) {
    return encodeURIComponent(str).replace(/%20/g, "+");
  }
}

class VideoDevice extends Device {
  start(source = "") {
    super.start();

    return "Rendering source...";
  }
}

class DiskDevice extends Device {
  constructor(params = {}) {
    super({ status: "on" });
  }

  format(size = 0) {
    return "Formatting device | Firmware: " + this._firmware;
  }
}

let d1 = new Device();
console.log(d1.status); // "off"


let player = new VideoDevice({ brand: "Videodrome" });
console.log(player.brand); // "Videodrome"
console.log(player.status); // "off"
console.log(player.start()); // "Rendering source..."
console.log(player.status); // "on"

let hdd = new DiskDevice();
console.log(hdd.status); // "on"
console.log(hdd.format()); // "Formatting device | Firmware: unknown"


console.log(Device.strToURL("text convert to string"));