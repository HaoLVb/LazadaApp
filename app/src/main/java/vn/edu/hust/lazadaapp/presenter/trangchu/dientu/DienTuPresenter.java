package vn.edu.hust.lazadaapp.presenter.trangchu.dientu;

import java.util.ArrayList;

import vn.edu.hust.lazadaapp.model.entity.SanPham;
import vn.edu.hust.lazadaapp.model.entity.ThuongHieu;
import vn.edu.hust.lazadaapp.model.trangchu.dientu.DienTuModel;
import vn.edu.hust.lazadaapp.view.trangchu.fragment.DienTuView;

/**
 * Created by HaoLV on 1/2/2018.
 */

public class DienTuPresenter implements DienTuPresenterInterface {

    private DienTuView dienTuView;

    public DienTuPresenter(DienTuView dienTuView) {
        this.dienTuView = dienTuView;
    }


    @Override
    public void getDanhSachTopDienThoai() {
        ArrayList<SanPham> topDienThoais;
        topDienThoais = DienTuModel.getInstance().getJsonTopDienThoai();
        dienTuView.hienthiTopDienThoai(topDienThoais);
    }

    @Override
    public void getDanhSachThuongHieuLon() {
        ArrayList<ThuongHieu> thuongHieus;
        thuongHieus = DienTuModel.getInstance().getJsonThuongHieuLon();
        dienTuView.hienThiCacThuongHieuLon(thuongHieus);
    }

    @Override
    public void getDanhSachPhuKien() {
        ArrayList<ThuongHieu> phuKienList;
        phuKienList = DienTuModel.getInstance().getJsonPhuKien();
        dienTuView.hienThiDanhSachPhuKien(phuKienList);
    }

    @Override
    public void getTopTivi() {
        ArrayList<SanPham> tiviList;
        tiviList = DienTuModel.getInstance().getJsonTopTivi();
        dienTuView.hienThiDanhSachTivi(tiviList);
    }

    @Override
    public void getDanhSachTienIch() {
        ArrayList<ThuongHieu> tienIchList;
        tienIchList = DienTuModel.getInstance().getJsonTienIch();
        dienTuView.hienThiDanhSachTienIch(tienIchList);
    }

    @Override
    public void getTopMayAnh() {
        ArrayList<SanPham> mayAnhList;
        mayAnhList = DienTuModel.getInstance().getJsonTopMayAnh();
        dienTuView.hienThiDanhSachTopMayAnh(mayAnhList);
    }

    @Override
    public void getDanhSachHangMoi() {
        ArrayList<SanPham> hangMoiList;
        hangMoiList = DienTuModel.getInstance().getJsonHangMoi();
        dienTuView.hienThiDanhSachHangMoi(hangMoiList);
    }

    @Override
    public void getDanhSachLogoThuongHieu() {
        ArrayList<ThuongHieu> logoList;
        logoList = DienTuModel.getInstance().getJsonLogoThuongHieu();
        dienTuView.hienThiDanhSachLogoThuongHieu(logoList);
    }

}
