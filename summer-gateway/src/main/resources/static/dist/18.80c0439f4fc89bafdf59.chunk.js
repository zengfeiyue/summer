webpackJsonp([18],{276:function(t,n,e){"use strict";function a(t){d||e(964)}Object.defineProperty(n,"__esModule",{value:!0});var o=e(511),i=e.n(o);for(var r in o)"default"!==r&&function(t){e.d(n,t,function(){return o[t]})}(r);var l=e(966),p=e.n(l),d=!1,g=e(0),s=a,c=g(i.a,p.a,!1,s,null,null);c.options.__file="src\\views\\tables\\table-to-image.vue",n.default=c.exports},511:function(t,n,e){"use strict";Object.defineProperty(n,"__esModule",{value:!0});var a=e(100),o=function(t){return t&&t.__esModule?t:{default:t}}(a);n.default={name:"table-to-image",data:function(){var t=this;return{tableData1:this.mockTableData1(),imageName:"",tableColumns1:[{title:"名称",key:"name"},{title:"状态",key:"status",render:function(t,n){var e=n.row;return t("Tag",{props:{type:"dot",color:1===e.status?"blue":2===e.status?"green":"red"}},1===e.status?"构建中":2===e.status?"构建完成":"构建失败")}},{title:"画像内容",key:"portrayal",render:function(n,e){return n("Poptip",{props:{trigger:"hover",title:e.row.portrayal.length+"个画像",placement:"bottom"}},[n("Tag",e.row.portrayal.length),n("div",{slot:"content"},[n("ul",t.tableData1[e.index].portrayal.map(function(t){return n("li",{style:{textAlign:"center",padding:"4px"}},t)}))])])}},{title:"选定人群数",key:"people",render:function(n,e){return n("Poptip",{props:{trigger:"hover",title:e.row.people.length+"个客群",placement:"bottom"}},[n("Tag",e.row.people.length),n("div",{slot:"content"},[n("ul",t.tableData1[e.index].people.map(function(t){return n("li",{style:{textAlign:"center",padding:"4px"}},t.n+"："+t.c+"人")}))])])}},{title:"取样时段",key:"time",render:function(t,n){return t("div","近"+n.row.time+"天")}},{title:"更新时间",key:"update",render:function(n,e){return n("div",t.formatDate(t.tableData1[e.index].update))}}]}},methods:{mockTableData1:function(){for(var t=[],n=0;n<10;n++)t.push({name:"商圈"+Math.floor(100*Math.random()+1),status:Math.floor(3*Math.random()+1),portrayal:["城市渗透","人群迁移","消费指数","生活指数","娱乐指数"],people:[{n:"客群"+Math.floor(100*Math.random()+1),c:Math.floor(1e6*Math.random()+1e5)},{n:"客群"+Math.floor(100*Math.random()+1),c:Math.floor(1e6*Math.random()+1e5)},{n:"客群"+Math.floor(100*Math.random()+1),c:Math.floor(1e6*Math.random()+1e5)}],time:Math.floor(7*Math.random()+1),update:new Date});return t},formatDate:function(t){var n=t.getFullYear(),e=t.getMonth()+1;e=e<10?"0"+e:e;var a=t.getDate();return a=a<10?"0"+a:a,n+"-"+e+"-"+a},exportImage:function(){var t=this,n=this.$refs.table2image.$el;(0,o.default)(n,{onrendered:function(n){var e=n.toDataURL();document.getElementById("exportedImage").src=e;var a=document.createElement("a");a.href=e,a.download=t.imageName?t.imageName:"未命名",document.body.appendChild(a),a.click(),document.body.removeChild(a)}})}}}},964:function(t,n,e){var a=e(965);"string"==typeof a&&(a=[[t.i,a,""]]),a.locals&&(t.exports=a.locals);e(11)("11aa8ecf",a,!1)},965:function(t,n,e){n=t.exports=e(10)(!1),n.push([t.i,"\n.margin-top-8 {\n  margin-top: 8px;\n}\n.margin-top-10 {\n  margin-top: 10px;\n}\n.margin-top-20 {\n  margin-top: 20px;\n}\n.margin-left-10 {\n  margin-left: 10px;\n}\n.margin-bottom-10 {\n  margin-bottom: 10px;\n}\n.margin-bottom-100 {\n  margin-bottom: 100px;\n}\n.margin-right-10 {\n  margin-right: 10px;\n}\n.padding-left-6 {\n  padding-left: 6px;\n}\n.padding-left-8 {\n  padding-left: 5px;\n}\n.padding-left-10 {\n  padding-left: 10px;\n}\n.padding-left-20 {\n  padding-left: 20px;\n}\n.height-100 {\n  height: 100%;\n}\n.height-120px {\n  height: 100px;\n}\n.height-200px {\n  height: 200px;\n}\n.height-492px {\n  height: 492px;\n}\n.height-460px {\n  height: 460px;\n}\n.line-gray {\n  height: 0;\n  border-bottom: 2px solid #dcdcdc;\n}\n.notwrap {\n  word-break: keep-all;\n  white-space: nowrap;\n  overflow: hidden;\n  text-overflow: ellipsis;\n}\n.padding-left-5 {\n  padding-left: 10px;\n}\n[v-cloak] {\n  display: none;\n}\n.dragging-tip-enter-active {\n  opacity: 1;\n  transition: opacity .3s;\n}\n.dragging-tip-enter,\n.dragging-tip-leave-to {\n  opacity: 0;\n  transition: opacity 0.3s;\n}\n.dragging-tip-con {\n  display: block;\n  text-align: center;\n  width: 100%;\n  height: 50px;\n}\n.dragging-tip-con span {\n  font-size: 18px;\n}\n.record-tip-con {\n  display: block;\n  width: 100%;\n  height: 292px;\n  overflow: auto;\n}\n.record-item {\n  box-sizing: content-box;\n  display: block;\n  overflow: hidden;\n  height: 24px;\n  line-height: 24px;\n  padding: 8px 10px;\n  border-bottom: 1px dashed gainsboro;\n}\n.record-tip-con span {\n  font-size: 14px;\n}\n.edittable-test-con {\n  height: 160px;\n}\n.edittable-table-height-con {\n  height: 190px;\n}\n.edittable-con-1 {\n  box-sizing: content-box;\n  padding: 15px 0 0;\n  height: 196px;\n}\n.edittable-table-get-currentdata-con {\n  height: 190px !important;\n}\n.exportable-table-download-con1 {\n  padding: 16px 0 16px 20px;\n  border-bottom: 1px dashed #c3c3c3;\n  margin-bottom: 16px;\n}\n.exportable-table-download-con2 {\n  padding-left: 20px;\n}\n.show-image {\n  padding: 20px 0px;\n}\n.show-image img {\n  display: block;\n  width: 100%;\n  height: auto;\n}\n.searchable-table-con1 {\n  height: 230px !important;\n}\n",""])},966:function(t,n,e){"use strict";Object.defineProperty(n,"__esModule",{value:!0});var a=function(){var t=this,n=t.$createElement,e=t._self._c||n;return e("div",[e("Row",[e("Card",[e("p",{attrs:{slot:"title"},slot:"title"},[e("Icon",{attrs:{type:"images"}}),t._v("\n                将表格数据连同样式一起以图片形式导出\n            ")],1),t._v(" "),e("Row",[e("Col",{attrs:{span:"18"}},[e("Table",{ref:"table2image",attrs:{data:t.tableData1,columns:t.tableColumns1,stripe:""}})],1),t._v(" "),e("Col",{staticClass:"padding-left-20",attrs:{span:"6"}},[e("div",{staticClass:"margin-bottom-10",attrs:{id:"showImage"}},[e("span",[t._v("输入文件名：")]),t._v(" "),e("Input",{staticStyle:{width:"190px"},attrs:{icon:"document",placeholder:"请输入图片名"},model:{value:t.imageName,callback:function(n){t.imageName=n},expression:"imageName"}})],1),t._v(" "),e("Button",{attrs:{type:"primary"},on:{click:t.exportImage}},[t._v("导出表格为图片")]),t._v(" "),e("div",{staticClass:"show-image margin-top-20",attrs:{id:"showImage"}},[e("img",{attrs:{id:"exportedImage"}})])],1)],1)],1)],1)],1)},o=[];a._withStripped=!0;var i={render:a,staticRenderFns:o};n.default=i}});