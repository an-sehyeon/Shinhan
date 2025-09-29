import person from "./person.js";
import { baseData, clean } from "./utility.js";

console.log("person:", person);
console.log("baseData:" + baseData);
clean("$$$$$");

window.clean = clean;
