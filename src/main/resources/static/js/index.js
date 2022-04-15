$(document).ready(function() {
    $("#btnCon").click(function() {
        var mauTKhai = $("#mauTKhai option:selected").val();
        if (!mauTKhai) {
            alert("Bạn chưa chọn tờ khai!");
            return;
        }
        if (mauTKhai == "KKTNCN02") {
            window.location.href = "/khai-thue/to-khai";
        }
    });

    $("#namKeKhai").on("input", function() {
        var nam = $("#namKeKhai").val();
        if (!nam) {
            $("#loiNamThang").text("* Năm không để trống");
            $("#loiNamThang").show();
            return;
        }
        if (nam < 2000 || nam > 2900) {
            $("#loiNamThang").text("* Năm ngoài phạm vi");
            $("#loiNamThang").show();
            return;
        }
        $("#loiNamThang").hide();
    });

    $("#daiLyThue").click(function(e) {
        var checkbox = $(this);
        if (!checkbox.is(":checked")) {
            $("#tenDaiLy").prop("disabled", true);
            $("#maSoThueDaiLy").prop("disabled", true);
            $("#diaChiDaiLy").prop("disabled", true);
            $("#tinhThanhDaiLy").prop("disabled", true);
            $("#quanHuyenDaiLy").prop("disabled", true);
            $("#dienThoaiDaiLy").prop("disabled", true);
            $("#faxDaiLy").prop("disabled", true);
            $("#emailDaiLy").prop("disabled", true);
            $("#soHopDong").prop("disabled", true);
            $("#ngayHopDong").prop("disabled", true);
        } else {
            $("#tenDaiLy").prop("disabled", false);
            $("#maSoThueDaiLy").prop("disabled", false);
            $("#diaChiDaiLy").prop("disabled", false);
            $("#tinhThanhDaiLy").prop("disabled", false);
            $("#quanHuyenDaiLy").prop("disabled", false);
            $("#dienThoaiDaiLy").prop("disabled", false);
            $("#faxDaiLy").prop("disabled", false);
            $("#emailDaiLy").prop("disabled", false);
            $("#soHopDong").prop("disabled", false);
            $("#ngayHopDong").prop("disabled", false);
        }
    });

	$("#hoTen").change(function() {
		var hoTen = $("#hoTen").val();
		if(!hoTen) {
			$("#loiTenNguoiNopThue").text("*Họ tên không để trống");
            $("#loiTenNguoiNopThue").show();
            return;
		}
		$("#loiTenNguoiNopThue").hide();
	});
	
	$("#maSoThue").change(function() {
		var maSoThue = $("#maSoThue").val();
		if(!maSoThue) {
			$("#loiMaSoThue").text("*Mã số thuế không để trống");
            $("#loiMaSoThue").show();
            return;
		}
		if(!/^\d+$/.test(maSoThue)) {
			$("#loiMaSoThue").text("*Mã số thuế phải là số");
            $("#loiMaSoThue").show();
            return;
		}
		$("#loiMaSoThue").hide();
	});
	
	$("#diaChi").change(function() {
		var diaChi = $("#diaChi").val();
		if(!diaChi) {
			$("#loiDiaChi").text("*Địa chỉ không để trống");
            $("#loiDiaChi").show();
            return;
		}
		$("#loiDiaChi").hide();
	});
	
	$("#tinhThanh").change(function() {
		var tinhThanh = $("#tinhThanh").val();
		if(!tinhThanh) {
			$("#loiTinhThanh").text("*Hãy lựa chọn Tỉnh/Thành phố");
            $("#loiTinhThanh").show();
            return;
		}
		$("#loiTenNguoiNopThue").hide();
	});
	
	$("#quanHuyen").change(function() {
		var quanHuyen = $("#quanHuyen").val();
		if(!quanHuyen) {
			$("#loiQuanHuyen").text("*Hãy lựa chọn Quận/Huyện");
            $("#loiQuanHuyen").show();
            return;
		}
		$("#loiQuanHuyen").hide();
	});
	
	$("#tenDaiLyThue").change(function() {
		var hoTen = $("#tenDaiLyThue").val();
		if(!hoTen) {
			$("#loiTenDLT").text("*Tên đại lý thuế không để trống");
            $("#loiTenDLT").show();
            return;
		}
		$("#loiTenDLT").hide();
	});
	
	$("#maSoThueDLT").change(function() {
		var maSoThueDLT = $("#maSoThueDLT").val();
		if(!maSoThueDLT) {
			$("#loiMstDLT").text("*Mã số thuế không để trống");
            $("#loiMstDLT").show();
            return;
		}
		if(!/^\d+$/.test(maSoThueDLT)) {
			$("#loiMstDLT").text("*Mã số thuế phải là số");
            $("#loiMstDLT").show();
            return;
		}
		$("#loiMstDLT").hide();
	});
	
	$("#diaChiDaiLy").change(function() {
		var diaChi = $("#diaChiDaiLy").val();
		if(!diaChi) {
			$("#loiDiaChiDLT").text("*Địa chỉ không để trống");
            $("#loiDiaChiDLT").show();
            return;
		}
		$("#loiDiaChi").hide();
	});
	
	$("#tinhThanhDaiLy").change(function() {
		var tinhThanh = $("#tinhThanhDaiLy").val();
		if(!tinhThanh) {
			$("#loiTinhThanhDLT").text("*Hãy lựa chọn Tỉnh/Thành phố");
            $("#loiTinhThanhDLT").show();
            return;
		}
		$("#loiTinhThanhDLT").hide();
	});
	
	$("#quanHuyenDaiLy").change(function() {
		var quanHuyen = $("#quanHuyenDaiLy").val();
		if(!quanHuyen) {
			$("#loiQuanHuyenDLT").text("*Hãy lựa chọn Quận/Huyện");
            $("#loiQuanHuyenDLT").show();
            return;
		}
		$("#loiQuanHuyenDLT").hide();
	});
	
	$("#soHopDong").change(function() {
		var soHopDong = $("#soHopDong").val();
		if(!soHopDong) {
			$("#loiSoHopDong").text("*Số hợp đồng không để trống");
            $("#loiSoHopDong").show();
            return;
		}
		$("#loiSoHopDong").hide();
	});

	$("#ngayHopDong").change(function() {
		var ngayHopDong = $("#ngayHopDong").val();
		if(!ngayHopDong) {
			$("#loiNgayHopDong").text("*Ngày hợp đồng không để trống");
            $("#loiNgayHopDong").show();
            return;
		}
		$("#loiNgayHopDong").hide();
	});

    $("#kyTinhThue").change(function() {
        var kyTinhThue = $("#kyTinhThue option:selected").val();
        if (kyTinhThue == "Tháng") {
            $("#quy").hide();
            $("#thang").show();
        }
        if (kyTinhThue == "Quý") {
            $("#thang").hide();
            $("#quy").show();
        }
        localStorage.setItem("kyTinhThue", kyTinhThue);
    });

    /*$("#btnConThongTinToKhai").click(function() {
        var kyTinhThue = $("#kyTinhThue option:selected").val();
       	var nam = $("#namKeKhai").val();
        if (!nam || nam < 2000 || nam > 2900) {
            $("#namKeKhai").focus();
            return;
        }
        localStorage.setItem("kyTinhThue", kyTinhThue);
        window.location.href = "/khai-thue/tinh-thue";
    }); */

    $("#coCuTru").click(function(e) {
        var checkbox = $(this);
        if (!checkbox.is(":checked")) {
            e.preventDefault();
            return;
        }
		$("#coCuTru").attr( "checked", true );
		$("#khongCuTru").prop("checked", false);
        $("#khongCuTru").removeAttr( "checked" );
        
        $("#thuNhapTinhThueKCT").prop("disabled", true);

        $("#thueThuNhapCaNhanKCT").val(0);
        $("#thuNhapTinhThueKCT").val(0);
        $("#loiThuNhapKCT").hide();
        $("#loiThueSuat").hide();

        $("#thuNhapChiuThue").prop("disabled", false);
        $("#thuNhapChiuThueMienGiam").prop("disabled", false);
        $("#giamTruNguoiPhuThuoc").prop("disabled", false);
        $("#giamTruTuThien").prop("disabled", false);
        $("#giamTruBaoHiem").prop("disabled", false);
        $("#giamTruHuuTri").prop("disabled", false);
    });

    $("#khongCuTru").click(function(e) {
        var checkbox = $(this);
        if (!checkbox.is(":checked")) {
            e.preventDefault();
            return false;
        }
        
        $("#khongCuTru").attr( "checked", true );
        $("#coCuTru").prop("checked", false);
        $("#coCuTru").removeAttr( "checked" );
        
        $("#thuNhapTinhThueKCT").prop("disabled", false);

        $("#thuNhapChiuThue").val(0);
        $("#thuNhapChiuThueMienGiam").val(0);
        var kyTinhThue = localStorage.getItem("kyTinhThue");
        if (kyTinhThue == "Tháng") {
            $("#giamTruBanThan").val(11000000);
            $("#tongGiamTru").val(11000000);
        } else {
            $("#giamTruBanThan").val(33000000);
            $("#tongGiamTru").val(33000000);
        }
        $("#giamTruNguoiPhuThuoc").val(0);
        $("#giamTruTuThien").val(0);
        $("#giamTruBaoHiem").val(0);
        $("#giamTruHuuTri").val(0);
        $("#thuNhapTinhThue").val(0);
        $("#thueThuNhapCaNhan").val(0);

        $("#loiThuNhap").hide();
        $("#loiMienGiam").hide();
        $("#loiGiamTruBanThan").hide();
        $("#loiGiamTruNPT").hide();
        $("#loiGiamTruTuThien").hide();
        $("#loiGiamTruBaoHiem").hide();
        $("#loiGiamTruHuuTri").hide();

        $("#thuNhapChiuThue").prop("disabled", true);
        $("#thuNhapChiuThueMienGiam").prop("disabled", true);
        $("#giamTruNguoiPhuThuoc").prop("disabled", true);
        $("#giamTruTuThien").prop("disabled", true);
        $("#giamTruBaoHiem").prop("disabled", true);
        $("#giamTruHuuTri").prop("disabled", true);
    });

    $("#thuNhapChiuThue").on("input", function() {
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

    $("#thuNhapChiuThueMienGiam").on("input", function() {
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


    $("#giamTruNguoiPhuThuoc").on("input", function() {
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
        var kyTinhThue = localStorage.getItem("kyTinhThue");
        if (kyTinhThue == "Tháng") {
            if (v % 4400000 !== 0) {
                $("#loiGiamTruNPT").text("* Mỗi người phụ thuộc giảm 4.400.000đ");
                $("#loiGiamTruNPT").show();
                return;
            }
        } else {
            if (v % 13200000 !== 0) {
                $("#loiGiamTruNPT").text("* Mỗi người phụ thuộc giảm 13.200.000đ");
                $("#loiGiamTruNPT").show();
                return;
            }
        }
        $("#loiGiamTruNPT").hide();
    });

    $("#giamTruTuThien").on("input", function() {
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

    $("#giamTruBaoHiem").on("input", function() {
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

    $("#giamTruHuuTri").on("input", function() {
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

    $("#thuNhapTinhThueKCT").on("input", function() {
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


    $("#btnNopToKhai").click(function() {
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

            var v = $("#giamTruNguoiPhuThuoc").val();
            var kyTinhThue = localStorage.getItem("kyTinhThue");
            if (kyTinhThue == "Tháng") {
                if (!v || v < 0 || v % 4400000 !== 0) {
                    $("#giamTruNguoiPhuThuoc").focus();
                    return;
                }
            } else {
                if (!v || v < 0 || v % 13200000 != 0) {
                    $("#giamTruNguoiPhuThuoc").focus();
                    return;
                }
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
            if (!v || v < 0 || v > 100) {
                $("#mucThueSuat").focus();
                return;
            }
        }
    });
});
// tinh thue
function tinhThue() {
    var kyTinhThue = localStorage.getItem("kyTinhThue");
    if ($("#coCuTru").is(":checked")) {
        var thuNhapChiuThue = $("#thuNhapChiuThue").val();
        if (!thuNhapChiuThue || thuNhapChiuThue < 0) {
            thuNhapChiuThue = 0;
            $("#thuNhapChiuThue").val(thuNhapChiuThue);
            $("#loiThuNhap").hide();
        }

        var mienGiam = $("#thuNhapChiuThueMienGiam").val();
        if (!mienGiam || mienGiam < 0) {
            mienGiam = 0;
            $("#thuNhapChiuThueMienGiam").val(mienGiam);
            $("#loiMienGiam").hide();
        }

        var banThan = $("#giamTruBanThan").val();

        var nguoiPhuThuoc = $("#giamTruNguoiPhuThuoc").val();
        if (kyTinhThue == "Tháng") {
            if (!nguoiPhuThuoc || nguoiPhuThuoc < 0 || nguoiPhuThuoc % 4400000 !== 0) {
                nguoiPhuThuoc = 0;
                $("#giamTruNguoiPhuThuoc").val(nguoiPhuThuoc);
                $("#loiGiamTruNPT").hide();
            }
        } else {
            if (!nguoiPhuThuoc || nguoiPhuThuoc < 0 || nguoiPhuThuoc % 13200000 !== 0) {
                nguoiPhuThuoc = 0;
                $("#giamTruNguoiPhuThuoc").val(nguoiPhuThuoc);
                $("#loiGiamTruNPT").hide();
            }
        }

        var tuThien = $("#giamTruTuThien").val();
        if (!tuThien || tuThien < 0) {
            tuThien = 0;
            $("#giamTruTuThien").val(tuThien);
            $("#loiGiamTruTuThien").hide();
        }

        var baoHiem = $("#giamTruBaoHiem").val();
        if (!baoHiem || baoHiem < 0) {
            baoHiem = 0;
            $("#giamTruBaoHiem").val(baoHiem);
            $("#loiGiamTruBaoHiem").hide();
        }

        var huuTri = $("#giamTruHuuTri").val();
        if (!huuTri || huuTri < 0) {
            huuTri = 0;
            $("#giamTruHuuTri").val(huuTri);
            $("#loiGiamTruHuuTri").hide();
        }
        var tongGiamTru = Number(banThan) + Number(nguoiPhuThuoc) + Number(tuThien) + Number(baoHiem) + Number(huuTri);
        $("#tongGiamTru").val(tongGiamTru);
        var thuNhapTinhThue = Number(thuNhapChiuThue) - Number(mienGiam) - Number(tongGiamTru);
        if (thuNhapTinhThue <= 0) {
            $("#thuNhapTinhThue").val(0);
            $("#thueThuNhapCaNhan").val(0);
        } else {
            if (kyTinhThue == "Tháng") {
                $("#thuNhapTinhThue").val(thuNhapTinhThue);
                var thueThuNhapCaNhan;
                if (thuNhapTinhThue <= 5000000)
                    thueThuNhapCaNhan = (thuNhapTinhThue * 5 / 100).toFixed(0);
                else if (thuNhapTinhThue <= 10000000)
                    thueThuNhapCaNhan = (thuNhapTinhThue * 10 / 100 - 250000).toFixed(0);
                else if (thuNhapTinhThue <= 18000000)
                    thueThuNhapCaNhan = (thuNhapTinhThue * 15 / 100 - 750000).toFixed(0);
                else if (thuNhapTinhThue <= 32000000)
                    thueThuNhapCaNhan = (thuNhapTinhThue * 20 / 100 - 1650000).toFixed(0);
                else if (thuNhapTinhThue <= 52000000)
                    thueThuNhapCaNhan = (thuNhapTinhThue * 25 / 100 - 3250000).toFixed(0);
                else if (thuNhapTinhThue <= 80000000)
                    thueThuNhapCaNhan = (thuNhapTinhThue * 30 / 100 - 5850000).toFixed(0);
                else
                    thueThuNhapCaNhan = (thuNhapTinhThue * 35 / 100 - 9850000).toFixed(0);

                $("#thueThuNhapCaNhan").val(thueThuNhapCaNhan);
            } else {
                $("#thuNhapTinhThue").val(thuNhapTinhThue);
                var thueThuNhapCaNhan;
                if (thuNhapTinhThue <= 15000000)
                    thueThuNhapCaNhan = (thuNhapTinhThue * 5 / 100).toFixed(0);
                else if (thuNhapTinhThue <= 30000000)
                    thueThuNhapCaNhan = (thuNhapTinhThue * 10 / 100 - 250000 * 3).toFixed(0);
                else if (thuNhapTinhThue <= 54000000)
                    thueThuNhapCaNhan = (thuNhapTinhThue * 15 / 100 - 750000 * 3).toFixed(0);
                else if (thuNhapTinhThue <= 96000000)
                    thueThuNhapCaNhan = (thuNhapTinhThue * 20 / 100 - 1650000 * 3).toFixed(0);
                else if (thuNhapTinhThue <= 156000000)
                    thueThuNhapCaNhan = (thuNhapTinhThue * 25 / 100 - 3250000 * 3).toFixed(0);
                else if (thuNhapTinhThue <= 240000000)
                    thueThuNhapCaNhan = (thuNhapTinhThue * 30 / 100 - 5850000 * 3).toFixed(0);
                else
                    thueThuNhapCaNhan = (thuNhapTinhThue * 35 / 100 - 9850000 * 3).toFixed(0);

                $("#thueThuNhapCaNhan").val(thueThuNhapCaNhan);
            }
        }


    }


    if ($("#khongCuTru").is(":checked")) {
        var thuNhapTinhThue = $("#thuNhapTinhThueKCT").val();
        if (!thuNhapTinhThue || thuNhapTinhThue < 0) {
            thuNhapTinhThue = 0;
            $("#thuNhapTinhThueKCT").val(0);
            $("#loiThuNhapKCT").hide();
        }
        var thue = (thuNhapTinhThue * 20 / 100).toFixed(0);
        $("#thueThuNhapCaNhanKCT").val(thue);
    }
}


// district
window.onload = function() {
	var kyTinhThue = $("#kyTinhThue option:selected").val();
    localStorage.setItem("kyTinhThue", kyTinhThue);
    
    if ((address_2 = localStorage.getItem("address_2_saved"))) {
        $('select[name="quanHuyen"] option').each(function() {
            if ($(this).text() == address_2) {
                $(this).attr("selected", "");
            }
        });
    }
    if ((district = localStorage.getItem("district"))) {
        $('select[name="quanHuyen"]').html(district);
        $('select[name="quanHuyen"]').on("change", function() {
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
    $('select[name="tinhThanh"]').each(function() {
        var $this = $(this),
            stc = "";
        c.forEach(function(i, e) {
            e += +1;
            stc += '<option value="' + i + '">' + i + '</option>';
            $this.html('<option value="">Tỉnh / Thành phố</option>' + stc);
            if ((address_1 = localStorage.getItem("address_1_saved"))) {
                $('select[name="tinhThanh"] option').each(
                    function() {
                        if ($(this).text() == address_1) {
                            $(this).attr("selected", "");
                        }
                    }
                );
            }
            $this.on("change", function(i) {
                i = $this.children("option:selected").index() - 1;
                var str = "",
                    r = $this.val();
                if (r != "") {
                    arr[i].forEach(function(el) {
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
                        function() {
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
        $('select[name="quanHuyenDLT"] option').each(function() {
            if ($(this).text() == address_4) {
                $(this).attr("selected", "");
            }
        });
    }
    if ((district2 = localStorage.getItem("district2"))) {
        $('select[name="quanHuyenDLT"]').html(district2);
        $('select[name="quanHuyenDLT"]').on("change", function() {
            var target = $(this).children("option:selected");
            target.attr("selected", "");
            $('select[name="quanHuyenDLT"] option')
                .not(target)
                .removeAttr("selected");
            address_4 = target.text();
            district2 = $('select[name="quanHuyenDLT"]').html();
            localStorage.setItem("district2", district2);
            localStorage.setItem("address_4_saved", address_4);
        });
    }
    $('select[name="tinhThanhDLT"]').each(function() {
        var $this = $(this),
            stc = "";
        c.forEach(function(i, e) {
            e += +1;
            stc += "<option value=" + i + ">" + i + "</option>";
            $this.html('<option value="">Tỉnh / Thành phố</option>' + stc);
            if ((address_3 = localStorage.getItem("address_3_saved"))) {
                $('select[name="tinhThanhDLT"] option').each(
                    function() {
                        if ($(this).text() == address_3) {
                            $(this).attr("selected", "");
                        }
                    }
                );
            }
            $this.on("change", function(i) {
                i = $this.children("option:selected").index() - 1;
                var str = "",
                    r = $this.val();
                if (r != "") {
                    arr[i].forEach(function(el) {
                        str += '<option value="' + el + '">' + el + "</option>";
                        $('select[name="quanHuyenDLT"]').html(
                            '<option value="">Quận / Huyện</option>' + str
                        );
                    });
                    var address_3 = $this.children("option:selected").text();
                    var district2 = $('select[name="quanHuyenDLT"]').html();
                    localStorage.setItem("address_3_saved", address_3);
                    localStorage.setItem("district2", district2);
                    $('select[name="quanHuyenDaiLy"]').on(
                        "change",
                        function() {
                            var target = $(this).children("option:selected");
                            target.attr("selected", "");
                            $('select[name="quanHuyenDLT"] option')
                                .not(target)
                                .removeAttr("selected");
                            var address_4 = target.text();
                            district2 = $('select[name="quanHuyenDLT"]').html();
                            localStorage.setItem("district2", district2);
                            localStorage.setItem("address_4_saved", address_4);
                        }
                    );
                } else {
                    $('select[name="quanHuyenDLT"]').html(
                        '<option value="">Quận / Huyện</option>'
                    );
                    district2 = $('select[name="quanHuyenDLT"]').html();
                    localStorage.setItem("district2", district2);
                    localStorage.removeItem("address_3_saved", address_3);
                }
            });
        });
    });
}

function loadTinhThue() {
   	var kyTinhThue = localStorage.getItem("kyTinhThue");
    if (kyTinhThue == "Tháng") {
        $("#giamTruBanThan").val(11000000);
        $("#tongGiamTru").val(11000000);
    } else {
        $("#giamTruBanThan").val(33000000);
        $("#tongGiamTru").val(33000000);
    }
}

function validateToKhaiForm() {
   	var nam = $("#namKeKhai").val();
    if (!nam || nam < 2000 || nam > 2900) {
        $("#namKeKhai").focus();
        return false;
    }
    
    var hoTen = $("#hoTen").val();
    if (!hoTen) {
        $("#hoTen").focus();
        $("#loiTenNguoiNopThue").text("*Họ tên không để trống");
        $("#loiTenNguoiNopThue").show();
        return false;
    }
    
    var maSoThue = $("#maSoThue").val();
    if (!maSoThue) {
        $("#maSoThue").focus();
        $("#loiMaSoThue").text("*Mã số thuế không để trống");
        $("#loiMaSoThue").show();
        return false;
    }
	if(!/^\d+$/.test(maSoThue)) {
		$("#loiMaSoThue").text("*Mã số thuế phải là số");
        $("#loiMaSoThue").show();
        return false;
	}
    
    var diaChi = $("#diaChi").val();
    if (!diaChi) {
        $("#diaChi").focus();
        $("#loiDiaChi").text("*Địa chỉ không để trống");
        $("#loiDiaChi").show();
        return false;
    }
    
    var tinhThanh = $("#tinhThanh option:selected").val();
    if (!tinhThanh) {
        $("#tinhThanh").focus();
        $("#loiTinhThanh").text("*Hãy lựa chọn Tỉnh/Thành phố");
        $("#loiTinhThanh").show();
        return false;
    }
    
    var quanHuyen = $("#quanHuyen").val();
    if (!quanHuyen) {
        $("#quanHuyen").focus();
        $("#loiQuanHuyen").text("*Hãy lựa chọn Quận/Huyện");
        $("#loiQuanHuyen").show();
        return false;
    }
    
    var daiLyThue = $("#daiLyThue").prop( "checked" );
    if (daiLyThue) {
        var tenDaiLyThue = $("#tenDaiLy").val();
	    if (!tenDaiLyThue) {
	        $("#tenDaiLy").focus();
	        $("#loiTenDLT").text("*Tên đại lý thuế không để trống");
            $("#loiTenDLT").show();
	        return false;
	    }
	    
	    var maSoThueDLT = $("#maSoThueDaiLy").val();
	    if (!maSoThueDLT) {
	        $("#maSoThueDaiLy").focus();
	        $("#loiMstDLT").text("*Mã số thuế không để trống");
            $("#loiMstDLT").show();
	        return false;
	    }
		if(!/^\d+$/.test(maSoThueDLT)) {
			$("#loiMstDLT").text("*Mã số thuế phải là số");
            $("#loiMstDLT").show();
            return false;
		}
	    
	    var diaChiDLT = $("#diaChiDaiLy").val();
	    if (!diaChiDLT) {
	        $("#diaChiDaiLy").focus();
	        $("#loiDiaChiDLT").text("*Địa chỉ không để trống");
            $("#loiDiaChiDLT").show();
	        return false;
	    }
	    
	    var tinhThanhDaiLy = $("#tinhThanhDaiLy option:selected").val();
	    if (!tinhThanhDaiLy) {
	        $("#tinhThanhDaiLy").focus();
	        $("#loiTinhThanhDLT").text("*Hãy lựa chọn Tỉnh/Thành phố");
            $("#loiTinhThanhDLT").show();
	        return false;
	    }
	    
	    var quanHuyenDaiLy = $("#quanHuyenDaiLy option:selected").val();
	    if (!quanHuyenDaiLy) {
	        $("#quanHuyenDaiLy").focus();
	        $("#loiQuanHuyenDLT").text("*Hãy lựa chọn Quận/Huyện");
            $("#loiQuanHuyenDLT").show();
	        return false;
	    }
	    
	    var soHopDong = $("#soHopDong").val();
		if(!soHopDong) {
			$("#loiSoHopDong").focus();
			$("#loiSoHopDong").text("*Số hợp đồng không để trống");
            $("#loiSoHopDong").show();
            return false;
		}
		
		var ngayHopDong = $("#ngayHopDong").val();
		if(!ngayHopDong) {
			$("#ngayHopDong").focus();
			$("#loiNgayHopDong").text("*Ngày hợp đồng không để trống");
            $("#loiNgayHopDong").show();
            return flase;
		}
    }
    
    return true;
}

function validateTinhThueForm() {
	var cuTru = $("#coCuTru").prop( "checked" );
	console.log(cuTru)
	if(cuTru) {
		var thuNhapChiuThue = $("#thuNhapChiuThue").val();
	    if (thuNhapChiuThue <= 0) {
	        $("#tenDaiLy").focus();
	        $("#loiThuNhap").text("*Thu nhập phải lớn hơn 0");
	        $("#loiThuNhap").show();
	        return false;
	    }
	} else {
		var thuNhapTinhThue = $("#thuNhapTinhThueKCT").val();
	    if (thuNhapTinhThue <= 0) {
	        $("#thuNhapTinhThueKCT").focus();
	        $("#loiThuNhapKCT").text("*Thu nhập phải lớn hơn 0");
	        $("#loiThuNhapKCT").show();
	        return false;
	    }
	}
	
   	return true;
}