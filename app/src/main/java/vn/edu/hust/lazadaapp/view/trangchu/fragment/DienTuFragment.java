package vn.edu.hust.lazadaapp.view.trangchu.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import vn.edu.hust.lazadaapp.LogManager;
import vn.edu.hust.lazadaapp.R;
import vn.edu.hust.lazadaapp.adapter.dientu.SanPhamTopAdapter;
import vn.edu.hust.lazadaapp.adapter.dientu.ThuongHieuAdapter;
import vn.edu.hust.lazadaapp.adapter.dientu.ThuongHieuLonAdapter;
import vn.edu.hust.lazadaapp.customview.RecyclerItemClickListener;
import vn.edu.hust.lazadaapp.model.entity.SanPham;
import vn.edu.hust.lazadaapp.model.entity.ThuongHieu;
import vn.edu.hust.lazadaapp.presenter.trangchu.dientu.DienTuPresenter;
import vn.edu.hust.lazadaapp.view.danhmuc.SanPhamTheoDanhMucActivity;

public class DienTuFragment extends Fragment implements DienTuView {
    public static final String TEN_THUONGHIEU = "TEN_THUONGHIEU";
    public static final String MA_THUONGHIEU = "MA_THUONGHIEU";
    private View view;
    private DienTuPresenter presenter;

    private RecyclerView thuongHieuLonRecyclerView;
    private RecyclerView topDienThoaiRecyclerView;
    private RecyclerView phuKienRecyclerView;
    private RecyclerView topTiviRecyclerView;
    private RecyclerView tienIchRecyclerView;
    private RecyclerView topMayAnhRecyclerView;
    private RecyclerView logoRecyclerView;
    private RecyclerView hangMoiRecyclerView;

    public DienTuFragment() {
        // Required empty public constructor
    }

    public static DienTuFragment newInstance() {
        DienTuFragment fragment = new DienTuFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_dientu, container, false);
        initView();
        initControl();
        return view;
    }

    private void initControl() {
        presenter = new DienTuPresenter(this);
        presenter.getDanhSachThuongHieuLon();
        presenter.getDanhSachTopDienThoai();
        presenter.getDanhSachPhuKien();
        presenter.getTopTivi();
        presenter.getDanhSachTienIch();
        presenter.getTopMayAnh();
        presenter.getDanhSachHangMoi();
        presenter.getDanhSachLogoThuongHieu();
    }

    private void initView() {
        topDienThoaiRecyclerView = view.findViewById(R.id.topDienThoaiRecyclerView);
        thuongHieuLonRecyclerView = view.findViewById(R.id.thuongHieuLonRecyclerView);
        phuKienRecyclerView = view.findViewById(R.id.phuKienRecyclerView);
        topTiviRecyclerView = view.findViewById(R.id.topTiviRecyclerView);
        tienIchRecyclerView = view.findViewById(R.id.tienIchRecyclerView);
        topMayAnhRecyclerView = view.findViewById(R.id.topMayAnhRecyclerView);
        logoRecyclerView = view.findViewById(R.id.logoRecyclerView);
        hangMoiRecyclerView = view.findViewById(R.id.hangMoiRecyclerView);
    }


    @Override
    public void hienThiCacThuongHieuLon(final ArrayList<ThuongHieu> thuongHieuList) {
        ThuongHieuAdapter thuongHieuAdapter = new ThuongHieuAdapter(getContext(), thuongHieuList);
        thuongHieuLonRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3, GridLayoutManager.HORIZONTAL, false));
        thuongHieuLonRecyclerView.setAdapter(thuongHieuAdapter);
        thuongHieuLonRecyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getContext(), thuongHieuLonRecyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent intent = new Intent(getActivity(), SanPhamTheoDanhMucActivity.class);
                        intent.putExtra(TEN_THUONGHIEU, thuongHieuList.get(position).getTenThuongHieu());
                        intent.putExtra(MA_THUONGHIEU, thuongHieuList.get(position).getMaThuongHieu());
                        startActivity(intent);
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );
    }

    @Override
    public void hienthiTopDienThoai(ArrayList<SanPham> dienthoaiList) {
        SanPhamTopAdapter sanPhamTopAdapter = new SanPhamTopAdapter(getContext(), dienthoaiList);
        topDienThoaiRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        topDienThoaiRecyclerView.setAdapter(sanPhamTopAdapter);
    }

    @Override
    public void hienThiDanhSachPhuKien(ArrayList<ThuongHieu> phuKienList) {
        ThuongHieuAdapter phuKienAdapter = new ThuongHieuAdapter(getContext(), phuKienList);
        phuKienRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3, GridLayoutManager.HORIZONTAL, false));
        phuKienRecyclerView.setAdapter(phuKienAdapter);
    }

    @Override
    public void hienThiDanhSachTivi(ArrayList<SanPham> tiviList) {
        SanPhamTopAdapter tiviAdapter = new SanPhamTopAdapter(getContext(), tiviList);
        topTiviRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        topTiviRecyclerView.setAdapter(tiviAdapter);
    }

    @Override
    public void hienThiDanhSachTienIch(ArrayList<ThuongHieu> tienIchList) {
        ThuongHieuAdapter tienIchnAdapter = new ThuongHieuAdapter(getContext(), tienIchList);
        tienIchRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3, GridLayoutManager.HORIZONTAL, false));
        tienIchRecyclerView.setAdapter(tienIchnAdapter);
    }

    @Override
    public void hienThiDanhSachTopMayAnh(ArrayList<SanPham> mayAnhList) {
        SanPhamTopAdapter mayAnhAdapter = new SanPhamTopAdapter(getContext(), mayAnhList);
        topMayAnhRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        topMayAnhRecyclerView.setAdapter(mayAnhAdapter);
    }

    @Override
    public void hienThiDanhSachHangMoi(ArrayList<SanPham> hangMoiList) {
        SanPhamTopAdapter mayAnhAdapter = new SanPhamTopAdapter(getContext(), hangMoiList);
        hangMoiRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        hangMoiRecyclerView.setAdapter(mayAnhAdapter);
    }

    @Override
    public void hienThiDanhSachLogoThuongHieu(ArrayList<ThuongHieu> logoList) {
        ThuongHieuLonAdapter thuongHieuLonAdapter = new ThuongHieuLonAdapter(getContext(), logoList);
        logoRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2, GridLayoutManager.HORIZONTAL, false));
        logoRecyclerView.setAdapter(thuongHieuLonAdapter);
    }

}
