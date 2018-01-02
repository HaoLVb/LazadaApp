package vn.edu.hust.lazadaapp.presenter.dangki;

import vn.edu.hust.lazadaapp.LogManager;
import vn.edu.hust.lazadaapp.model.dangky.DangKyModel;
import vn.edu.hust.lazadaapp.model.entity.NhanVien;
import vn.edu.hust.lazadaapp.view.dangnhap.dangky.DangKyFragment;
import vn.edu.hust.lazadaapp.view.dangnhap.dangky.DangKyView;

/**
 * Created by HaoLV on 1/1/2018.
 */

public class DangKyPresenter implements DangKyPresenterInterface{
    private DangKyModel dangKyModel;
    private DangKyView dangKyView;

    public DangKyPresenter(DangKyView dangKyView) {
        this.dangKyView = dangKyView;
        this.dangKyModel=new DangKyModel();
    }

    @Override
    public void dangKyThanhVien(NhanVien nhanVien) {
        LogManager.e(this,nhanVien.toString());
        String ketqua=dangKyModel.dangKyThanhVien(nhanVien);
        LogManager.e(DangKyPresenter.this,ketqua);
        if(ketqua.equals("true")){
            dangKyView.dangKyThanhCong();
        }else {
            dangKyView.dangKyThatBai();
        }
    }
}
