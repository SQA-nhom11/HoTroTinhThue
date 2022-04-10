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

    $("#namKeKhaiQuy").on("input", function() {
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

    $("#namKeKhaiThang").on("input", function() {
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
        }
        else{
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
    
    
    

    $("#kyTinhThue").change(function() {
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
    
    $("#btnConThongTinToKhai").click(function() {
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
        localStorage.setItem("kyTinhThue", kyTinhThue);
        window.location.href = "/khai-thue/dien-to-khai";
    });

    $("#coCuTru").click(function(e) {
        var checkbox = $(this);
        if (!checkbox.is(":checked")) {
            e.preventDefault();
            return;
        }
        
        $("#khongCuTru").prop("checked", false);
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
        $("#coCuTru").prop("checked", false);
        $("#thuNhapTinhThueKCT").prop("disabled", false);

        $("#thuNhapChiuThue").val(0);
        $("#thuNhapChiuThueMienGiam").val(0);
        var kyTinhThue = localStorage.getItem("kyTinhThue");
        if(kyTinhThue == "T"){
            $("#giamTruBanThan").val(11000000);
            $("#tongGiamTru").val(11000000);
        }
        else{
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
        if(kyTinhThue == "T"){
            if(v%4400000 !== 0){
                $("#loiGiamTruNPT").text("* Mỗi người phụ thuộc giảm 4.400.000đ");
                $("#loiGiamTruNPT").show();
                return;
            }
        }
        else{
            if(v%13200000 !== 0){
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
            if (kyTinhThue == "T"){
                if (!v || v < 0 || v%4400000 !== 0) {
                    $("#giamTruNguoiPhuThuoc").focus();
                    return;
                }
            }else{
                if (!v || v < 0 || v%13200000 != 0) {
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

function tinhThue(){
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
                if(kyTinhThue == "T"){
                    if (!nguoiPhuThuoc || nguoiPhuThuoc < 0 || nguoiPhuThuoc%4400000 !==0) {
                        nguoiPhuThuoc = 0;
                        $("#giamTruNguoiPhuThuoc").val(nguoiPhuThuoc);
                        $("#loiGiamTruNPT").hide();
                    }
                }else{
                    if (!nguoiPhuThuoc || nguoiPhuThuoc < 0 || nguoiPhuThuoc%13200000 !==0) {
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
                var thuNhapTinhThue = Number(thuNhapChiuThue)-Number(mienGiam) - Number(tongGiamTru);
                if (thuNhapTinhThue <=0){
                    $("#thuNhapTinhThue").val(0);
                    $("#thueThuNhapCaNhan").val(0);
                }else{
                    if(kyTinhThue == "T"){
                        $("#thuNhapTinhThue").val(thuNhapTinhThue);
                        var thueThuNhapCaNhan;
                        if (thuNhapTinhThue <= 5000000)
                            thueThuNhapCaNhan = (thuNhapTinhThue*5/100).toFixed(0);
                        else if(thuNhapTinhThue <= 10000000)
                            thueThuNhapCaNhan = (thuNhapTinhThue*10/100-250000).toFixed(0);
                        else if(thuNhapTinhThue <= 18000000)
                            thueThuNhapCaNhan = (thuNhapTinhThue*15/100-750000).toFixed(0);
                        else if(thuNhapTinhThue <= 32000000)
                            thueThuNhapCaNhan = (thuNhapTinhThue*20/100-1650000).toFixed(0);
                        else if(thuNhapTinhThue <= 52000000)
                            thueThuNhapCaNhan = (thuNhapTinhThue*25/100-3250000).toFixed(0);
                        else if(thuNhapTinhThue <= 80000000)
                            thueThuNhapCaNhan = (thuNhapTinhThue*30/100-5850000).toFixed(0);
                        else
                            thueThuNhapCaNhan = (thuNhapTinhThue*35/100-9850000).toFixed(0);

                        $("#thueThuNhapCaNhan").val(thueThuNhapCaNhan);
                    }else{
                        $("#thuNhapTinhThue").val(thuNhapTinhThue);
                        var thueThuNhapCaNhan;
                        if (thuNhapTinhThue <= 15000000)
                            thueThuNhapCaNhan = (thuNhapTinhThue*5/100).toFixed(0);
                        else if(thuNhapTinhThue <= 30000000)
                            thueThuNhapCaNhan = (thuNhapTinhThue*10/100-250000*3).toFixed(0);
                        else if(thuNhapTinhThue <= 54000000)
                            thueThuNhapCaNhan = (thuNhapTinhThue*15/100-750000*3).toFixed(0);
                        else if(thuNhapTinhThue <= 96000000)
                            thueThuNhapCaNhan = (thuNhapTinhThue*20/100-1650000*3).toFixed(0);
                        else if(thuNhapTinhThue <= 156000000)
                            thueThuNhapCaNhan = (thuNhapTinhThue*25/100-3250000*3).toFixed(0);
                        else if(thuNhapTinhThue <= 240000000)
                            thueThuNhapCaNhan = (thuNhapTinhThue*30/100-5850000*3).toFixed(0);
                        else
                            thueThuNhapCaNhan = (thuNhapTinhThue*35/100-9850000*3).toFixed(0);

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
                var thue = (thuNhapTinhThue*20/100).toFixed(0);
                $("#thueThuNhapCaNhanKCT").val(thue);
            }
}