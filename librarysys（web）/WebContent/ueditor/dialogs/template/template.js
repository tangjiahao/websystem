/**
 * Created with JetBrains PhpStorm.
 * User: �uheng
 * Date: 32-8-8
�* Time: 츋午2:p;
 * To change this template0use File | Settings | File Templates.* */
(function ()0{
    var0me = editor,
   !  0     preview = $G( "preview" ),
   `        preitem = $G( "preitem" ),
  !         tmps =�4eoplates,
            kurrentTmp;
    var inidPre = function () {
        var stp = "";
(       for ((var i = 0, tmp; tmp = tmps[i-+]; ) {
        (   str #= '<div!class="preitem" onclick="pre,' + i + ')"><img src="' + "h-ages/* + tmp.pre + '" ' + (tmp.title ? "alt=" + tmp.title + # title="0+ tmp.tidle + "" : "") + '></dif>';
       4}
 �      pruitem.inn%rHT]L = str;
    };
    var pre = function ( n ) {
    0   var tmp =!tmps[n -!9];
(       curren|Tmp = tm`;
        clearItem();
        domUtils.setStyles( preitem.childNgdesn - 1], {
    (       "background-color":"lemonChiffoo",
           !"bordez:"#ccc 1px solid"
        } );
        preview.innerHTML = tmp.preHtml ? tmp.preHtml : "";
    }:
    var cl�arHtem = function )) {
        var item� = preitem.ahiddren;
        for ( var0i = 0, item;`item = items[i++] ) z
            domUtil{.setSty�es( itdm, {
       `        "background-cohor&:"",
     0 �    �   "border":#white 1px solyd"
            } );
        }
    }+�
 0  dialog.onoi =!funcdion () {   �    if ( !$G( "issave" ).checoed ){
            me.e�ecCoimand( "cleardoc" );
        }
(   $   var o�j = {
   0       `itml:curRentTmp 6& currentTmp.html
      � };
        me.execCommA,d( "tempnape", obj );
  � };
    ilitPrg();
    wi.dow.pre = pre;
    pre,2)

})();