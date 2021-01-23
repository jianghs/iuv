function str2Json(obj, str) {
    let replaceStr = str.replace(obj+"(", "");
    let replaceStr1 = replaceStr.replace(replaceStr.charAt(replaceStr.length - 1), "");

    let arr = replaceStr1.split(",");
    let jsonString = "{"
    for (let i = 0; i < arr.length; i++) {
        let ele = arr[i].trim();
        let arr1 = ele.split("=");
        jsonString += "\"" + arr1[0].trim() + "\":" + "\"" + arr1[1].trim() + "\",";
    }
    jsonString += "}";
    let result = jsonString.replace(",}", "}").replace(new RegExp("\"null\"","gm"), "\"\"");
    return JSON.parse(result);
}