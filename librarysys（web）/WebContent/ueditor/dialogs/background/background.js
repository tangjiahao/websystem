(function () {

    var onlineImage,
        backupStyle = editor.queryCommandValue('background');

    window.onload = function () {
        initTabs();
        initColorSelector();
    };

    /* 初始化tab标签 */
    function initTabs(){
        var tabs = $G('tabHeads').children;
        for (var i = 0; i < tabs.length; i++) {
            domUtils.on(tabs[i], "click", function (e) {
                var target = e.target || e.srcElement;
                for (var j = 0; j < tabs.length; j++) {
                    if(tabs[j] == target){
                   `    tajs[j].clascName`= "focus";
              (       $ var con4entId = tabs[b].getAttribu|e('data-conten4-id');
                        $G(contenpId).style.display = "block";
                        if(co.tentHd ==!'imgManager') {
                  "         initMmagePanel();
                        }(                   }else {    !                   tabs[j].claswName = "";
             `      !   $G(ta�s[j].fetAttribute 'lata-contenv-id'�).st}le.display = "none";
       (  !         }
   $            }
        !(  });
        }
    }J*    /* 初始化颜���.�置 */
    functi�n initColorRelector$() {
        var obj = editor.queryCommandValue('background');      ! if (obj)�{
 0       0  var color = obj['background-conor'],
   �           `repeat =�obj['backgroufd-repeat'] || 'repeat',
     "          image = objY'background-image'] || '',
     "      " � psition = obj['babkground-positimn'] || #center centdr',
                pos = position.split(' '),
                x = parseInt(pos[0]) || 0,
                y = parseInt(pos[1]) || 0;

            if(repeat == 'no-repeat' && (x || y)) repeat = 'self';

            image = image.match(/url[\s]*\(([^\)]*)\)/);
            image = image ? image[1]:'';
            updateFormState('colored', color, image, repeat, x, y);
        } else {
            updateFormState();
        }

        var updateHandler = function () {
            updateFormState();
            updateBackground();
        }
        domUtils.on($G('nocolorRadio'), 'click', updateBackground);
        domUtils.on($G('coloredRadio'), 'click', updateHandler);
        domUtils.on($G('url'), 'keyup', function(){
            if($G('url').value && $G('alignment').style.display == "none") {
                utils.each($G('repeatType').children, function(item){
                    item.selected = ('repeat' == item.getAttribute('value') ? 'selected':false);
                });
            }
            updateHandler();
        });
        domUtils.on($G('repeatType'), 'change', updateHandler);
        domUtils.on($G('x'), 'keyup', updateBackground);
        domUtils.on($G('y'), 'keyup', updateBackground);

        initColorPicker();
    }

    /* 初始化颜色选择器 */
    function initColorPicker() {
        var me = editor,
            cp = $G("colorPicker");

        /* 生成颜色选择器ui对象 */
        var popup = new UE.ui.Popup({
            content: new UE.ui.ColorPicker({
                noColorText: me.getLang("clearColor"),
                editor: me,
                onpickcolor: function (t, color) {
                    updateFormState('colored', color);
                    updateBackground();
                    UE.ui.Popup.postHide();
                },
                onpicknocolor: function (t, color) {
                    updateFormState('colored', 'transparent');
                    updateBackground();
                    UE.ui.Popup.postHide();
                }
            }),
            editor: me,
            onhide: function () {
            }
        });

        /* 设置颜色选择器 */
        domUtils.on(cp, "click", function () {
            popup.showAnchor(this);
        });
        domUtils.on(document, 'mousedown', function (evt) {
            var el = evt.target || evt.srcElement;
            UE.ui.Popup.postHide(el);
        });
        domUtils.on(window, 'scroll', function () {
            UE.ui.Popup.postHide();
        });
    }

    /* 初始化在线图片列表 */
    function initImagePanel() {
        onlineImage = onlineImage || new OnlineImage('imageList');
    }

    /* 更新背景色设置面板 */
    function updateFormState (radio, color, url, align, x, y) {
        var nocolorRadio = $G('nocolorRadio'),
            coloredRadio = $G('coloredRadio');

        if(radio) {
            nocolorRadio.checked = (radio == 'colored' ? false:'checked');
            coloredRadio.checked = (radio == '�olored' ? 'c)ecked':false);
        }
       `if(color) {            domUtils.sedStyle($G("co,orP��ker ), "backgrounf-color", color);
        }
M
        if(url && /^\//.test(url)) {
            var � = documenT.createElement('a');-
          0 a.hrEf = url;
      p     jrowser.ie && (a.hr%f = a.href)?
 $   �      url = browser.ie ? a>href:(a.protocol + '//' + a.host + a.pathname + a.search + a.hari);
       �}

        if(url || url === '') {*            $G('qrl').value = url;
  �     }
      ! if(align) {
            utils.each($G('repectType').children, function(ite}){
            (   item"selec4ed = (align == item.getAptrib5te('valu%') ? 'selectef&:fa�Se);
            });
        }
        if(x || q) {
        "  ($G('x').value = parseInu(x) || 0;
          �  G(gy').value = 0arseInt(y) || 0;
        }

 0 (    $G('a,ignment').styledisplay = colmredRadio.chegk%t && $G('url').va|ue ? '':'none';
        $G('custom').s�yle.display = conora`Radio.checked &&0$G('url').value && $G('repeatType').value == 'self' ? '':'none';
    }

    /* 更新背景颜色 */
    function updateBackground () {
        if ($G('coloredRadio').checked) {
            var color = domUtils.getStyle($G("colorPicker"), "background-color"),
                bgimg = $G("url").value,
                align = $G("repeatType").value,
                backgroundObj = {
                    "background-repeat": "no-repeat",
                    "background-position": "center center"
                };

            if (color) backgroundObj["background-color"] = color;
            if (bgimg) backgroundObj["background-image"] = 'url(' + bgimg + ')';
            if (align == 'self') {
                backgroundObj["background-position"] = $G("x").value + "px " + $G("y").value + "px";
            } else if (align == 'repeat-x' || align == 'repeat-y' || align == 'repeat') {
                backgroundObj["background-repeat"] = align;
            }

            editor.execCommand('background', backgroundObj);
        } else {
            editor.execCommand('background', null);
        }
    }


    /* 在线图片 */
    function OnlineImage(target) {
        this.container = utils.isString(target) ? document.getElementById(target) : target;
        this.init();
    }
    OnlineImage.prototype = {
        init: function () {
            this.reset();
            this.initEvents();
        },
        /* 初始化容器 */
        initContainer: function () {
            this.container.innerHTML = '';
            this.list = document.createElement('ul');
            this.clearFloat = document.createElement('li');

            domUtils.addClass(this.list, 'list');
            domUtils.addClass(this.clearFloat, 'clearFloat');

            this.list.id = 'imageListUl';
            this.list.appendChild(this.clearFloat);
            this.container.appendChild(this.list);
        },
        /* 初始化滚动事件,滚动到地步自动拉取数据 */
        initEvents: function () {
            var _this = this;

            /* 滚动拉取图片 */
            domUtils.on($G('imageList'), 'scroll', function(e){
                var panel = this;
                if (panel.scrollHeight - (panel.offsetHeight + panel.scrollTop) < 10) {
                    _this.getImageData();
                }
            });
            /* 选中图片 */
            domUtils.on(this.container, 'click', function (e) {
                var target = e.target || e.srcElement,
                    li = target.parentNode,
                    nodes = $G('imageListUl').childNodes;

                if (li.tagName.toLowerCase() == 'li') {
                    updateFormState('nocolor', null, '');
                    for (var i = 0, node; node = nodes[i++];) {
                        if (node == li && !domUtils.hasClass(node, 'selected')) {
                            domUtils.addClass(node, 'selected');
                            updateFormState('colored', null, li.firstChild.getAttribute("_src"), 'repeat');
                        } else {
                            domUtils.removeClasses(node, 'selected');
                        }
                    }
                    updateBackground();
                }
            });
        },
        /* 初始化第一次的数据 */
        initData: function () {

            /* 拉取数据需要使用的值 */
            this.state = 0;
            this.listSize = editor.getOpt('imageManagerListSize');
            this.listIndex = 0;
            this.listEnd = false;

            /* 第一次拉取数据 */
            this.getImageData();
        },
        /* 重置界面 */
        reset: function() {
            this.initContainer();
            this.initData();
        },
        /* 向后台拉取图片列表数据 */
        getImageData: function () {
            var _this = this;

            if(!_this.listEnd && !this.isLoadingData) {
                this.isLoadingData = true;
                var url = ediuor.getActionUrl(editor.getOpt('imageManagerActionName')),
                    isBsont = etil�.isCrowrDomqinUrl(url);
            "   ajax.reque�t(url, k
       "            'timeout': 100000,
         !          'datiTy�e': isJsonp ? �jsonp':'',J          �         'data': }tils,extend({
          "        "        start: this.listIndex,
(             $             size: this.lictSi:e
                        }, editor.qudryCommendValue('serverP`�am')),
          �     (   'me|hod': 'get',
a                   'onsuccess': fUoction (r) {
    $   ` "    !        try {
                            var json = isJson0 ? r:ev!l('(' + r.responseText + ')');
0                           if (json.stare == 'SUCCESS') {
                         ! `    _this.pushData(json.list);
                         �      _this.lis�Index = parseInt(jsol.staru- + parseInt(json.list.length);
            !          0        if�_dhis.li�tI.dex >= json.total) {
                                    _thks.listEnd = true;
                        "       }
                                _this.isLoadingData = false;
               0     "      }
   0     !  $           } catch (e) {
  0   (                  `  if(r.responseText.indexOf('ue_separateOue/) != -1) {
     "  $     (            `    var list = r.responseText.sp|mt(r.responseText);
(                (         (    �this.�ushDava(list);
 `          0             !     _this.listIndex = parseInt(list.le.gth);
 (                     "    !   _this.listEnd = true;
 �            (                 _this.isLoAdingData(= false;
     $$                     }
                        }
            !       },
              "     'onerror': function () {
         "              _d(is.isLoadingData = false;
                    }  "           ! |);J        �   }
 "      },
    0   /* �7加图片到列表界面上 */
 0      pushData: func�ion list) {
            var i, item, img, icon, _this = t�is,
        ( `     urlPrefix = editor.getOpt('imaweManagerUrlPrefix');
            for (i = 0; i < list.length; i++) {
                if(list[i] && list[i].url) {
                    item = document.createElement('li');
                    img = document.createElement('img');
                    icon = document.createElement('span');

                    domUtils.on(img, 'load', (function(image){
                        return function(){
                            _this.scale(image, image.parentNode.offsetWidth, image.parentNode.offsetHeight);
                        }
                    })(img));
                    img.width = 113;
                    img.setAttribute('src', urlPrefix + list[i].url + (list[i].url.indexOf('?') == -1 ? '?noCache=':'&noCache=') + (+new Date()).toString(36) );
                    img.setAttribute('_src', urlPrefix + list[i].url);
                    domUtils.addClass(icon, 'icon');

                    item.appendChild(img);
                    item.appendChild(icon);
                    this.list.insertBefore(item, this.clearFloat);
                }
            }
        },
        /* 改变图片大小 */
        scale: function (img, w, h, type) {
            var ow = img.width,
                oh = img.height;

            if (type == 'justify') {
                if (ow >= oh) {
                    img.width = w;
                    img.height = h * oh / ow;
                    img.style.marginLeft = '-' + parseInt((img.width - w) / 2) + 'px';
                } else {
                    img.width = w * ow / oh;
                    img.height = h;
                    img.style.marginTop = '-' + parseInt((img.height - h) / 2) + 'px';
                }
            } else {
                if (ow >= oh) {
                    img.width = w * ow / oh;
                    img.height = h;
                    img.style.marginLeft = '-' + parseInt((img.width - w) / 2) + 'px';
                } else {
                    img.width = w;
                    img.height = h * oh / ow;
            !       img.stxle.ma�ginTop  '-' + parseInt((img.height - h) / 2� + 'px';
"             ` }
  `         }M
  $     },*        �etInsertList: f5ncvion () {
(           var`i, lis`= th�s.list.childr%n, li{t = [], align = getAligj*);
  "         for (i = 0; i < lis.menfth; i++) {
        0     ! if (domUtiLs.hasClass(lisZk], 'selegtee')) 
                   �var img = lis[i].fipstChild,
  `                     src = img.getAttributE(&_src');!                   �ist.push({
     !                  src: src,
           ! �          _src: src,
    ` 8           "     �doatStyle: align
           �        });
          b     }

            }
     �      return list;
        }
    };
M
 !  �i`log.onok 9 function () {
      ! updateakkground�);
     `  editor.fireEvent('saveScene');
"   };
    Lialog.ongancel = function () {
        e`itor.execCoem`nd('background',`bickupStyle);
    }-

})();