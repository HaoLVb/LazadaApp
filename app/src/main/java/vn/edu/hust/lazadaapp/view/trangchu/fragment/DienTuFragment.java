package vn.edu.hust.lazadaapp.view.trangchu.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import vn.edu.hust.lazadaapp.R;
import vn.edu.hust.lazadaapp.adapter.dientu.SanPhamTopAdapter;
import vn.edu.hust.lazadaapp.adapter.dientu.ThuongHieuAdapter;
import vn.edu.hust.lazadaapp.model.entity.SanPham;
import vn.edu.hust.lazadaapp.model.entity.ThuongHieu;
import vn.edu.hust.lazadaapp.presenter.trangchu.dientu.DienTuPresenter;

public class DienTuFragment extends Fragment implements DienTuView {
    private View view;
    private DienTuPresenter presenter;

    private RecyclerView thuongHieuLonRecyclerView;
    private RecyclerView topDienThoaiRecyclerView;
    private RecyclerView phuKienRecyclerView;
    private RecyclerView topTiviRecyclerView;
    private RecyclerView tienIchRecyclerView;
    private RecyclerView topMayAnhRecyclerView;

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
    }

    private void initView() {
        topDienThoaiRecyclerView = view.findViewById(R.id.topDienThoaiRecyclerView);
        thuongHieuLonRecyclerView = view.findViewById(R.id.thuongHieuLonRecyclerView);
        phuKienRecyclerView = view.findViewById(R.id.phuKienRecyclerView);
        topTiviRecyclerView = view.findViewById(R.id.topTiviRecyclerView);
        tienIchRecyclerView = view.findViewById(R.id.tienIchRecyclerView);
        topMayAnhRecyclerView = view.findViewById(R.id.topMayAnhRecyclerView);
    }


    @Override
    public void hienThiCacThuongHieuLon(ArrayList<ThuongHieu> thuongHieus) {
        ThuongHieuAdapter thuongHieuAdapter = new ThuongHieuAdapter(getContext(), thuongHieus);
        thuongHieuLonRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3, GridLayoutManager.HORIZONTAL, false));
        thuongHieuLonRecyclerView.setAdapter(thuongHieuAdapter);
    }

    @Override
    public void hienthiTopDienThoai(ArrayList<SanPham> dienthoaiList) {
        SanPhamTopAdapter sanPhamTopAdapter = new SanPhamTopAdapter(getContext(), dienthoaiList);
        topDienThoaiRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        topDienThoaiRecyclerView.setAdapter(sanPhamTopAdapter);
    }

    @Override
    public void hienThiDanhSachPhuKien(ArrayList<ThuongHieu> phuKienList) {
        ThuongHieuAdapter thuongHieuAdapter = new ThuongHieuAdapter(getContext(), phuKienList);
        thuongHieuLonRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3, GridLayoutManager.HORIZONTAL, false));
        thuongHieuLonRecyclerView.setAdapter(thuongHieuAdapter);
    }
}
