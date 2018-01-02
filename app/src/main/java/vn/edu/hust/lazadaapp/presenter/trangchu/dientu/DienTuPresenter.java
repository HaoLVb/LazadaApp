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
    public void layDanhSachDienTu() {
        ArrayList<ThuongHieu> thuongHieus = DienTuModel.getInstance().getJsonThuongHieu();
        ArrayList<SanPham> sanPhams = DienTuModel.getInstance().getJsonSanPham();
        if (thuongHieus.size() > 0) {
            dienTuView.hienThiThuongHieu(thuongHieus, sanPhams);
        }
    }
}
