$(document).ready(function () {
  $("#btnCon").click(function () {
    var mauTKhai = $("#mauTKhai option:selected").val();
    if (!mauTKhai) {
      alert("Bạn chưa chọn tờ khai!");
      return;
    }
    if (mauTKhai == "KKTNCN02") {
      window.location.href = "./thongtintokhai.html";
    }
  });

  $("#btnConThongTinToKhai").click(function () {
    var kyTinhThue = $("#kyTinhThue option:selected").val();
    if (kyTinhThue == "Q") {
      var namQuy = $("#namKeKhaiQuy").val();
      if (!namQuy || namQuy < 2000 || namQuy > 2900) {
        $("#namKeKhaiQuy").focus();
        return;
      }
    }
    if (kyTinhThue == "T") {
      var namThang = $("#namKeKhaiThang").val();
      if (!namThang || namThang < 2000 || namThang > 2900) {
        $("#namKeKhaiQuy").focus();
        return;
      }
    }
    window.location.href = "./khaithue.html";
  });

  $("#namKeKhaiQuy").on("input", function () {
    var namQuy = $("#namKeKhaiQuy").val();
    if (!namQuy) {
      $("#loiNamQuy").text("* Năm không để trống");
      $("#loiNamQuy").show();
      return;
    }
    if (namQuy < 2000 || namQuy > 2900) {
      $("#loiNamQuy").text("* Năm ngoài phạm vi");
      $("#loiNamQuy").show();
      return;
    }
    $("#loiNamQuy").hide();
  });

  $("#namKeKhaiThang").on("input", function () {
    var namThang = $("#namKeKhaiThang").val();
    if (!namThang) {
      $("#loiNamThang").text("* Năm không để trống");
      $("#loiNamThang").show();
      return;
    }
    if (namQuy < 2000 || namQuy > 2900) {
      $("#loiNamThang").text("* Năm ngoài phạm vi");
      $("#loiNamThang").show();
      return;
    }
    $("#loiNamThang").hide();
  });

  $("#kyTinhThue").change(function () {
    var kyTinhThue = $("#kyTinhThue option:selected").val();
    if (kyTinhThue == "T") {
      $("#quy").hide();
      $("#thang").show();
    }
    if (kyTinhThue == "Q") {
      $("#thang").hide();
      $("#quy").show();
    }
  });

  $("#coCuTru").click(function (e) {
    var checkbox = $(this);
    if (!checkbox.is(":checked")) {
      e.preventDefault();
      return;
    }
    $("#khongCuTru").prop("checked", false);
    $("#thuNhapTinhThueKCT").prop("disabled", true);
    $("#mucThueSuat").prop("disabled", true);

    $("#thuNhapTinhThueKCT").val(0);
    $("#mucThueSuat").val(0);
    $("#loiThuNhapKCT").hide();
    $("#loiThueSuat").hide();

    $("#thuNhapChiuThue").prop("disabled", false);
    $("#thuNhapChiuThueMienGiam").prop("disabled", false);
    $("#giamTruBanThan").prop("disabled", false);
    $("#giamTruNguoiPhuThuoc").prop("disabled", false);
    $("#giamTruTuThien").prop("disabled", false);
    $("#giamTruBaoHiem").prop("disabled", false);
    $("#giamTruHuuTri").prop("disabled", false);
  });

  $("#khongCuTru").click(function (e) {
    var checkbox = $(this);
    if (!checkbox.is(":checked")) {
      e.preventDefault();
      return false;
    }
    $("#coCuTru").prop("checked", false);
    $("#thuNhapTinhThueKCT").prop("disabled", false);
    $("#mucThueSuat").prop("disabled", false);

    $("#thuNhapChiuThue").val(0);
    $("#thuNhapChiuThueMienGiam").val(0);
    $("#giamTruBanThan").val(0);
    $("#giamTruNguoiPhuThuoc").val(0);
    $("#giamTruTuThien").val(0);
    $("#giamTruBaoHiem").val(0);
    $("#giamTruHuuTri").val(0);

    $("#loiThuNhap").hide();
    $("#loiMienGiam").hide();
    $("#loiGiamTruBanThan").hide();
    $("#loiGiamTruNPT").hide();
    $("#loiGiamTruTuThien").hide();
    $("#loiGiamTruBaoHiem").hide();
    $("#loiGiamTruHuuTri").hide();

    $("#thuNhapChiuThue").prop("disabled", true);
    $("#thuNhapChiuThueMienGiam").prop("disabled", true);
    $("#giamTruBanThan").prop("disabled", true);
    $("#giamTruNguoiPhuThuoc").prop("disabled", true);
    $("#giamTruTuThien").prop("disabled", true);
    $("#giamTruBaoHiem").prop("disabled", true);
    $("#giamTruHuuTri").prop("disabled", true);
  });

  $("#thuNhapChiuThue").on("input", function () {
    var v = $("#thuNhapChiuThue").val();
    if (!v) {
      $("#loiThuNhap").text("* Không được để trống");
      $("#loiThuNhap").show();
      return;
    }
    if (v < 0) {
      $("#loiThuNhap").text("* Giá trị không nhỏ hơn 0");
      $("#loiThuNhap").show();
      return;
    }
    $("#loiThuNhap").hide();
  });

  $("#thuNhapChiuThueMienGiam").on("input", function () {
    var v = $("#thuNhapChiuThueMienGiam").val();
    if (!v) {
      $("#loiMienGiam").text("* Không được để trống");
      $("#loiMienGiam").show();
      return;
    }
    if (v < 0) {
      $("#loiMienGiam").text("* Giá trị không nhỏ hơn 0");
      $("#loiMienGiam").show();
      return;
    }
    $("#loiMienGiam").hide();
  });

  $("#giamTruBanThan").on("input", function () {
    var v = $("#giamTruBanThan").val();
    if (!v) {
      $("#loiGiamTruBanThan").text("* Không được để trống");
      $("#loiGiamTruBanThan").show();
      return;
    }
    if (v < 0) {
      $("#loiGiamTruBanThan").text("* Giá trị không nhỏ hơn 0");
      $("#loiGiamTruBanThan").show();
      return;
    }
    $("#loiGiamTruBanThan").hide();
  });

  $("#giamTruNguoiPhuThuoc").on("input", function () {
    var v = $("#giamTruNguoiPhuThuoc").val();
    if (!v) {
      $("#loiGiamTruNPT").text("* Không được để trống");
      $("#loiGiamTruNPT").show();
      return;
    }
    if (v < 0) {
      $("#loiGiamTruNPT").text("* Giá trị không nhỏ hơn 0");
      $("#loiGiamTruNPT").show();
      return;
    }
    $("#loiGiamTruNPT").hide();
  });

  $("#giamTruTuThien").on("input", function () {
    var v = $("#giamTruTuThien").val();
    if (!v) {
      $("#loiGiamTruTuThien").text("* Không được để trống");
      $("#loiGiamTruTuThien").show();
      return;
    }
    if (v < 0) {
      $("#loiGiamTruTuThien").text("* Giá trị không nhỏ hơn 0");
      $("#loiGiamTruTuThien").show();
      return;
    }
    $("#loiGiamTruTuThien").hide();
  });

  $("#giamTruBaoHiem").on("input", function () {
    var v = $("#giamTruBaoHiem").val();
    if (!v) {
      $("#loiGiamTruBaoHiem").text("* Không được để trống");
      $("#loiGiamTruBaoHiem").show();
      return;
    }
    if (v < 0) {
      $("#loiGiamTruBaoHiem").text("* Giá trị không nhỏ hơn 0");
      $("#loiGiamTruBaoHiem").show();
      return;
    }
    $("#loiGiamTruBaoHiem").hide();
  });

  $("#giamTruHuuTri").on("input", function () {
    var v = $("#giamTruHuuTri").val();
    if (!v) {
      $("#loiGiamTruHuuTri").text("* Không được để trống");
      $("#loiGiamTruHuuTri").show();
      return;
    }
    if (v < 0) {
      $("#loiGiamTruHuuTri").text("* Giá trị không nhỏ hơn 0");
      $("#loiGiamTruHuuTri").show();
      return;
    }
    $("#loiGiamTruHuuTri").hide();
  });

  $("#thuNhapTinhThueKCT").on("input", function () {
    var v = $("#thuNhapTinhThueKCT").val();
    if (!v) {
      $("#loiThuNhapKCT").text("* Không được để trống");
      $("#loiThuNhapKCT").show();
      return;
    }
    if (v < 0) {
      $("#loiThuNhapKCT").text("* Giá trị không nhỏ hơn 0");
      $("#loiThuNhapKCT").show();
      return;
    }
    $("#loiThuNhapKCT").hide();
  });

  $("#mucThueSuat").on("input", function () {
    var v = $("#mucThueSuat").val();
    if (!v) {
      $("#loiThueSuat").text("* Không được để trống");
      $("#loiThueSuat").show();
      return;
    }
    if (v < 0) {
      $("#loiThueSuat").text("* Giá trị không nhỏ hơn 0");
      $("#loiThueSuat").show();
      return;
    }
    $("#loiThueSuat").hide();
  });

  $("#btnNopToKhai").click(function () {
    if ($("#coCuTru").is(":checked")) {
      var v = $("#thuNhapChiuThue").val();
      if (!v || v < 0) {
        $("#thuNhapChiuThue").focus();
        return;
      }

      var v = $("#thuNhapChiuThueMienGiam").val();
      if (!v || v < 0) {
        $("#thuNhapChiuThueMienGiam").focus();
        return;
      }

      var v = $("#giamTruBanThan").val();
      if (!v || v < 0) {
        $("#giamTruBanThan").focus();
        return;
      }

      var v = $("#giamTruNguoiPhuThuoc").val();
      if (!v || v < 0) {
        $("#giamTruNguoiPhuThuoc").focus();
        return;
      }

      var v = $("#giamTruTuThien").val();
      if (!v || v < 0) {
        $("#giamTruTuThien").focus();
        return;
      }

      var v = $("#giamTruBaoHiem").val();
      if (!v || v < 0) {
        $("#giamTruBaoHiem").focus();
        return;
      }

      var v = $("#giamTruHuuTri").val();
      if (!v || v < 0) {
        $("#giamTruHuuTri").focus();
        return;
      }
    }

    if ($("#khongCuTru").is(":checked")) {
      var v = $("#thuNhapTinhThueKCT").val();
      if (!v || v < 0) {
        $("#thuNhapTinhThueKCT").focus();
        return;
      }

      var v = $("#mucThueSuat").val();
      if (!v || v < 0) {
        $("#mucThueSuat").focus();
        return;
      }
    }
  });

  $(".tab").click(function () {
    $(".tab").removeClass("current");
    $(this).addClass("current");
  });
});
