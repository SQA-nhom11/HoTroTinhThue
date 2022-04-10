/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
if ((address_2 = localStorage.getItem("address_2_saved"))) {
        $('select[name="quanHuyen"] option').each(function () {
          if ($(this).text() == address_2) {
            $(this).attr("selected", "");
          }
        });
      }
      if ((district = localStorage.getItem("district"))) {
        $('select[name="quanHuyen"]').html(district);
        $('select[name="quanHuyen"]').on("change", function () {
          var target = $(this).children("option:selected");
          target.attr("selected", "");
          $('select[name="quanHuyen"] option')
            .not(target)
            .removeAttr("selected");
          address_2 = target.text();
          district = $('select[name="quanHuyen"]').html();
          localStorage.setItem("district", district);
          localStorage.setItem("address_2_saved", address_2);
        });
      }
      $('select[name="tinhThanh"]').each(function () {
        var $this = $(this),
          stc = "";
        c.forEach(function (i, e) {
          e += +1;
          stc += "<option value=" + e + ">" + i + "</option>";
          $this.html('<option value="">Tỉnh / Thành phố</option>' + stc);
          if ((address_1 = localStorage.getItem("address_1_saved"))) {
            $('select[name="tinhThanh"] option').each(
              function () {
                if ($(this).text() == address_1) {
                  $(this).attr("selected", "");
                }
              }
            );
          }
          $this.on("change", function (i) {
            i = $this.children("option:selected").index() - 1;
            var str = "",
              r = $this.val();
            if (r != "") {
              arr[i].forEach(function (el) {
                str += '<option value="' + el + '">' + el + "</option>";
                $('select[name="quanHuyen"]').html(
                  '<option value="">Quận / Huyện</option>' + str
                );
              });
              var address_1 = $this.children("option:selected").text();
              var district = $('select[name="quanHuyen"]').html();
              localStorage.setItem("address_1_saved", address_1);
              localStorage.setItem("district", district);
              $('select[name="quanHuyen"]').on(
                "change",
                function () {
                  var target = $(this).children("option:selected");
                  target.attr("selected", "");
                  $('select[name="quanHuyen"] option')
                    .not(target)
                    .removeAttr("selected");
                  var address_2 = target.text();
                  district = $('select[name="quanHuyen"]').html();
                  localStorage.setItem("district", district);
                  localStorage.setItem("address_2_saved", address_2);
                }
              );
            } else {
              $('select[name="quanHuyen"]').html(
                '<option value="">Quận / Huyện</option>'
              );
              district = $('select[name="quanHuyen"]').html();
              localStorage.setItem("district", district);
              localStorage.removeItem("address_1_saved", address_1);
            }
          });
        });
      });
      
      
      
      
      
      
if ((address_4 = localStorage.getItem("address_4_saved"))) {
        $('select[name="quanHuyenDaiLy"] option').each(function () {
          if ($(this).text() == address_4) {
            $(this).attr("selected", "");
          }
        });
      }
      if ((district2 = localStorage.getItem("district2"))) {
        $('select[name="quanHuyenDaiLy"]').html(district2);
        $('select[name="quanHuyenDaiLy"]').on("change", function () {
          var target = $(this).children("option:selected");
          target.attr("selected", "");
          $('select[name="quanHuyenDaiLy"] option')
            .not(target)
            .removeAttr("selected");
          address_4 = target.text();
          district2 = $('select[name="quanHuyenDaiLy"]').html();
          localStorage.setItem("district2", district2);
          localStorage.setItem("address_4_saved", address_4);
        });
      }
      $('select[name="tinhThanhDaiLy"]').each(function () {
        var $this = $(this),
          stc = "";
        c.forEach(function (i, e) {
          e += +1;
          stc += "<option value=" + e + ">" + i + "</option>";
          $this.html('<option value="">Tỉnh / Thành phố</option>' + stc);
          if ((address_3 = localStorage.getItem("address_3_saved"))) {
            $('select[name="tinhThanhDaiLy"] option').each(
              function () {
                if ($(this).text() == address_3) {
                  $(this).attr("selected", "");
                }
              }
            );
          }
          $this.on("change", function (i) {
            i = $this.children("option:selected").index() - 1;
            var str = "",
              r = $this.val();
            if (r != "") {
              arr[i].forEach(function (el) {
                str += '<option value="' + el + '">' + el + "</option>";
                $('select[name="quanHuyenDaiLy"]').html(
                  '<option value="">Quận / Huyện</option>' + str
                );
              });
              var address_3 = $this.children("option:selected").text();
              var district2 = $('select[name="quanHuyenDaiLy"]').html();
              localStorage.setItem("address_3_saved", address_3);
              localStorage.setItem("district2", district2);
              $('select[name="quanHuyenDaiLy"]').on(
                "change",
                function () {
                  var target = $(this).children("option:selected");
                  target.attr("selected", "");
                  $('select[name="quanHuyenDaiLy"] option')
                    .not(target)
                    .removeAttr("selected");
                  var address_4 = target.text();
                  district2 = $('select[name="quanHuyenDaiLy"]').html();
                  localStorage.setItem("district2", district2);
                  localStorage.setItem("address_4_saved", address_4);
                }
              );
            } else {
              $('select[name="quanHuyenDaiLy"]').html(
                '<option value="">Quận / Huyện</option>'
              );
              district2 = $('select[name="quanHuyenDaiLy"]').html();
              localStorage.setItem("district2", district2);
              localStorage.removeItem("address_3_saved", address_3);
            }
          });
        });
      });