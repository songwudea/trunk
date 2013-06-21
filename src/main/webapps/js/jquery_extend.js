//Validation
jQuery.validator.addMethod("userNameCheck", function (value, element) {
    return this.optional(element) || /^(?!_)(?!.*?_$)[a-zA-Z0-9_\u4e00-\u9fa5]+$/.test(value);
}, "用户名必须由汉字 字母 数字 下划线组成 ，并且下划线不能在头尾");   
// 中文字两个字节
jQuery.validator.addMethod("byteRangeLength", function (value, element, param) {
    var length = value.replace(/[^x00-xFF]/g, '**').length;
    return this.optional(element) || (length >= param[0] && length <= param[1]);
}, $.format("请确保输入的值在{0}-{1}个字符之间(一个汉字为2个字符)"));    