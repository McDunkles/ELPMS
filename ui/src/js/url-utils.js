const criteria = {
    ALL: ""
  }

export default class UrlUtils {

  static toUrlEncoded(params) {
    var str = [];
    for (var p in params) {
      let val = params[p];
      if (val === criteria.ALL || val == null) {
        continue;
      }
      str.push(p + "=" + encodeURIComponent(val));
    }
    return str.join("&");
  }

}